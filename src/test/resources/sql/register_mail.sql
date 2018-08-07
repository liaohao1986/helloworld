DROP TABLE IF EXISTS `register_mail`;

CREATE TABLE `register_mail` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`mail` VARCHAR(100) NULL DEFAULT NULL COMMENT '邮箱地址',
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

BEGIN;
INSERT INTO `register_mail` (`id`, `mail`) VALUES (1, 'vapyb322259@maopao.com');
INSERT INTO `register_mail` (`id`, `mail`) VALUES (2, 'kzrqc924600@maopao.com');
COMMIT;
