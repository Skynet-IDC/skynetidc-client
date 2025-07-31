const testResultRepository = require('../repositories/TestResultRepository');
const errorCode = require('../constants/ErrorCode');

module.exports = {
    /**
     * Submit a test result
     * @param {Object} req - Express request object
     * @param {Object} res - Express response object
     * @returns {Promise<void>}
     */
    submitTestResult: async function (req, res) {
        try {
            const { type, questions, user_id, level } = req.body;
            
            // Save test result to database
            const testResult = await testResultRepository.save({
                userId: user_id,
                type: type,
                questions: questions,
                level: level
            });
            
            res.json({
                errorCode: errorCode.SUCCESS,
                message: 'Lưu kết quả bài kiểm tra thành công',
                data: {
                    id: testResult.id,
                    userId: testResult.userId,
                    type: testResult.type,
                    questions: testResult.questions,
                    level: testResult.level,
                    createdAt: testResult.createdAt
                }
            });
        } catch (error) {
            console.error('Error submitting test result:', error);
            res.json({
                errorCode: errorCode.COMMON_FAIL,
                message: 'Có lỗi xảy ra khi lưu kết quả bài kiểm tra'
            });
        }
    },

    /**
     * Get test results by user ID
     * @param {Object} req - Express request object
     * @param {Object} res - Express response object
     * @returns {Promise<void>}
     */
    getTestResults: async function (req, res) {
        try {
            // Use the authenticated user's ID from req.body.user instead of query parameter
            // This ensures users can only access their own test results
            const userId = req.body.user.id;
            const type = req.query.type;
            
            let testResults;
            if (type) {
                testResults = await testResultRepository.findByUserIdAndType(userId, type);
            } else {
                testResults = await testResultRepository.findByUserId(userId);
            }
            
            res.json({
                errorCode: errorCode.SUCCESS,
                message: 'Lấy kết quả bài kiểm tra thành công',
                data: testResults
            });
        } catch (error) {
            console.error('Error getting test results:', error);
            res.json({
                errorCode: errorCode.COMMON_FAIL,
                message: 'Có lỗi xảy ra khi lấy kết quả bài kiểm tra'
            });
        }
    }
};