const {body} = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    body('number').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin number'}),
    body('package_id').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin package_id'}),
    body('created_by').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin created_by'}),
]
