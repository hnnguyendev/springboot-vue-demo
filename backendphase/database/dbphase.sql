CREATE DATABASE `dbphase`;
USE `dbphase`;

CREATE TABLE `phases` (
	`id` BIGINT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NULL,
	`description` VARCHAR(1000) NULL,
	CONSTRAINT `pk_id` PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `phases` (`name`, `description`)
VALUES ('Phase 1', 'Automatic context help is disabled. Use the toolbar to manually get help for the current caret position or to toggle automatic help.'),
		('Phase 2', 'Automatic context help is disabled. Use the toolbar to manually get help for the current caret position or to toggle automatic help.'),
        ('Phase 3', 'Automatic context help is disabled. Use the toolbar to manually get help for the current caret position or to toggle automatic help.'),
        ('Phase 4', 'Automatic context help is disabled. Use the toolbar to manually get help for the current caret position or to toggle automatic help.'),
        ('Phase 5', 'Automatic context help is disabled. Use the toolbar to manually get help for the current caret position or to toggle automatic help.');