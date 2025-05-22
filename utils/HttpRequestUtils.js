const axios = require("axios");
const utils = require("./CommonUtils");

module.exports = {
    post: function (url, headers, params) {
        return new Promise(resolve => {
            utils.log(`Start HTTP request, url: ${url}, headers: ${JSON.stringify(headers)}, params: ${JSON.stringify(params)}`);
            axios.post(url, params, {
                headers: {
                    "Content-Type": "application/json",
                    ...headers
                },
                timeout: 5000
            }).then(response => {
                utils.log(`HTTP request success: ${JSON.stringify(response.data)}`);
                resolve(response.data);
            }).catch(err => {
                utils.log(`HTTP request error: ${err}`);
                resolve(false);
            });
        });
    }
}
