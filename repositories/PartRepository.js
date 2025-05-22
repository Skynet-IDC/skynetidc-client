let Part = require('../entities/Part');

module.exports = {
    findAllByUnitID: async function (unitIds) {
        return await Part.findAll({
            where: {
                is_active: true,
                unit_id: unitIds
            },
            order: [['position']]
        });
    }

}