const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const UnitGrammar = sequelize.define("UnitGrammar", {

    grammarId: {
        field: 'grammar_id',
        type: DataTypes.INTEGER
    },
    unitId: {
        field: 'unit_id',
        type: DataTypes.INTEGER
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
    tableName: 'gb_units_grammars',
    timestamps: false
});

module.exports = UnitGrammar;