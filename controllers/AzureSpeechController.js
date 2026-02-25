import sdk from "microsoft-cognitiveservices-speech-sdk"
import * as pronunciationAssessmentService from './../services/PronunciationAssessmentService.js';
import * as practiceService from "./../services/PracticeService.js";

export const speechToText = async (req, res) => {
    try {
        let uploadedFile = req.files.file;
        const formData = req.body;

        const audioConfig = sdk.AudioConfig.fromWavFileInput(uploadedFile.data);
        const speechConfig = sdk.SpeechConfig.fromSubscription(process.env.SPEECH_KEY, process.env.SPEECH_REGION);
        const reference_text = "What's the weather like?";

        const pronunciationAssessmentConfig = new sdk.PronunciationAssessmentConfig(
            reference_text,
            sdk.PronunciationAssessmentGradingSystem.HundredMark,
            sdk.PronunciationAssessmentGranularity.Phoneme,
            true
        );
        pronunciationAssessmentConfig.enableProsodyAssessment = true;
        speechConfig.speechRecognitionLanguage = 'en-US';

        const recognizer = new sdk.SpeechRecognizer(speechConfig, audioConfig);
        pronunciationAssessmentConfig.applyTo(recognizer);

        const getRecognitionResult = () => {
            return new Promise((resolve, reject) => {
                recognizer.recognizeOnceAsync(
                    (result) => {
                        resolve(result);
                        recognizer.close();
                    },
                    (err) => {
                        recognizer.close();
                        reject(err);
                    }
                );
            });
        };

        // Đợi cho đến khi có kết quả từ Azure
        const result = await getRecognitionResult();

        // Xử lý kết quả sau khi đã "await" xong
        const pronunciation_result = sdk.PronunciationAssessmentResult.fromResult(result);
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);

        const responseData = {
            profileId: profile.id,
            activityId: formData.activity_id,
            levelId: formData.level_id,
            startTime: formData.start_time,
            timeSpent: formData.time_spent,
            score: {
                accuracy: pronunciation_result.accuracyScore,
                fluency: pronunciation_result.fluencyScore,
                prosody: pronunciation_result.prosodyScore,
                completeness: pronunciation_result.completenessScore,
                pron: pronunciation_result.pronunciationScore,
            },
            isPracticeConversation: req.body.is_practice_conversation ? 1 : 0,
            createdAt: new Date()
        }

        // Lưu vào DB (đợi lưu xong nếu cần)
        if (req.body.is_practice_conversation) {
            await practiceService.savePracticeConversationScore(responseData);
        } else {
            await pronunciationAssessmentService.savePronunciationAssessment(responseData);
        }

        // Trả về response JSON thực tế cho client
        res.json({
            errorCode: "Success",
            message: 'Assessment completed',
            data: responseData
        });

    } catch (error) {
        console.error(error);
        res.status(500).json({ errorCode: "Fail", message: error.message });
    }
}
