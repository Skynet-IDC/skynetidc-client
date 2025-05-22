// let Activity = require('../entities/Activity');
// let ActivityQuestion = require('../entities/ActivityQuestion');
const PracticeConversationScore = require("../entities/PracticeConversationScore");
const utils = require("../utils/CommonUtils");

module.exports = {
    save: function save(fields = {}) {
        return new Promise(resolve => {
            PracticeConversationScore.create(fields).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[PracticeConversationRepository] Error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    }

}