const {DataTypes} = require('sequelize');
const sequelize = require('./Connection').sequelize;

const BotLevel = sequelize.define("BotLevel", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    name: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    difficulty: {
        field: 'difficulty',
        type: DataTypes.STRING(255),
        allowNull: false
    },
    min: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    max: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    percent: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    isActive: {
        field: 'is_active',
        type: DataTypes.BOOLEAN,
        default: false
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
    tableName: 'gb_bot_levels',
    timestamps: false
});

module.exports = BotLevel;