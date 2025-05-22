const {body} = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    // body('activity_id').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin ActivityID'}),
]