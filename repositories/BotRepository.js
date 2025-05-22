let File = require('../entities/File');
let Bot = require('../entities/Bot');
const BotLevel = require("../entities/BotLevel");

module.exports = {
    getList: async function (id) {
        return await Bot.findAll({
            where: {
                is_active: true
            },
        });
    },

    getBotInfo: async function (id) {
        const bot = await Bot.findOne({
            where: {
                id: id
            },
        });

        const level = await BotLevel.findOne({
            where: {
                id: bot.botLevelId
            },
        });

        return {info: bot, level}
    },

}