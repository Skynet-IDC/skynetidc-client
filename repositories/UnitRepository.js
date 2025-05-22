let Unit = require('../entities/Unit');
let Grammar = require('../entities/Grammar');
let Part = require('../entities/Part');
let UnitWord = require('../entities/UnitWord');
let UnitGrammar = require('../entities/UnitGrammar');
let UnitSentence = require('../entities/UnitSentence');
const {Op} = require("sequelize");

Unit.hasMany(Part, {
    sourceKey: 'id',
    foreignKey: 'unitId',
    as: 'parts'
});

module.exports = {

    findAllByLevelId: async function (levelId, unitId, page, reverse) {
        const limit = 10;
        const offset = (page - 1) * limit;
        const order = (reverse == 0 ? [['position']] : [['position', 'DESC']]);
        let query = {
            is_active: true,
            level_id: levelId
        };
        if (unitId) {
            const compareSign = (reverse == 0 ? Op.gte : Op.lt);
            query.id = {[compareSign]: unitId};
        }
        const units = await Unit.findAll({
            attributes: {exclude: ['grammar']},
            where: query,
            limit,
            offset,
            order,
            include: {
                model: Part,
                as: 'parts',
                where: {
                    isActive: true
                }
            }
        });
        return units.map(unit => {
            unit.parts = unit.parts.sort((a, b) => a.position - b.position)
            return unit
        })
    },

    findByLevelId: async function (levelId) {
        let query = {
            isActive: true,
            levelId: levelId,
            deletedAt: null
        };
        return await Unit.findAll({
            where: query,
            order: [['position']],
        })
    },

    getWords: async function (unitId) {
        let grammarsType = {
            "WORD": [],
            "SENTENCE": [],
            "GRAMMAR": "",
        }
        const unitInfo =  await Unit.findOne({
            where: {
                id: unitId,
            }
        });
        const wordsUnits = await UnitWord.findAll({where: {unitId: unitId, deletedAt: null}, order: [['position']]})
        const sentencesUnits = await UnitSentence.findAll({where: {unitId: unitId, deletedAt: null}, order: [['position']]})

        const wordIds = wordsUnits.map(item => item.grammarId)
        const wordsInfo = await Grammar.findAll({where: {id: wordIds, deletedAt: null, isActive: true}})

        const grammarIds = sentencesUnits.map(item => item.grammarId)
        const grammarsInfo = await Grammar.findAll({where: {id: grammarIds, deletedAt: null, isActive: true}})

        // if (!wordsInfo) return grammarsType

        for (let i = 0; i < wordsUnits.length; i++) {
            const wordId = wordsUnits[i].grammarId
            const item = wordsInfo.find(u => u.id == wordId)
            grammarsType.WORD.push(item)
        }

        for (let i = 0; i < sentencesUnits.length; i++) {
            const wordId = sentencesUnits[i].grammarId
            const item = grammarsInfo.find(u => u.id == wordId)
            grammarsType.SENTENCE.push(item)
        }


        grammarsType['GRAMMAR'] = unitInfo.grammar

        return grammarsType
    }

}
