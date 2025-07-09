let Package = require('../entities/Package');

module.exports = {

    findAllActivePackage: async function (params) {
        let whereClause = {
            is_active: true,
        };

        // Add app_id to where clause if provided
        if (params?.appId) {
            whereClause.app_id = params.appId;
        }

        return await Package.findAll({
            where: whereClause,
            order: [['position', 'ASC']]
        });
    },

    findById: async function (id) {
        let whereClause = {
            id: id,
        };
        return await Package.findOne({
            where: whereClause
        });
    },

    findByProductId: async function (productId, channel) {
        let query = {
            iosProductId: productId,
        }
        if(channel === 2){
            query = {
                androidProductId: productId,
            }
        }

        return await Package.findOne({
            where: query
        });
    },

}
