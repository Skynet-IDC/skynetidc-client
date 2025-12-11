const errorCode = require('../constants/ErrorCode');
const missionService = require("../services/MissionService");
module.exports = {
    /**
     * Get Missions By Skill
     * @returns {Promise<void>}
     */
    getMissionBySkill: async function (req, res) {
        try {
            const skill = req.query.skill;
            const missions = await missionService.getMissionBySkill(skill);
            res.json(missions);
        } catch (error) {
            console.error('Error get mission:', error);
            res.json({
                errorCode: errorCode.COMMON_FAIL,
                message: 'Có lỗi xảy ra khi lấy thông tin nhiệm vụ'
            });
        }
    },
};
