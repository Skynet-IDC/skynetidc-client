const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const PracticeConversationScore = sequelize.define("PracticeConversationScore", {
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
    isPracticeConversation: {
        field: 'is_practice_conversation',
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
        type: DataTypes.INTEGER
    },
    questionResponsesHolders: {
        field: 'question_responses_holders',
        type: DataTypes.STRING(1023)
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
}, {
    tableName: 'gb_practice_conversation_score',
    timestamps: false
});

module.exports = PracticeConversationScore;