let WritingResult = require('../entities/WritingResult');
const utils = require("../utils/CommonUtils");

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

    updateById: async function (id, fields) {
        return new Promise(async resolve => {
            WritingResult.update(fields, {
                where: {
                    id: id
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

    findAllById: async function (id) {
        let query = {
            id: id
        };
        return await WritingResult.findOne({ where: query });
    }
}