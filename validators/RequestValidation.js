const utils = require("../utils/CommonUtils");

module.exports = function (rules) {
    return [
        ...rules,
        (req, res, next) => {
            const errorMsg = utils.getErrorMessage(req);
            if (errorMsg) {
                res.json(errorMsg);
                return;
            }
            next();
        },
    ];
}
