const config = require('../config');
const { Sequelize } = require('sequelize');
const sequelize = new Sequelize(config.mysqlConnection.db, config.mysqlConnection.username, config.mysqlConnection.password, {
    host: config.mysqlConnection.host,
    port: config.mysqlConnection.port,
    dialect: 'mariadb',
    dialectOptions: {
        allowPublicKeyRetrieval: true
    },
    pool: {
        max: 5,
        min: 0,
        acquire: 30000,
        idle: 10000
    }
});
module.exports = {
    sequelize: sequelize
}