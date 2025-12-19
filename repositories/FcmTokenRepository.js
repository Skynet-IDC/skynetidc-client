let FcmToken = require('../entities/FcmToken');
const utils = require("../utils/CommonUtils");

module.exports = {
    save: function save(fields = {}) {
        return new Promise(resolve => {
            FcmToken.create(fields).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[FcmTokenRepository] error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    },
    findOne: async function (id) {
        return await FcmToken.findOne({
            where: {
                is_active: true,
                id: id
            },
        });
    },
    findAllByUserId: async function (userId) {
        return await FcmToken.findAll({
            where: {
                is_active: true,
                user_id: userId
            },
            order: [['id']]
        });
    },
}
