SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
    `a_id` INT UNSIGNED AUTO_INCREMENT,
    `a_name` VARCHAR(20) NOT NULL,
    `a_psd` VARCHAR(20) NOT NULL,
    `a_tel` DOUBLE  NOT NULL,
    PRIMARY KEY (`a_id`)
    )ENGINE=InnoDB DEFAULT CHARSET =utf8;
INSERT INTO `admin` VALUES ('1','测试管理员1', '1','12345');
INSERT INTO `admin` VALUES ('2','测试管理员2', '1','23456');
INSERT INTO `admin` VALUES ('3','测试管理员3', '1','34567');
INSERT INTO `admin` VALUES ('4','测试管理员4', '1','1234');
INSERT INTO `admin` VALUES ('5','测试管理员5', '1','12345');
INSERT INTO `admin` VALUES ('6','测试管理员6', '1','123456');
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
     `u_ID` INT  UNSIGNED AUTO_INCREMENT ,
    `u_Name` varchar(20) NOT NULL ,
    `u_PSWD` varchar(10) NOT NULL ,
    `u_tel` DOUBLE  NOT NULL,
    PRIMARY KEY (`u_ID`)
) ENGINE=InnoDB DEFAULT CHARSET =utf8;

-- ----------------------------
-- Records of customer
INSERT INTO `user` VALUES ('1','测试用户1', '1','12345');
INSERT INTO `user` VALUES ('2','测试用户2', '1','23456');
INSERT INTO `user` VALUES ('3','测试用户3', '1','34567');
INSERT INTO `user` VALUES ('4','测试用户4', '1','1234');
INSERT INTO `user` VALUES ('5','测试用户5', '1','12345');
INSERT INTO `user` VALUES ('6','测试用户6', '1','123456');
drop table IF exists `book`
CREATE  TABLE `book`(
    `b_id` INT UNSIGNED AUTO_INCREMENT  ,
    `b_name` varchar (20) NOT NULL,
    `b_p` varchar (20) NOT NULL ,
    `b_a` varchar (20) NOT  NULL ,
    `b_n` INT NOT NULL,
    PRIMARY  KEY (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET =utf8;
