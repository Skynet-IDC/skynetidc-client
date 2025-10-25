let WritingResult = require('../entities/WritingResult');
const utils = require("../utils/CommonUtils");
const Activity = require("../entities/Activity");
const TestResult = require("../entities/TestResult");
const {Op} = require("sequelize");

module.exports = {
    save: function save(fields = {}) {
        return new Promise(resolve => {
            WritingResult.create(fields).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[WritingResultRepository] Error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    },

    update: async function (profileId, questionId, fields) {
        return new Promise(async resolve => {
            WritingResult.update(fields, {
                where: {
                    user_id: profileId,
                    question_id: questionId
                }
            }).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[WritingResultRepository] Error when executing "update", detail: ${e}`);
                resolve(false);
            });
        });
    },

    updateById: async function (profileId, topicId, fields) {
        return new Promise(async resolve => {
            WritingResult.update(fields, {
                where: {
                    userId: profileId,
                    topicId: topicId
                }
            }).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[WritingResultRepository] Error when executing "update", detail: ${e}`);
                resolve(false);
            });
        });
    },

    findAllByProfile: async function (profileId) {
        let query = {
            user_id: profileId,
            view: 0
        };
        return await WritingResult.findAll({ where: query });
    },

    countHaveFeedback: async function (profileId, topicId) {
        let query = {
            user_id: profileId,
            topicId: topicId,
            feedback: {
                [Op.not]: null,
            },
            view: 0
        };
        return await WritingResult.findAll({ where: query });
    },

    countAllWritingNotify: async function (profileId) {
        let query = {
            user_id: profileId,
            view: 0
        };
        return await WritingResult.findAndCountAll({ where: query });
    },

    findAllByTopicId: async function (profileId, topicId) {
        let query = {
            userId: profileId,
            topicId: topicId,
        };
        return await WritingResult.findAll({ where: query, order: [['id', 'DESC']]});
    }
}