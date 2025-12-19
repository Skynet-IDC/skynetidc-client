const { body } = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    body('isdn').trim().notEmpty().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin isdn' }),
    body('package').trim().notEmpty().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin package' }),
    body('command').trim().toLowerCase().notEmpty().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin command' }),
    body('telco').trim().optional().isInt({ min: 1, max: 5 }).withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'telco phải có giá trị 1-5. 1: Viettel, 2: Mobifone, 3: Vinaphone, 4: Vietnamobile, 5: Vietnammobile' }),
    body('days').trim().optional({ nullable: true, checkFalsy: true }).isInt().withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'days phải là số nguyên' }).isInt({ min: 1 }).withMessage({ errorCode: ErrorCode.COMMON_FAIL, message: 'days phải là số nguyên lớn hơn 0' }),
]