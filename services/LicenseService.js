const profileRepository = require("../repositories/ProfileRepository");
const freeStudyLogRepository = require("../repositories/FreeStudyLogRepository");
const purchaseTransactionRepository = require("../repositories/PurchaseTransactionRepository");
const packageRepository = require("../repositories/PackageRepository");
const profilePackageRepository = require("../repositories/ProfilePackageRepository");
const ErrorCode = require("../constants/ErrorCode");
const utils = require("../utils/CommonUtils");
const moment = require("moment");

module.exports = {

    checkVip: async function (profileId) {
        // Get packages
        const profile = await profileRepository.findByIdIncludePackages(profileId);
        const vipDays = utils.calVipDays(profile.profilePackages);
        let remainingEnergy = 0;
        let currentPackage = null;
        if (vipDays <= 0) {
            // Check free
            let usedAmount = await freeStudyLogRepository.sumAmountByProfileIdToday(profileId);
            usedAmount = !isNaN(usedAmount) ? usedAmount : 0;
            remainingEnergy = 5 - usedAmount;
        } else {
            // If not free -> return current package
            currentPackage = profile.profilePackages[profile.profilePackages.length - 1].package;
        }
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {vipDays, remainingEnergy, currentPackage}};
    },

    updateVip: async function (profileId, amount, activityId, unitId, levelId, reason) {
        // Get packages
        const profile = await profileRepository.findByIdIncludePackages(profileId);
        const vipDays = utils.calVipDays(profile.profilePackages);
        let remainingEnergy = 0;
        let currentPackage = null;
        if (vipDays <= 0) {
            // Check free
            let usedAmount = await freeStudyLogRepository.sumAmountByProfileIdToday(profileId);
            usedAmount = !isNaN(usedAmount) ? usedAmount : 0;
            const oldRemainingEnergy = 5 - usedAmount;
            if (amount > oldRemainingEnergy) {
                return {errorCode: ErrorCode.COMMON_FAIL, message: 'Hết năng lượng'};
            }
            remainingEnergy = oldRemainingEnergy - amount;
            // Decrease amount
            const fields = {
                profileId: profileId,
                amount: amount,
                reason: reason,
                createdAt: new Date()
            };
            if (!utils.isEmpty(activityId)) {
                fields.activityId = activityId;
            }
            if (!utils.isEmpty(unitId)) {
                fields.unitId = unitId;
            }
            if (!utils.isEmpty(levelId)) {
                fields.levelId = levelId;
            }
            const result = await freeStudyLogRepository.save(fields);
            if (!result) {
                return {errorCode: ErrorCode.COMMON_FAIL, message: 'Cập nhật vip không thành công'};
            }
        } else {
            // If not free -> return current package
            currentPackage = profile.profilePackages[profile.profilePackages.length - 1].package;
        }
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {vipDays, remainingEnergy, currentPackage}};
    },

    async buyPackage(objData){
        const {
            profile,
            transaction_id,
            channel,
            status,
            package_id
        } = objData
        // console.log(profile)
        const packageInfo = await packageRepository.findById(package_id);
        if(!packageInfo){
            return {errorCode: ErrorCode.COMMON_FAIL, message: 'Package Not Found !', data: null};
        }

        const currentDateTime = moment();

        const profilePackage = {
            profileId: profile.id,
            packageId: packageInfo.id,
            isActive: 1,
            startTime: currentDateTime.format('YYYY-MM-DD HH:mm:ss'),
            endTime: currentDateTime.add(packageInfo.duration, 'days').format('YYYY-MM-DD HH:mm:ss'),
            createdAt: currentDateTime.format('YYYY-MM-DD HH:mm:ss'),
            updatedAt: currentDateTime.format('YYYY-MM-DD HH:mm:ss'),
        }

        const saveProfilePackage = await profilePackageRepository.save(profilePackage);

        // console.log('saveProfilePackage', saveProfilePackage)
        if(saveProfilePackage){
            await purchaseTransactionRepository.syncPurchaseTransaction({
                transactionId: transaction_id,
                channel,
                status: 1,
                profilePackageId: saveProfilePackage.id,
                createdAt: currentDateTime.format('YYYY-MM-DD HH:mm:ss'),
            });
        }
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: saveProfilePackage};
    }

}