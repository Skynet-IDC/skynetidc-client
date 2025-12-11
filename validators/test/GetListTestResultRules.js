const { query } = require("express-validator");
const ErrorCode = require("../../constants/ErrorCode");

module.exports = [
    query('level_id').notEmpty().withMessage({errorCode: 1, message: 'Thiếu thông tin level_id'})
]