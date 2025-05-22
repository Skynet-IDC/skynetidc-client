let UserLearningReport = require('../entities/UserLearningReport');

module.exports = {

    findByProfileIdAndLevelId: async function (profileId, levelId) {
        return await UserLearningReport.findOne({
            where: {
                profile_id: profileId,
                level_id: levelId
            }
        });
    }

}