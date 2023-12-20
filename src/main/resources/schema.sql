DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `avatar_path` varchar(255) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `email` varchar(255) DEFAULT NULL,
    `phone` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


