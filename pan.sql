/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : pan

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 29/11/2020 18:07:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint(20) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (9);
INSERT INTO `hibernate_sequence` VALUES (9);
INSERT INTO `hibernate_sequence` VALUES (9);

-- ----------------------------
-- Table structure for link_secret
-- ----------------------------
DROP TABLE IF EXISTS `link_secret`;
CREATE TABLE `link_secret`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `download_num` int(11) NOT NULL,
  `expire_date` datetime(0) NULL DEFAULT NULL,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `local_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `secret` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `secret_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `share_date` datetime(0) NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of link_secret
-- ----------------------------
INSERT INTO `link_secret` VALUES (7, 1, NULL, '3.JPG', '/data/share/admin/zheshi/1/3.JPG', 'v53Z', 'cbiA3XWaoqrlgo7BTpFruIIv7evdy423', '2020-06-24 17:32:15', 'admin');
INSERT INTO `link_secret` VALUES (8, 1, NULL, 'chat-img2.jpg', '/data/share/admin/chat-img2.jpg', 'IXjT', 'w0nnjS9b7NLk41hCzww-IfqO64lGkaz1', '2020-10-17 18:08:05', 'admin');

-- ----------------------------
-- Table structure for pan_save
-- ----------------------------
DROP TABLE IF EXISTS `pan_save`;
CREATE TABLE `pan_save`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `local_link` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `pan_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for pan_user
-- ----------------------------
DROP TABLE IF EXISTS `pan_user`;
CREATE TABLE `pan_user`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'username',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'password',
  `level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT 'level',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'email',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'phone',
  `alias` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pan_user
-- ----------------------------
INSERT INTO `pan_user` VALUES (1, 'admin', '464A4CCFC21BD8CD05B106205EE025A883724B', '0', 'sandeepin@qq.com', '15578352978', NULL);
INSERT INTO `pan_user` VALUES (2, 'sandeepin', '464A4CCFC21BD8CD05B106205EE025A883724B', '0', 'jfz@jfz.me', '17671766376', NULL);
INSERT INTO `pan_user` VALUES (3, 'cflower', '464A4CCFC21BD8CD05B106205EE025A883724B', '0', 'xxx@qq.com', '18200000000', NULL);
INSERT INTO `pan_user` VALUES (4, 'zc2', '464A4CCFC21BD8CD05B106205EE025A883724B', '0', 'xxx@qq.com', '18200000000', NULL);
INSERT INTO `pan_user` VALUES (5, 'zuidaima', '464A4CCFC21BD8CD05B106205EE025A883724B', '0', 'zuidaima@qq.com', '13520109202', '最代码');

-- ----------------------------
-- Table structure for verify_code
-- ----------------------------
DROP TABLE IF EXISTS `verify_code`;
CREATE TABLE `verify_code`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custom_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `date` datetime(0) NULL DEFAULT NULL,
  `operate_person` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `register_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `state` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
