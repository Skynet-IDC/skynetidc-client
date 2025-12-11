const errorCode = require('../constants/ErrorCode');
const writingResultService = require("../services/WritingResultService");
const questionService = require("../services/QuestionService");

module.exports = {
    countWritingNotify: async function (req, res) {
        try {
            // Use the authenticated user's ID from req.body.user instead of query parameter
            // This ensures users can only access their own test results
            const profile = req.body.user.profiles.find(item => item.isDefault == 1);
            const topicId = req.query.topicId;
            let response = await writingResultService.countHaveFeedbackByTopicId(profile.id, topicId);
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
            const topicId = req.params.id;
            const profile = req.body.user.profiles.find(item => item.isDefault == 1);
            let writingResults = await writingResultService.getWritingNotifyByTopicId(profile.id, topicId);
            let writingResult = writingResults[0];
            let question = await questionService.getByIdAndActivity(writingResult.questionId, writingResult.activityId);
            res.json({
                errorCode: errorCode.SUCCESS,
                message: 'Success get writing result notify detail!',
                data: {
                    feedback: writingResult.feedback ? writingResult.feedback : '',
                    answers: writingResult.answers ? writingResult.answers : '',
                    question: question,
                    createdAt: writingResult.createdAt ? writingResult.createdAt : '',
                    updatedAt: writingResult.updatedAt ? writingResult.updatedAt : '',
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
