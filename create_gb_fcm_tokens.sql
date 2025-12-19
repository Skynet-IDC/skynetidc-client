CREATE TABLE `gb_fcm_tokens` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `user_id` INT(10) UNSIGNED NOT NULL,
    `fcm_token` VARCHAR(500) NOT NULL,
    `device_id` VARCHAR(150) DEFAULT NULL,
    `device_type` ENUM('ios', 'android', 'web') DEFAULT 'android',
    `is_active` TINYINT(1) DEFAULT 1,
    `last_used_at` DATETIME DEFAULT NULL,
    `created_at` DATETIME DEFAULT NULL,
    `updated_at` DATETIME DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;