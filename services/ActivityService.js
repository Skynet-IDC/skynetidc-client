const userLearningInfoRepository = require('../repositories/UserLearningInfoRepository');
const activityRepository = require('../repositories/ActivityRepository');
const activityScoreRepository = require('../repositories/ActivityScoreRepository');
const writingResultRepository = require('../repositories/WritingResultRepository');
const questionRepository = require('../repositories/QuestionRepository');
const ErrorCode = require('../constants/ErrorCode');
const eventEmitter = require("../queues/events/EventEmitter");
const utils = require("../utils/CommonUtils");

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

    getTestResults: async function (levelId) {
        const testResults = await activityRepository.getTestResults(levelId);
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: testResults};
    },

    updateTestResults: async function (profileId, levelId, fields) {
        const result = await userLearningInfoRepository.update(profileId, levelId, fields);
         if (result) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Lưu thông tin thành công'};
        }
        return {errorCode: ErrorCode.COMMON_FAIL, message: 'Lưu thông tin thất bại'};
    },

    saveWritingResult: async function (profile, fields) {
        const levelId = fields.level_id ? parseInt(fields.level_id) : null;
        const activityId = fields.activity_id  ? parseInt(fields.activity_id) : null;
        const topicId = fields.topic_id ? parseInt(fields.topic_id) : null;
        const questionResponses = fields.question_responses_holders;
        const questionId = questionResponses[0].question_id;
        const writingAnswer = questionResponses[0].responses.map(writingAnswer => writingAnswer.response).filter(Boolean).join("|");
        utils.log(`body: ${JSON.stringify(fields)}`);

        const request = {
            userId: profile.id,
            questionId: questionId,
            topicId: topicId,
            levelId: levelId,
            activityId: activityId,
            answers: `[${writingAnswer}]`,
            view: 0,
            status: 0
        }
        utils.log(`request: ${JSON.stringify(request)}`);

        const writingResultExit = await writingResultRepository.findAllByProfileAndQuestionId(profile.id, questionId);
        let result;
        if (writingResultExit && Object.keys(writingResultExit).length > 0) {
            result = await writingResultRepository.updateForReAnswer(writingResultExit.id, {answers: `[${writingAnswer}]`});
        } else {
            result = await writingResultRepository.save(request);
        }
        if (result) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Lưu thông tin thành công'};
        }
        return {errorCode: ErrorCode.COMMON_FAIL, message: 'Lư  u thông tin thất bại'};
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
    },

    updateScore: async function (profileId, activityId, levelId, score) {
        const result = await activityScoreRepository.updateScore(profileId, activityId, levelId, score);

        eventEmitter.emit("saveScoreSuccess", {
            profileId: profileId,
            activityId: activityId,
            levelId: levelId,
            score: score,
        });
        if (result) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Cập nhật thông tin thành công'};
        }
        return {errorCode: ErrorCode.COMMON_FAIL, message: 'Cập nhật thông tin thất bại'};
    }

}