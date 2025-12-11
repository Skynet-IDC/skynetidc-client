const fs = require('fs');
const path = require('path');
const moment = require('moment');
const config = require('../config');

class Logger {
    constructor() {
        this.config = config.logging;
    }

    /**
     * Đảm bảo thư mục log tồn tại
     * @param {string|null} folderName - Subfolder name, null = root logs/
     */
    ensureLogDirectory(folderName) {
        const basePath = path.resolve(this.config.path);

        // Tạo thư mục root logs/ nếu chưa có
        if (!fs.existsSync(basePath)) {
            fs.mkdirSync(basePath, { recursive: true });
        }

        // Tạo subfolder nếu có folderName
        if (folderName) {
            const folderPath = path.join(basePath, folderName);
            if (!fs.existsSync(folderPath)) {
                fs.mkdirSync(folderPath, { recursive: true });
            }
        }
    }

    /**
     * Lấy đường dẫn file log
     * @param {string|null} folderName - Subfolder name
     * @returns {string} Full path đến file log
     */
    getLogFilePath(folderName) {
        const date = moment().format('YYYY-MM-DD');
        const fileName = `${date}.log`;
        const basePath = path.resolve(this.config.path);

        if (folderName) {
            return path.join(basePath, folderName, fileName);
        }
        return path.join(basePath, fileName);
    }

    /**
     * Format log message
     * @param {string} type - Log type: info, error, warn, debug
     * @param {string} content - Log message
     * @returns {string} Formatted log string
     */
    formatLog(type, content) {
        const timestamp = moment().format('YYYY-MM-DD HH:mm:ss');
        return `[${timestamp}] [${type.toUpperCase()}] ${content}\n`;
    }

    /**
     * Ghi log vào file
     * @param {string} type - Log type: 'info', 'error', 'warn', 'debug'
     * @param {string} content - Nội dung log
     * @param {string|null} folderName - Subfolder name, null = lưu root logs/
     */
    log(type, content, folderName = null) {
        // Kiểm tra logging có enabled không
        if (!this.config.enabled) {
            return;
        }

        // Validate type
        const validTypes = ['info', 'error', 'warn', 'debug'];
        if (!validTypes.includes(type)) {
            console.error(`Invalid log type: ${type}. Must be one of: ${validTypes.join(', ')}`);
            return;
        }

        // Validate content
        if (!content || typeof content !== 'string') {
            console.error('Log content must be a non-empty string');
            return;
        }

        try {
            // Đảm bảo thư mục tồn tại
            this.ensureLogDirectory(folderName);

            // Lấy đường dẫn file
            const logFilePath = this.getLogFilePath(folderName);

            // Format log message
            const logMessage = this.formatLog(type, content);

            // Ghi vào file (async, không block)
            fs.appendFile(logFilePath, logMessage, (err) => {
                if (err) {
                    console.error('Failed to write log:', err);
                }
            });

            // Console output nếu config bật
            if (this.config.consoleOutput) {
                console.log(logMessage.trim());
            }
        } catch (error) {
            console.error('Error in logger:', error);
        }
    }
}

module.exports = new Logger();

