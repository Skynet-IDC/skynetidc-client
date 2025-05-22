const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Account = sequelize.define("Account", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    phone: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    phone_validated: {
        type: DataTypes.BOOLEAN,
        default: false
    },
    password: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    full_name: {
        type: DataTypes.STRING(255)
    },
    email: {
        type: DataTypes.STRING(255)
    },
    address: {
        type: DataTypes.STRING(255)
    },
    gender: {
        type: DataTypes.INTEGER
    },
    birthday: {
        type: DataTypes.DATE,
        default: 0
    },
    status: {
        type: DataTypes.BOOLEAN,
        default: 0
    },
    created_at: {
        type: DataTypes.DATE
    },
    updated_at: {
        type: DataTypes.DATE
    }
}, {
    tableName: 'gb_account',
    timestamps: false
});

module.exports = Account;