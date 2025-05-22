const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const ActiveCode = sequelize.define("ActiveCode", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    code: {
        type: DataTypes.STRING,
        allowNull: false
    },
    status: {
        type: DataTypes.BOOLEAN,
        default: true,
        allowNull: false
    },
    packageId: {
        field: 'package_id',
        type: DataTypes.STRING(50),
        allowNull: false
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
    activatedAt: {
        field: 'activated_at',
        type: DataTypes.DATE
    },
    createdBy: {
        field: 'created_by',
        type: DataTypes.INTEGER
    },
    activatedBy: {
        field: 'activated_by',
        type: DataTypes.INTEGER
    }
}, {
    tableName: 'gb_active_code',
    timestamps: false
});

module.exports = ActiveCode;
