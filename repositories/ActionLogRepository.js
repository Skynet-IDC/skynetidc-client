let ActionLog = require('../entities/ActionLog');
const utils = require("../utils/CommonUtils");

module.exports = {

    findByAccountId: async function (accountId) {
        return await ActionLog.findOne({
            where: {
                accountId: accountId
            }
        });
    },
    save: function save(fields = {}) {
        return new Promise(resolve => {
            ActionLog.create(fields).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[ActionLogRepository] Error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    }

}