const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Part = sequelize.define("Part", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    code: {
        type: DataTypes.STRING(200),
        allowNull: false
    },
    name: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    thumbnail: {
        type: DataTypes.STRING(255)
    },
    type: {
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
    position: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    unitId: {
        field: 'unit_id',
        type: DataTypes.INTEGER,
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
    tableName: 'gb_parts',
    timestamps: false
});

module.exports = Part;