const {body} = require('express-validator');
const otpConstant = require("../../constants/OtpConstant");
const utils = require("../../utils/CommonUtils");
const accountRepository = require("../../repositories/UserRepository");
const ErrorCode = require("../../constants/ErrorCode");
const otpRepository = require("../../repositories/OtpRepository");

module.exports = [
    body('phone').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập số điện thoại'})
        .isNumeric().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .isLength({min: 9, max: 11}).withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .custom(value => {
            const isdn = utils.convertPhoneNumber(value, utils.PHONE_NOT_PREFIX);
            return accountRepository.findActiveUserByPhone(isdn).then(user => {
                if (!user) {
                    return Promise.reject({errorCode: 1, message: 'Tài khoản không tồn tại'});
                }
            });
        }),
    body('otp').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập mã xác nhận'})
        .isLength({ max: 255 }).withMessage({errorCode: 1, message: 'Mã xác nhận không được dài hơn 255 ký tự'})
        .custom((value, { req }) => {
            const isdn = utils.convertPhoneNumber(req.body.phone, utils.PHONE_NOT_PREFIX);
            return otpRepository.findByUsernameAndOtpAndTypeAndNotExpired(isdn, value, otpConstant.FORGOT_PASSWORD_OTP_TYPE).then(checkOtp => {
                if (!checkOtp) {
                    return Promise.reject({errorCode: 1, message: 'Mã xác nhận không hợp lệ'});
                }
            });
        })
]