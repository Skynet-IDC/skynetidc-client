let User = require('../entities/Account');
const utils = require("../utils/CommonUtils");
let Account = require('../entities/Account');
let Profile = require('../entities/Profile');
const {Op} = require("sequelize");

Account.hasMany(Profile, {
    sourceKey: 'id',
    foreignKey: 'account_id',
    as: 'profiles'
});

module.exports = {

    findUserById: async function (id) {
        return await User.findOne({
            where: {
                id: id
            },
            include: {
                model: Profile,
                as: 'profiles',
            }
        });
    },
    findActiveUserByPhone: async function (phone) {
        return await User.findOne({
            where: {
                phone: phone,
                phone_validated: true,
                status: 1
            },
            include: {
                model: Profile,
                as: 'profiles',
            }
        });
    },
    findActiveUserByPhoneExceptId: async function (phone, userId) {
        return await User.findOne({
            where: {
                phone: phone,
                phone_validated: true,
                status: 1,
                id: {
                    [Op.ne]: userId
                }
            },
            include: {
                model: Profile,
                as: 'profiles',
            }
        });
    },
    save: function save(fields = {}) {
        return new Promise(resolve => {
            User.create(fields).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[UserRepository] Error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    },
    update: function (userId, fields) {
        return new Promise(resolve => {
            User.update(fields, {
                where: {id: userId}
            }).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[UserRepository] Error when executing "update", detail: ${e}`);
                resolve(false);
            });
        });
    },
    updateByPhone: function (phone, fields) {
        return new Promise(resolve => {
            User.update(fields, {
                where: {phone: phone}
            }).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[UserRepository] Error when executing "updateByPhone", detail: ${e}`);
                resolve(false);
            });
        });
    }

}
