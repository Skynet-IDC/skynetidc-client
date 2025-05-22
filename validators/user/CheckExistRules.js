const {query} = require('express-validator');
const userRepository = require('../../repositories/UserRepository');
const utils = require("../../utils/CommonUtils");
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    query('phone').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập số điện thoại'})
        .isNumeric().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .isLength({min: 9, max: 11}).withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .custom(value => {
            return userRepository.findActiveUserByPhone(utils.convertPhoneNumber(value, utils.PHONE_NOT_PREFIX)).then(user => {
                if (user) {
                    return Promise.reject({errorCode: ErrorCode.ACCOUNT_EXIST, message: 'Số điện thoại đã tồn tại'});
                }
            });
        })
]