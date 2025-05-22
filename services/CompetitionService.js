const botRepository = require('../repositories/BotRepository');
const UserLearningInfoRepository = require('../repositories/UserLearningInfoRepository');
const ErrorCode = require('../constants/ErrorCode');
const GrammarService = require("./GrammarService");
const UnitService = require("./UnitService");

module.exports = {

    getBotList: async function () {
        let botList = await botRepository.getList();
        botList = botList.filter(item => item.code != 0 && item.botLevelId != null && item.deletedAt == null)
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {bots: botList}};
    },
    getWords: async function (levelId, profileId, botId) {
        const wordsData = [];
        const learningInfo = await UserLearningInfoRepository.findByProfileIdAndLevelId(profileId, levelId)

        const units = JSON.parse(learningInfo?.units) || [];

        let unitFinished = [];

        for (let key in units) {
            if (units[key].isFinished === true) {
                unitFinished.push(key);
            }
        }

        if(!unitFinished.length){
            // lay words owr topic dau
            // const unitsByLevel =
            const unitsByLevel = await UnitService.getByLevel(levelId)

            const unitFirst = unitsByLevel[0]
            unitFinished = [unitFirst.id]
        }

        const wordsUnits = await GrammarService.getWordsByUnits(unitFinished, true)
        for (let i = 0; i < wordsUnits.length; i++) {
            wordsData.push({
                "text": wordsUnits[i].text,
                "en_description": wordsUnits[i].description,
                "description": wordsUnits[i].description,
            })
        }

        const bot = await botRepository.getBotInfo(botId)

        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {bot: bot, words: wordsData}};
        },

}