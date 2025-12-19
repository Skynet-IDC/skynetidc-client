let Notification = require('../entities/Notification');
const utils = require("../utils/CommonUtils");

module.exports = {
    save: function save(fields = {}) {
        return new Promise(resolve => {
            Notification.create(fields).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[NotificationRepository] error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    },
    findAllByType: async function (type) {
         const notifications = await Notification.findAll({
            where: {
                type: type
            }
        });

        return notifications.map(item => ({
            title: item.title,
            content: item.content,
            type: item.type
        }));
    }
}
