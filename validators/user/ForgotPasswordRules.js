const {body} = require('express-validator');
const userRepository = require('../../repositories/UserRepository');
const utils = require("../../utils/CommonUtils");
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    body('phone').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập số điện thoại'})
        .isNumeric().withMessage({errorCode: 1, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .isLength({min: 9, max: 11}).withMessage({errorCode: 1, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .custom(value => {
            return userRepository.findActiveUserByPhone(utils.convertPhoneNumber(value, utils.PHONE_NOT_PREFIX)).then(user => {
                if (!user) {
                    return Promise.reject({errorCode: ErrorCode.ACCOUNT_NOT_EXISTS, message: 'Số điện thoại này chưa đăng ký tài khoản, bạn hãy nhập số khác nhé'});
                }
            });
        })
]