const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const WritingResult = sequelize.define("WritingResult", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    userId: {
        field: 'user_id',
        type: DataTypes.INTEGER
    },
    questionId: {
        field: 'question_id',
        type: DataTypes.INTEGER,
        allowNull: false
    },
    topicId: {
        field: 'topic_id',
        type: DataTypes.INTEGER
    },
    levelId: {
        field: 'level_id', type: DataTypes.INTEGER
    },
    activityId: {
        field: 'activity_id', type: DataTypes.INTEGER
    },
    answers: {
        type: DataTypes.STRING(1023)
    },
    feedback: {
        type: DataTypes.STRING(1023)
    },
    view: {
        type: DataTypes.INTEGER
    },
    status: {
        type: DataTypes.INTEGER
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
    tableName: 'gb_writing_results',
    timestamps: false
});

module.exports = WritingResult;