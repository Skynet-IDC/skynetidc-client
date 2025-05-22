const {query} = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");
const activeCodeRepository = require("../../repositories/ActiveCodeRepository");
const profilePackageRepository = require("../../repositories/ProfilePackageRepository");

module.exports = [
    query('code').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Vui lòng nhập mã kích hoạt'})
        .custom((value, {req}) => {
            return activeCodeRepository.findByCodeIncludePackageAndProfileAndAccount(value).then(code => {
                if (!code) {
                    return Promise.reject({errorCode: ErrorCode.ACTIVE_CODE_NOT_EXIST, message: 'Mã kích hoạt không tồn tại'});
                } else {
                    if (!code.status) {
                        return profilePackageRepository.findByCode(code.code).then(profilePackage => {
                            const profile = code.profile;
                            return Promise.reject({
                                errorCode: ErrorCode.ACTIVE_CODE_ALREADY_USED,
                                message: 'Mã kích hoạt đã được sử dụng',
                                data: {
                                    profile,
                                    profilePackage,
                                    package: {
                                        id: code.package.id,
                                        name: code.package.name,
                                        duration: code.package.duration
                                    }
                                }
                            });
                        });
                    }
                }
                req.body.code_info = code;
            });
        })
]
