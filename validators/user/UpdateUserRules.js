const {body} = require('express-validator');
const bcrypt = require("bcrypt");
const ErrorCode = require("../../constants/ErrorCode");
const userRepository = require("../../repositories/UserRepository");

module.exports = [
    body('image').if(body('image').notEmpty()).custom((value, {req}) => {
        return ['/', 'i'].includes(req.body.image.charAt(0));
    }).withMessage({errorCode: 1, message: 'File không đúng định dạng'}),
    body('current_password').if(body('password').notEmpty())
        .notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập mật khẩu cũ'})
        .custom((currentPassword, { req }) => {
            return userRepository.findActiveUserByPhone(req.body.user.phone).then(user => {
                return bcrypt.compare(currentPassword, user.password).then(result => {
                    if (!result) {
                        return Promise.reject({errorCode: ErrorCode.COMMON_FAIL, message: 'Mật khẩu cũ chưa chính xác. Vui lòng nhập lại.'});
                    }
                })
            });
        })
]