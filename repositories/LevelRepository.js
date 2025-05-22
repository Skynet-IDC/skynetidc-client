let Level = require('../entities/Level');
let Unit = require('../entities/Unit');

Level.hasMany(Unit, {
    sourceKey: 'id',
    foreignKey: 'levelId',
    as: 'units'
});

module.exports = {

    findByCode: async function (code) {
        return await Level.findOne({
            model: Level,
            where: {code: code, is_active: true}
        });
    },

    findAllActiveLevel: async function () {
        return await Level.findAll({
            model: Level,
            where: {is_active: true},
            include: {
                attributes: ['id'],
                model: Unit,
                as: 'units'
            },
            order: [['position'], ['units', 'position']]
        });
    }

}