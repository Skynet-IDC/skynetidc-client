let Activity = require('../entities/Activity');
let ActivityQuestion = require('../entities/ActivityQuestion');

module.exports = {
    findOne: async function (id) {
        return await Activity.findOne({
            where: {
                is_active: true,
                id: id
            },
        });
    },
    findQuestions: async function (id) {
        return await ActivityQuestion.findAll({
            where: {
                activityId: id,
                deletedAt: null
            },
        });
    },
    findAllByQuestionId: async function (questionId) {
        return await ActivityQuestion.findAll({
            where: {
                questionId: questionId
            },
        });
    },
    findAllByPartId: async function (partId) {
        return await Activity.findAll({
            where: {
                is_active: true,
                part_id: partId
            },
            order: [['position']]
        });
    },

    getTestResults: async function (levelId) {
        return await Activity.findAll({
            where: {
                is_active: true,
                part_id: 0, // Assuming 0 is used for test results activities
                type: "TEST_RESULTS",
                levelId: levelId
            },
            order: [['position']]
        });
    }

}