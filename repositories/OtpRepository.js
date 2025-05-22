let Otp = require('../entities/Otp');
const utils = require("../utils/CommonUtils");
const {Op} = require("sequelize");
const moment = require('moment');

module.exports = {

    countOtpReceivedTimes: async function (username) {
        const startTime = moment().startOf('day').toDate();
        const endTime = moment().endOf('day').toDate();
        return await Otp.count({
            where: {
                username: username,
                created_at: {
                    [Op.between]: [startTime, endTime]
                }
            }
        });
    },

    findByUsernameAndOtpAndTypeAndNotExpired: async function (username, otp, type) {
        return await Otp.findOne({
            where: {
                username: username,
                otp: otp,
                type: type,
                status: 1,
                created_at: {
                    [Op.gte]: moment().subtract(90, 's').toDate()
                }
            }
        });
    },

    save: function (fields = {}) {
        return new Promise(resolve => {
            Otp.create(fields).then(result => {
                resolve(result);
            }).catch(e => {
                utils.log(`[OtpRepository] Error when executing "save", detail: ${e}`);
                resolve(false);
            })
        });
    },

    update: function (fields = {}, query) {
        return new Promise(resolve => {
            Otp.update(fields, query).then(result => {
                resolve(result);
            }).catch(e => {
                utils.log(`[OtpRepository] Error when executing "update", detail: ${e}`);
                resolve(false);
            })
        });
    }

}