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
    },
    packageCode: {
        field: 'package_code',
        type: DataTypes.STRING(255)
    },
    telco: {
        field: 'telco',
        type: DataTypes.INTEGER,
        defaultValue: 4 // 1: Viettel, 2: Mobifone, 3: Vinaphone, 4: Vietnamobile, 5: Vietnammobile
    }
}, {
    tableName: 'gb_package',
    timestamps: false
});

module.exports = Package;
