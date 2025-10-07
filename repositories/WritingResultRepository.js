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

    update: async function (profileId, levelId, fields = {}) {
        return new Promise(async resolve => {
            WritingResult.update(fields, {
                where: {
                    user_id: profileId,
                    level_id: levelId
                }
            }).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[WritingResultRepository] Error when executing "update", detail: ${e}`);
                resolve(false);
            });
        });
    }
}