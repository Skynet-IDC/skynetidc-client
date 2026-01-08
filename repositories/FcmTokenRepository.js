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
    findAllByUserIdAndDeviceId: async function (userId, deviceId) {
        return await FcmToken.findAll({
            where: {
                is_active: true,
                user_id: userId,
                device_id: deviceId
            },
            order: [['id']]
        });
    },
    updateByUserId: async function (userId, deviceId, fields) {
        return new Promise(async resolve => {
            FcmToken.update(fields, {
                where: {
                    user_id: userId,
                    device_id: deviceId
                }
            }).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[FcmTokenRepository] Error when executing "update", detail: ${e}`);
                resolve(false);
            });
        });
    },
}
