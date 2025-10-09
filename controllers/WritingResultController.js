const errorCode = require('../constants/ErrorCode');
const writingResultService = require("../services/WritingResultService");

module.exports = {
    countWritingNotify: async function (req, res) {
        try {
            // Use the authenticated user's ID from req.body.user instead of query parameter
            // This ensures users can only access their own test results
            const profile = req.body.user.profiles.find(item => item.isDefault == 1);
            let response = await writingResultService.getWritingNotify(profile.id);
            res.json({
                errorCode: errorCode.SUCCESS,
                message: 'Success get writing result notify!',
                data: response
            });
        } catch (error) {
            console.error('Error get writing result notify:', error);
            res.json({
                errorCode: errorCode.COMMON_FAIL,
                message: 'Error get writing result notify!'
            });
        }
    },

    getWritingNotify: async function (req, res) {
        try {
            // Use the authenticated user's ID from req.body.user instead of query parameter
            // This ensures users can only access their own test results
            const profile = req.body.user.profiles.find(item => item.isDefault == 1);
            let response = await writingResultService.getWritingNotify(profile.id);
            res.json({
                errorCode: errorCode.SUCCESS,
                message: 'Success get writing result notify!',
                data: response
            });
        } catch (error) {
            console.error('Error get writing result notify:', error);
            res.json({
                errorCode: errorCode.COMMON_FAIL,
                message: 'Error get writing result notify!'
            });
        }
    },

    getWritingNotifyDetail: async function (req, res) {
        try {
            // Use the authenticated user's ID from req.body.user instead of query parameter
            // This ensures users can only access their own test results
            const writingResultId = req.params.id;
            let response = await writingResultService.getWritingNotifyById(writingResultId);
            res.json({
                errorCode: errorCode.SUCCESS,
                message: 'Success get writing result notify detail!',
                data: {
                    feedback: response.feedback,
                    createdAt: response.createdAt,
                    updatedAt: response.updatedAt
                }
            });
        } catch (error) {
            console.error('Error get writing result notify detail:', error);
            res.json({
                errorCode: errorCode.COMMON_FAIL,
                message: 'Error get writing result notify detail!'
            });
        }
    }
};
