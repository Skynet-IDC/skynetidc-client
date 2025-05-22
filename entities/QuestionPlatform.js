const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const QuestionPlatform = sequelize.define("QuestionPlatform", {

    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    description: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    code: {
        type: DataTypes.STRING(100),
        allowNull: false
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
    tableName: 'gb_question_platforms',
    timestamps: false
});

module.exports = QuestionPlatform;