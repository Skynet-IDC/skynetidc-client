const levelService = require('../services/LevelService');
const unitService = require('../services/UnitService');
const activityService = require('../services/ActivityService');
const { getTestResults } = require('./TestResultController');
const errorCode = require("../constants/ErrorCode");

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
        const response = await unitService.getUnitList(req.query.level_id, null, req.query.page, req.query.reverse);
        res.json({
            errorCode: errorCode.SUCCESS,
            message: 'Success get unit by level.',
            data: response
        });
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