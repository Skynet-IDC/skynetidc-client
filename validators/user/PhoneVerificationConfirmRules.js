const {body, header} = require('express-validator');
const utils = require("../../utils/CommonUtils");
const ErrorCode = require("../../constants/ErrorCode");
const otpRepository = require("../../repositories/OtpRepository");
const otpConstant = require("../../constants/OtpConstant");
const userRepository = require("../../repositories/UserRepository");

module.exports = [
    body('phone').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập số điện thoại'})
        .isNumeric().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .isLength({min: 9, max: 11}).withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .custom((value, {req}) => {
            return userRepository.findActiveUserByPhoneExceptId(utils.convertPhoneNumber(value, utils.PHONE_NOT_PREFIX),
                req.body.user.id).then(user => {
                if (user) {
                    return Promise.reject({errorCode: ErrorCode.ACCOUNT_EXIST, message: 'Số điện thoại đã tồn tại'});
                }
            });
        }),
    body('otp').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập mã xác nhận'})
    .isLength({max: 255}).withMessage({
        errorCode: ErrorCode.COMMON_FAIL,
        message: 'Mã xác nhận không được dài hơn 255 ký tự'
    }).custom((value, {req}) => {
        const isdn = utils.convertPhoneNumber(req.body.phone, utils.PHONE_NOT_PREFIX);
        return otpRepository.findByUsernameAndOtpAndTypeAndNotExpired(isdn, value, otpConstant.PHONE_VERIFICATION).then(checkOtp => {
            if (!checkOtp) {
                return Promise.reject({errorCode: ErrorCode.COMMON_FAIL, message: 'Mã xác nhận không hợp lệ'});
            }
        });
    })
]
