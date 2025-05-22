const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const PurchaseTransaction = sequelize.define("PurchaseTransaction", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    transactionId: {
        field: 'transaction_id',
        type: DataTypes.STRING,
        allowNull: false
    },
    profilePackageId: {
        field: 'profile_package_id',
        type: DataTypes.INTEGER,
        allowNull: false
    },
    channel: {
        field: 'channel',
        type: DataTypes.INTEGER, //1: iOS; 2: Android
        allowNull: false
    },
    status: {
        field: 'status',
        type: DataTypes.INTEGER, // 1: Pending; 2: Success; 3: Fail; 4: Cancel; 5: Expired
        allowNull: false
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
}, {
    tableName: 'gb_purchase_transactions',
    timestamps: false
});

module.exports = PurchaseTransaction;