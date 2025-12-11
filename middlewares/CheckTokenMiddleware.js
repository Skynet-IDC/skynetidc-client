const userService = require('../services/UserService');

module.exports = async (req, res, next) => {
    let payload = await userService.checkToken(req.headers['access-token'], req.headers['access-user']);
    if (!payload) {
        return res.json({ errorCode: 1, message: 'Thông tin xác thực không hợp lệ' });
    }

    req.body.user = payload.user;

    next();
};