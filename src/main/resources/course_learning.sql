/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : course_learning

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 05/01/2020 21:30:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登陆名称',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1172709569248497664', 'yh', '$2a$10$iTiXgK8D5VgnuJ2BcXtWq.aS/FWGjzLcku9bgchnNm53HNnWIs0Fi', '1');

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '城市名称',
  `ishot` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否热门',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '城市' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', '北京', '1');
INSERT INTO `city` VALUES ('2', '上海', '1');
INSERT INTO `city` VALUES ('3', '广州', '1');
INSERT INTO `city` VALUES ('4', '深圳', '1');
INSERT INTO `city` VALUES ('5', '天津', '0');
INSERT INTO `city` VALUES ('6', '重庆', '0');
INSERT INTO `city` VALUES ('7', '西安', '0');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `summary` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `catalog` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目录',
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父节点',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', 'C语言', '二级C语言', '很多的目录', '21', '2019-09-18 16:16:22', '2019-09-18 16:16:25');
INSERT INTO `course` VALUES ('10', 'Office学习', '二级office学习', '这是目录', '22', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('11', '三级数据库设计', '三级数据库设计简介', '这是目录', '23', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('12', '三级网络', '三级网络简介', '这是目录', '24', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('13', '三级信息安全', '三级信息安全简介', '这是目录', '25', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('14', '四级网络工程师', '四级网络工程师简介', '这是目录', '26', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('15', '四级数据库工程师', '四级数据库工程师简介', '这是目录', '27', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('16', '四级信息安全工程师', '四级信息安全工程师简介', '这是目录', '28', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('17', 'HTML设计', 'HTML设计简介', '这是目录', '31', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('18', 'JavaScript设计', 'JavaScript设计简介', '这是目录', '32', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('19', 'CSS设计', 'CSS设计简介', '这是目录', '33', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('2', 'Node.js设计', 'Node.js设计简介', '这是目录', '34', '2019-09-18 16:49:59', '2019-09-18 16:50:01');
INSERT INTO `course` VALUES ('20', 'C语言', '二级C语言', '很多的目录', '21', '2019-09-18 16:16:22', '2019-09-18 16:16:25');
INSERT INTO `course` VALUES ('21', 'C语言', '二级C语言', '很多的目录', '21', '2019-09-18 16:16:22', '2019-09-18 16:16:25');
INSERT INTO `course` VALUES ('22', 'C语言', '二级C语言', '很多的目录', '21', '2019-09-18 16:16:22', '2019-09-18 16:16:25');
INSERT INTO `course` VALUES ('23', 'C语言', '二级C语言', '很多的目录', '21', '2019-09-18 16:16:22', '2019-09-18 16:16:25');
INSERT INTO `course` VALUES ('3', 'Vue.js设计', 'Vue.js设计简介', '这是目录', '35', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('4', 'C语言程序设计', 'C语言程序设计简介', '这是目录', '41', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('5', 'C++语言程序设计', 'C++语言程序设计简介', '这是目录', '42', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('6', 'JAVA语言程序设计', 'JAVA语言程序设计简介', '这是目录', '43', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('7', '数据结构设计', '数据结构简介', '这是目录', '51', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('71', '微机原理与接口技术', '微机原理与接口技术简介', '这是目录', '71', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('8', '算法分析与实现', '算法分析与实现简介', '这是目录', '52', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('9', '数据库基础设计', '数据库基础设计简介', '这是目录', '61', '2019-09-26 15:21:11', '2019-09-26 15:21:14');

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `targetuser` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '被关注用户ID',
  PRIMARY KEY (`userid`, `targetuser`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES ('1', '1');
INSERT INTO `follow` VALUES ('1', '10');

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标签ID',
  `label_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称',
  `state` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `count` bigint(20) NULL DEFAULT NULL COMMENT '使用数量',
  `recommend` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否推荐',
  `fans` bigint(20) NULL DEFAULT NULL COMMENT '粉丝数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of label
-- ----------------------------
INSERT INTO `label` VALUES ('1', 'java', '1', NULL, NULL, NULL);
INSERT INTO `label` VALUES ('1176770382598901760', NULL, '1', NULL, NULL, NULL);
INSERT INTO `label` VALUES ('2', 'PHP', '1', NULL, NULL, NULL);
INSERT INTO `label` VALUES ('3', 'C++', '1', NULL, NULL, NULL);
INSERT INTO `label` VALUES ('4', 'python', '1', NULL, NULL, NULL);
INSERT INTO `label` VALUES ('5', 'ios++', '1', NULL, NULL, NULL);
INSERT INTO `label` VALUES ('6', 'ios6', '1', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for courseResource
-- ----------------------------
DROP TABLE IF EXISTS `courseResource`;
CREATE TABLE `courseResource`  (
  `id` varbinary(20) NOT NULL COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `summary` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `creationtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for courseClassification
-- ----------------------------
DROP TABLE IF EXISTS `courseClassification`;
CREATE TABLE `courseClassification`  (
  `id` int(20) NOT NULL COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `parent_id` int(20) NULL DEFAULT NULL COMMENT '父节点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseClassification
-- ----------------------------
INSERT INTO `courseClassification` VALUES (1, '计算机等级考试', NULL);
INSERT INTO `courseClassification` VALUES (2, '前端语言程序设计', NULL);
INSERT INTO `courseClassification` VALUES (3, '后端语言程序设计', NULL);
INSERT INTO `courseClassification` VALUES (4, '数据结构与算法分析', NULL);
INSERT INTO `courseClassification` VALUES (5, '数据库设计', NULL);
INSERT INTO `courseClassification` VALUES (6, '微机原理与接口技术', NULL);
INSERT INTO `courseClassification` VALUES (21, '二级C语言', 1);
INSERT INTO `courseClassification` VALUES (22, '二级Office', 1);
INSERT INTO `courseClassification` VALUES (23, '三级数据库', 1);
INSERT INTO `courseClassification` VALUES (24, '三级网络', 1);
INSERT INTO `courseClassification` VALUES (25, '三级信息安全', 1);
INSERT INTO `courseClassification` VALUES (26, '四级网络工程师', 1);
INSERT INTO `courseClassification` VALUES (27, '四级数据库工程师', 1);
INSERT INTO `courseClassification` VALUES (28, '四级信息安全工程师', 1);
INSERT INTO `courseClassification` VALUES (31, 'HTML', 2);
INSERT INTO `courseClassification` VALUES (32, 'JavaScript', 2);
INSERT INTO `courseClassification` VALUES (33, 'CSS', 2);
INSERT INTO `courseClassification` VALUES (34, 'Node.js', 2);
INSERT INTO `courseClassification` VALUES (35, 'Vue.js', 2);
INSERT INTO `courseClassification` VALUES (41, 'C语言程序设计', 3);
INSERT INTO `courseClassification` VALUES (42, 'C++语言程序设计', 3);
INSERT INTO `courseClassification` VALUES (43, 'JAVA语言程序设计', 3);
INSERT INTO `courseClassification` VALUES (51, '数据结构', 4);
INSERT INTO `courseClassification` VALUES (52, '算法分析与实现', 4);
INSERT INTO `courseClassification` VALUES (61, '数据库基础', 5);
INSERT INTO `courseClassification` VALUES (71, '微机原理与接口技术', 6);

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `summary` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `creationtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updatetime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for ul
-- ----------------------------
DROP TABLE IF EXISTS `ul`;
CREATE TABLE `ul`  (
  `userid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `labelid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userid`, `labelid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ul
-- ----------------------------
INSERT INTO `ul` VALUES ('1', '1');
INSERT INTO `ul` VALUES ('1', '2');
INSERT INTO `ul` VALUES ('1', '3');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `nickname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` datetime(0) NULL DEFAULT NULL COMMENT '出生年月日',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'E-Mail',
  `reg_date` datetime(0) NULL DEFAULT NULL COMMENT '注册日期',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '修改日期',
  `last_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登陆日期',
  `online` bigint(20) NULL DEFAULT NULL COMMENT '在线时长（分钟）',
  `interest` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '兴趣',
  `personality` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性',
  `fans_count` int(20) NULL DEFAULT NULL COMMENT '粉丝数',
  `follow_count` int(20) NULL DEFAULT NULL COMMENT '关注数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1173422474768027648', 'yh', '18608212510', '$2a$10$H/f/AC.hGflPHFpWIEkUXepcHUnTgpEptd7WgmphYN3Lh58gQIV.6', '1', '小袁', '1', NULL, NULL, NULL, '2019-09-16 10:24:54', '2019-09-16 10:24:54', '2019-09-16 10:24:54', 0, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES ('1173436466529964032', 'yh1', NULL, '$2a$10$/L5.1UlABNKRW/pRst8fnORBYKqtbKvYXwC/HFG0TnXMfLbfYK1Wu', '1', NULL, NULL, NULL, NULL, NULL, '2019-09-16 11:20:30', '2019-09-16 11:20:30', '2019-09-16 11:20:30', 0, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES ('1173601195294593024', 'yh2', NULL, '$2a$10$EKyGB8fF2TXrYy3kBhI50OAoJrsG./cYgCPyy.z6/mFmU9MeUVQ2y', '1', NULL, NULL, NULL, NULL, NULL, '2019-09-16 22:15:04', '2019-09-16 22:15:04', '2019-09-16 22:15:04', 0, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES ('1173604458760900608', 'yh3', NULL, '$2a$10$kfP22jswGNypw/gqXxIxxuMzfk9DKX8LBz9txHAvs3w.KAf2tSzWC', '1', NULL, NULL, NULL, NULL, NULL, '2019-09-16 22:28:02', '2019-09-16 22:28:02', '2019-09-16 22:28:02', 0, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES ('1173823255853797376', 'js', NULL, '$2a$10$6L51SmXKyRaSPAUoxZQpgOgUb9euyuJodqlP7frENQVSgtz7OBrMi', '待审核', NULL, NULL, NULL, NULL, NULL, '2019-09-17 12:57:28', '2019-09-17 12:57:28', '2019-09-17 12:57:28', 0, NULL, NULL, 0, 0);

SET FOREIGN_KEY_CHECKS = 1;
