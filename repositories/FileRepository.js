let File = require('../entities/File');
let Bot = require('../entities/Bot');

module.exports = {
    findAll: async function () {
        const files = await File.findAll()
        const filesMapped = {}
        for (let i = 0; i < files.length; i++) {
            const id = files[i].id
            let content = files[i].toJSON()

            delete content.name
            delete content.isActive
            delete content.type
            delete content.deletedAt
            delete content.createdAt
            delete content.updatedAt

            filesMapped[id] = content

        }
        return filesMapped;
    },
    findAllBot: async function () {
        const files = await Bot.findAll()
        const filesMapped = {}
        for (let i = 0; i < files.length; i++) {
            const id = files[i].id
            let content = files[i].toJSON()

            delete content.isActive
            delete content.type
            delete content.deletedAt
            delete content.createdAt
            delete content.updatedAt

            content.filePath = content.image


            filesMapped[id] = content

        }
        return filesMapped;
    },
    findOne: async function (id) {
        return await File.findOne({
            where: {
                is_active: true,
                id: id
            },
        });
    },

}