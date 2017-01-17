DROP TABLE IF EXISTS `register_mail_channel`;
CREATE TABLE `register_mail_channel` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`mail_id` INT(10) NULL DEFAULT '0' COMMENT '邮箱ID',
	`channel_id` INT(10) NULL DEFAULT '0' COMMENT '渠道ID',
	PRIMARY KEY (`id`),
	INDEX `mail_id` (`mail_id`),
	INDEX `channel_id` (`channel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;