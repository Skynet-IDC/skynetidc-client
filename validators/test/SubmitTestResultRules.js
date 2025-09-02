const { body } = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    body('type')
        .notEmpty().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin loại bài kiểm tra' })
        .isIn(['TEST_BASIC', 'TEST_ADVANCED']).withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Loại bài kiểm tra không hợp lệ' }),
    
    body('questions')
        .notEmpty().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin kết quả câu hỏi' })
        .isArray().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Kết quả câu hỏi phải là mảng' })
        .custom(questions => {
            if (!Array.isArray(questions)) return false;
            return questions.every(q => typeof q === 'boolean');
        }).withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Kết quả câu hỏi phải là mảng các giá trị boolean' }),
    
    body('user_id')
        .notEmpty().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin user_id' })
        .isInt().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'user_id phải là số nguyên' }),
    
    body('level')
        .optional()
        .isInt().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'level phải là số nguyên' })
];