const TestResult = require('../entities/TestResult');

module.exports = {
    /**
     * Save a new test result
     * @param {Object} data - Test result data
     * @param {number} data.userId - User ID
     * @param {string} data.type - Test type (TEST_BASIC or TEST_ADVANCED)
     * @param {number} data.level - Test type (TEST_BASIC or TEST_ADVANCED)
     * @param {Array<boolean>} data.questions - Array of boolean values representing question results
     * @returns {Promise<Object>} - Created test result
     */
    save: async function (data) {
        return await TestResult.create({
            userId: data.userId,
            type: data.type,
            level: data.level,
            questions: data.questions,
            createdAt: new Date(),
            updatedAt: new Date()
        });
    },

    /**
     * Find test results by user ID
     * @param {number} userId - User ID
     * @returns {Promise<Array<Object>>} - Array of test results
     */
    findByUserId: async function (userId) {
        return await TestResult.findAll({
            where: {
                userId: userId
            },
            order: [['createdAt', 'DESC']]
        });
    },

    /**
     * Find test results by user ID and type
     * @param {number} userId - User ID
     * @param {string} type - Test type (TEST_BASIC or TEST_ADVANCED)
     * @returns {Promise<Array<Object>>} - Array of test results
     */
    findByUserIdAndType: async function (userId, type) {
        return await TestResult.findAll({
            where: {
                userId: userId,
                type: type
            },
            order: [['createdAt', 'DESC']]
        });
    },

    /**
     * Find a test result by ID
     * @param {number} id - Test result ID
     * @returns {Promise<Object>} - Test result
     */
    findById: async function (id) {
        return await TestResult.findByPk(id);
    }
};