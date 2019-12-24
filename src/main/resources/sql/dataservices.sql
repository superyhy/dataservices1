/*
 Navicat Premium Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : dataservices

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 24/12/2019 16:23:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for air_quality
-- ----------------------------
DROP TABLE IF EXISTS `air_quality`;
CREATE TABLE `air_quality`  (
  `id` int(23) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `pm25` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '细颗粒物pm2.5指数',
  `pm10` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '可吸入颗粒物pm10指数',
  `so2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '二氧化硫指数',
  `no2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '二氧化碳指数',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `aqi` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '空气质量指数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of air_quality
-- ----------------------------
INSERT INTO `air_quality` VALUES (1, '株洲', '23', '23', '21', '23', '2019-12-19 16:10:10', '2019-12-19 16:15:58', '34');
INSERT INTO `air_quality` VALUES (2, '北京', '23', '23', '7', '45', '2019-12-16 11:00:30', NULL, '30');
INSERT INTO `air_quality` VALUES (3, '南京', '34', '23', '8', '46', '2019-12-16 11:00:53', NULL, '42');
INSERT INTO `air_quality` VALUES (4, '长沙', '32', '23', '8', '46', '2019-12-16 11:01:13', NULL, '45');
INSERT INTO `air_quality` VALUES (5, '衡阳', '23', '34', '7', '56', '2019-12-16 11:01:34', NULL, '45');
INSERT INTO `air_quality` VALUES (6, '广州', '21', '34', '8', '57', '2019-12-16 11:02:03', NULL, '43');
INSERT INTO `air_quality` VALUES (7, '广州', '34', '34', '8', '25', '2019-12-17 13:55:04', NULL, '34');
INSERT INTO `air_quality` VALUES (8, '长沙·', '23', '23', '7', '23', '2019-12-17 10:07:01', '2019-12-17 10:07:19', '34');
INSERT INTO `air_quality` VALUES (9, '长沙', '24', '35', '8', '34', '2019-12-15 10:07:47', '2019-12-17 15:33:43', '42');
INSERT INTO `air_quality` VALUES (10, '长沙', '24', '34', '8', '24', '2019-12-16 10:08:07', '2019-12-17 15:33:48', '34');
INSERT INTO `air_quality` VALUES (18, '长沙', '23', '24', '32', '31', '2019-12-18 10:10:59', NULL, '21');
INSERT INTO `air_quality` VALUES (23, '衡阳', '23', '21', '24', '23', '2019-12-18 11:03:33', NULL, '34');
INSERT INTO `air_quality` VALUES (24, '郴州', '21', '23', '23', '21', '2019-12-18 11:05:16', NULL, '23');
INSERT INTO `air_quality` VALUES (25, '株洲', '24', '23', '24', '21', '2019-12-18 11:07:48', '2019-12-19 17:35:50', '21');
INSERT INTO `air_quality` VALUES (32, '长沙', '23', '23', '23', '23', '2019-12-19 14:32:47', '2019-12-19 15:14:18', '50');

-- ----------------------------
-- Table structure for city_pm25
-- ----------------------------
DROP TABLE IF EXISTS `city_pm25`;
CREATE TABLE `city_pm25`  (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `pm_25` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'PM2.5值',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_pm25
-- ----------------------------
INSERT INTO `city_pm25` VALUES (1, '衡阳', '115', '2019-12-13 16:04:55');
INSERT INTO `city_pm25` VALUES (2, '长沙', '80', '2019-12-13 16:05:41');
INSERT INTO `city_pm25` VALUES (3, '株洲', '120', '2019-12-13 16:06:31');
INSERT INTO `city_pm25` VALUES (4, '岳阳', '90', '2019-12-13 16:09:52');
INSERT INTO `city_pm25` VALUES (5, '郴州', '40', '2019-12-13 16:10:20');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色(admain,user两种)',
  `role_describe` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `role_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称(描述性)',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', '管理员', '2019-12-23 09:45:54', '小北', '2019-12-24 10:26:46');
INSERT INTO `role` VALUES (2, 'user', '普通用户', '2019-12-23 09:46:07', '鸣人', '2019-12-24 10:26:56');
INSERT INTO `role` VALUES (3, 'admin', '管理员1', '2019-12-24 13:26:33', '小南', '2019-12-24 13:26:52');
INSERT INTO `role` VALUES (4, 'user', '普通用户2', '2019-12-24 13:27:29', '小英', NULL);
INSERT INTO `role` VALUES (5, 'user', '普通用户3', '2019-12-24 13:28:03', '小智', NULL);
INSERT INTO `role` VALUES (7, 'user', '普通用户张', '2019-12-24 16:10:03', '张无忌', NULL);
INSERT INTO `role` VALUES (8, 'admin', '管理员，强哥', '2019-12-24 16:18:56', '强哥', NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `role` int(12) NULL DEFAULT NULL COMMENT '用户角色，role关联字段',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'yuhanyi', '123', 1, '2019-12-11 09:37:56', NULL);
INSERT INTO `user` VALUES (2, '托尼', '123', 2, '2019-12-23 09:47:03', NULL);
INSERT INTO `user` VALUES (3, 'yhy', '123', 5, '2019-12-23 14:52:45', '2019-12-24 14:38:11');
INSERT INTO `user` VALUES (4, '皮卡丘', '123', 2, '2019-12-23 14:56:48', NULL);

SET FOREIGN_KEY_CHECKS = 1;
