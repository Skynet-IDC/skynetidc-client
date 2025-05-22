const userService = require('../services/UserService');

module.exports = async (req, res, next) => {
    let payload = await userService.checkOtpToken(req.headers.access_token, req.headers.access_user);
    if (!payload) {
        return res.json({ errorCode: 1, message: 'Thông tin xác thực không hợp lệ' });
    }

    next();
};