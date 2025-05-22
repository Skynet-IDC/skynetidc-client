const {body} = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");
const utils = require("../../utils/CommonUtils");

module.exports = [
    body('phone').notEmpty().withMessage({errorCode: 1, message: 'Thiếu thông tin số điện thoại'})
        .custom((value, { req }) => {
            return req.body.user.phone == utils.convertPhoneNumber(value, utils.PHONE_NOT_PREFIX);
        }).withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Số điện thoại không chính xác'})
]