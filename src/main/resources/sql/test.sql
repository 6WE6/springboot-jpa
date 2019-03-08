-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
--DROP TABLE IF EXISTS `t_user`;
--CREATE TABLE `t_user` (
--  `id` int(11) NOT NULL AUTO_INCREMENT,
--  `name` varchar(32) DEFAULT NULL,
--  `age` varchar(32) DEFAULT NULL,
--  `gender` varchar(32) DEFAULT NULL,
--  PRIMARY KEY (`id`)
--) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE t_user;

CREATE TABLE t_user(
id number(11) primary key,
name varchar2(32),
age varchar2(32),
gender varchar2(32)
);
