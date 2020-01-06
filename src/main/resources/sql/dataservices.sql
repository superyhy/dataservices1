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

 Date: 06/01/2020 16:05:36
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
  `month` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '2019年月份',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of air_quality
-- ----------------------------
INSERT INTO `air_quality` VALUES (1, '株洲', '23', '23', '21', '23', '2019-12-19 16:10:10', '2019-12-19 16:15:58', '34', NULL);
INSERT INTO `air_quality` VALUES (2, '北京', '23', '23', '7', '45', '2019-12-16 11:00:30', NULL, '30', NULL);
INSERT INTO `air_quality` VALUES (3, '南京', '34', '23', '8', '46', '2019-12-16 11:00:53', NULL, '42', NULL);
INSERT INTO `air_quality` VALUES (4, '长沙', '32', '23', '8', '46', '2019-12-16 11:01:13', NULL, '45', NULL);
INSERT INTO `air_quality` VALUES (5, '衡阳', '23', '34', '7', '56', '2019-12-16 11:01:34', NULL, '45', NULL);
INSERT INTO `air_quality` VALUES (6, '广州', '21', '34', '8', '57', '2019-12-16 11:02:03', NULL, '43', NULL);
INSERT INTO `air_quality` VALUES (7, '广州', '34', '34', '8', '25', '2019-12-17 13:55:04', NULL, '34', NULL);
INSERT INTO `air_quality` VALUES (8, '长沙·', '23', '23', '7', '23', '2019-12-17 10:07:01', '2019-12-17 10:07:19', '34', NULL);
INSERT INTO `air_quality` VALUES (9, '长沙', '24', '35', '8', '34', '2019-12-15 10:07:47', '2019-12-17 15:33:43', '42', NULL);
INSERT INTO `air_quality` VALUES (10, '长沙', '24', '34', '8', '24', '2019-12-16 10:08:07', '2019-12-17 15:33:48', '34', NULL);
INSERT INTO `air_quality` VALUES (18, '长沙', '23', '24', '32', '31', '2019-12-18 10:10:59', NULL, '21', NULL);
INSERT INTO `air_quality` VALUES (23, '衡阳', '23', '21', '24', '23', '2019-12-18 11:03:33', NULL, '34', NULL);
INSERT INTO `air_quality` VALUES (24, '郴州', '21', '23', '23', '21', '2019-12-18 11:05:16', NULL, '23', NULL);
INSERT INTO `air_quality` VALUES (25, '株洲', '24', '23', '24', '21', '2019-12-18 11:07:48', '2019-12-19 17:35:50', '21', NULL);
INSERT INTO `air_quality` VALUES (32, '长沙', '23', '23', '23', '23', '2019-12-19 14:32:47', '2019-12-19 15:14:18', '50', NULL);

-- ----------------------------
-- Table structure for city_air_quality
-- ----------------------------
DROP TABLE IF EXISTS `city_air_quality`;
CREATE TABLE `city_air_quality`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `month` int(20) NULL DEFAULT NULL COMMENT '2019年月份',
  `aqi` int(20) NULL DEFAULT NULL COMMENT '空气质量指数',
  `pm25` int(30) NULL DEFAULT NULL COMMENT '细颗粒物PM2.5指数',
  `pm10` int(255) NULL DEFAULT NULL COMMENT 'PM10指数',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city_air_quality
-- ----------------------------
INSERT INTO `city_air_quality` VALUES (1, '长沙', 1, 130, 98, 60, '2020-01-02 16:09:51', '2020-01-02 16:40:33');
INSERT INTO `city_air_quality` VALUES (2, '长沙', 2, 73, 53, 51, '2020-01-02 16:10:31', '2020-01-02 16:40:34');
INSERT INTO `city_air_quality` VALUES (3, '长沙', 3, 68, 48, 64, '2020-01-02 16:11:03', '2020-01-02 16:40:35');
INSERT INTO `city_air_quality` VALUES (4, '长沙', 4, 63, 38, 50, '2020-01-02 16:11:48', '2020-01-02 16:40:36');
INSERT INTO `city_air_quality` VALUES (5, '长沙', 5, 74, 36, 63, '2020-01-02 16:12:24', '2020-01-02 16:40:38');
INSERT INTO `city_air_quality` VALUES (6, '长沙', 6, 65, 23, 37, '2020-01-02 16:14:28', '2020-01-02 16:40:39');
INSERT INTO `city_air_quality` VALUES (7, '长沙', 7, 65, 21, 36, '2020-01-02 16:15:17', '2020-01-02 16:40:41');
INSERT INTO `city_air_quality` VALUES (8, '长沙', 8, 89, 28, 50, '2020-01-02 16:19:44', '2020-01-02 16:40:43');
INSERT INTO `city_air_quality` VALUES (9, '长沙', 9, 108, 39, 66, '2020-01-02 16:21:03', '2020-01-02 16:40:44');
INSERT INTO `city_air_quality` VALUES (10, '长沙', 10, 76, 44, 62, '2020-01-02 16:21:52', '2020-01-02 16:40:47');
INSERT INTO `city_air_quality` VALUES (11, '长沙', 11, 86, 60, 76, '2020-01-02 16:22:32', '2020-01-02 16:40:48');
INSERT INTO `city_air_quality` VALUES (13, '株洲', 1, 131, 98, 120, '2020-01-02 16:30:16', '2020-01-02 16:42:02');
INSERT INTO `city_air_quality` VALUES (14, '株洲', 2, 70, 51, 61, '2020-01-02 16:31:07', '2020-01-02 16:43:24');
INSERT INTO `city_air_quality` VALUES (15, '株洲', 3, 70, 50, 72, '2020-01-02 16:31:27', '2020-01-02 16:44:17');
INSERT INTO `city_air_quality` VALUES (16, '长沙', 12, 104, 78, 75, '2020-01-02 16:42:35', NULL);
INSERT INTO `city_air_quality` VALUES (17, '株洲', 4, 62, 41, 54, '2020-01-02 16:44:45', NULL);
INSERT INTO `city_air_quality` VALUES (18, '株洲', 5, 66, 36, 64, '2020-01-02 16:45:07', NULL);
INSERT INTO `city_air_quality` VALUES (19, '株洲', 6, 55, 24, 36, '2020-01-02 16:45:27', '2020-01-02 16:45:47');
INSERT INTO `city_air_quality` VALUES (20, '株洲', 7, 56, 22, 31, '2020-01-02 16:46:17', NULL);
INSERT INTO `city_air_quality` VALUES (21, '株洲', 8, 82, 27, 46, '2020-01-02 16:46:40', NULL);
INSERT INTO `city_air_quality` VALUES (22, '株洲', 9, 106, 40, 67, '2020-01-02 16:47:08', NULL);
INSERT INTO `city_air_quality` VALUES (23, '株洲', 10, 74, 46, 72, '2020-01-02 16:47:36', NULL);
INSERT INTO `city_air_quality` VALUES (24, '株洲', 11, 81, 55, 86, '2020-01-02 16:48:02', NULL);
INSERT INTO `city_air_quality` VALUES (25, '株洲', 12, 107, 80, 99, '2020-01-02 16:48:29', NULL);
INSERT INTO `city_air_quality` VALUES (26, '衡阳', 1, 114, 85, 100, '2020-01-06 13:53:47', NULL);
INSERT INTO `city_air_quality` VALUES (27, '衡阳', 2, 60, 42, 52, '2020-01-06 13:54:21', NULL);
INSERT INTO `city_air_quality` VALUES (28, '衡阳', 3, 60, 40, 60, '2020-01-06 13:55:03', NULL);
INSERT INTO `city_air_quality` VALUES (29, '衡阳', 4, 48, 26, 45, '2020-01-06 13:55:43', NULL);
INSERT INTO `city_air_quality` VALUES (30, '衡阳', 5, 61, 34, 64, '2020-01-06 13:56:07', NULL);
INSERT INTO `city_air_quality` VALUES (31, '衡阳', 6, 56, 23, 43, '2020-01-06 13:56:30', NULL);
INSERT INTO `city_air_quality` VALUES (32, '衡阳', 7, 48, 19, 37, '2020-01-06 13:57:21', NULL);
INSERT INTO `city_air_quality` VALUES (33, '衡阳', 8, 75, 28, 54, '2020-01-06 13:57:55', NULL);
INSERT INTO `city_air_quality` VALUES (34, '衡阳', 9, 96, 38, 69, '2020-01-06 13:58:36', NULL);
INSERT INTO `city_air_quality` VALUES (35, '衡阳', 10, 70, 43, 74, '2020-01-06 13:58:58', NULL);
INSERT INTO `city_air_quality` VALUES (36, '衡阳', 11, 76, 51, 91, '2020-01-06 13:59:19', NULL);
INSERT INTO `city_air_quality` VALUES (37, '衡阳', 12, 96, 71, 92, '2020-01-06 13:59:54', NULL);
INSERT INTO `city_air_quality` VALUES (38, '岳阳', 1, 107, 80, 107, '2020-01-06 14:01:42', '2020-01-06 14:01:56');
INSERT INTO `city_air_quality` VALUES (39, '岳阳', 2, 73, 54, 67, '2020-01-06 14:02:22', NULL);
INSERT INTO `city_air_quality` VALUES (40, '岳阳', 3, 61, 38, 67, '2020-01-06 14:02:53', NULL);
INSERT INTO `city_air_quality` VALUES (41, '岳阳', 4, 63, 36, 59, '2020-01-06 14:03:12', '2020-01-06 14:03:22');
INSERT INTO `city_air_quality` VALUES (42, '岳阳', 5, 76, 38, 74, '2020-01-06 14:04:23', NULL);
INSERT INTO `city_air_quality` VALUES (43, '岳阳', 6, 77, 27, 41, '2020-01-06 14:04:44', NULL);
INSERT INTO `city_air_quality` VALUES (44, '岳阳', 7, 71, 26, 40, '2020-01-06 14:05:14', NULL);
INSERT INTO `city_air_quality` VALUES (45, '岳阳', 8, 85, 32, 50, '2020-01-06 14:05:42', NULL);
INSERT INTO `city_air_quality` VALUES (46, '岳阳', 9, 99, 40, 67, '2020-01-06 14:06:25', NULL);
INSERT INTO `city_air_quality` VALUES (47, '岳阳', 10, 66, 39, 66, '2020-01-06 14:06:57', NULL);
INSERT INTO `city_air_quality` VALUES (48, '岳阳', 11, 74, 50, 86, '2020-01-06 14:07:22', NULL);
INSERT INTO `city_air_quality` VALUES (49, '岳阳', 12, 86, 63, 92, '2020-01-06 14:07:41', NULL);
INSERT INTO `city_air_quality` VALUES (50, '郴州', 1, 75, 52, 77, '2020-01-06 14:10:37', NULL);
INSERT INTO `city_air_quality` VALUES (51, '郴州', 2, 42, 26, 41, '2020-01-06 14:10:37', NULL);
INSERT INTO `city_air_quality` VALUES (52, '郴州', 3, 49, 31, 51, '2020-01-06 14:12:38', NULL);
INSERT INTO `city_air_quality` VALUES (53, '郴州', 4, 45, 19, 39, '2020-01-06 14:12:57', NULL);
INSERT INTO `city_air_quality` VALUES (54, '郴州', 5, 54, 28, 56, '2020-01-06 14:13:19', NULL);
INSERT INTO `city_air_quality` VALUES (55, '郴州', 6, 46, 16, 38, '2020-01-06 14:13:38', NULL);
INSERT INTO `city_air_quality` VALUES (56, '郴州', 7, 43, 15, 34, '2020-01-06 14:13:59', NULL);
INSERT INTO `city_air_quality` VALUES (57, '郴州', 8, 66, 22, 44, '2020-01-06 14:14:10', '2020-01-06 14:14:23');
INSERT INTO `city_air_quality` VALUES (58, '郴州', 9, 87, 34, 63, '2020-01-06 14:14:46', NULL);
INSERT INTO `city_air_quality` VALUES (59, '郴州', 10, 63, 35, 52, '2020-01-06 14:15:02', NULL);
INSERT INTO `city_air_quality` VALUES (60, '郴州', 11, 67, 42, 67, '2020-01-06 14:15:19', NULL);
INSERT INTO `city_air_quality` VALUES (61, '郴州', 12, 65, 45, 63, '2020-01-06 14:15:35', NULL);

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
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idIndex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', '管理员', '2019-12-23 09:45:54', '小北', '2019-12-24 10:26:46');
INSERT INTO `role` VALUES (2, 'user', '普通用户', '2019-12-23 09:46:07', '鸣人', '2019-12-24 10:26:56');
INSERT INTO `role` VALUES (3, 'admin', '管理员1', '2019-12-24 13:26:33', '小南', '2019-12-24 13:26:52');
INSERT INTO `role` VALUES (4, 'user', '普通用户2', '2019-12-24 13:27:29', '小英', NULL);
INSERT INTO `role` VALUES (5, 'user', '普通用户3', '2019-12-24 13:28:03', '小智', NULL);
INSERT INTO `role` VALUES (7, 'user', '普通用户张无忌', '2019-12-24 16:10:03', '张无忌', '2019-12-26 14:30:02');
INSERT INTO `role` VALUES (8, 'admin', '管理员，强哥1', '2019-12-24 16:18:56', '强哥1', '2019-12-27 14:33:16');

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
  `is_able` int(10) NULL DEFAULT NULL COMMENT '是否可用(0: 禁用，1：可用）',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `roleIndex`(`role`) USING BTREE COMMENT '关联字段索引'
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'yuhanyi', '123', 1, '2019-12-11 09:37:56', '2019-12-31 11:04:22', 1);
INSERT INTO `user` VALUES (2, '托尼', '123', 5, '2019-12-23 09:47:03', '2019-12-31 11:04:23', 1);
INSERT INTO `user` VALUES (3, 'yhy', '123', 3, '2019-12-23 14:52:45', '2019-12-31 11:04:24', 1);
INSERT INTO `user` VALUES (4, '皮卡丘', 'abc', 5, '2019-12-23 14:56:48', '2020-01-02 10:23:46', 1);
INSERT INTO `user` VALUES (5, '你难拿', '234', 3, '2019-12-31 11:08:27', '2019-12-31 11:11:03', 0);
INSERT INTO `user` VALUES (13, '南华', '123', 2, '2020-01-02 13:49:59', '2020-01-02 13:56:37', 1);

SET FOREIGN_KEY_CHECKS = 1;
