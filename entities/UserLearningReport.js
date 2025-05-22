const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const UserLearningReport = sequelize.define("UserLearningReport", {
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
    levelId: {
        field: 'level_id',
        type: DataTypes.INTEGER
    },
    finishedUnits: {
        field: 'finished_units',
        type: DataTypes.INTEGER
    },
    totalUnits: {
        field: 'total_units',
        type: DataTypes.INTEGER
    },
    learnedWords: {
        field: 'learned_words',
        type: DataTypes.INTEGER
    },
    finishedActivities: {
        field: 'finished_activities',
        type: DataTypes.INTEGER
    },
    avgScore: {
        field: 'avg_score',
        type: DataTypes.INTEGER
    },
    skillAvgScore: {
        field: 'skill_avg_score',
        type: DataTypes.INTEGER
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
}, {
    tableName: 'gb_user_learning_report',
    timestamps: false
});

module.exports = UserLearningReport;