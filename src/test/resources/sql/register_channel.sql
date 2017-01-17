DROP TABLE IF EXISTS `register_channel`;
CREATE TABLE `register_channel` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NULL DEFAULT NULL COMMENT '渠道名称',
	`status` TINYINT(4) NULL DEFAULT '0' COMMENT '渠道状态(0:关闭 1：打开)',
	PRIMARY KEY (`id`),
	INDEX `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

BEGIN;
INSERT INTO `register_channel` (`id`, `name`, `status`) VALUES (1, 'hnair-ffpcard', 1);
COMMIT;
