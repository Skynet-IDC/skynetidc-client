const { validationResult } = require('express-validator');
const moment = require('moment');
const crypto = require('crypto');

const PHONE_GLOBAL = "849x";
const PHONE_SIMPLE = "09x";
const PHONE_NOT_PREFIX = "9x";

module.exports = {

    PHONE_GLOBAL: PHONE_GLOBAL,
    PHONE_SIMPLE: PHONE_SIMPLE,
    PHONE_NOT_PREFIX: PHONE_NOT_PREFIX,
    log: function log(msg) {
        let time = new moment().format("YYYY-MM-DD HH:mm:ss");
        console.log(time + ' ' + msg);
    },
    getErrorMessage: function getErrorMessage(req) {
        const errors = validationResult(req);
        if (!errors.isEmpty()) {
            for (let error of errors.errors) {
                return error.msg
            }
        }
        return false;
    },
    convertPhoneNumber: function convertPhoneNumber(phone, type) {
        if (!phone) {
            return '';
        }

        phone = phone.trim();
        switch (type) {
            case "849x":
                if (phone.substr(0, 1) == '0') {
                    return "84" + phone.substr(1);
                } else if (phone.length == 9 || phone.substr(0, 2) != '84') {
                    return "84" + phone;
                }
                return phone;
            case "9x":
                if (phone.substr(0, 1) == '0') {
                    return phone.substr(1);
                } else if (phone.length == 11 && phone.substr(0, 2) == '84') {
                    return phone.substr(2);
                }
                return phone;
            default:
                if (phone.length == 11 && phone.substr(0, 2) == '84') {
                    return "0" + phone.substr(2);
                } else if (phone.substr(0, 1) != '0') {
                    return "0" + phone;
                }
                return phone;
        }
    },
    md5: function (str) {
        return crypto.createHash('md5').update(str).digest('hex');
    },
    randomInteger: function (min, max) {
        min = Math.ceil(min);
        max = Math.floor(max);
        return Math.floor(Math.random() * (max - min + 1)) + min;
    },
    isEmpty: function (obj) {
        if (Number.isInteger(obj)) {
            return false;
        }
        if (typeof obj === "undefined" || obj == null) {
            return true;
        }
        return !Object.keys(obj).length;
    },
    calVipDays: function (packages) {
        if (packages) {
            packages = this.quickSort(packages, "start_time");
            let endTime = null;
            for (let i = 0; i < packages.length; i++) {
                let pEndTime = new Date(packages[i].endTime).getTime();
                if (endTime == null) {
                    endTime = pEndTime;
                } else {
                    let pStartTime = new Date(packages[i].startTime).getTime();
                    let packDuration = pEndTime - pStartTime;
                    if (endTime > pStartTime) {
                        endTime = endTime + packDuration;
                    } else {
                        endTime = pStartTime + packDuration;
                    }
                }
            }
            let remain = Math.ceil((endTime - new Date().getTime()) / 86400000);
            return remain > 0 ? remain : 0;
        }
        return 0;
    },
    quickSort: function (myArray, prop) {
        let lt = [];
        let gt = [];
        if (myArray.length < 2) {
            return myArray;
        }
        let pivot = myArray[0];
        myArray = myArray.slice(1);
        for (let i = 0; i < myArray.length; i++) {
            if (myArray[i][prop] <= pivot[prop]) {
                lt.push(myArray[i]);
            } else {
                gt.push(myArray[i]);
            }
        }
        return this.quickSort(lt, prop).concat([pivot], this.quickSort(gt, prop));
    },
    isJsonString: function(str) {
        try {
            JSON.parse(str);
        } catch (e) {
            return false;
        }
        return true;
    },
    formatDate: function (date, format) {
        return moment(date).format(format);
    },
    genANewCode(length) {
        let result = '';
        const characters = 'abcdefghijklmnopqrstuvwxyz0123456789';
        const charactersLength = characters.length;
        let counter = 0;
        while (counter < length) {
            result += characters.charAt(Math.floor(Math.random() * charactersLength));
            counter += 1;
        }
        return result;
    }

}
