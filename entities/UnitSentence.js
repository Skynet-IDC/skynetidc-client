const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const UnitSentence = sequelize.define("UnitSentence", {

    grammarId: {
        field: 'sentence_id',
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
    tableName: 'gb_units_sentences',
    timestamps: false
});

module.exports = UnitSentence;