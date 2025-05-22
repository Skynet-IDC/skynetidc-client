const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Ticket = sequelize.define("Ticket", {
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
    userType: {
        field: 'user_type',
        type: DataTypes.INTEGER,
        allowNull: false
    },
    title: {
        type: DataTypes.STRING(255),
        allowNull: false
    },
    description: {
        type: DataTypes.STRING(1023)
    },
    type: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    status: {
        type: DataTypes.INTEGER,
        allowNull: false,
        default: 0
    },
    parameters: {
        type: DataTypes.STRING(255)
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
    tableName: 'gb_tickets',
    timestamps: false
});

module.exports = Ticket;