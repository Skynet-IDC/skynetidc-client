const PracticeConversationRepository = require('../repositories/PracticeConversationRepository');
const ErrorCode = require('../constants/ErrorCode');
const PracticeConversationScore = require("../entities/PracticeConversationScore");
const PartRepository = require("../repositories/PartRepository");
const ActivityRepository = require("../repositories/ActivityRepository");
const unitService = require("./UnitService");

module.exports = {

    savePracticeConversationScore: async function (params) {
        const {activityId, profileId} = params
        const existSubmit = await PracticeConversationScore.findOne({
            where: {activityId, profileId}
        })

        if (existSubmit && existSubmit.toJSON().score < params.score) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Lưu thông tin thành công'};
        }

        const result = await PracticeConversationRepository.save(params);
        if (result) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Lưu thông tin thành công'};
        }
        return {errorCode: ErrorCode.COMMON_FAIL, message: 'Lưu thông tin thất bại'};
    },

    getConversationsInfo: async function (levelId, profileId) {
        const rs = await PracticeConversationScore.findAll({
            where: {profileId, levelId}
        });

        const unitsInfo = await unitService.getByLevel(levelId)

        const unitIds = unitsInfo.map(item => item.id);

        const partInUnits = await PartRepository.findAllByUnitID(unitIds);
        const partIds = partInUnits.map(item => item.id)
        const activityInParts = await ActivityRepository.findAllByPartId(partIds);


        let actRs = {}
        for (let i = 0; i < activityInParts.length; i++) {
            const act = activityInParts[i].toJSON()
            const actPointScore = rs.find(item => item.activityId == act.id)
            actRs[act.id] = actPointScore?.score || 0
        }

        return {
            "activities": actRs
        }
    }
}