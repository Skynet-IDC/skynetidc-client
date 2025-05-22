const fs = require("fs");
const moment = require("moment");

module.exports = {

    saveBase64ToFile: function (base64, filePath) {
        fs.writeFile(filePath, base64, 'base64', function (err) {
            console.log(err);
        });
    },

    generateFilePath: function (baseDir, fileName) {
        const momentObj = new moment();
        const yyyy = momentObj.format("YYYY");
        const mm = momentObj.format("MM");
        const dd = momentObj.format("DD");
        const fileFolder = baseDir + '/' + yyyy + '/' + mm + '/' + dd
        if (!fs.existsSync(fileFolder)) {
            fs.mkdirSync(fileFolder, { recursive: true });
        }
        return fileFolder + '/' + fileName;
    }

}