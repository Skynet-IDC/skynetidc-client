const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Level = sequelize.define("Level", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    title: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    description: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    thumbnail: {
        type: DataTypes.STRING(255)
    },
    isOverStudy: {
        field: 'is_overstudy',
        type: DataTypes.BOOLEAN,
        default: false
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
    words: {
        type: DataTypes.INTEGER,
        allowNull: true
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
    tableName: 'gb_levels',
    timestamps: false
});

module.exports = Level;