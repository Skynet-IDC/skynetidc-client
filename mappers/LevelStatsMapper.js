module.exports = (model) => {
    return {
        id: model.id,
        profileId: model.profileId,
        levels: JSON.parse(model.levels),
        createdAt: model.created_at
    }
}