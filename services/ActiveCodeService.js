const activeCodeRepository = require('../repositories/ActiveCodeRepository');
const ErrorCode = require('../constants/ErrorCode');
const commonUtils = require("../utils/CommonUtils");
const moment = require("moment/moment");
const profilePackageRepository = require("../repositories/ProfilePackageRepository");

module.exports = {

    genUniqueCode: async function () {
        let code = commonUtils.genANewCode(6);
        while (true) {
            const codeCheck = await activeCodeRepository.findByCode(code);
            if (!codeCheck) {
                break;
            }
            code = commonUtils.genANewCode(6);
        }
        return code;
    },

    genCode: async function (number, packageId, createdBy) {
        const records = [];
        const codeArr = [];
        for (let i = 0; i < number; i++) {
            const code = await this.genUniqueCode();
            const record = {
                code,
                packageId,
                createdAt: new Date(),
                createdBy
            };
            records.push(record);
            codeArr.push(code);
        }
        const result = await activeCodeRepository.saveMany(records);
        if (result) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {code: codeArr.join(',')}};
        }
        return {errorCode: ErrorCode.COMMON_FAIL, message: 'Thất bại'};
    },

    activeCode: async function (code, profileId) {
        // Get code
        const activeCode = await activeCodeRepository.findByCodeIncludePackage(code);
        if (commonUtils.isEmpty(activeCode)) {
            return {errorCode: ErrorCode.ACTIVE_CODE_NOT_EXIST, message: 'Mã kích hoạt không tồn tại'};
        }
        if (!activeCode.status) {
            return {errorCode: ErrorCode.ACTIVE_CODE_ALREADY_USED, message: 'Mã kích hoạt đã được sử dụng'};
        }
        // Lock code
        const result = await activeCodeRepository.updateByCode(code, {
            status: 0,
            activatedAt: new Date(),
            activatedBy: profileId
        });
        if (result) {
            // Add profile package
            const currentDateTime = moment();
            const profilePackage = {
                profileId,
                packageId: activeCode.package.id,
                code,
                isActive: 1,
                startTime: currentDateTime.format('YYYY-MM-DD HH:mm:ss'),
                endTime: currentDateTime.add(activeCode.package.duration, 'days').format('YYYY-MM-DD HH:mm:ss'),
                createdAt: currentDateTime.format('YYYY-MM-DD HH:mm:ss'),
                updatedAt: currentDateTime.format('YYYY-MM-DD HH:mm:ss'),
            }
            const addPackageResult = await profilePackageRepository.save(profilePackage);
            if (addPackageResult) {
                return {errorCode: ErrorCode.SUCCESS, message: 'Thành công'};
            }
        }
        return {errorCode: ErrorCode.COMMON_FAIL, message: 'Thất bại'};
    }

}
