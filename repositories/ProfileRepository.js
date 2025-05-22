let Profile = require('../entities/Profile');
let ProfilePackage = require('../entities/ProfilePackage');
let Package = require('../entities/Package');
let Account = require('../entities/Account');
const utils = require("../utils/CommonUtils");

Profile.belongsTo(Account, {
    targetKey: 'id',
    foreignKey: 'account_id',
    as: 'account'
});

Profile.hasMany(ProfilePackage, {
    sourceKey: 'id',
    foreignKey: 'profile_id',
    as: 'profilePackages'
});

ProfilePackage.belongsTo(Package, {
    targetKey: 'id',
    foreignKey: 'package_id',
    as: 'package'
});

module.exports = {

    findById: async function (id) {
        return await Profile.findOne({
            where: {
                id: id,
            }
        });
    },

    findByIdIncludePackages: async function (id) {
        return await Profile.findOne({
            where: {
                id: id,
            },
            include: {
                model: ProfilePackage,
                as: 'profilePackages',
                include: {
                    model: Package,
                    as: 'package'
                }
            }
        });
    },

    save: function save(fields = {}) {
        return new Promise(resolve => {
            Profile.create(fields).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[ProfileRepository] Error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    },

    update: function (profileId, fields) {
        return new Promise(resolve => {
            Profile.update(fields, {
                where: {id: profileId}
            }).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[ProfileRepository] Error when executing "update", detail: ${e}`);
                resolve(false);
            });
        });
    },

    updateWithCondition: function (conditions, fields) {
        return new Promise(resolve => {
            Profile.update(fields, {
                where: conditions
            }).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[ProfileRepository] Error when executing "updateWithCondition", detail: ${e}`);
                resolve(false);
            });
        });
    },

}