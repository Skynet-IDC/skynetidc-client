import sdk from "microsoft-cognitiveservices-speech-sdk"
import _ from "lodash"

export const speechToText = (req, res) => {
    // if (!req.files || Object.keys(req.files).length === 0) {
    //     res.json({errorCode: ErrorCode.COMMON_FAIL, message: 'No files were uploaded.'});
    // }
    // if (!req.body.text) {
    //     res.json({errorCode: ErrorCode.COMMON_FAIL, message: 'No Words were uploaded.'});
    // }
    let uploadedFile = req.files.file;

    const audioConfig = sdk.AudioConfig.fromWavFileInput(uploadedFile.data);
    const speechConfig = sdk.SpeechConfig.fromSubscription(process.env.SPEECH_KEY, process.env.SPEECH_REGION);

    const reference_text = "What's the weather like?";
    // create pronunciation assessment config, set grading system, granularity and if enable miscue based on your requirement.
    const pronunciationAssessmentConfig = new sdk.PronunciationAssessmentConfig(
        reference_text,
        sdk.PronunciationAssessmentGradingSystem.HundredMark,
        sdk.PronunciationAssessmentGranularity.Phoneme,
        true
    );
    pronunciationAssessmentConfig.enableProsodyAssessment = true;

    // setting the recognition language to English.
    speechConfig.speechRecognitionLanguage = 'en-US';

    // create the speech recognizer.
    var reco = new sdk.SpeechRecognizer(speechConfig, audioConfig);
    // (Optional) get the session ID
    reco.sessionStarted = (_s, e) => {
        console.log(`SESSION ID: ${e.sessionId}`);
    };
    pronunciationAssessmentConfig.applyTo(reco);

    function onRecognizedResult(result) {
        console.log("pronunciation assessment for: ", result.text);
        var pronunciation_result = sdk.PronunciationAssessmentResult.fromResult(result);
        console.log("pronunciation_result: " + JSON.stringify(pronunciation_result))
        console.log(" Accuracy score: ", pronunciation_result.accuracyScore, '\n',
            "pronunciation score: ", pronunciation_result.pronunciationScore, '\n',
            "completeness score : ", pronunciation_result.completenessScore, '\n',
            "fluency score: ", pronunciation_result.fluencyScore, '\n',
            "prosody score: ", pronunciation_result.prosodyScore
        );
        console.log("  Word-level details:");
        _.forEach(pronunciation_result.detailResult.Words, (word, idx) => {
            console.log("    ", idx + 1, ": word: ", word.Word, "\taccuracy score: ", word.PronunciationAssessment.AccuracyScore, "\terror type: ", word.PronunciationAssessment.ErrorType, ";");
        });
        reco.close();
    }

    reco.recognizeOnceAsync(
        function (successfulResult) {
            onRecognizedResult(successfulResult);
        }
    )
}
