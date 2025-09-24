module.exports = (model) => {
    return {
        id: model.id,
        profileId: model.profileId,
        levelId: model.levelId,
        units: JSON.parse(model.units),
        parts: JSON.parse(model.parts),
        activities: JSON.parse(model.activities),
        createdAt: model.created_at,
        testResults: JSON.parse(model.testResults)
    }
}