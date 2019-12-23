/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : company

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2019-12-23 17:58:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL COMMENT '项目名',
  `number` int(11) NOT NULL COMMENT '项目编号',
  `remark` text COMMENT '项目要求，详细说明等（选填）',
  `status` varchar(255) NOT NULL default '待开发' COMMENT '开发情况（待开发/正在开发/开发完成）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL COMMENT '员工姓名',
  `number` int(11) NOT NULL COMMENT '工号',
  `ofTeam` int(11) NOT NULL default '0' COMMENT '所属小组',
  `phone` varchar(25) default '无' COMMENT '手机号',
  `tenure` varchar(20) NOT NULL default '在职' COMMENT '任职情况（在职/休假/离职）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------

-- ----------------------------
-- Table structure for `team`
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) NOT NULL COMMENT '小组名',
  `number` int(11) NOT NULL COMMENT '小组编号',
  `ofPorject` int(11) NOT NULL default '0' COMMENT '所属项目（0表示未参与项目开发）',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of team
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', '123');
