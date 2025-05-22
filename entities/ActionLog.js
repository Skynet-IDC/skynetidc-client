const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const ActionLog = sequelize.define("ActionLog", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    action: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    platform: {
        type: DataTypes.ENUM,
        values: ['APP'],
        allowNull: false
    },
    phone: {
        type: DataTypes.STRING(50),
        allowNull: false
    },
    accountId: {
        field: 'account_id',
        type: DataTypes.INTEGER
    },
    profileId: {
        field: 'profile_id',
        type: DataTypes.INTEGER
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE,
        allowNull: false
    }
}, {
    tableName: 'gb_action_log',
    timestamps: false
});

module.exports = ActionLog;