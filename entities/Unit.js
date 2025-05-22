const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Unit = sequelize.define("Unit", {
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
    thumbnail: {
        type: DataTypes.STRING(255)
    },
    description: {
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
    position: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    levelId: {
        field: 'level_id',
        type: DataTypes.INTEGER,
        allowNull: false
    },
    grammar: {
        type: DataTypes.TEXT,
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
    tableName: 'gb_units',
    timestamps: false
});

module.exports = Unit;