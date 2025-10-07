-- Script to create gb_test_results table
-- Created on: 2025-07-30

-- Check if table exists and drop it if it does (uncomment if you want to recreate the table)
-- DROP TABLE IF EXISTS gb_test_results;

-- Create table if it doesn't exist
CREATE TABLE IF NOT EXISTS gb_test_results (
    id BIGINT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    level INT NULL,
    type ENUM('TEST_BASIC', 'TEST_ADVANCED') NOT NULL,
    questions TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Add indexes for faster queries
-- These will only be created if the table is being created for the first time
-- If the table already exists, these statements will be ignored

-- Index on user_id
CREATE INDEX idx_gb_test_results_user_id ON gb_test_results(user_id);

-- Index on type
CREATE INDEX idx_gb_test_results_type ON gb_test_results(type);

-- Combined index for user_id and type
CREATE INDEX idx_gb_test_results_user_id_type ON gb_test_results(user_id, type);

-- Add comment to the table
ALTER TABLE gb_test_results COMMENT 'Stores test results for users';

CREATE TABLE `gb_writing_results` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `question_id` int(11) NOT NULL,
  `level_id` int(11) DEFAULT NULL,
  `topic_id` int(11) DEFAULT NULL,
  `answers` text NOT NULL,
  `feedback` text DEFAULT NULL,
  `view` int NOT NULL,
  `status` int NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `idx_gb_writing_results_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Stores test result writing for users';