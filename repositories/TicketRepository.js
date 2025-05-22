const Ticket = require("../entities/Ticket");
const utils = require("../utils/CommonUtils");

module.exports = {

    save: function (fields = {}) {
        return new Promise(resolve => {
            Ticket.create(fields).then(result => {
                resolve(result);
            }).catch(e => {
                utils.log(`[TicketRepository] Error when executing "save", detail: ${e}`);
                resolve(false);
            })
        });
    }

}