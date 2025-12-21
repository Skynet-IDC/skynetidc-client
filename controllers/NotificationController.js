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
        const { title, content } = req.body;
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const fcmToken = await fcmTokenService.getByUserId(profile.id);

        const registrationTokens = fcmToken[0].fcmToken;

        if (registrationTokens.length === 0) {
            return res.status(404).send('No tokens found for user');
        }
        let response = await notificationService.sendNotify(title, content, registrationTokens);
        res.json(response);
    }
}
