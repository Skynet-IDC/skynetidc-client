const notificationRepository = require('../repositories/NotificationRepository');
const utils = require("../utils/CommonUtils");
const ErrorCode = require("../constants/ErrorCode");

module.exports = {
    createNotify: async function (title, content, type) {
        const result = await notificationRepository.save({
            title: title,
            content: content,
            type: type
        });
        if (result) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Lưu notification thành công'};
        }
        return {errorCode: ErrorCode.COMMON_FAIL, message: 'Lưu notification thất bại'};
    },
    getByType: async function (type) {
        const notifications = await notificationRepository.findAllByType(type);
        utils.log(`Get notification with type : ${type}`);
        return notifications;
    }
}
