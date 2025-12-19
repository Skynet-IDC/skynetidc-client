const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Notification = sequelize.define("Notification", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    title: {
        field: 'title',
        type: DataTypes.STRING(255),
        allowNull: false
    },
    content: {
        field: 'content',
        type: DataTypes.STRING,
        allowNull: false
    },
    type: {
        field: 'type',
        type: DataTypes.ENUM('system', 'daily', 'weekly'),
        allowNull: false
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
    tableName: 'gb_notifications',
    timestamps: false
});

module.exports = Notification;
