const writingResultRepository = require("../repositories/WritingResultRepository");
const WritingResult = require("../entities/WritingResult");

module.exports = {
    updateWritingNotify: async function (profileId, questionId, request) {
        return await writingResultRepository.update(profileId, questionId, request);
    },

    getWritingNotify: async function (profileId) {
        return await writingResultRepository.findAllByProfile(profileId);
    },

    countAllWritingNotify: async function (profileId) {
        return await writingResultRepository.countAllWritingNotify(profileId);
    },

    getWritingNotifyByTopicId: async function (profileId, topicId) {
        // await writingResultRepository.updateById(profileId, topicId, {view: 1});
        return await writingResultRepository.findAllByTopicId(profileId, topicId);
    }
}
