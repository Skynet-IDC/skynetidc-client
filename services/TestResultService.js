const userLearningInfoRepository = require("../repositories/UserLearningInfoRepository");

module.exports = {
    getReport: async function (levelId, profileId) {
        let percent = 0;
        let scoreGramma = 0;
        let scoreListening = 0;
        let scoreSpeaking = 0;
        let scoreReading = 0;
        let scoreWriting = 0;
        let userLearningInfo = await userLearningInfoRepository.findByLevelIdAndProfileId(levelId, profileId);
        // const activity = JSON.parse(userLearningInfo.activities);
        // if (activity) {
        //
        // }

        if (userLearningInfo.skill === 'GRAMMAR') {
            scoreGramma += 1;
        }
        if (userLearningInfo.skill === 'SPEAKING') {
            scoreSpeaking += 1;
        }
        if (userLearningInfo.skill === 'LISTENING') {
            scoreListening += 1;
        }
        if (userLearningInfo.skill === 'READING') {
            scoreReading += 1;
        }
        if (userLearningInfo.skill === 'WRITING') {
            scoreWriting += 1;
        }

        return {
            percent: percent, // Tối đa 100%
            overview: {
                gramma: scoreGramma, // Tối đa 10 điểm
                listening: scoreListening, // Tối đa 3 điểm
                speaking: scoreSpeaking, // Tối đa 5 điểm
                reading: scoreReading, // Tối đa 3 điểm
                writing: scoreWriting // Tối đa 3 điểm
            },
            detailReview: {
                gramma: "Nắm chắc cơ bản, còn vài lỗi nhỏ cần cải thiện.",
                listening: "Hiểu nội dung chính, phản xạ nhanh.",
                speaking: "Phát âm chưa rõ, diễn đạt còn hạn chế.",
                reading: "Đọc chưa chuẩn ở một số âm tiết, cần cải thiện thêm",
                writing: "Bố cục chưa rõ ràng, cần cải thiện ngữ pháp và mạch lạc."
            }
        };
    }
}
