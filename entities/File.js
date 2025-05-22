const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const File = sequelize.define("File", {
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
    isActive: {
        field: 'is_active',
        type: DataTypes.BOOLEAN,
        default: false
    },
    type: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    filePath: {
        field: 'file_path',
        type: DataTypes.STRING(255),
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
    tableName: 'gb_files',
    timestamps: false
});

module.exports = File;