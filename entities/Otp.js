const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Otp = sequelize.define("Otp", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    username: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    otp: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    type: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    status: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    created_at: {
        type: DataTypes.DATE
    },
    updated_at: {
        type: DataTypes.DATE
    }
}, {
    tableName: 'gb_otp',
    timestamps: false
});

module.exports = Otp;