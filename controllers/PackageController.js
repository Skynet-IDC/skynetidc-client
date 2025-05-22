const packageService = require('../services/PackageService');

module.exports = {

    getPackageList: async function (req, res) {
        const response = await packageService.getPackageList();
        res.json(response);
    }

}