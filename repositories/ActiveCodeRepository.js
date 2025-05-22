let ActiveCode = require('../entities/ActiveCode');
const utils = require("../utils/CommonUtils");
const Package = require("../entities/Package");
const Profile = require("../entities/Profile");
let Account = require('../entities/Account');

ActiveCode.belongsTo(Package, {
    targetKey: 'id',
    foreignKey: 'package_id',
    as: 'package'
});

ActiveCode.belongsTo(Profile, {
    targetKey: 'id',
    foreignKey: 'activated_by',
    as: 'profile'
});

module.exports = {

    findByCode: async function (code) {
        return await ActiveCode.findOne({
            where: {
                code: code
            }
        });
    },

    findByCodeIncludePackageAndProfileAndAccount: async function (code) {
        return await ActiveCode.findOne({
            where: {
                code: code
            },
            include: [
                {
                  model: Package,
                  as: 'package'
                },
                {
                    model: Profile,
                    as: 'profile',
                    include: {
                        model: Account,
                        as: 'account'
                    }
                }
            ]
        });
    },

    findByCodeIncludePackage: async function (code) {
        return await ActiveCode.findOne({
            where: {
                code: code
            },
            include: {
                model: Package,
                as: 'package'
            }
        });
    },

    updateByCode: function (code, fields) {
        return new Promise(resolve => {
            ActiveCode.update(fields, {
                where: {code: code}
            }).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[ActiveCodeRepository] Error when executing "update", detail: ${e}`);
                resolve(false);
            });
        });
    },

    saveMany: function (records = []) {
        return new Promise(resolve => {
            ActiveCode.bulkCreate(records).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[ActiveCodeRepository] Error when executing "saveMany", detail: ${e}`);
                resolve(false);
            });
        });
    }

}
