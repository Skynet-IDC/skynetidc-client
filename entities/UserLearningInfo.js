const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const UserLearningInfo = sequelize.define("UserLearningInfo", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    profileId: {
        field: 'profile_id',
        type: DataTypes.INTEGER
    },
    levelId: {
        field: 'level_id',
        type: DataTypes.INTEGER
    },
    units: {
        type: DataTypes.STRING(1023)
    },
    parts: {
        type: DataTypes.STRING(1023)
    },
    activities: {
        type: DataTypes.STRING(1023)
    },
    test_results: {
        type: DataTypes.STRING(1023)
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
}, {
    tableName: 'gb_user_learning_info',
    timestamps: false
});

module.exports = UserLearningInfo;