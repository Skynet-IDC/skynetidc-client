const {query} = require('express-validator');

module.exports = [
    query('part_id').notEmpty().withMessage({errorCode: 1, message: 'Thiếu thông tin PartID'})
]