const ticketService = require("../services/TicketService");
const TicketConst = require("../constants/TicketConstant");
const utils = require("../utils/CommonUtils");

module.exports = {

    submitTicket: async function (req, res) {
        const profile = req.body.user.profiles.find(item => item.isDefault == 1);
        const responseData = {
            userId: profile.id,
            userType: TicketConst.USER_TYPES.CUSTOMER,
            title: TicketConst.REPORT_TYPE_2_TITLE[req.body.type],
            description: !utils.isEmpty(req.body.description) ? req.body.description : null,
            type: TicketConst.TICKET_TYPES.ERROR_REPORT,
            status: 0,
            parameters: req.body.params,
            createdAt: new Date(),
            updatedAt: new Date()
        }
        const response = await ticketService.saveTicket(responseData);
        res.json(response);
    },

}
