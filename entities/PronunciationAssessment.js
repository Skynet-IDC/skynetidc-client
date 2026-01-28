const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const PronunciationAssessment = sequelize.define("PronunciationAssessment", {
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
    levelId: {
        field: 'level_id',
        type: DataTypes.INTEGER
    },
    startTime: {
        field: 'start_time',
        type: DataTypes.DATE
    },
    timeSpent: {
        field: 'time_spent',
        type: DataTypes.INTEGER
    },
    score: {
        field: 'score',
        type: DataTypes.JSON
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
}, {
    tableName: 'gb_pronunciation_assessment',
    timestamps: false
});

module.exports = PronunciationAssessment;