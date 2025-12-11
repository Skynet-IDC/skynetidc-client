const userLearningInfoRepository = require("../repositories/UserLearningInfoRepository");
const utils = require("../utils/CommonUtils");
const reviewConst = require("../constants/ReviewConstant");
const overallConst = require("../constants/OverallConstant");
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
        let evaluate = '';
        let writingReview = '';
        let readingReview = '';
        let speakingReview = '';
        let listeningReview = '';
        let grammaReview = '';
        let vocabularyReview = '';
        let writingOverall = '';
        let readingOverall = '';
        let speakingOverall = '';
        let listeningOverall = '';
        let grammaOverall = '';
        let vocabularyOverall = '';
        let model = await userLearningInfoRepository.findByLevelIdAndProfileId(levelId, profileId);

        if (!utils.isEmpty(model) && !utils.isEmpty(model.testResults) ) {
            let testResults = JSON.parse(model.testResults);
            let results =  testResults.results;

            if (results) {
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
                if (vocabularyScore >= 0 && vocabularyScore <= 2) {
                    vocabularyReview = reviewConst.VOCABULARY_ELEMENTARY;
                    vocabularyOverall = overallConst.ELEMENTARY;
                } else if (vocabularyScore > 2 && vocabularyScore <= 4) {
                    vocabularyReview = reviewConst.VOCABULARY_INTERMEDIATE;
                    vocabularyOverall = overallConst.INTERMEDIATE;
                } else if (vocabularyScore === 5) {
                    vocabularyReview = reviewConst.VOCABULARY_PROFICIENT;
                    vocabularyOverall = overallConst.PROFICIENT;
                }

                if (grammaScore >= 0 && grammaScore <= 2) {
                    grammaReview = reviewConst.GRAMMA_ELEMENTARY;
                    grammaOverall = overallConst.ELEMENTARY;
                } else if (grammaScore > 2 && grammaScore <= 4) {
                    grammaReview = reviewConst.GRAMMA_INTERMEDIATE;
                    grammaOverall = overallConst.INTERMEDIATE;
                } else if (grammaScore === 5) {
                    grammaReview = reviewConst.GRAMMA_PROFICIENT;
                    grammaOverall = overallConst.PROFICIENT;
                }

                if (listeningScore >= 0 && listeningScore <= 1) {
                    listeningReview = reviewConst.LISTENING_ELEMENTARY;
                    listeningOverall = overallConst.ELEMENTARY;
                } else if (listeningScore === 2) {
                    listeningReview = reviewConst.LISTENING_INTERMEDIATE;
                    listeningOverall = overallConst.INTERMEDIATE;
                } else if (listeningScore === 3) {
                    listeningReview = reviewConst.LISTENING_PROFICIENT;
                    listeningOverall = overallConst.PROFICIENT;
                }

                if (speakingScore >= 0 && speakingScore <= 2) {
                    speakingReview = reviewConst.SPEAKING_ELEMENTARY;
                    speakingOverall = overallConst.ELEMENTARY;
                } else if (speakingScore > 2 && speakingScore <= 4) {
                    speakingReview = reviewConst.SPEAKING_INTERMEDIATE;
                    speakingOverall = overallConst.INTERMEDIATE;
                } else if (speakingScore === 5) {
                    speakingReview = reviewConst.SPEAKING_PROFICIENT;
                    speakingOverall = overallConst.PROFICIENT;
                }

                if (readingScore >= 0 && readingScore <= 1) {
                    readingReview = reviewConst.READING_ELEMENTARY;
                    readingOverall = overallConst.ELEMENTARY;
                } else if (readingScore === 2) {
                    readingReview = reviewConst.READING_INTERMEDIATE;
                    readingOverall = overallConst.INTERMEDIATE;
                } else if (readingScore === 3) {
                    readingReview = reviewConst.READING_PROFICIENT;
                    readingOverall = overallConst.PROFICIENT;
                }

                if (writingScore >= 0 && writingScore <= 1) {
                    writingReview = reviewConst.WRITING_ELEMENTARY;
                    writingOverall = overallConst.ELEMENTARY;
                } else if (writingScore === 2) {
                    writingReview = reviewConst.WRITING_INTERMEDIATE;
                    writingOverall = overallConst.INTERMEDIATE;
                } else if (writingScore === 3) {
                    writingReview = reviewConst.WRITING_PROFICIENT;
                    writingOverall = overallConst.PROFICIENT;
                }

                totalScore = vocabularyScore + grammaScore + listeningScore + speakingScore + readingScore + writingScore;

                if (totalScore < 12) {
                    evaluate = reviewConst.EVALUATE_ELEMENTARY;
                } else if (12 < totalScore <= 20 ) {
                    evaluate = reviewConst.EVALUATE_INTERMEDIATE;
                } else if (20 < totalScore <= 24) {
                    evaluate = reviewConst.EVALUATE_PROFICIENT;
                }
                percent = (totalScore/results.length) * 100;
                utils.log(`vocabularyScore : ${vocabularyScore}`);
                utils.log(`grammaScore : ${grammaScore}`);
                utils.log(`listeningScore : ${listeningScore}`);
                utils.log(`speakingScore : ${speakingScore}`);
                utils.log(`readingScore : ${readingScore}`);
                utils.log(`writingScore : ${writingScore}`);
                utils.log(`percent : ${percent}`);
            }
        }

        return {
            percent: percent,
            evaluate: evaluate,
            overview: {
                vocabulary: vocabularyScore*(10/5), // Tối đa 5 điểm
                gramma: grammaScore*(10/5), // Tối đa 5 điểm
                listening: listeningScore*(10/3), // Tối đa 3 điểm
                speaking: speakingScore*(10/5), // Tối đa 5 điểm
                reading: readingScore*(10/3), // Tối đa 3 điểm
                writing: writingScore*(10/3) // Tối đa 3 điểm
            },
            overall: {
                vocabulary: vocabularyOverall,
                gramma: grammaOverall,
                listening: listeningOverall,
                speaking: speakingOverall,
                reading: readingOverall,
                writing: writingOverall
            },
            reviews: [
                vocabularyReview, grammaReview, listeningReview, speakingReview, readingReview, writingReview
            ]
        };
    }
}
