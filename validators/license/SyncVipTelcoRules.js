const { body } = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    body('isdn').notEmpty().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin isdn' }),
    body('package').notEmpty().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin package' }),
    body('command').notEmpty().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin command' }),
    body('telco').optional().isInt({ min: 1, max: 5 }).withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'telco phải có giá trị 1-5. 1: Viettel, 2: Mobifone, 3: Vinaphone, 4: Vietnamobile, 5: Vietnammobile' }),
    body('days').optional().isInt({ min: 1 }).withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'days phải là số nguyên dương' }),
]