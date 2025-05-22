const {query} = require('express-validator');

module.exports = [
    query('level_id').notEmpty().withMessage({errorCode: 1, message: 'Level is required !'}),
]