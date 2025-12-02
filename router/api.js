const express = require('express');
const router = express.Router();

// Controllers
let userController = require('../controllers/UserController');
let courseController = require('../controllers/CourseController');
let licenseController = require('../controllers/LicenseController');
let activityController = require('../controllers/ActivityController')
let questionController = require('../controllers/QuestionController')
let missionController = require('../controllers/MissionController')
let packageController = require('../controllers/PackageController');
let grammarController = require('../controllers/GrammarController');
let ticketController = require('../controllers/TicketController');
let SpeechaceController = require('../controllers/SpeechaceController');
let CompetitionController = require('../controllers/CompetitionController');
let testResultController = require('../controllers/TestResultController');
let writingResultController = require('../controllers/WritingResultController');

// Rules
let requestValidation = require('../validators/RequestValidation');
let loginRules = require('../validators/user/LoginRules');
let registerRules = require('../validators/user/RegisterRules');
let checkExistRules = require('../validators/user/CheckExistRules');
let registerConfirmRules = require('../validators/user/RegisterConfirmRules');
let forgotPasswordRules = require('../validators/user/ForgotPasswordRules');
let forgotPasswordCheckOtpRules = require('../validators/user/ForgotPasswordCheckOtpRules');
let forgotPasswordConfirmRules = require('../validators/user/ForgotPasswordConfirmRules');
let getLearningInfoRules = require('../validators/user/GetLearningInfoRules');
let getLearningReportRules = require('../validators/user/GetLearningReportRules');
let updateUserRules = require('../validators/user/UpdateUserRules');
let getGrammarRules = require('../validators/grammar/GetGrammarRules');
let disableAccountRules = require('../validators/user/DisableAccountRules');
let getActivityListRules = require('../validators/course/GetActivityListRules');
let getUnitListRules = require('../validators/course/GetUnitListRules');
let submitActivityScoreRules = require('../validators/activity/SubmitActivityScoreRules');
let updateActivityScore = require('../validators/activity/UpdateActivityScore');
let submitTestResultRules = require('../validators/activity/SubmitTestResults');
let GetActivityRules = require('../validators/activity/GetActivityRules');
let getWordsRules = require('../validators/unit/GetWordsRules');
let updateVipRules = require('../validators/license/UpdateVipRules');
let buyPackageRules = require('../validators/license/BuyPackageRules');
let genCodeRules = require('../validators/license/GenCodeRules');
let checkActiveCodeRules = require('../validators/license/CheckActiveCodeRules');
let submitTicketRules = require('../validators/ticket/SubmitTicketRules');
let getConversationRules = require('../validators/grammar/GetConversationRules');
let CompetitionRules = require('../validators/grammar/CompetitionRules');
let phoneVerificationGetOtpRules = require('../validators/user/PhoneVerificationGetOtpRules');
let phoneVerificationConfirmRules = require('../validators/user/PhoneVerificationConfirmRules');
let submitBeginTestResultRules = require('../validators/test/SubmitTestResultRules');

let checkOtpTokenMiddleware = require('../middlewares/CheckOtpTokenMiddleware');
let checkTokenMiddleware = require('../middlewares/CheckTokenMiddleware');
let checkIpMiddleware = require('../middlewares/CheckIpMiddleware');
let getListTestResultRules = require('../validators/test/GetListTestResultRules');


router.get('/', function (req, res) {
    res.send('Hello World');
});

router.post('/user/login', requestValidation(loginRules), userController.login);
router.get('/user/check-exist', requestValidation(checkExistRules), userController.checkExist);
router.post('/user/register', requestValidation(registerRules), userController.register);
router.post('/user/register-confirm', requestValidation(registerConfirmRules), userController.registerConfirm);
router.post('/user/forgot-password', requestValidation(forgotPasswordRules), userController.forgotPassword);
router.post('/user/forgot-password-check-otp', requestValidation(forgotPasswordCheckOtpRules), userController.forgotPasswordCheckOtp);
router.post('/user/forgot-password-confirm', checkOtpTokenMiddleware, requestValidation(forgotPasswordConfirmRules), userController.forgotPasswordConfirm);
router.get('/user/learning-info', checkTokenMiddleware, requestValidation(getLearningInfoRules), userController.getLearningInfo);
router.get('/user/learning-report', checkTokenMiddleware, requestValidation(getLearningReportRules), userController.getLearningReport);
router.get('/user/level-stats', checkTokenMiddleware, userController.getLevelStats);
router.get('/user/info', checkTokenMiddleware, userController.info);
router.post('/user/update', checkTokenMiddleware, requestValidation(updateUserRules), userController.update);
router.post('/user/disable', checkTokenMiddleware, requestValidation(disableAccountRules), userController.disable);
router.post('/user/phone-verification/get-otp', checkTokenMiddleware, requestValidation(phoneVerificationGetOtpRules), userController.phoneVerificationGetOtp);
router.post('/user/phone-verification/confirm', checkTokenMiddleware, requestValidation(phoneVerificationConfirmRules), userController.phoneVerificationConfirm);

router.get('/course/level-list', checkTokenMiddleware, courseController.getLevelList);
router.get('/course/unit-list', checkTokenMiddleware, requestValidation(getUnitListRules), courseController.getUnitList);
router.get('/course/units', checkTokenMiddleware, courseController.getUnitListByLevel);
router.get('/course/activity-list', checkTokenMiddleware, requestValidation(getActivityListRules), courseController.getActivityList);
router.get('/course/test-list', checkTokenMiddleware, courseController.getTestList);
router.get('/course/test-results', checkTokenMiddleware, requestValidation(getListTestResultRules), courseController.getTestResults);
router.post('/course/test-list/submit-result', checkTokenMiddleware, requestValidation(submitBeginTestResultRules), testResultController.submitTestResult);
router.get('/course/test-list/results', checkTokenMiddleware, testResultController.filterTestResults);
router.get('/course/test-result/report', checkTokenMiddleware, testResultController.getReportForTestResults);

// Danh sách từ của unit
router.get('/course/unit/words', checkTokenMiddleware, requestValidation(getWordsRules), courseController.getWords);

router.get('/premium/package-list', checkTokenMiddleware, packageController.getPackageList);

router.get('/license/check-vip', checkTokenMiddleware, licenseController.checkVip);
router.post('/license/update-vip', checkTokenMiddleware, requestValidation(updateVipRules), licenseController.updateVip);
// Purchase Transaction
router.post('/license/buy-package', checkTokenMiddleware, requestValidation(buyPackageRules), licenseController.buyPackage);
router.post('/license/gen-code', checkIpMiddleware, requestValidation(genCodeRules), licenseController.genCode);
router.post('/license/active-code', checkTokenMiddleware, licenseController.activeCode);
router.get('/license/check-active-code', checkIpMiddleware, requestValidation(checkActiveCodeRules), licenseController.checkActiveCode);

router.get('/activity/:id', requestValidation(GetActivityRules), activityController.getInfo);
router.post('/question/build/:id', activityController.buildQuestionData);
router.post('/activity/submit-score', checkTokenMiddleware, requestValidation(submitActivityScoreRules), activityController.submitActivityScore);
router.post('/activity/update-score', checkIpMiddleware, requestValidation(updateActivityScore), activityController.updateActivityScore);
router.post('/activity/submit-test-results', checkTokenMiddleware, requestValidation(submitTestResultRules), activityController.submitTestResult);

// get writing question
router.get('/questions/:id', checkTokenMiddleware, questionController.getQuestionById);

// writing submit
router.post('/writing/submit', checkTokenMiddleware, questionController.submitWriting);

router.get('/writing/count-notify', checkTokenMiddleware, writingResultController.countWritingNotify);
router.get('/writing/notifications', checkTokenMiddleware, writingResultController.getWritingNotify);
router.get('/writing/notification/:id', checkTokenMiddleware, writingResultController.getWritingNotifyDetail);

// Mission
router.get('/missions', checkTokenMiddleware, missionController.getMissionBySkill);

// Ngữ pháp + Từ vựng
router.get('/practice/grammar/words', checkTokenMiddleware, requestValidation(getGrammarRules), grammarController.getWords);
router.get('/practice/grammar/sentences', checkTokenMiddleware, requestValidation(getGrammarRules), grammarController.getSentences);

// Game hoi thoai AI.
router.get('/practice/conversation',checkTokenMiddleware, requestValidation(getConversationRules),  grammarController.getConversation);
router.get('/practice/conversation/learning-info',checkTokenMiddleware, requestValidation(getConversationRules),  grammarController.getConversationLearningInfo);
// Game thi dau
router.get('/practice/competition/bot-list', checkTokenMiddleware, CompetitionController.botList); // Chon bot
router.get('/practice/competition/play', checkTokenMiddleware, requestValidation(CompetitionRules), CompetitionController.play); // Play game

// Tickets
router.post('/ticket/submit', checkTokenMiddleware, requestValidation(submitTicketRules), ticketController.submitTicket);

// Speechace
router.post('/speechace',checkTokenMiddleware, SpeechaceController.speakAI);

module.exports = router;
