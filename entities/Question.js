const { DataTypes } = require('sequelize');
const sequelize = require('./Connection').sequelize;

const Question = sequelize.define("Question", {
    id: {
        type: DataTypes.BIGINT,
        allowNull: false,
        primaryKey: true,
        autoIncrement: true
    },
    name: {
        field: 'name',
        type: DataTypes.STRING(255)
    },
    title: {
        field: 'title',
        type: DataTypes.STRING(255)
    },
    description: {
        field: 'description',
        type: DataTypes.STRING(255)
    },
    duration: {
        field: 'duration',
        type: DataTypes.INTEGER,
    },
    questionContent: {
        field: 'question_content',
        type: DataTypes.TEXT
    },
    answers: {
        field: 'answers',
        type: DataTypes.TEXT
    },
    platformId: {
        field: 'platform_id',
        type: DataTypes.INTEGER,
    },
    bot: {
        field: 'bot',
        type: DataTypes.INTEGER,
    },

    skill: {
        field: 'skill',
        type: DataTypes.STRING(255)
    },

    level: {
        field: 'level',
        type: DataTypes.STRING(255)
    },
    isActive: {
        field: 'is_active',
        type: DataTypes.BOOLEAN
    },
    contentText: {
        field: 'content_text',
        type: DataTypes.TEXT
    },
    contentImage: {
        field: 'content_image',
        type: DataTypes.TEXT
    },
    contentVideo: {
        field: 'content_video',
        type: DataTypes.TEXT
    },

    contentAudio: {
        field: 'content_audio',
        type: DataTypes.TEXT
    },

    subQuestionsIds: {
        field: 'sub_questions_ids',
        type: DataTypes.TEXT
    },
    answerHelpText: {
        field: 'answer_help_text',
        type: DataTypes.TEXT
    },
    answerHelpImage: {
        field: 'answer_help_image',
        type: DataTypes.TEXT
    },
    answerHelpAudio: {
        field: 'answer_help_audio',
        type: DataTypes.TEXT
    },
    answerHelpVideo: {
        field: 'answer_help_video',
        type: DataTypes.TEXT
    },
    hintText: {
        field: 'hint_text',
        type: DataTypes.TEXT
    },
    hintAudio: {
        field: 'hint_audio',
        type: DataTypes.TEXT
    },
    hintImage: {
        field: 'hint_image',
        type: DataTypes.TEXT
    },
    hintVideo: {
        field: 'hint_video',
        type: DataTypes.TEXT
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
    tableName: 'gb_questions',
    timestamps: false
});

module.exports = Question;