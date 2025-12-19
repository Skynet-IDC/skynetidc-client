const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const FcmToken = sequelize.define("FcmToken", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    userId: {
        field: 'user_id',
        type: DataTypes.INTEGER,
        allowNull: false
    },
    fcmToken: {
        field: 'fcm_token',
        type: DataTypes.STRING(500),
        allowNull: false
    },
    deviceId: {
        field: 'device_id',
        type: DataTypes.STRING(500),
        allowNull: false
    },
    deviceType: {
        field: 'device_type',
        type: DataTypes.ENUM('ios', 'android', 'web'),
        allowNull: false,
        default: 'android'
    },
    isActive: {
        field: 'is_active',
        type: DataTypes.BOOLEAN,
        default: false
    },
    lastUsedAt: {
        field: 'last_used_at',
        type: DataTypes.DATE,
        defaultValue: DataTypes.NOW
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE,
        defaultValue: DataTypes.NOW
    },
    updatedAt: {
        field: 'updated_at',
        type: DataTypes.DATE,
        defaultValue: DataTypes.NOW
    }
}, {
    tableName: 'gb_fcm_tokens',
    timestamps: false
});

module.exports = FcmToken;
