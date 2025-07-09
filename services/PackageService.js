const packageRepository = require('../repositories/PackageRepository');
const ErrorCode = require('../constants/ErrorCode');

module.exports = {

    getPackageList: async function (params) {
        const packageList = await packageRepository.findAllActivePackage(params);
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {items: packageList}};
    },

    findByProductID: async function (productId, channel) {
        return await packageRepository.findByProductId(productId, channel)
    }

}