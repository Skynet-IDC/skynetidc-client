const levelService = require('../services/LevelService');
const unitService = require('../services/UnitService');
const activityService = require('../services/ActivityService');
const errorCode = require("../constants/ErrorCode");
const writingResultService = require("../services/WritingResultService");
const UserLearningInfoRepository = require("../repositories/UserLearningInfoRepository");

module.exports = {

    getLevelList: async function (req, res) {
        const response = await levelService.getLevelList();
        res.json(response);
    },

    getUnitList: async function (req, res) {
        const response = await unitService.getUnitList(req.query.level_id, req.query.unit_id, req.query.page, req.query.reverse);
        res.json(response);
    },

    getUnitListByLevel: async function (req, res) {
        try {
            const profile = req.body.user.profiles.find(item => item.isDefault == 1);
            const response = await unitService.getUnitList(req.query.level_id, null, req.query.page, req.query.reverse);

            const learningInfo = await UserLearningInfoRepository.findByProfileIdAndLevelId(profile.id, req.query.level_id)
            const units = response.data.items;
            const unitLearningInfos = JSON.parse(learningInfo?.units) || [];
            units.forEach(unit => {
                const unitLearningInfo = unitLearningInfos[`${unit.id}`];
                unit.isActive = !!unitLearningInfo;
            })
            let responseWritingNotify = await writingResultService.countHaveFeedbackByTopicId(profile.id, null);
            res.json({
                errorCode: errorCode.SUCCESS,
                message: 'Success get unit by level id',
                units: response.data.items,
                notifications: responseWritingNotify
            });
        } catch (error) {
            console.error('Error get unit by level id:', error);
            res.json({
                errorCode: errorCode.COMMON_FAIL,
                message: 'Error get unit by level id!'
            });
        }

    },

    getActivityList: async function (req, res) {
        const response = await activityService.getActivityList(req.query.part_id);
        res.json(response);
    },
    
    getTestList: async function (req, res) {
        const response = await activityService.getActivityList(0); // Assuming 0 is used for test activities
        res.json(response);
    },

    getTestResults: async function (req, res) {
        const response = await activityService.getTestResults(req.query.level_id);
        res.json(response);
    },

    getWords: async function (req, res) {
        const response = await unitService.getWords(req.query.unit_id);
        res.json(response);
    },

}