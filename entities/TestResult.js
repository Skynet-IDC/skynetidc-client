const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const TestResult = sequelize.define("TestResult", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    userId: {
        field: 'user_id',
        type: DataTypes.INTEGER,
        allowNull: false
    },
    type: {
        field: 'type',
        type: DataTypes.ENUM('TEST_BASIC', 'TEST_ADVANCED'),
        allowNull: false
    },
    questions: {
        field: 'questions',
        type: DataTypes.TEXT,
        allowNull: false,
        get() {
            const rawValue = this.getDataValue('questions');
            return rawValue ? JSON.parse(rawValue) : [];
        },
        set(value) {
            this.setDataValue('questions', JSON.stringify(value));
        }
    },
    level: {
        field: 'level',
        type: DataTypes.INTEGER,
        allowNull: true
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE,
        defaultValue: DataTypes.NOW
    },
    updatedAt: {
        field: 'updated_at',
        type: DataTypes.DATE,
        defaultValue: DataTypes.NOW
    }
}, {
    tableName: 'gb_test_results',
    timestamps: false
});

module.exports = TestResult;