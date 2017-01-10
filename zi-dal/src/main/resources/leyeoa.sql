/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : leyeoa

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-01-06 11:43:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_authority`
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `is_enable` varchar(255) DEFAULT NULL,
  `url` longtext,
  `parent_id` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_Time` datetime DEFAULT NULL,
  `is_deleted` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO `sys_authority` VALUES ('1', '菜单路径', 'cdlj', '1', 'N', '/menu/findByUserId.htm', '1', '2017-01-05 11:13:36', '2017-01-05 11:13:39', 'N', '1');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `ico` varchar(255) DEFAULT NULL,
  `authority_id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `is_enable` varchar(255) DEFAULT NULL,
  `is_deleted` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '1', '1', '1', '2017-01-05 11:09:44', '2017-01-05 11:09:44', 'N', 'true', '1', '1');
INSERT INTO `sys_menu` VALUES ('2', '1', '1', '1', '2017-01-05 11:09:48', '2017-01-05 11:09:48', 'N', 'true', '1', '1');
INSERT INTO `sys_menu` VALUES ('3', '1', '1', '1', '2017-01-05 11:09:50', '2017-01-05 11:09:50', 'N', 'true', '1', '1');
INSERT INTO `sys_menu` VALUES ('4', '1', '1', '1', '2017-01-05 11:09:52', '2017-01-05 11:09:52', 'N', 'true', '1', '1');
INSERT INTO `sys_menu` VALUES ('5', '1', '1', '1', '2017-01-05 11:09:54', '2017-01-05 11:09:54', 'N', 'true', '1', '1');
INSERT INTO `sys_menu` VALUES ('6', '1', '1', '1', '2017-01-05 11:09:57', '2017-01-05 11:09:57', 'N', 'true', '1', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `code` varchar(255) NOT NULL,
  `is_enable` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '管理员', 'gly', 'N', '管理员');

-- ----------------------------
-- Table structure for `sys_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_authority`;
CREATE TABLE `sys_role_authority` (
  `id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  `authority_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_authority
-- ----------------------------
INSERT INTO `sys_role_authority` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  `menu_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('1', '1', '1');
INSERT INTO `sys_role_menu` VALUES ('2', '1', '2');
INSERT INTO `sys_role_menu` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for `sys_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('1', '1', '3f9ad1abce6511e68958f07959e0872f');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(255) NOT NULL,
  `to_id` varchar(255) DEFAULT NULL,
  `login_name` varchar(500) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `name` varchar(500) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `is_deleted` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `address` varchar(1000) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('3f9ad1abce6511e68958f07959e0872f', null, null, '111', '111', '111', '111', null, null, null, null, null, null, null, null, null, null);
