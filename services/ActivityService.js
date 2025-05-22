const activityRepository = require('../repositories/ActivityRepository');
const activityScoreRepository = require('../repositories/ActivityScoreRepository');
const questionRepository = require('../repositories/QuestionRepository');
const ErrorCode = require('../constants/ErrorCode');
const eventEmitter = require("../queues/events/EventEmitter");

module.exports = {
    getActivityInfo: async function (id) {

        let activity = await activityRepository.findOne(id);

        const questionsOfActivity = await activityRepository.findQuestions(id);

        const questionIds = questionsOfActivity.map(question => question.questionId)

        const questions = await questionRepository.getQuestionsInfo(questionIds)

        let questionsInfoWithOrder = [];
        questionIds.forEach(id => {
            const qInfo = questions.find(item => item.id == id)
            questionsInfoWithOrder.push(qInfo)
        })

        activity = activity.toJSON()
        activity.questions = questionsInfoWithOrder

        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: activity};
    },

    getQuestions: async function (actId){
        const questionsOfActivity = await activityRepository.findQuestions(actId);

        const questionIds = questionsOfActivity.map(question => question.questionId)

        const questions = await questionRepository.getQuestionsInfo(questionIds)

        return questions
    },

    getActivityList: async function (partId) {
        const partList = await activityRepository.findAllByPartId(partId);
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {items: partList}};
    },

    saveScore: async function (params) {
        const result = await activityScoreRepository.save(params);
        // Save score success event
        eventEmitter.emit("saveScoreSuccess", {
            profileId: params.profileId,
            activityId: params.activityId,
            levelId: params.levelId,
            score: params.score,
        });
        if (result) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Lưu thông tin thành công'};
        }
        return {errorCode: ErrorCode.COMMON_FAIL, message: 'Lưu thông tin thất bại'};
    }

}