const pronunciationAssessmentRepository = require('../repositories/PronunciationAssessmentRepository');
const ErrorCode = require('../constants/ErrorCode');
const eventEmitter = require("../queues/events/EventEmitter");

module.exports = {
    savePronunciationAssessment: async function (params) {
        const result = await pronunciationAssessmentRepository.save(params);
        // Save score success event
        eventEmitter.emit("savePronunciationAssessmenSuccess", {
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

    updatePronunciationAssessment: async function (profileId, activityId, levelId, score) {
        const result = await pronunciationAssessmentRepository.updateScore(profileId, activityId, levelId, score);

        eventEmitter.emit("updatePronunciationAssessmentSuccess", {
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