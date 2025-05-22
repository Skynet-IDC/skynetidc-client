const userService = require('../services/UserService');
const otpService = require('../services/OtpService');
const bcrypt = require('bcrypt');
const config = require('../config');
const utils = require('../utils/CommonUtils');
const otpConstant = require('../constants/OtpConstant');
const errorCode = require('../constants/ErrorCode');
const jwt = require("jsonwebtoken");
const TokenConstant = require("../constants/TokenConstant");
const fs = require("fs");
const fileUtils = require("../utils/FileUtils");
const actionLogRepository = require("../repositories/ActionLogRepository");
const levelRepository = require("../repositories/LevelRepository");
const ErrorCode = require("../constants/ErrorCode");
const eventEmitter = require("../queues/events/EventEmitter");
const actionConst = require("../constants/ActionConstant");
const userRepository = require("../repositories/UserRepository");
const privateKey = fs.readFileSync('keys/private.pem');

module.exports = {

    login: async function (req, res) {
        const response = await userService.login(req.body.phone, req.body.password);
        res.json(response);
    },
    checkExist: async function (req, res) {
        utils.log(`checkExist|Phone is not exist: ${req.query.phone}`);
        return res.json({errorCode: errorCode.SUCCESS, message: "Tài khoản chưa tồn tại"});
    },
    register: async function (req, res) {
        // Send OTP to email
        const otp = utils.randomInteger(1000, 9999);
        // Save OTP to DB
        const isdn = utils.convertPhoneNumber(req.body.phone, utils.PHONE_NOT_PREFIX);
        const response = await otpService.addOtp({
            username: isdn,
            otp: otp,
            type: otpConstant.REGISTER_OTP_TYPE
        });
        // Save action log
        actionLogRepository.save({
            action: actionConst.ACTION_REGISTER_GET_OTP,
            platform: actionConst.PLATFORM_APP,
            phone: isdn,
            createdAt: new Date()
        });
        res.json(response);
    },
    registerConfirm: async function (req, res) {
        if (!utils.isEmpty(req.body.otp)) {
            // Lock OTP
            otpService.lockOtp(utils.convertPhoneNumber(req.body.phone, utils.PHONE_NOT_PREFIX), req.body.otp, otpConstant.REGISTER_OTP_TYPE);
        }
        // Save user info to DB
        const params = {
            phone: req.body.phone,
            password: req.body.password,
            phone_validated: !utils.isEmpty(req.body.otp)
        }
        const response = await userService.register(params);
        res.json(response);
    },
    forgotPassword: async function (req, res) {
        // Send OTP to email
        const otp = utils.randomInteger(1000, 9999);
        // Save OTP to DB
        const response = await otpService.addOtp({
            username: utils.convertPhoneNumber(req.body.phone, utils.PHONE_NOT_PREFIX),
            otp: otp,
            type: otpConstant.FORGOT_PASSWORD_OTP_TYPE
        });
        res.json(response);
    },
    forgotPasswordCheckOtp: async function (req, res) {
        let isdn = utils.convertPhoneNumber(req.body.phone, utils.PHONE_NOT_PREFIX);
        // Delete OTP
        otpService.lockOtp(isdn, req.body.otp, otpConstant.FORGOT_PASSWORD_OTP_TYPE);
        // Gen access token
        let token = jwt.sign(
            {type: TokenConstant.VERIFY_OTP_FORGOT_PASSWORD, phone: isdn},
            privateKey,
            {expiresIn: "5m"}
        );
        res.json({
            errorCode: errorCode.SUCCESS,
            message: "Mã xác nhận hợp lệ",
            accessToken: token
        });
    },
    forgotPasswordConfirm: async function (req, res) {
        // Update user info to DB
        const fields = {
            password: await bcrypt.hash(`${req.body.password}`, config.passwordSalt),
            created_at: new Date(),
            updated_at: new Date(),
        };
        const response = await userService.updateByPhone(req.body.phone, fields);
        res.json(response);
    },
    getLearningInfo: async function (req, res) {
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const response = await userService.getLearningInfo(profile.id, req.query.level_id);
        res.json(response);
    },
    getLearningReport: async function (req, res) {
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const response = await userService.getLearningReport(profile.id, req.query.level_id);
        res.json(response);
    },
    getLevelStats: async function (req, res) {
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const response = await userService.getLevelStats(profile.id);
        res.json(response);
    },
    info: async function (req, res) {
        const response = await userService.info(req.body.user.id);
        res.json(response);
    },
    update: async function (req, res) {
        let isUserUpdated = false;
        const fields = {updated_at: new Date()};
        if (req.body.password) {
            fields.password = await bcrypt.hash(req.body.password, config.passwordSalt);
            isUserUpdated = true;
        }
        if (req.body.level_id) {
            fields.level_id = req.body.level_id;
            // User update level
            const profile = req.body.user.profiles.find(item => item.isDefault == 1);
            eventEmitter.emit("userUpdateLevelSuccess", {
                profileId: profile.id,
                levelId: req.body.level_id
            });
        }
        if (req.body.level_code) {
            const level = await levelRepository.findByCode(req.body.level_code);
            if (level) {
                fields.level_id = level.id;
                // User update level
                const profile = req.body.user.profiles.find(item => item.isDefault == 1);
                eventEmitter.emit("userUpdateLevelSuccess", {
                    profileId: profile.id,
                    levelId: level.id
                });
            }
        }
        if (req.body.fullname) {
            fields.name = req.body.fullname;
        }
        if (req.body.image) {
            const baseDir = 'statics/avatar';
            const fileName = utils.md5(req.body.user.phone + new Date().getTime()) + '.jpg';
            const filePath = fileUtils.generateFilePath(baseDir, fileName);
            // Save base64 to file
            fileUtils.saveBase64ToFile(req.body.image, filePath);
            fields.avatar = "/" + filePath;
        }
        if (isUserUpdated) {
            const response = await userService.updateUser(req.body.user.id, fields);
            if (response.errorCode === ErrorCode.SUCCESS && req.body.password) {
                response.message = 'Mật khẩu đã được đổi thành công.';
            }
            res.json(response);
        } else {
            const profile = req.body.user.profiles.find(item => item.isDefault == 1);
            const response = await userService.updateProfile(req.body.user.id, profile.id, fields);
            res.json(response);
        }
    },
    disable: async function (req, res) {
        const response = await userService.disableUser(req.body.user.id);
        res.json(response);
    },
    phoneVerificationGetOtp: async function (req, res) {
        // Send OTP to email
        const otp = utils.randomInteger(1000, 9999);
        // Save OTP to DB
        const isdn = utils.convertPhoneNumber(req.body.phone, utils.PHONE_NOT_PREFIX);
        const response = await otpService.addOtp({
            username: isdn,
            otp: otp,
            type: otpConstant.PHONE_VERIFICATION
        });
        // Save action log
        actionLogRepository.save({
            action: actionConst.ACTION_PHONE_VERIFICATION_GET_OTP,
            platform: actionConst.PLATFORM_APP,
            phone: isdn,
            createdAt: new Date()
        });
        res.json(response);
    },
    phoneVerificationConfirm: async function (req, res) {
        if (!utils.isEmpty(req.body.otp)) {
            // Lock OTP
            otpService.lockOtp(utils.convertPhoneNumber(req.body.phone, utils.PHONE_NOT_PREFIX), req.body.otp, otpConstant.PHONE_VERIFICATION);
        }
        // Save user info to DB
        const fields = {
            phone_validated: true
        }
        const response = await userService.updateUser(req.body.user.id, fields);
        res.json(response);
    }

}
