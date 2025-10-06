const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Activity = sequelize.define("Activity", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    code: {
        type: DataTypes.STRING(100),
        allowNull: false
    },
    name: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    description: {
        type: DataTypes.STRING(255),
    },
    image: {
        type: DataTypes.INTEGER,
    },
    thumbnail: {
        type: DataTypes.STRING(255)
    },
    isActive: {
        field: 'is_active',
        type: DataTypes.BOOLEAN,
        default: false
    },
    position: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    partId: {
        field: 'part_id',
        type: DataTypes.INTEGER,
        allowNull: false
    },
    type: {
        type: DataTypes.STRING(100),
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
    },
    levelId: {
        field: 'level_id',
        type: DataTypes.INTEGER
    }
}, {
    tableName: 'gb_activities',
    timestamps: false
});

module.exports = Activity;