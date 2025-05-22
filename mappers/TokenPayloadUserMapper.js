const TokenPayloadProfileMapper = require('../mappers/TokenPayloadProfileMapper');

module.exports = (model) => {
    return {
        id: model.id,
        phone: model.phone,
        profiles: model.profiles.map(item => TokenPayloadProfileMapper(item))
    }
}