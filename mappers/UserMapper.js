const ProfileMapper = require("./ProfileMapper");
const utils = require("../utils/CommonUtils");

module.exports = (model, isFirstTimeLogIn = false) => {
    return {
        id: model.id,
        phone: model.phone,
        phoneValidated: model.phone_validated,
        password: model.password,
        fullName: model.full_name,
        email: model.email,
        address: model.address,
        gender: model.gender,
        birthday: model.birthday,
        status: model.status,
        isFirstTimeLogIn: isFirstTimeLogIn,
        createdAt: model.created_at,
        updatedAt: model.updated_at,
        profiles: !utils.isEmpty(model.profiles) ? model.profiles.map(item => ProfileMapper(item)) : []
    }
}