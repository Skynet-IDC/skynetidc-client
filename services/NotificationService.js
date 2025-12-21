const notificationRepository = require('../repositories/NotificationRepository');
const utils = require("../utils/CommonUtils");
const ErrorCode = require("../constants/ErrorCode");
const admin = require('firebase-admin');
const serviceAccount = require('../keys/serviceAccountKey.json');
admin.initializeApp({
    credential: admin.credential.cert(serviceAccount)
});

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
    },

    sendNotify: async function (title, content, registrationTokens) {
        // 2. Construct the notification payload
        const message = {
            notification: {
                title: title,
                body: content,
            },
            token: registrationTokens
        };

        // 3. Send the message using the Admin SDK
        try {
            const response = await admin.messaging().send(message);
            // Send a message to the device corresponding to the provided registration token.
            admin.messaging().send(message)
                .then((response) => {
                    // Response is a message ID string.
                    console.log('Successfully sent message:', response);
                })
                .catch((error) => {
                    console.error('Error sending message:', error);
                });
            console.log('Successfully sent message:', response);
        } catch (error) {
            console.error('Error sending message:', error);
        }
    }
}
