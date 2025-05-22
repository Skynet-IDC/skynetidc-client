let Package = require('../entities/Package');

module.exports = {

    findAllActivePackage: async function () {
        return await Package.findAll({
            where: {
                is_active: true
            },
            order: [['position', 'ASC']]
        });
    },

    findById: async function (id) {
        return await Package.findOne({
            where: {
                id: id,
            }
        });
    },

    findByProductId: async function (productId, channel) {
        let query = {
            iosProductId: productId,
        }
        if(channel == 2){
            query = {
                androidProductId: productId,
            }
        }
        return await Package.findOne({
            where: query
        });
    },

}