const notificationService = require("../services/NotificationService");

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
    }
}
