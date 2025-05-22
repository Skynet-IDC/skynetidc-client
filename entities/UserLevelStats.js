const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const UserLevelStats = sequelize.define("UserLevelStats", {
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
    levels: {
        type: DataTypes.STRING(1023)
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    }
}, {
    tableName: 'gb_user_level_stats',
    timestamps: false
});

module.exports = UserLevelStats;