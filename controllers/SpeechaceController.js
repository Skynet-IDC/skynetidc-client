const axios = require('axios');
const ErrorCode = require("../constants/ErrorCode");
module.exports = {

    speakAI: async function (req, res) {

        if (!req.files || Object.keys(req.files).length === 0) {
            res.json({errorCode: ErrorCode.COMMON_FAIL, message: 'No files were uploaded.'});
        }
        if (!req.body.text) {
            res.json({errorCode: ErrorCode.COMMON_FAIL, message: 'No Words were uploaded.'});
        }
        let uploadedFile = req.files.file;


        const fileBlob = new Blob([uploadedFile.data], {type: uploadedFile.mimetype});

        const formData = new FormData();

        formData.append('text', req.body.text);
        formData.append('include_unknown_words', 1);

        formData.append('user_audio_file', fileBlob, {
            filename: uploadedFile.name,
            contentType: uploadedFile.mimetype,
        });

        axios.post(`https://api2.speechace.com/api/scoring/text/v9/json?key=${process.env.SPEECHACE_KEY}&dialect=en-gb&user_id=${process.env.SPEECHACE_USER}`, formData, {
            headers: {},
        })
            .then(apiRes => {
                res.json({errorCode: ErrorCode.SUCCESS, message: "OK", data: apiRes.data});
            })
            .catch(apiErr => {
                // Handle API request error
                console.error('Error posting to API:', apiErr);
                res.json({errorCode: ErrorCode.COMMON_FAIL, message: apiErr.message});
            });
    },

}