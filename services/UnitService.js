const unitRepository = require('../repositories/UnitRepository');
const conversationRepository = require('../repositories/ConversationRepository');
const PartRepository = require('../repositories/PartRepository');
const ActivityRepository = require('../repositories/ActivityRepository');
const ErrorCode = require('../constants/ErrorCode');
const Unit = require("../entities/Unit");
const PracticeConversation = require("../entities/PracticeConversation");
const ActivityService = require("../services/ActivityService");
const Activity = require("../entities/Activity");

module.exports = {

    getUnitList: async function (levelId, unitId, page, reverse) {
        const unitList = await unitRepository.findAllByLevelId(levelId, unitId, page, reverse);
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: {items: unitList}};
    },

    getByLevel: async function (levelId) {
        return await unitRepository.findByLevelId(levelId);
    },

    getWords: async function (unitId) {
        const words = await unitRepository.getWords(unitId);
        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: words};
    },

    activitiesConversationInfo: async function (activityIds) {
        const activitiesInfo = await Activity.findAll({
            where: {id: activityIds, isActive: true}
        });

        const questionsAct = []
        for (let i = 0; i < activitiesInfo.length; i++) {
            const questions = await ActivityService.getQuestions(activitiesInfo[i].id)
            if (questions.length) {
                activitiesInfo[i].name = questions[0].name
            }
            questionsAct.push(activitiesInfo[i].toJSON())
        }

        return questionsAct
    },

    getConversations: async function (levelId) {


        const unitsInfo = await this.getByLevel(levelId)

        const unitIds = unitsInfo.map(item => item.id);

        const partInUnits = await PartRepository.findAllByUnitID(unitIds);
        const partIds = partInUnits.map(item => item.id)
        const activityInParts = await ActivityRepository.findAllByPartId(partIds);
        const activitySortedInUnit = this.topicWithACtSorted(unitsInfo, partInUnits, activityInParts);


        const practicesUnitConversations = await PracticeConversation.findAll({
            where: {unitId: unitIds, deletedAt: null}
        });

        const activityIds = practicesUnitConversations.map(item => item.activityId);

        const activitiesInfo = await this.activitiesConversationInfo(activityIds)

        let unitsWithActivities = {};
        practicesUnitConversations.forEach(item => {
            if (!unitsWithActivities[item.unitId]) {
                unitsWithActivities[item.unitId] = [item.activityId]
            } else {
                unitsWithActivities[item.unitId].push(item.activityId)
            }
        })

        const sortedVariable2 = this.sortByReferenceOrder(activitySortedInUnit, unitsWithActivities);

        let unitsInfoWithActivitiesInfo = [];

        for (let i = 0; i < (await unitsInfo).length; i++) {
            const unitItem = unitsInfo[i];
            const activities = unitsWithActivities[unitItem.id] || []

            const activitiesUnique = [...new Set(activities)];

            let activitiesItems = []
            activitiesUnique.forEach(item => {
                activitiesItems.push(activitiesInfo.find(i => i.id == item))
            })

            unitsInfoWithActivitiesInfo.push({
                ...unitItem.toJSON(),
                activities: activitiesItems
            })
        }

        return {errorCode: ErrorCode.SUCCESS, message: 'Thành công', data: unitsInfoWithActivitiesInfo};
    },

    topicWithACtSorted: function (unitInfo, partInUnits, activities) {
        const activitiesByPart = activities.reduce((acc, activity) => {
            activity = activity.toJSON()
            if (!acc[activity.partId]) {
                acc[activity.partId] = [];
            }
            acc[activity.partId].push(activity);
            return acc;
        }, {});


        const partsByUnit = partInUnits.reduce((acc, part) => {
            part = part.toJSON()
            if (!acc[part.unitId]) {
                acc[part.unitId] = [];
            }
            acc[part.unitId].push(part);
            return acc;
        }, {});

        const unitsWithActivities = unitInfo.map(unit => {
            unit = unit.toJSON();
            const parts = partsByUnit[unit.id] || [];
            const activitiesForUnit = parts.reduce((acc, part) => {
                return acc.concat(activitiesByPart[part.id] || null);
            }, []);
            return {
                ...unit,
                activities: activitiesForUnit
            };
        });
        let rs = {};
        unitsWithActivities.forEach(item => {
            rs[item.id] = item.activities.map(item => item.id);
        })
        return rs
    },

    sortByReferenceOrder: function sortByReferenceOrder(reference, data) {
        const sortedData = {};

        for (const key in data) {
            if (data.hasOwnProperty(key) && reference.hasOwnProperty(key)) {
                const orderMap = new Map(reference[key].map((id, index) => [id, index]));

                sortedData[key] = data[key].sort((a, b) => {
                    return (orderMap.has(a) ? orderMap.get(a) : Infinity) - (orderMap.has(b) ? orderMap.get(b) : Infinity);
                });
            } else {
                sortedData[key] = data[key];
            }
        }

        return sortedData;
    }

}