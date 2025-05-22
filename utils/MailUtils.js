const nodemailer =  require('nodemailer');
const config = require('../config');
// Config mail server
const transporter =  nodemailer.createTransport({
    service: 'Gmail',
    secure: false, // use SSL
    port: 25, // port for secure SMTP
    auth: {
        user: config.email.admin.username,
        pass: config.email.admin.password
    },
    tls: {
        rejectUnauthorized: false
    }
});

module.exports = {

    sendMail: function (to, subject, text, html) {
        // Setup subject, content to send mail
        const mainOptions = {
            from: config.email.admin.name,
            to: to,
            subject: subject,
            text: text,
            html: html
        }
        return new Promise(resolve => {
            transporter.sendMail(mainOptions, function(err, info){
                if (err) {
                    console.log(err);
                    resolve(true);
                } else {
                    console.log('Message sent: ' +  info.response);
                    resolve(false);
                }
            });
        });
    }

}