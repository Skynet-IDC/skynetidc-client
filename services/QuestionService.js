const questionRepository = require('../repositories/QuestionRepository');
const fileRepository = require('../repositories/FileRepository');
const activityRepository = require('../repositories/ActivityRepository');
const ErrorCode = require('../constants/ErrorCode');
const utils = require("../utils/CommonUtils");

module.exports = {
    convertSubQuestionInfo: function (subQuestionsInfo, filesContent, botsContent) {

        let arr = [];
        for (let i = 0; i < subQuestionsInfo.length; i++) {
            const subQuestionContent = JSON.parse(subQuestionsInfo[i].questionContent)
            const subQuestionAnswers = JSON.parse(subQuestionsInfo[i].answers)


            // Danh sasch cau tra loi cua 1 question
            const subQuestionAnswersInfo = []

            for (let j = 0; j < subQuestionAnswers.length; j++) {
                const answerItem = subQuestionAnswers[j]
                const timeout = parseInt(answerItem.timeout?.value) || 0
                const newItem = {
                    text: answerItem.text.value,
                    pronunciation: answerItem.pronunciation?.value,
                    vnTitle: answerItem.vn_title?.value,
                    timeout: timeout * 1000,
                    position: parseInt(answerItem.position?.value) || 0,
                    image: filesContent[answerItem.image?.id] || null,
                    audio: filesContent[answerItem.audio?.id] || null,
                    rightResponse: answerItem.right_response,
                }
                subQuestionAnswersInfo.push(newItem)
            }
            const subQuestionData = {
                content: {
                    bot: botsContent[subQuestionsInfo[i].bot] || null,
                    title: subQuestionContent.title?.value,
                    text: subQuestionContent.text?.value,
                    vnTitle: subQuestionContent.description?.value,
                    pronunciation: subQuestionContent.pronunciation?.value,
                    image: filesContent[subQuestionContent['q-content_image']?.id] || null,
                    audio: filesContent[subQuestionContent['q-content_audio']?.id] || null,
                    video: filesContent[subQuestionContent['content_video']?.id] || null,
                },
                explanation: {
                    text: subQuestionContent.explanation_text?.value,
                    image: filesContent[subQuestionContent.explanation_image],
                    audio: filesContent[subQuestionContent.explanation_audio],
                    video: filesContent[subQuestionContent.explanation_video],
                },
                message: {
                    correct: subQuestionContent.message_correct?.value,
                    wrong: subQuestionContent.message_wrong?.value,
                },
                answers: subQuestionAnswersInfo,
            }
            arr.push(subQuestionData)
        }
        return arr
    },
    build: async function (id) {

        const filesContent = await fileRepository.findAll();
        const botsContent = await fileRepository.findAllBot();

        const question = await questionRepository.findOne(id);

        const subQuestionIds = !question.subQuestionsIds ? [] : question.subQuestionsIds.split(",")
        const subQuestionInfo = subQuestionIds.length == 0 ? [question] : await questionRepository.findMany(subQuestionIds)

        const resource = {
            id: question.id,
            name: question.name || "",
            title: question.title || "",
            description: question.description || "",
            duration: question.duration || 0,
            platform: await questionRepository.getPlatformDetail(question.platformId),
            skill: question.skill || "",
            content: {
                text: question.contentText,
                image: filesContent[question.contentImage],
                audio: filesContent[question.contentAudio],
                video: filesContent[question.contentVideo],
            },
            hint: {
                text: question.hintText,
                image:filesContent[question.hintImage],
                audio: filesContent[question.hintAudio],
                video: filesContent[question.hintVideo],
            },
            answerHelp: {
                text: question.answerHelpText,
                image: filesContent[question.answerHelpImage],
                audio: filesContent[question.answerHelpAudio],
                video: filesContent[question.answerHelpVideo],
            },
            subQuestions: this.convertSubQuestionInfo(subQuestionInfo, filesContent, botsContent)
        }
        utils.log(`Build Question Data : ${id}`);

        return await questionRepository.syncQuestionResource({
            questionId: id,
            content: JSON.stringify(resource),
            createdAt: new Date(),
            updatedAt: new Date()
        })
    },
    getById: async function (id) {
        const question = await questionRepository.findOne(id);
        const activities = await activityRepository.findAllByQuestionId(id);
        const activity = activities[0];
        utils.log(`Get question with id : ${id}`);

        return {
            id: question.id,
            activityId: activity.activityId,
            name: question.name,
            content: JSON.parse(question.questionContent).text.value
        }

    },

}