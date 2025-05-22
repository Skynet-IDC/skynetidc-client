let UserLevelStats = require('../entities/UserLevelStats');

module.exports = {

    findByProfileId: async function (profileId) {
        return await UserLevelStats.findOne({
            where: {
                profile_id: profileId
            }
        });
    }

}