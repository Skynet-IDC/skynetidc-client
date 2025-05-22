const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Grammar = sequelize.define("Grammar", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    text: {
        field: 'text',
        type: DataTypes.TEXT
    },
    description: {
        field: 'description',
        type: DataTypes.TEXT
    },
    enDescription: {
        field: 'en_description',
        type: DataTypes.TEXT
    },
    form: {
        field: 'form',
        type: DataTypes.TEXT
    },
    pronunciation: {
        field: 'pronunciation',
        type: DataTypes.TEXT
    },
    content: {
        field: 'content',
        type: DataTypes.TEXT
    },
    vnContent: {
        field: 'vn_content',
        type: DataTypes.TEXT
    },
    image: {
        field: 'image',
        type: DataTypes.TEXT
    },
    audio: {
        field: 'audio',
        type: DataTypes.TEXT
    },
    video: {
        field: 'video',
        type: DataTypes.TEXT
    },
    type: {
        field: 'type',
        type: DataTypes.TEXT
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
    },
    isActive: {
        field: 'is_active',
        type: DataTypes.BOOLEAN,
        default: false
    },
}, {
    tableName: 'gb_grammars',
    timestamps: false
});

module.exports = Grammar;