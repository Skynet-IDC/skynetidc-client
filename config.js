require('dotenv').config();
console.log(process.env.LOG_ENABLED)
module.exports = {
    mysqlConnection: {
        host: process.env.DB_HOST,
        port: process.env.DB_PORT,
        db: process.env.DB_NAME,
        username: process.env.DB_USER,
        password: process.env.DB_PASS
    },
    passwordSalt: 10,
    email: {
        admin: {
            name: process.env.EMAIL_NAME,
            username: process.env.EMAIL_USERNAME,
            password: process.env.EMAILSUS_PASSWORD
        },
        content: {
            registerSubject: process.env.EMAIL_REGISTER_SUBJECT,
            registerContent: process.env.EMAIL_REGISTER_CONTENT,
            forgotPasswordSubject: process.env.EMAIL_FORGOT_PASSWORD_SUBJECT,
            forgotPasswordContent: process.env.EMAIL_FORGOT_PASSWORD_CONTENT,
        }
    },
    sms: {
        url: process.env.SMS_URL,
        admin: {
            providerKey: process.env.SMS_PROVIDER_KEY,
            username: process.env.SMS_USERNAME,
            provider: process.env.SMS_PROVIDER,
            source: process.env.SMS_SOURCE
        },
        content: {
            text: process.env.SMS_CONTENT
        }
    },
    redisConnection: {
        host: process.env.REDIS_HOST,
        port: process.env.REDIS_PORT,
        db: process.env.REDIS_DB,
        username: process.env.REDIS_USER,
        password: process.env.REDIS_PASS
    },
    googleService: {
        accountEmail: process.env.GOOGLE_SERVICE_ACCOUNT_EMAIL,
        privateKey: process.env.GOOGLE_PRIVATE_KEY.split(String.raw`\n`).join('\n'),
        ticketSheetId: process.env.GOOGLE_TICKET_SHEET_ID
    },
    whiteListIp: process.env.WHITE_LIST_IP.split(','),
    logging: {
        enabled: process.env.LOG_ENABLED === 'true',
        path: process.env.LOG_PATH || './logs',
        consoleOutput: process.env.LOG_CONSOLE === 'true'
    }
}
