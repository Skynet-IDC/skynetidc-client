let FreeStudyLog = require('../entities/FreeStudyLog');
const moment = require("moment");
const {Op} = require("sequelize");
const Otp = require("../entities/Otp");
const utils = require("../utils/CommonUtils");

module.exports = {

    sumAmountByProfileIdToday: async function (profileId) {
        const startTime = moment().startOf('day').toDate();
        const endTime = moment().endOf('day').toDate();
        return await FreeStudyLog.sum('amount', {
            where: {
                profile_id: profileId,
                created_at: {
                    [Op.between]: [startTime, endTime]
                }
            }
        });
    },

    save: function (fields = {}) {
        return new Promise(resolve => {
            FreeStudyLog.create(fields).then(result => {
                resolve(result);
            }).catch(e => {
                utils.log(`[FreeStudyLogRepository] Error when executing "save", detail: ${e}`);
                resolve(false);
            })
        });
    }

}