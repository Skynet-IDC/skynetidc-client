let UnitConversation = require('../entities/UnitConversation');
module.exports = {
    getByLevel: async function (levelId) {
        let query = {
            deletedAt: null,
            level_id: levelId
        };
        return await UnitConversation.findAll({
            where: query,
            order: [['position']]
        })
    },
}