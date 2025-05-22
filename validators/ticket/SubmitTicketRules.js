const {body} = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");
const TicketConst = require("../../constants/TicketConstant");
const utils = require("../../utils/CommonUtils");

module.exports = [
    body('type').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin loại báo lỗi'})
        .isIn(TicketConst.REPORT_TYPES).withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Loại báo lỗi không hợp lệ'}),
    body('description').if(body('type').equals('OTHER'))
        .notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin mô tả lỗi'}),
    body('params').custom(value => {
        return utils.isJsonString(value);
    }).withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Tham số không hợp lệ'})
]