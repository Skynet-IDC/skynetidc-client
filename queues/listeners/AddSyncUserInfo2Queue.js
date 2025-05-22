const utils = require('../../utils/CommonUtils');
const redisConst = require("../../constants/RedisConstant");
const {redis} = require("../../utils/RedisUtils");

module.exports = (payload) => {
    setImmediate(() => {
        utils.log('AddSyncUserInfo2Queue, payload=' + JSON.stringify(payload));
        redis.rpush(redisConst.REDIS_KEY_USER_LEARNING_INFO_QUEUE, JSON.stringify(payload));
    });
}