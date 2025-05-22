const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const UnitWord = sequelize.define("UnitWord", {

    grammarId: {
        field: 'grammar_id',
        type: DataTypes.INTEGER
    },
    unitId: {
        field: 'unit_id',
        type: DataTypes.INTEGER
    },
    createdAt: {
        field: 'created_at',
        type: DataTypes.DATE
    },
    deletedAt: {
        field: 'deleted_at',
        type: DataTypes.DATE
    },
    updatedAt: {
        field: 'updated_at',
        type: DataTypes.DATE
    }
}, {
    tableName: 'gb_units_words',
    timestamps: false
});

module.exports = UnitWord;