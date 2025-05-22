const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const QuestionResource = sequelize.define("QuestionResource", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    questionId: {
        field: 'question_id',
        type: DataTypes.INTEGER,
        allowNull: false
    },
    content: {
        type: DataTypes.TEXT,
        allowNull: true
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
    tableName: 'gb_question_resource',
    timestamps: false
});

module.exports = QuestionResource;