const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const PracticeConversation = sequelize.define("PracticeConversation", {

    unitId: {
        field: 'unit_id',
        type: DataTypes.INTEGER
    },
    activityId: {
        field: 'activity_id',
        type: DataTypes.INTEGER
    },
    questionId: {
        field: 'question_id',
        type: DataTypes.INTEGER
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
    deletedAt: {
        field: 'deleted_at',
        type: DataTypes.DATE
    },
    updatedAt: {
        field: 'updated_at',
        type: DataTypes.DATE
    }
}, {
    tableName: 'gb_practice_conversations',
    timestamps: false
});

module.exports = PracticeConversation;