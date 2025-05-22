const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const FreeStudyLog = sequelize.define("FreeStudyLog", {
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
    activityId: {
        field: 'activity_id',
        type: DataTypes.INTEGER
    },
    unitId: {
        field: 'unit_id',
        type: DataTypes.INTEGER
    },
    levelId: {
        field: 'level_id',
        type: DataTypes.INTEGER
    },
    reason: {
        type: DataTypes.STRING(255)
    },
    amount: {
        type: DataTypes.INTEGER
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
}, {
    tableName: 'gb_free_study_log',
    timestamps: false
});

module.exports = FreeStudyLog;