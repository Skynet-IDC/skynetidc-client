const ticketRepository = require('../repositories/TicketRepository');
const ErrorCode = require('../constants/ErrorCode');
const commonUtils = require("../utils/CommonUtils");
const googleSheetUtils = require("../utils/GoogleSheetUtils");
const config = require('../config');

module.exports = {

    saveTicket: async function (params) {
        const result = await ticketRepository.save(params);
        // Add to google sheet
        let actId = '';
        try {
            const parameters = JSON.parse(params.parameters);
            actId = parameters.activityId;
        } catch (err) {}
        googleSheetUtils.addRow(config.googleService.ticketSheetId, 0, {
            'Ngày tạo': commonUtils.formatDate(new Date(), 'YYYY-MM-DD'),
            'Thời điểm': commonUtils.formatDate(new Date(), 'HH:mm:ss'),
            'User ID': params.userId,
            'ActID': actId,
            'Thông tin lỗi': params.title,
            'Chi tiết lỗi': params.description
        });
        if (result) {
            return {errorCode: ErrorCode.SUCCESS, message: 'Lưu thông tin thành công'};
        }
        return {errorCode: ErrorCode.COMMON_FAIL, message: 'Lưu thông tin thất bại'};
    }

}
