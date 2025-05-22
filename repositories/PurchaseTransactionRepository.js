const utils = require("../utils/CommonUtils");
const PurchaseTransaction = require("../entities/PurchaseTransaction");

module.exports = {

    syncPurchaseTransaction: async function save(fields = {}) {
        console.log(' syncPurchaseTransaction fields', fields)
        return new Promise(resolve => {
            PurchaseTransaction.create(fields).then(result => {
                utils.log(`Create PurchaseTransaction Success : ${fields}`);
                resolve(result);
            }).catch((e) => {
                utils.log(`[PurchaseTransaction] Error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    },

}