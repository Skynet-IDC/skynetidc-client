let ActivityScore = require('../entities/ActivityScore');
const utils = require("../utils/CommonUtils");

module.exports = {

    save: function save(fields = {}) {
        return new Promise(resolve => {
            ActivityScore.create(fields).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[ActivityRepository] Error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    }

}