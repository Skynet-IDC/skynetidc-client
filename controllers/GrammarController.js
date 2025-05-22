const unitService = require('../services/UnitService');
const GrammarService = require('../services/GrammarService');
const PracticeService = require('../services/PracticeService');
const ErrorCode = require("../constants/ErrorCode");

module.exports = {

    getWords: async function (req, res) {
        const units = await unitService.getByLevel(req.query.level_id);

        const unitIds = units.map(unit => unit.id)
        const unitWords = await GrammarService.getWordsByUnits(unitIds)
        // const
        let dataWords = [];
        for (let i = 0; i < units.length; i++) {
            const unitItem = {
                ...units[i].toJSON(),
                words: unitWords[units[i].id] || []
            }
            dataWords.push(unitItem)
        }

        res.json({errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: dataWords})
    },

    getSentences: async function (req, res) {
        const units = await unitService.getByLevel(req.query.level_id);

        const unitIds = units.map(unit => unit.id)
        const unitWords = await GrammarService.getGrammarsByUnits(unitIds)
        // const
        let dataSentences = [];
        for (let i = 0; i < units.length; i++) {
            const unitItem = {
                ...units[i].toJSON(),
                sentences: unitWords[units[i].id] || []
            }
            dataSentences.push(unitItem)
        }
        res.json({errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: dataSentences})
    },

    getConversation: async function (req, res) {
        const conversations = await unitService.getConversations(req.query.level_id);

        res.json({errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: conversations})
    },
    getConversationLearningInfo: async function (req, res) {
        const levelId = req.query.level_id;
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const conversations = await PracticeService.getConversationsInfo(levelId, profile.id);
        res.json({errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: conversations})
    },
}