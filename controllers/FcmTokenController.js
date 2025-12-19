const utils = require("../utils/CommonUtils");
const fcmTokenService = require("../services/FcmTokenService");

module.exports = {

    getByUser: async function (req, res) {
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        try {
            const response = await fcmTokenService.getByUserId(profile.id);
            res.json(response);
        } catch (e) {
            res.status(404).json({
                success: false,
                message: `Notfound token for user id = ${profile.id}`,
            });
        }
    },

    createFcmToken: async function (req, res) {
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);

        const userId = profile.id;
        const fcmToken = req.body.fcm_token;
        const deviceId = req.body.device_id;
        const deviceType = req.body.device_type;

        let response = await fcmTokenService.createFcmToken(userId, fcmToken, deviceId, deviceType);
        res.json(response);
    }
}
