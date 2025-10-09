const userLearningInfoRepository = require("../repositories/UserLearningInfoRepository");
const utils = require("../utils/CommonUtils");
const reviewConst = require("../constants/ReviewConstant");
const knowledgeConst = require("../constants/KnowledgeConstant");
module.exports = {
    getReport: async function (levelId, profileId) {
        let percent = 0;
        let vocabularyScore = 0;
        let grammaScore = 0;
        let listeningScore = 0;
        let speakingScore = 0;
        let readingScore = 0;
        let writingScore = 0;
        let totalScore = 0;
        let writingReview = '';
        let readingReview = '';
        let speakingReview = '';
        let listeningReview = '';
        let grammaReview = '';
        let vocabularyReview = '';
        let model = await userLearningInfoRepository.findByLevelIdAndProfileId(levelId, profileId);

        if (!utils.isEmpty(model) && !utils.isEmpty(model.testResults) ) {
            let testResults = JSON.parse(model.testResults);
            let results =  testResults.results;

            results.forEach(function(result) {
                if (result.skill === knowledgeConst.VOCABULARY && result.score > 0) {
                    vocabularyScore += 1;
                }
                if (result.skill === knowledgeConst.GRAMMAR && result.score > 0) {
                    grammaScore += 1;
                }
                if (result.skill === knowledgeConst.LISTENING && result.score > 0) {
                    listeningScore += 1;
                }
                if (result.skill === knowledgeConst.SPEAKING && result.score >= 60) {
                    speakingScore += 1;
                }
                if (result.skill === knowledgeConst.READING && result.score > 0) {
                    readingScore += 1;
                }
                if (result.skill === knowledgeConst.WRITING && result.score > 0) {
                    writingScore += 1;
                }
            });
            if (vocabularyScore > 0 && vocabularyScore <= 2) {
                vocabularyReview = reviewConst.VOCABULARY_ELEMENTARY;
            } else if (vocabularyScore > 2 && vocabularyScore <= 4) {
                vocabularyReview = reviewConst.VOCABULARY_INTERMEDIATE;
            } else if (vocabularyScore === 5) {
                vocabularyReview = reviewConst.VOCABULARY_PROFICIENT;
            }

            if (grammaScore > 0 && grammaScore <= 2) {
                grammaReview = reviewConst.GRAMMA_ELEMENTARY;
            } else if (grammaScore > 2 && grammaScore <= 4) {
                grammaReview = reviewConst.GRAMMA_INTERMEDIATE;
            } else if (grammaScore === 5) {
                grammaReview = reviewConst.GRAMMA_PROFICIENT;
            }

            if (listeningScore > 0 && listeningScore <= 1) {
                listeningReview = reviewConst.LISTENING_ELEMENTARY;
            } else if (listeningScore === 2) {
                listeningReview = reviewConst.LISTENING_INTERMEDIATE;
            } else if (listeningScore === 3) {
                listeningReview = reviewConst.LISTENING_PROFICIENT;
            }

            if (speakingScore > 0 && speakingScore <= 2) {
                speakingReview = reviewConst.SPEAKING_ELEMENTARY;
            } else if (speakingScore > 2 && speakingScore <= 4) {
                speakingReview = reviewConst.SPEAKING_INTERMEDIATE;
            } else if (speakingScore === 5) {
                speakingReview = reviewConst.SPEAKING_PROFICIENT;
            }

            if (readingScore > 0 && readingScore <= 1) {
                readingReview = reviewConst.READING_ELEMENTARY;
            } else if (readingScore === 2) {
                readingReview = reviewConst.READING_INTERMEDIATE;
            } else if (readingScore === 3) {
                readingReview = reviewConst.READING_PROFICIENT;
            }

            if (writingScore > 0 && writingScore <= 1) {
                writingReview = reviewConst.WRITING_ELEMENTARY;
            } else if (writingScore === 2) {
                writingReview = reviewConst.WRITING_INTERMEDIATE;
            } else if (writingScore === 3) {
                writingReview = reviewConst.WRITING_PROFICIENT;
            }

            totalScore = vocabularyScore + grammaScore + listeningScore + speakingScore + readingScore + writingScore;
            percent = (totalScore/results.length) * 100;
            utils.log(`vocabularyScore : ${vocabularyScore}`);
            utils.log(`grammaScore : ${grammaScore}`);
            utils.log(`listeningScore : ${listeningScore}`);
            utils.log(`speakingScore : ${speakingScore}`);
            utils.log(`readingScore : ${readingScore}`);
            utils.log(`writingScore : ${writingScore}`);
            utils.log(`percent : ${percent}`);
        }

        return {
            percent: percent,
            overview: {
                vocabulary: (vocabularyScore/5)*10, // Tối đa 5 điểm
                gramma: (grammaScore/5)*10, // Tối đa 5 điểm
                listening: (listeningScore/3)*10, // Tối đa 3 điểm
                speaking: (speakingScore/5)*10, // Tối đa 5 điểm
                reading: (readingScore/3)*10, // Tối đa 3 điểm
                writing: (writingScore/3)*10 // Tối đa 3 điểm
            },
            detailReview: {
                vocabulary: vocabularyReview,
                gramma: grammaReview,
                listening: listeningReview,
                speaking: speakingReview,
                reading: readingReview,
                writing: writingReview
            }
        };
    }
}
