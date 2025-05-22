const {body, header} = require('express-validator');
const userRepository = require('../../repositories/UserRepository');
const utils = require("../../utils/CommonUtils");
const otpRepository = require("../../repositories/OtpRepository");
const otpConstant = require("../../constants/OtpConstant");
const ErrorCode = require("../../constants/ErrorCode");
const userService = require("../../services/UserService");
const TokenConstant = require("../../constants/TokenConstant");

module.exports = [
    body('phone').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập số điện thoại'})
        .isNumeric().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .isLength({min: 9, max: 11}).withMessage({
            errorCode: ErrorCode.COMMON_FAIL,
            message: 'Vui lòng nhập đúng định dạng SĐT'
        }).custom(value => {
            return userRepository.findActiveUserByPhone(utils.convertPhoneNumber(value, utils.PHONE_NOT_PREFIX)).then(user => {
                if (user) {
                    return Promise.reject({errorCode: ErrorCode.ACCOUNT_EXIST, message: 'Số điện thoại đã tồn tại'});
                }
            });
        }),
    body('password').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập mật khẩu'})
        .isLength({max: 255}).withMessage({
            errorCode: ErrorCode.COMMON_FAIL,
            message: 'Mật khẩu không được dài hơn 255 ký tự'
        }),
    body('otp').if(header('access_token').isEmpty()).notEmpty().withMessage({
            errorCode: ErrorCode.COMMON_FAIL,
            message: 'Vui lòng nhập mã xác nhận'
        }).isLength({max: 255}).withMessage({
            errorCode: ErrorCode.COMMON_FAIL,
            message: 'Mã xác nhận không được dài hơn 255 ký tự'
        }).custom((value, {req}) => {
            const isdn = utils.convertPhoneNumber(req.body.phone, utils.PHONE_NOT_PREFIX);
            return otpRepository.findByUsernameAndOtpAndTypeAndNotExpired(isdn, value, otpConstant.REGISTER_OTP_TYPE).then(checkOtp => {
                if (!checkOtp) {
                    return Promise.reject({errorCode: ErrorCode.COMMON_FAIL, message: 'Mã xác nhận không hợp lệ'});
                }
            });
        }),
    header('access_user').if(body('otp').isEmpty())
        .notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Không có thông tin xác thực'}),
    header('access_token').if(body('otp').isEmpty())
        .notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Không có thông tin xác thực'})
        .custom((value, {req}) => {
            return userService.checkOtpToken(req.headers.access_token, req.headers.access_user, TokenConstant.VERIFY_OTP_REGISTER).then(payload => {
                if (!payload) {
                    return Promise.reject({errorCode: ErrorCode.COMMON_FAIL, message: 'Thông tin xác thực không hợp lệ'});
                }
            });
        })
]