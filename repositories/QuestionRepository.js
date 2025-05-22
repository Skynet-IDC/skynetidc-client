let Question = require('../entities/Question');
const utils = require("../utils/CommonUtils");
const QuestionResource = require("../entities/QuestionResource");
const QuestionPlatform = require("../entities/QuestionPlatform");

module.exports = {
    getQuestionsInfo: async function (ids) {
        const questions = await QuestionResource.findAll({
            where: {
                questionId: ids
            },
        });

        return questions.map(q => JSON.parse(q.content))
    },

    getPlatformDetail: async function(id){
        if((!id)) return null;
        return await QuestionPlatform.findOne({
            where: {
                is_active: true,
                id: id
            },
        });
    },

    syncQuestionResource: async function save(fields = {}) {
        const questionResource = await QuestionResource.findOne({
            where: {
                questionId: fields.questionId
            },
        });
        if (!questionResource) {
            return new Promise(resolve => {
                QuestionResource.create(fields).then(result => {
                    utils.log(`Create Question Question Success : ${fields.questionId}`);
                    resolve(result);
                }).catch((e) => {
                    utils.log(`[saveQuestionResource] Error when executing "save", detail: ${e}`);
                    resolve(false);
                });
            });
        }

        return new Promise(resolve => {
            QuestionResource.update({content: fields.content, updatedAt: fields.updatedAt}, {
                where: {questionId: fields.questionId}
            }).then(result => {
                utils.log(`Update Question Question Success : ${fields.questionId}`);
                resolve(result);
            }).catch(e => {
                utils.log(`[UpdateQuestionResource] Error when executing "update", detail: ${e}`);
                resolve(false);
            })
        });
    },

    findOne: async function (id) {
        return await Question.findOne({
            where: {
                id: id
            },
        });
    },

    findMany: async function (ids) {
        return await Question.findAll({
            where: {
                is_active: true,
                id: ids
            },
        });
    },

}