const {query} = require('express-validator');

module.exports = [
    query('unit_id').notEmpty().withMessage({errorCode: 1, message: 'UnitId is required !'}),
]