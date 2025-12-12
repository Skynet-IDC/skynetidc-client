const licenseService = require('../services/LicenseService');
const packageService = require('../services/PackageService');
const ErrorCode = require("../constants/ErrorCode");
const activeCodeService = require("../services/ActiveCodeService");

module.exports = {

    checkVip: async function (req, res) {
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const response = await licenseService.checkVip(profile.id);
        res.json(response);
    },

    updateVip: async function (req, res) {
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const response = await licenseService.updateVip(profile.id, req.body.amount, req.body.activity_id,
            req.body.unit_id, req.body.level_id, req.body.reason);
        res.json(response);
    },

    buyPackage: async function (req, res) {
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const { transaction_id, channel, status, product_id } = req.body;
        const packageInfo = await packageService.findByProductID(product_id, channel)
        // console.log('packageInfo', packageInfo)
        if (!packageInfo) {
            res.json({ errorCode: ErrorCode.COMMON_FAIL, message: 'Package Not Found !', data: null });
        }
        const package_id = packageInfo.id
        const response = await licenseService.buyPackage({
            profile,
            transaction_id,
            channel,
            status,
            package_id
        });
        res.json(response);
    },

    genCode: async function (req, res) {
        const { number, package_id, created_by } = req.body;
        const response = await activeCodeService.genCode(number, package_id, created_by);
        res.json(response);
    },

    activeCode: async function (req, res) {
        const { code } = req.body;
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const response = await activeCodeService.activeCode(code, profile.id);
        res.json(response);
    },

    checkActiveCode: async function (req, res) {
        const codeInfo = req.body.code_info;
        res.json({
            errorCode: ErrorCode.SUCCESS,
            message: 'Mã kích hoạt hợp lệ',
            data: {
                package: {
                    id: codeInfo.package.id,
                    name: codeInfo.package.name,
                    duration: codeInfo.package.duration
                }
            }
        });
    },

    syncVipTelco: async function (req, res) {
        try {
            const { telco, days, isdn, package, command } = req.body;
            // Log request
            utils.log(`Sync Vip Telco Request: ${JSON.stringify(req.body)}`);

            const response = await licenseService.syncVipTelco(isdn, days, package, command, telco);

            // Log response
            if (response.errorCode === ErrorCode.SUCCESS) {
                utils.log(`Sync Vip Telco Success: ${isdn} - ${package}`);
            } else {
                utils.log(`Sync Vip Telco Failed: ${response.message} - ${JSON.stringify(req.body)}`);
            }

            res.json(response);
        } catch (error) {
            utils.log(`Sync Vip Telco Exception: ${error.message}`);
            res.json({ errorCode: ErrorCode.COMMON_FAIL, message: 'Lỗi hệ thống', data: null });
        }
    }
}
