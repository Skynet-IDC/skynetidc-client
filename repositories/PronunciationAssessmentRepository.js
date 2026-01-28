let PronunciationAssessment = require('../entities/PronunciationAssessment');
const utils = require("../utils/CommonUtils");

module.exports = {

    save: function save(fields = {}) {
        return new Promise(resolve => {
            PronunciationAssessment.create(fields).then(result => {
                resolve(result);
            }).catch((e) => {
                utils.log(`[PronunciationAssessmentRepository] Error when executing "save", detail: ${e}`);
                resolve(false);
            });
        });
    },

    updateScore: function update(profileId, activityId, levelId, score) {
    return new Promise(resolve => {
        PronunciationAssessment.update(
            { score: score },
            {
                where: { 
                    profile_id: profileId,
                    activity_id: activityId,
                    level_id: levelId
                },
                order: [['start_time', 'DESC']],
                limit: 1
            }
        ).then(result => {
            resolve(result);
        }).catch((e) => {
            utils.log(`[PronunciationAssessmentRepository] Error when executing "updateScore", detail: ${e}`);
            resolve(false);
        });
    });
}

}