const ProfilePackage = require("../entities/ProfilePackage");
const utils = require("../utils/CommonUtils");

module.exports = {

    save: async function (profilePackage) {
        return new Promise(resolve => {
            ProfilePackage.create(profilePackage).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`save profile package error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    },

    findByCode: async function (code) {
        return await ProfilePackage.findOne({
            where: {
                code: code
            }
        });
    }

}
