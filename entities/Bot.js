const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Bot = sequelize.define("Bot", {
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
    image: {
        type: DataTypes.STRING(255)
    },
    isActive: {
        field: 'is_active',
        type: DataTypes.BOOLEAN,
        default: false
    },
    code: {
        type: DataTypes.STRING(100),
        allowNull: false
    },
    botLevelId: {
        field: 'bot_level_id',
        type: DataTypes.INTEGER(),
        allowNull: false
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
    tableName: 'gb_bots',
    timestamps: false
});

module.exports = Bot;