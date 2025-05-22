const {body} = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    body('amount').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin Amount'}),
    body('reason').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin Reason'})
]