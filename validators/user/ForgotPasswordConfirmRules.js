const {body} = require('express-validator');
const userRepository = require("../../repositories/UserRepository");
const utils = require("../../utils/CommonUtils");

module.exports = [
    body('phone').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập số điện thoại'})
        .isNumeric().withMessage({errorCode: 1, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .isLength({min: 9, max: 11}).withMessage({errorCode: 1, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .custom(value => {
            return userRepository.findActiveUserByPhone(utils.convertPhoneNumber(value, utils.PHONE_NOT_PREFIX)).then(user => {
                if (!user) {
                    return Promise.reject({errorCode: 1, message: 'Tài khoản không tồn tại'});
                }
            });
        }),
    body('password').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập mật khẩu'})
        .isLength({ max: 255 }).withMessage({errorCode: 1, message: 'Mật khẩu không được dài hơn 255 ký tự'}),
    body('retype_password').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập lại mật khẩu'})
        .isLength({ max: 255 }).withMessage({errorCode: 1, message: 'Mật khẩu nhập lại không được dài hơn 255 ký tự'})
        .custom((value, { req }) => {
            return value === req.body.password;
        }).withMessage({errorCode: 1, message: 'Mật khẩu nhập lại không khớp'})
]