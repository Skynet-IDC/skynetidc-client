const unitService = require('../services/UnitService');
const CompetitionService = require('../services/CompetitionService');
const ErrorCode = require("../constants/ErrorCode");
const userService = require("../services/UserService");

module.exports = {

    botList: async function (req, res) {
        const bots = await CompetitionService.getBotList();

        res.json({errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: bots})
    },

    play: async function (req, res) {
        const levelId = req.query.level_id;
        const botId = req.query.bot_id;
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const words = await CompetitionService.getWords(levelId, profile.id, botId);

        res.json({errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: words})
    },

    // submit: async function (req, res) {
    //     const attempt = req.body.attempt_id;
    //     const questionId = req.body.question_id;
    //     const holder = req.body.response_holder;
    //
    //     res.json({errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {attempt, questionId, holder}})
    // },

    // submit: async function (req, res) {
    //     // const attempt = req.body.attempt_id;
    //     const response_holder = [
    //         {
    //             "question_id": 106829,
    //             "response_holder": {
    //                 "bot": {
    //                     "correct": true
    //                 },
    //                 "user": {
    //                     "answer_id": 1,
    //                     "correct": false
    //                 }
    //             }
    //         }
    //     ]
    //
    //     res.json({errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: response_holder})
    // },
}