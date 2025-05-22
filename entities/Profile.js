const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Profile = sequelize.define("Profile", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    name: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    avatar: {
        type: DataTypes.STRING(255)
    },
    birthday: {
        type: DataTypes.DATE
    },
    gender: {
        type: DataTypes.INTEGER
    },
    status: {
        type: DataTypes.BOOLEAN,
        default: 0
    },
    account_id: {
        type: DataTypes.INTEGER
    },
    is_default: {
        type: DataTypes.BOOLEAN,
    },
    level_id: {
        type: DataTypes.INTEGER
    },
    created_at: {
        type: DataTypes.DATE
    },
    updated_at: {
        type: DataTypes.DATE
    }
}, {
    tableName: 'gb_profile',
    timestamps: false
});

module.exports = Profile;