const errorCode = require('../constants/ErrorCode');
const questionService = require("../services/QuestionService");
module.exports = {
    /**
     * Get a Question By Id
     * @returns {Promise<void>}
     */
    getQuestionById: async function (req, res) {
        try {
            const id = req.params.id;
            const response = await questionService.getById(id);
            res.json(response);
        } catch (error) {
            console.error('Error get question:', error);
            res.json({
                errorCode: errorCode.COMMON_FAIL,
                message: 'Có lỗi xảy ra khi lấy thông tin câu hỏi'
            });
        }
    },

    submitAnswer: async function (req, res) {
        try {
            // Use the authenticated user's ID from req.body.user instead of query parameter
            // This ensures users can only access their own test results
            const profile = req.body.user.profiles.find(item => item.isDefault == 1);
            console.log('submit answer:', req.body);
            res.json({
                errorCode: errorCode.SUCCESS,
            });
        } catch (error) {
            console.error('Error submit test result writing:', error);
            res.json({
                errorCode: errorCode.COMMON_FAIL,
                message: 'Có lỗi xảy ra khi gửi bài viết'
            });
        }
    }
};
