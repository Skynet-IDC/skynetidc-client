const {body} = require('express-validator');
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    body('results').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin Results'}),
    body('level_id').notEmpty().withMessage({errorCode: ErrorCode.COMMON_FAIL, message: 'Thiếu thông tin LevelID'})
]