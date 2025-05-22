const {EventEmitter} = require("events");
const addSyncUserInfo2Queue = require('../listeners/AddSyncUserInfo2Queue');

const eventEmitter = new EventEmitter();
// Events
eventEmitter.on("userUpdateLevelSuccess", addSyncUserInfo2Queue);
eventEmitter.on("saveScoreSuccess", addSyncUserInfo2Queue);

module.exports = eventEmitter;
