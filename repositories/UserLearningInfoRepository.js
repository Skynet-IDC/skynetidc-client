let UserLearningInfo = require('../entities/UserLearningInfo');
const { update } = require('./UserRepository');

module.exports = {

    findByProfileIdAndLevelId: async function (profileId, levelId) {
        return await UserLearningInfo.findOne({
            where: {
                profile_id: profileId,
                level_id: levelId
            }
        });
    },

    update: async function (profileId, levelId, fields = {}) {
        return new Promise(async resolve => {
            let learningInfo = await this.findByProfileIdAndLevelId(profileId, levelId);
            if (learningInfo) {
                // Update
                learningInfo.update(fields).then(result => {
                    resolve(result);
                }).catch((e) => {
                    utils.log(`[UserLearningInfoRepository] Error when executing "update", detail: ${e}`);
                    resolve(false);
                });
            }
        });
    }

}