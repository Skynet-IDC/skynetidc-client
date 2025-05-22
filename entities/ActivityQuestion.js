const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const ActivityQuestion = sequelize.define("ActivityQuestion", {

    activityId: {
        field: 'activity_id',
        type: DataTypes.INTEGER
    },
    questionId: {
        field: 'question_id',
        type: DataTypes.INTEGER
    },
    deletedAt: {
        field: 'deleted_at',
        type: DataTypes.DATE
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
    tableName: 'gb_activities_questions',
    timestamps: false
});

module.exports = ActivityQuestion;