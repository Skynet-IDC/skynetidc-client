const {body} = require('express-validator');
const userRepository = require('../../repositories/UserRepository');

module.exports = [
    body('otp').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập mã xác thực'}),
    body('username').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập username'}).custom(value => {
        return userRepository.findUserByUsername(value).then(user => {
            if (user) {
                return Promise.reject({errorCode: 1, message: 'Tên đăng nhập đã tồn tại'});
            }
        });
    }),
    body('password').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập mật khẩu'}),
    body('email').if(body('email').notEmpty()).isEmail().withMessage({
        errorCode: 1,
        message: 'Vui lòng nhập đúng định dạng email'
    }),
    body('phone').if(body('phone').notEmpty()).isNumeric().withMessage({errorCode: 1, message: 'Vui lòng nhập đúng định dạng SĐT'})
        .isLength({min: 9, max: 11}).withMessage({errorCode: 1, message: 'Vui lòng nhập đúng định dạng SĐT'}),
    body('image').if(body('image').notEmpty()).custom((value, {req}) => {
        if (!['/', 'i'].includes(req.image.charAt(0))) {
            return false;
        }
    }).withMessage({errorCode: 1, message: 'File không đúng định dạng'})
]