const utils = require("../utils/CommonUtils");
const config = require("../config");
const ErrorCode = require("../constants/ErrorCode");

module.exports = async (req, res, next) => {
    let ip;
    if (req.headers["x-forwarded-for"]) {
        ip = req.headers["x-forwarded-for"].split(",")[0];
    } else if (req.connection && req.connection.remoteAddress) {
        ip = req.connection.remoteAddress;
    } else {
        ip = req.ip;
    }
    utils.log(`Request IP address: ${ip}`);
    if (!config.whiteListIp.includes(ip)) {
        return res.json({ errorCode: ErrorCode.COMMON_FAIL, message: 'Không có quyền sử dụng' });
    }

    next();
};
