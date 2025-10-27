const writingResultRepository = require("../repositories/WritingResultRepository");

module.exports = {
    updateWritingNotify: async function (profileId, questionId, request) {
        return await writingResultRepository.update(profileId, questionId, request);
    },

    getWritingNotify: async function (profileId) {
        return await writingResultRepository.findAllByProfile(profileId);
    },

    countHaveFeedbackByTopicId: async function (profileId, topicId) {
        return await writingResultRepository.countHaveFeedback(profileId, topicId);
    },

    countAllWritingNotify: async function (profileId) {
        return await writingResultRepository.countAllWritingNotify(profileId);
    },

    getWritingNotifyByTopicId: async function (profileId, topicId) {
        await writingResultRepository.updateById(profileId, topicId, {view: 1});
        return await writingResultRepository.findAllByTopicId(profileId, topicId);
    }
}
