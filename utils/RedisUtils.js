const Redis = require("ioredis");
const config = require('../config');
const utils = require("./CommonUtils");
const redisConst = require("../constants/RedisConstant");
const redisAddress = config.redisConnection;

const redis = new Redis({
    port: redisAddress.port,
    host: redisAddress.host,
    username: redisAddress.username,
    password: redisAddress.password,
    db: redisAddress.db
});

module.exports = {
    redis: redis,
    getUserProfileInfo: async function (profileId) {
        const userProfileInfoJson = await redis.hget(
            utils.buildRedisKey256(
                redisConst.K12_PRODUCT_USER_PROFILE_INFO,
                profileId.toString()
            ),
            profileId
        );
        if (userProfileInfoJson != null) {
            return JSON.parse(userProfileInfoJson);
        }
        return null;
    },
    setCache: function (cacheKey, cacheValue, seconds) {
        return new Promise(resolve => {
            redis.setex(`${redisConst.K12_PRODUCT_CACHE_DATA}:${cacheKey}`, seconds, JSON.stringify(cacheValue)).then(result => {
                resolve(result);
            });
        });
    },
    getCache: function (cacheKey) {
        return new Promise(resolve => {
            redis.get(`${redisConst.K12_PRODUCT_CACHE_DATA}:${cacheKey}`).then(cacheData => {
                resolve(JSON.parse(cacheData));
            });
        });
    },
    getRedisHash: function getRedisHash(key, value) {
        return new Promise((resolve) => {
            redis.hget(key, value, function fn(err, obj) {
                resolve(obj);
            });
        });
    },
    delRedisHashKey: function delRedisHashKey(key, value) {
        return new Promise((resolve) => {
            redis.hdel(key, value, function fn(err, obj) {
                resolve(obj);
            });
        });
    },
    setRedisHash: function setRedisHash(name, key, value) {
        return new Promise((resolve) => {
            redis.hset(name, {[key]: value}, function (err, obj) {
                resolve(obj);
            });
        });
    }
};
