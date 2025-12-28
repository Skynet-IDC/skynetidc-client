const notificationService = require("../services/NotificationService");
const fcmTokenService = require("../services/FcmTokenService");

module.exports = {
    getByType: async function (req, res) {
        const type = req.query.type;
        try {
            const response = await notificationService.getByType(type);
            res.json(response);
        } catch (e) {
            res.status(404).json({
                success: false,
                message: 'Notfound notification!',
            });
        }
    },
    createNotify: async function (req, res) {
        const title = req.body.title;
        const content = req.body.content;
        const type = req.body.type;
        let response = await notificationService.createNotify(title, content, type);
        res.json(response);
    },
    sendNotify: async function (req, res) {
        const { title, content, data } = req.body;
        const userId = req.query.userId;
        console.log('Request body to send notify: ' + JSON.stringify(req.body));

        try {
            const fcmToken = await fcmTokenService.getByUserId(userId);
            const registrationTokens = fcmToken[0].fcmToken;
            if (registrationTokens.length === 0) {
                return res.status(404).send('No tokens found for user');
            }
            let response = await notificationService.sendNotify(title, content, data, registrationTokens);
            res.json(response);
        } catch (e) {
            res.json({
                success: false,
                message: 'Send notify fail!',
            });
        }
    }
}
