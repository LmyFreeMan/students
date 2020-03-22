/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : sakila

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-02-26 20:43:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `name_cid_INX` (`name`,`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 'zs', '2', null);
INSERT INTO `student` VALUES ('2', 'ls', '3', null);
INSERT INTO `student` VALUES ('3', 'ww', '4', null);
INSERT INTO `student` VALUES ('8', 'zs', '2', null);
INSERT INTO `student` VALUES ('10', 'zs', '2', null);
INSERT INTO `student` VALUES ('11', 'zs', '2', null);
INSERT INTO `student` VALUES ('12', 'zs', '2', null);
INSERT INTO `student` VALUES ('13', 'zs', '2', null);
INSERT INTO `student` VALUES ('17', 'zs', '2', null);
