const fcmTokenRepository = require('../repositories/FcmTokenRepository');
const utils = require("../utils/CommonUtils");
const ErrorCode = require("../constants/ErrorCode");

module.exports = {
    createFcmToken: async function (userId, fcmToken, deviceId, deviceType) {
        const result = await fcmTokenRepository.save({
            userId: userId,
            fcmToken: fcmToken,
            deviceId: deviceId,
            deviceType: deviceType
        });

        if (result) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Lưu token thành công'};
        }
        return {errorCode: ErrorCode.COMMON_FAIL, message: 'Lưu token thất bại'};
    },
    getByUserId: async function (userId) {
        const fcmToken = await fcmTokenRepository.findAllByUserId(userId);
        utils.log(`Get fcm token with userId : ${userId}`);
        return fcmToken;
    }
}
