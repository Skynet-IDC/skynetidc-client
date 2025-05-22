const {body} = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    // body('package_id').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin package_id'}),
    body('transaction_id').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin transaction_id'}),
    body('channel').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin channel'}),
    body('status').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin status'}),
    body('product_id').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin product_id'})
]