const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const ProfilePackage = sequelize.define("ProfilePackage", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    profileId: {
        field: 'profile_id',
        type: DataTypes.INTEGER
    },
    packageId: {
        field: 'package_id',
        type: DataTypes.INTEGER
    },
    code: {
        type: DataTypes.STRING(50)
    },
    startTime: {
        field: 'start_time',
        type: DataTypes.DATE
    },
    endTime: {
        field: 'end_time',
        type: DataTypes.DATE
    },
    isActive: {
        field: 'is_active',
        type: DataTypes.BOOLEAN,
        default: false
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
    updatedAt: {
        field: 'updated_at',
        type: DataTypes.DATE
    }
}, {
    tableName: 'gb_profile_package',
    timestamps: false
});

module.exports = ProfilePackage;