const jwt = require('jsonwebtoken');
const fs = require('fs');
const privateKey = fs.readFileSync('keys/private.pem');
const bcrypt = require('bcrypt');
const utils = require("../utils/CommonUtils");
const config = require("../config");
const userRepository = require('../repositories/UserRepository');
const profileRepository = require("../repositories/ProfileRepository");
const userLearningInfoRepository = require("../repositories/UserLearningInfoRepository");
const userLearningReportRepository = require("../repositories/UserLearningReportRepository");
const userLevelStatsRepository = require("../repositories/UserLevelStatsRepository");
const actionLogRepository = require("../repositories/ActionLogRepository");
const ErrorCode = require("../constants/ErrorCode");
const TokenConstant = require("../constants/TokenConstant");
const UserMapper = require("../mappers/UserMapper");
const TokenPayloadUserMapper = require("../mappers/TokenPayloadUserMapper");
const LearningInfoMapper = require("../mappers/LearningInfoMapper");
const LearningReportMapper = require("../mappers/LearningReportMapper");
const LevelStatsMapper = require("../mappers/LevelStatsMapper");
const actionConst = require("../constants/ActionConstant");

module.exports = {

    login: async function login(phone, password) {
        const isdn = utils.convertPhoneNumber(phone, utils.PHONE_NOT_PREFIX);
        let user = await userRepository.findActiveUserByPhone(isdn);
        if (!user) {
            return {errorCode: ErrorCode.COMMON_FAIL, message: 'Số điện thoại hoặc mật khẩu không đúng. Vui lòng nhập lại.'};
        }

        let result = await bcrypt.compare(password, user.password);
        if (result) {
            // Gen access token
            const mappedUser = TokenPayloadUserMapper(user);
            let token = jwt.sign({user: mappedUser}, privateKey, {expiresIn: '1y'});
            // Find action log
            const isFirstTimeLogIn = (await actionLogRepository.findByAccountId(user.id)) === null;
            // Save action log
            const profile = mappedUser.profiles.find(profile => profile.isDefault == 1);
            actionLogRepository.save({
                action: actionConst.ACTION_LOGGED_IN,
                platform: actionConst.PLATFORM_APP,
                phone: isdn,
                accountId: mappedUser.id,
                profileId: profile.id,
                createdAt: new Date()
            });
            return {errorCode: ErrorCode.SUCCESS, message: 'Đăng nhập thành công', accessToken: token, data: {user: UserMapper(user, isFirstTimeLogIn)}};
        } else {
            return {errorCode: ErrorCode.COMMON_FAIL, message: 'Số điện thoại hoặc mật khẩu không đúng. Vui lòng nhập lại.'};
        }
    },
    register: async function register(params = {}) {
        const isdn = utils.convertPhoneNumber(params.phone, utils.PHONE_NOT_PREFIX);
        const fields = {
            phone: isdn,
            phone_validated: params.phone_validated,
            password: await bcrypt.hash(params.password, config.passwordSalt),
            status: 1,
            created_at: new Date(),
            updated_at: new Date()
        };
        let account = await userRepository.save(fields);
        if (!account) {
            return {errorCode: ErrorCode.COMMON_FAIL, message: "Tạo tài khoản thất bại"};
        }
        // Save profile
        const profileFields = {
            name: 'Học viên',
            status: 1,
            account_id: account.id,
            is_default: 1,
            created_at: new Date(),
            updated_at: new Date()
        };
        const profile = await profileRepository.save(profileFields);
        if (!profile) {
            return {errorCode: ErrorCode.COMMON_FAIL, message: "Tạo tài khoản thất bại"};
        }
        const userInfo = await userRepository.findActiveUserByPhone(isdn);
        // Gen access token
        const token = jwt.sign({user: TokenPayloadUserMapper(userInfo)}, privateKey, {expiresIn: '1y'});
        // Find action log
        const isFirstTimeLogIn = (await actionLogRepository.findByAccountId(userInfo.id)) === null;
        // Save action log
        actionLogRepository.save({
            action: actionConst.ACTION_LOGGED_IN,
            platform: actionConst.PLATFORM_APP,
            phone: isdn,
            accountId: userInfo.id,
            profileId: profile.id,
            createdAt: new Date()
        });
        return {errorCode: 0, message: 'Tạo tài khoản thành công', accessToken: token, data: {user: UserMapper(userInfo, isFirstTimeLogIn)}};
    },
    info: async function info(id) {
        let user = await userRepository.findUserById(id);
        if (!user) {
            return {errorCode: ErrorCode.COMMON_FAIL, message: 'Không lấy được thông tin tài khoản'};
        }
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {user: UserMapper(user)}};
    },
    updateUser: async function (id, fields) {
        let result = await userRepository.update(id, fields);
        if (result) {
            const userInfo = await userRepository.findUserById(id);
            // Gen access token
            let token = jwt.sign({user: TokenPayloadUserMapper(userInfo)}, privateKey, {expiresIn: '1y'});
            return {errorCode: ErrorCode.SUCCESS, message: 'Cập nhật tài khoản thành công', accessToken: token, data: { user: UserMapper(userInfo) }};
        } else {
            return {errorCode: ErrorCode.COMMON_FAIL, message: 'Cập nhật tài khoản thất bại'};
        }
    },
    updateProfile: async function (userId, profileId, fields) {
        let result = await profileRepository.update(profileId, fields);
        if (result) {
            const userInfo = await userRepository.findUserById(userId);
            // Gen access token
            let token = jwt.sign({user: TokenPayloadUserMapper(userInfo)}, privateKey, {expiresIn: '1y'});
            return {errorCode: ErrorCode.SUCCESS, message: 'Cập nhật tài khoản thành công', accessToken: token, data: { user: UserMapper(userInfo) }};
        } else {
            return {errorCode: ErrorCode.COMMON_FAIL, message: 'Cập nhật tài khoản thất bại'};
        }
    },
    updateByPhone: async function updateByPhone(phone, fields = {}) {
        const isdn = utils.convertPhoneNumber(phone, utils.PHONE_NOT_PREFIX);
        let result = await userRepository.updateByPhone(isdn, fields);
        if (result) {
            const userInfo = await userRepository.findActiveUserByPhone(isdn);
            // Gen access token
            const mappedUser = TokenPayloadUserMapper(userInfo);
            let token = jwt.sign({user: mappedUser}, privateKey, {expiresIn: '1y'});
            // Save action log
            const profile = mappedUser.profiles.find(profile => profile.isDefault == 1);
            actionLogRepository.save({
                action: actionConst.ACTION_LOGGED_IN,
                platform: actionConst.PLATFORM_APP,
                phone: mappedUser.phone,
                accountId: mappedUser.id,
                profileId: profile.id,
                createdAt: new Date()
            });
            // Find action log
            const isFirstTimeLogIn = (await actionLogRepository.findByAccountId(userInfo.id)) === null;
            return {errorCode: 0, message: 'Cập nhật tài khoản thành công', accessToken: token, data: { user: UserMapper(userInfo, isFirstTimeLogIn) }};
        } else {
            return {errorCode: 1, message: 'Cập nhật tài khoản thất bại'};
        }
    },
    checkToken: function checkToken(accessToken, accessUsername) {
        return new Promise(resolve => {
            jwt.verify(accessToken, privateKey, {}, function (err, payload) {
                if (err) {
                    resolve(false);
                }

                const isdn = utils.convertPhoneNumber(accessUsername, utils.PHONE_NOT_PREFIX);
                if (payload.user.phone !== isdn) {
                    resolve(false);
                }

                resolve(payload);
            });
        });
    },
    checkOtpToken: function (accessToken, accessPhone, type = TokenConstant.VERIFY_OTP_FORGOT_PASSWORD) {
        return new Promise((resolve) => {
            jwt.verify(accessToken, privateKey, {}, function (err, payload) {
                if (err) {
                    resolve(false);
                }

                const isdn = utils.convertPhoneNumber(accessPhone, utils.PHONE_NOT_PREFIX);
                if (utils.isEmpty(payload.type) || payload.type != type || payload.phone != isdn) {
                    resolve(false);
                }

                resolve(payload);
            });
        });
    },
    getLearningInfo: async function (profileId, levelId) {
        const learningInfo = await userLearningInfoRepository.findByProfileIdAndLevelId(profileId, levelId);
        if (utils.isEmpty(learningInfo)) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Không có dữ liệu học', data: {}};
        }
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {info: LearningInfoMapper(learningInfo)}};
    },
    getLearningReport: async function (profileId, levelId
    ) {
        const learningReport = await userLearningReportRepository.findByProfileIdAndLevelId(profileId, levelId);
        if (utils.isEmpty(learningReport)) {
            return {errorCode: ErrorCode.COMMON_FAIL, message: 'Không có dữ liệu học'};
        }
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {info: LearningReportMapper(learningReport)}};
    },
    getLevelStats: async function (profileId) {
        const levelStats = await userLevelStatsRepository.findByProfileId(profileId);
        if (utils.isEmpty(levelStats)) {
            return {errorCode: ErrorCode.COMMON_FAIL, message: 'Không có dữ liệu học'};
        }
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {info: LevelStatsMapper(levelStats)}};
    },
    disableUser: async function (id) {
        let result = await userRepository.update(id, {status: 0, updated_at: new Date()});
        if (result) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Xóa tài khoản thành công'};
        } else {
            return {errorCode: ErrorCode.COMMON_FAIL, message: 'Xóa tài khoản thất bại'};
        }
    }

}