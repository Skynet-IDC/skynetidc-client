const axios = require('axios');
const ErrorCode = require("../constants/ErrorCode");
module.exports = {

    speechToText: async function (req, res) {
        if (!req.files || Object.keys(req.files).length === 0) {
            res.json({errorCode: ErrorCode.COMMON_FAIL, message: 'No files were uploaded.'});
        }
        if (!req.body.text) {
            res.json({errorCode: ErrorCode.COMMON_FAIL, message: 'No Words were uploaded.'});
        }
        let uploadedFile = req.files.file;


    },

}