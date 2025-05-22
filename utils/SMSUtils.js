const config = require('../config');
const httpRequestUtils = require("./HttpRequestUtils");
const utils = require("./CommonUtils");

module.exports = {

    sendOtpSMS: async function (phone, content) {
        const response = await httpRequestUtils.post(config.sms.url, {
            'Provider-Key': config.sms.admin.providerKey
        }, {
            username: config.sms.admin.username,
            provider: config.sms.admin.provider,
            sms: content,
            source: config.sms.admin.source,
            phone: phone,
            requestId: 1,
            campaignId: 'OTP',
            type: 0
        });
        return !utils.isEmpty(response) && parseInt(response.resultCode) === 0;
    }

}
