const levelService = require('../services/LevelService');
const unitService = require('../services/UnitService');
const activityService = require('../services/ActivityService');

module.exports = {

    getLevelList: async function (req, res) {
        const response = await levelService.getLevelList();
        res.json(response);
    },

    getUnitList: async function (req, res) {
        const response = await unitService.getUnitList(req.query.level_id, req.query.unit_id, req.query.page, req.query.reverse);
        res.json(response);
    },

    getActivityList: async function (req, res) {
        const response = await activityService.getActivityList(req.query.part_id);
        res.json(response);
    },
    
    getTestList: async function (req, res) {
        const response = await activityService.getActivityList(0); // Assuming 0 is used for test activities
        res.json(response);
    },

    getWords: async function (req, res) {
        const response = await unitService.getWords(req.query.unit_id);
        res.json(response);
    },

}