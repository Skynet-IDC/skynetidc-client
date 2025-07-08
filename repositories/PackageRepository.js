let Package = require('../entities/Package');

module.exports = {

    findAllActivePackage: async function (params) {
        console.log('AppId', params?.appId);
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

    findById: async function (id, appId) {
        let whereClause = {
            id: id,
        };

        // Add app_id to where clause if provided
        if (appId) {
            whereClause.app_id = appId;
        }

        return await Package.findOne({
            where: whereClause
        });
    },

    findByProductId: async function (productId, channel, appId) {
        let query = {
            iosProductId: productId,
        }
        if(channel == 2){
            query = {
                androidProductId: productId,
            }
        }

        // Add app_id to query if provided
        if (appId) {
            query.app_id = appId;
        }

        return await Package.findOne({
            where: query
        });
    },

}
