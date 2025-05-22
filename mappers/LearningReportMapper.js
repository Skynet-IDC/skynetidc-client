module.exports = (model) => {
    return {
        id: model.id,
        profileId: model.profileId,
        levelId: model.levelId,
        finishedUnits: model.finishedUnits,
        totalUnits: model.totalUnits,
        learnedWords: model.learnedWords,
        finishedActivities: model.finishedActivities,
        avgScore: model.avgScore,
        skillAvgScore: JSON.parse(model.skillAvgScore),
        createdAt: model.created_at
    }
}