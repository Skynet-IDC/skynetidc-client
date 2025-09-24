const utils = require("../utils/CommonUtils");
const activityService = require("../services/ActivityService");
const PracticeService = require("../services/PracticeService");
const questionService = require("../services/QuestionService");
const ErrorCode = require("../constants/ErrorCode");
const { submitTestResult } = require("./TestResultController");

module.exports = {

    getInfo: async function (req, res) {
        const id = req.params.id;
        try {
            const response = await activityService.getActivityInfo(id);
            res.json(response);
        } catch (e) {
            res.status(404).json({
                success: false,
                message: 'Không tồn tại dữ liệu',
            });
        }
    },

    buildQuestionData: async function (req, res) {
        const id = req.params.id;
        const response = await questionService.build(id);
        res.json(response);
    },

    submitTestResult: async function (req, res) {
        utils.log(`submitTestResult|Start execute, headers: ${JSON.stringify(req.headers)}, `
            + `body: ${JSON.stringify(req.body)}`);
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        let levelId = req.body.level_id ? parseInt(req.body.level_id) : null;
        let fields = {};
        if (req.body.results) {
            fields.test_results = parseInt(req.body.results);
        }

        let response = await activityService.updateTestResults(profile.id, levelId, fields);
        res.json(response);
    },

    submitActivityScore: async function (req, res) {
        utils.log(`submitActivityScore|Start execute, headers: ${JSON.stringify(req.headers)}, `
            + `body: ${JSON.stringify(req.body)}`);
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const responseData = {
            profileId: profile.id,
            activityId: req.body.activity_id ? parseInt(req.body.activity_id) : null,
            levelId: req.body.level_id ? parseInt(req.body.level_id) : null,
            startTime: req.body.start_time ? new Date(req.body.start_time) : null,
            timeSpent: req.body.time_spent ? parseInt(req.body.time_spent) : null,
            score: parseInt(req.body.score),
            questionResponsesHolders: JSON.stringify(req.body.question_responses_holders) || null,
            isPracticeConversation: req.body.is_practice_conversation ? 1 : 0,
            createdAt: new Date()
        }
        let response;
        if (req.body.is_practice_conversation) { // Game hoi thoaij practice -> luu rieng
            response = await PracticeService.savePracticeConversationScore(responseData);
        } else {
            response = await activityService.saveScore(responseData);
        }
        res.json(response);
    },

}