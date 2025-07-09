const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Package = sequelize.define("Package", {
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
    description: {
        type: DataTypes.STRING(255)
    },
    duration: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    price: {
        type: DataTypes.INTEGER,
        allowNull: false
    },
    originalPrice: {
        field: 'original_price',
        type: DataTypes.INTEGER
    },
    discountPercent: {
        field: 'discount_percent',
        type: DataTypes.INTEGER
    },
    isHot: {
        field: 'is_hot',
        type: DataTypes.BOOLEAN,
        default: false,
    },
    isActive: {
        field: 'is_active',
        type: DataTypes.BOOLEAN,
        default: false,
    },
    iosProductId: {
        field: 'ios_product_id',
        type: DataTypes.STRING(255),
        default: false,
    },
    androidProductId: {
        field: 'android_product_id',
        type: DataTypes.STRING(255),
        default: false,
    },
    position: {
        field: 'position',
        type: DataTypes.INTEGER
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
    updatedAt: {
        field: 'updated_at',
        type: DataTypes.DATE
    },
    appId: {
        field: 'app_id',
        type: DataTypes.INTEGER,
        defaultValue: 1
    }
}, {
    tableName: 'gb_package',
    timestamps: false
});

module.exports = Package;
