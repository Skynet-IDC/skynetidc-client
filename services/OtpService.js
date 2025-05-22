const otpRepository = require('../repositories/OtpRepository');
const errorCode = require('../constants/ErrorCode');
const jwt = require("jsonwebtoken");
const TokenConstant = require("../constants/TokenConstant");
const fs = require("fs");
const utils = require("../utils/CommonUtils");
const config = require("../config");
const smsUtils = require("../utils/SMSUtils");
const privateKey = fs.readFileSync('keys/private.pem');

module.exports = {

    addOtp: async function addOtp(fields = {}) {
        // Check OTP exists
        let otpCount = await otpRepository.countOtpReceivedTimes(fields.username);
        if (otpCount >= 3) {
            // Gen access token
            let token = jwt.sign(
                {type: TokenConstant.VERIFY_OTP_REGISTER, phone: fields.username},
                privateKey,
                {expiresIn: "5m"}
            );
            return {errorCode: errorCode.OTP_LIMIT_REACHING, message: 'Vượt quá số lần lấy mã xác nhận', accessToken: token};
        }
        const updateResult = await otpRepository.update({status: 0, updated_at: new Date()}, {
            where: {
                username: fields.username,
                type: fields.type,
                status: 1
            }
        });
        if (!updateResult) {
            return {errorCode: errorCode.COMMON_FAIL, message: 'Lấy mã xác nhận thất bại'};
        }
        const saveResult = await otpRepository.save({
            username: fields.username,
            otp: fields.otp,
            type: fields.type,
            status: 1,
            created_at: new Date(),
            updated_at: new Date()
        });
        if (!saveResult) {
            return {errorCode: errorCode.COMMON_FAIL, message: 'Lấy mã xác nhận thất bại'};
        }
        // Send SMS
        const msisdn = utils.convertPhoneNumber(fields.username, utils.PHONE_GLOBAL);
        let content = config.sms.content.text.replace("%OTP%", fields.otp);
        const smsResult = await smsUtils.sendOtpSMS(msisdn, content);
        if (!smsResult) {
            return {errorCode: errorCode.COMMON_FAIL, message: 'Gửi mã xác nhận đến SĐT không thành công'};
        }
        return {errorCode: errorCode.SUCCESS, message: 'Gửi mã xác nhận thành công'};
    },

    lockOtp: async function lockOtp(username, otp, type) {
        return otpRepository.update({status: 0, updated_at: new Date()}, {
            where: {
                username: username,
                otp: otp,
                type: type,
                status: 1
            }
        });
    }

}
