const {body} = require('express-validator');

module.exports = [
    body('phone').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập tên đăng nhập'}),
    body('password').notEmpty().withMessage({errorCode: 1, message: 'Vui lòng nhập mật khẩu'})
]