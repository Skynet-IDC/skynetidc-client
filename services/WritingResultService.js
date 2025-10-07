const writingResultRepository = require("../repositories/WritingResultRepository");

module.exports = {
    updateWritingNotify: async function (profileId, questionId, request) {
        return await writingResultRepository.update(profileId, questionId, request);
    },

    getWritingNotify: async function (profileId) {
        return await writingResultRepository.findAllByProfile(profileId);
    },

    getWritingNotifyById: async function (id) {
        return await writingResultRepository.findAllById(id);
    }
}
