module.exports = (model) => {
    return {
        id: model.id,
        name: model.name,
        avatar: model.avatar,
        birthday: model.birthday,
        gender: model.gender,
        status: model.status,
        accountId: model.account_id,
        isDefault: model.is_default,
        levelId: model.level_id,
        createdAt: model.created_at,
        updatedAt: model.updated_at
    }
}