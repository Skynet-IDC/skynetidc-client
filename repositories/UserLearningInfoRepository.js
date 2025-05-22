let UserLearningInfo = require('../entities/UserLearningInfo');

module.exports = {

    findByProfileIdAndLevelId: async function (profileId, levelId) {
        return await UserLearningInfo.findOne({
            where: {
                profile_id: profileId,
                level_id: levelId
            }
        });
    }

}