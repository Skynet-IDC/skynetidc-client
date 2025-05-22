const unitRepository = require('../repositories/UnitRepository');
const grammarRepository = require('../repositories/GrammarRepository');
const ErrorCode = require('../constants/ErrorCode');

module.exports = {

    getWordsByUnits: async function (unitIds, getAll = false) {
        const words = await grammarRepository.findWordsByUnitIds(unitIds);
        const wordIds = words.map(word => word.grammarId)
        const grammarsInfo = await grammarRepository.findByIds(wordIds)

        if(getAll){
            return grammarsInfo
        }

        let unitsWords = {};
        for (let i = 0; i < words.length; i++) {
            const grammarId = words[i].grammarId
            const grammarInfo = grammarsInfo.find(item => item.id == grammarId)
            if (!unitsWords[words[i].unitId]) {
                unitsWords[words[i].unitId] = [grammarInfo]
            } else {
                unitsWords[words[i].unitId].push(grammarInfo)
            }
        }
        // console.log('unitsWords', unitsWords)
        return unitsWords;
    },

    getGrammarsByUnits: async function (unitIds) {
        const words = await grammarRepository.findGrammarsByUnitIds(unitIds);
        const grammarIds = words.map(word => word.grammarId)
        const grammarsInfo = await grammarRepository.findByIds(grammarIds)

        let grammarsWords = {};
        for (let i = 0; i < words.length; i++) {
            const grammarId = words[i].grammarId
            const grammarInfo = grammarsInfo.find(item => item.id == grammarId)
            if (!grammarsWords[words[i].unitId]) {
                grammarsWords[words[i].unitId] = [grammarInfo]
            } else {
                grammarsWords[words[i].unitId].push(grammarInfo)
            }
        }
        return grammarsWords;
    },

}