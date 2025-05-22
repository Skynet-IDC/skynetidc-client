let Unit = require('../entities/Unit');
let Grammar = require('../entities/Grammar');
let Part = require('../entities/Part');
let UnitWord = require('../entities/UnitWord');
let UnitGrammar = require('../entities/UnitGrammar');

// Unit.hasMany(Part, {
//     sourceKey: 'id',
//     foreignKey: 'unitId',
//     as: 'parts'
// });

module.exports = {
    findByIds: async function (ids) {
        let query = {
            deletedAt: null,
            isActive: true,
            id: ids
        };
        return await Grammar.findAll({
            where: query,
        })
    },
    findWordsByUnitIds: async function (unitIds) {
        let query = {
            deletedAt: null,
            unitId: unitIds
        };
        return await UnitWord.findAll({
            where: query,
        })
    },
    findGrammarsByUnitIds: async function (unitIds) {
        let query = {
            deletedAt: null,
            unitId: unitIds
        };
        return await UnitGrammar.findAll({
            where: query,
        })
    },
}