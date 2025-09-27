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

    findByLevelIdAndActivityId: async function (levelId, activityId) {
        return await UserLearningInfo.findOne({
            where: {
                level_id: levelId,
                profile_id: activityId
            }
        });
    },

    update: async function (profileId, levelId, fields = {}) {
        return new Promise(async resolve => {
            UserLearningInfo.update(fields, {
                where: {
                    profile_id: profileId,
                    level_id: levelId
                }
            }).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[UserLearningInfoRepository] Error when executing "update", detail: ${e}`);
                resolve(false);
            });
        });
    }

}