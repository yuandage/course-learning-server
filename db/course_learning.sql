/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : course_learning

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 29/03/2020 11:15:45
*/

DROP DATABASE IF EXISTS `course_learning`;

CREATE DATABASE  `course_learning` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

USE `course_learning`;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `summary` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父节点',
  `popular` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热门课程',
  `cover_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程封面',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建日期',
  `update_date` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '微机原理与接口技术', '微机原理与接口技术简介', '这是目录', '71', '1', 'https://img2.sycdn.imooc.com/szimg/5dce41e70819b56b06000338-360-202.jpg', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('10', 'Office学习', '二级office学习', '这是目录', '22', NULL, 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('11', '三级数据库设计', '三级数据库设计简介', '这是目录', '23', NULL, 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('12', '三级网络', '三级网络简介', '这是目录', '24', NULL, 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('13', '三级信息安全', '三级信息安全简介', '这是目录', '25', NULL, 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('14', '四级网络工程师', '四级网络工程师简介', '这是目录', '26', NULL, 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('15', '四级数据库工程师', '四级数据库工程师简介', '这是目录', '27', NULL, 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('16', '四级信息安全工程师', '四级信息安全工程师简介', '这是目录', '28', NULL, 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('17', '初识HTML+CSS', 'HTML+CSS基础教程8小时带领大家步步深入学习标签用法和意义', '本课程从最基本的概念开始讲起，步步深入，带领大家学习HTML、CSS样式基础知识，了解各种常用标签的意义以及基本用法，后半部分教程主要讲解CSS样式代码添加，为后面的案例课程打下基础。', '31', '1', 'https://img2.sycdn.imooc.com/szimg/5c18d2d8000141c506000338-360-202.jpg', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('18', 'JavaScript设计', 'JavaScript设计简介', '这是目录', '32', NULL, 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('2', 'Node.js设计', 'Node.js设计简介', '这是目录', '34', NULL, 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-18 16:49:59', '2019-09-18 16:50:01');
INSERT INTO `course` VALUES ('20', 'C语言', '二级C语言', '很多的目录', '21', NULL, 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-18 16:16:22', '2019-09-18 16:16:25');
INSERT INTO `course` VALUES ('3', 'Vue.js设计', 'Vue.js设计简介', '这是目录', '35', '1', 'https://img4.sycdn.imooc.com/szimg/5dc9047a09bae31e12000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('4', 'C语言程序设计', 'C语言程序设计简介', '这是目录', '41', '1', 'https://img3.sycdn.imooc.com/szimg/5d25400a08fa408c06000338-360-202.jpg', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('5', 'C++语言程序设计', 'C++语言程序设计简介', '这是目录', '42', '1', 'https://img3.sycdn.imooc.com/szimg/5dde5881088dd8da06000338-360-202.jpg', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('6', 'Java入门第一季', '本教程从Java环境搭建、工具使用、基础语法开始，带你入门', '本教程为Java入门第一季，欢迎来到精彩的Java编程世界！Java语言已经成为当前软件开发行业中主流的开发语言。本教程将介绍Java环境搭建、工具使用、基础语法。带领大家一步一步的踏入Java达人殿堂！Let’s go!', '43', '1', 'https://img1.sycdn.imooc.com/szimg/5df1deec09ba554712000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('7', '数据结构设计', '数据结构简介', '这是目录', '51', '1', 'https://img1.sycdn.imooc.com/szimg/5ad05dc00001eae705400300-360-202.jpg', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('8', '算法分析与实现', '算法分析与实现简介', '这是目录', '52', '1', 'https://img3.sycdn.imooc.com/szimg/5a39cd3f0001c09805400300-360-202.jpg', '2019-09-26 15:21:11', '2019-09-26 15:21:14');
INSERT INTO `course` VALUES ('9', '数据库基础设计', '数据库基础设计简介', '这是目录', '61', '', 'https://img1.mukewang.com/szimg/5e26a9f909ef95b512000676-360-202.png', '2019-09-26 15:21:11', '2019-09-26 15:21:14');

-- ----------------------------
-- Table structure for course_category
-- ----------------------------
DROP TABLE IF EXISTS `course_category`;
CREATE TABLE `course_category`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父节点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_category
-- ----------------------------
INSERT INTO `course_category` VALUES ('1', '计算机等级考试', '0');
INSERT INTO `course_category` VALUES ('2', '前端语言程序设计', '0');
INSERT INTO `course_category` VALUES ('21', '二级C语言', '1');
INSERT INTO `course_category` VALUES ('22', '二级Office', '1');
INSERT INTO `course_category` VALUES ('23', '三级数据库', '1');
INSERT INTO `course_category` VALUES ('24', '三级网络', '1');
INSERT INTO `course_category` VALUES ('25', '三级信息安全', '1');
INSERT INTO `course_category` VALUES ('26', '四级网络工程师', '1');
INSERT INTO `course_category` VALUES ('27', '四级数据库工程师', '1');
INSERT INTO `course_category` VALUES ('28', '四级信息安全工程师', '1');
INSERT INTO `course_category` VALUES ('3', '后端语言程序设计', '0');
INSERT INTO `course_category` VALUES ('31', 'HTML/CSS', '2');
INSERT INTO `course_category` VALUES ('32', 'JavaScript', '2');
INSERT INTO `course_category` VALUES ('34', 'Node.js', '2');
INSERT INTO `course_category` VALUES ('35', 'Vue.js', '2');
INSERT INTO `course_category` VALUES ('4', '数据结构与算法分析', '0');
INSERT INTO `course_category` VALUES ('41', 'C语言程序设计', '3');
INSERT INTO `course_category` VALUES ('42', 'C++语言程序设计', '3');
INSERT INTO `course_category` VALUES ('43', 'JAVA语言程序设计', '3');
INSERT INTO `course_category` VALUES ('5', '数据库设计', '0');
INSERT INTO `course_category` VALUES ('51', '数据结构', '4');
INSERT INTO `course_category` VALUES ('52', '算法分析与实现', '4');
INSERT INTO `course_category` VALUES ('6', '计算机基础', '0');
INSERT INTO `course_category` VALUES ('61', '数据库基础', '5');
INSERT INTO `course_category` VALUES ('71', '微机原理与接口技术', '6');

-- ----------------------------
-- Table structure for course_chapter
-- ----------------------------
DROP TABLE IF EXISTS `course_chapter`;
CREATE TABLE `course_chapter`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `course_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属课程id',
  `parent_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父章节id(只有2级)',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章节标题',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章节描述',
  `time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时长',
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频链接',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程章节' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_chapter
-- ----------------------------
INSERT INTO `course_chapter` VALUES ('1', '6', '0', '第1章 Java初体验', '本章节主要讲解 Java 目前的应用、如何搭建 Java 开发环境、以及如何使用工具进行 Java 程序的开发，为以后的学习打下基础', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('11', '6', '1', '1-1 Java简介', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('12', '6', '1', '1-2 Java开发环境搭建', NULL, '07:30', 'https://www.imooc.com/video/1459', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('13', '6', '1', '1-3 使用Eclipse开发Java程序', NULL, '08:59', 'https://www.imooc.com/video/1412', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('2', '6', '0', '第2章 变量和常量', '本章节主要讲解如何在 Java 程序中应用变量和常量进行数据操作、数据类型分类及基本数据类型间的类型转换，帮助你对 Java 语言建立初步认识', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('21', '6', '2', '2-1 Java中的关键字', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('22', '6', '2', '2-2 认识Java标识符', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('23', '6', '2', '2-3 Java中的数据类型', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('24', '6', '2', '2-4 Java中变量的使用规则', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('25', '6', '2', '2-5 Java中的自动类型转换', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('26', '6', '2', '2-6 Java中的强制类型转换', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('27', '6', '2', '2-7 Java常量的应用', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('28', '6', '2', '2-8 如何在Java中使用注释', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('3', '1', '0', '第1章 Java初体验', '本章节主要讲解 Java 目前的应用、如何搭建 Java 开发环境、以及如何使用工具进行 Java 程序的开发，为以后的学习打下基础', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('31', '1', '3', '1-1 Java简介', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('32', '1', '3', '1-2 Java开发环境搭建', NULL, '07:30', 'https://www.imooc.com/video/1459', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('33', '1', '3', '1-3 使用Eclipse开发Java程序', NULL, '08:59', 'https://www.imooc.com/video/1412', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('4', '1', '0', '第2章 变量和常量', '本章节主要讲解如何在 Java 程序中应用变量和常量进行数据操作、数据类型分类及基本数据类型间的类型转换，帮助你对 Java 语言建立初步认识', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('41', '1', '4', '2-1 Java中的关键字', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('42', '1', '4', '2-2 认识Java标识符', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('43', '1', '4', '2-3 Java中的数据类型', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('44', '1', '4', '2-4 Java中变量的使用规则', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('45', '1', '4', '2-5 Java中的自动类型转换', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('46', '1', '4', '2-6 Java中的强制类型转换', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('47', '1', '4', '2-7 Java常量的应用', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);
INSERT INTO `course_chapter` VALUES ('48', '1', '4', '2-8 如何在Java中使用注释', NULL, '05:49', 'https://www.imooc.com/video/1430', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for course_comment
-- ----------------------------
DROP TABLE IF EXISTS `course_comment`;
CREATE TABLE `course_comment`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `course_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程id',
  `section_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章节id',
  `section_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章节标题',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_comment
-- ----------------------------
INSERT INTO `course_comment` VALUES ('1227783921161342976', NULL, '6', NULL, NULL, '唐小燕', 'if 后面没有 括号，则if 只包含下一行。 那这样这个 compare 函数，就有可能没有返回值。 在 11 行下面，再加一行 return true ; 即可。', NULL, '2020-03-15 09:49:25', NULL, NULL);
INSERT INTO `course_comment` VALUES ('1227784338473619456', NULL, '6', NULL, NULL, '袁大哥', '这门课程感觉好流弊啊', NULL, '2020-03-15 09:49:27', NULL, NULL);
INSERT INTO `course_comment` VALUES ('1227784387597307904', NULL, '6', NULL, NULL, '张超', '告诉大家一个白嫖的好方法，只要你用流量打开视频，注意！千万别点播放，完事点缓存再暂停，接着打开缓存页面用WiFi下载，看完删了就行，不仅不用投币点赞，甚至连播放量都不给[doge][doge][doge][doge]', NULL, '2020-03-15 09:49:30', NULL, NULL);
INSERT INTO `course_comment` VALUES ('1227784456794935296', NULL, '6', NULL, NULL, '杨忠学', '纯路人，第一次下载这个软件，看到首页推荐了这个视频，这就是B站的氛围吗，i了i了。', NULL, '2020-03-15 09:49:32', NULL, NULL);
INSERT INTO `course_comment` VALUES ('1227784934169645056', NULL, '6', NULL, NULL, '吴世龙', '这些片段当时是舞法天女新一季的其中一些片段，但由于被指抄袭和对儿童未来的发展和教育不利，所以被有关部门叫停制作并停止播放，我当时有幸看到过这些片段，如今能在这里看到，爷非常高兴', NULL, '2020-03-15 09:49:34', NULL, NULL);
INSERT INTO `course_comment` VALUES ('1227784995272265728', NULL, '6', NULL, NULL, '谢鑫', '纯路人，以前一直听同学说b站很好，今天第一次下载来看了看，没想到刚一进入就发现了这个up的视频，这个up的视频质量是我从没见过的高。没想到，在当今这个浮躁的社会，竟然还能有人沉下心来做出一个个质量如此高的视频，泪目，白嫖了', NULL, '2020-03-14 22:10:38', NULL, NULL);
INSERT INTO `course_comment` VALUES ('1227848117488062464', NULL, '6', NULL, NULL, '朱兴', '投币啊 投币 这个币要怎么投呢？\n啊先点按钮啊 很简单很好投\n那我们来投一下\n投...啊好...\n哦还没投呢哈哈哈哈哈哈哈', NULL, '2020-03-14 22:10:37', NULL, NULL);
INSERT INTO `course_comment` VALUES ('1235549250037878784', '1234119223710715904', '10', NULL, NULL, 'yh', 'nb?', NULL, '2020-03-14 22:10:32', NULL, NULL);
INSERT INTO `course_comment` VALUES ('1237304999965495296', '1234119223710715901', '1', NULL, NULL, 'admin', '666', NULL, '2020-03-15 09:55:12', NULL, NULL);
INSERT INTO `course_comment` VALUES ('1237304999965495297', NULL, '1', NULL, NULL, '222', '3333', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for course_question
-- ----------------------------
DROP TABLE IF EXISTS `course_question`;
CREATE TABLE `course_question`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `course_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程id',
  `section_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章节id',
  `section_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章节标题',
  `type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目类型',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目内容',
  `option_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目选项',
  `answer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目答案',
  `analysis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目解析',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试题' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_question
-- ----------------------------
INSERT INTO `course_question` VALUES ('1', '1', NULL, NULL, '单选题', '8086CPU 芯片的外部引线中，数据线的条数为？', 'A、6条#B、8条#C、16条#D、20条', '3', '666', NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('10', '1', NULL, NULL, '单选题', 'CPU 对存储器或 I/O 端口完成一次读/写操作所需的时间为一个？', 'A、指令周期#B、总线周期#C、时钟周期#D、机器周期', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('2', '1', NULL, NULL, '单选题', '8088CPU 上 READY 信号为下面哪种信号有效？', 'A、上升沿#B、下降沿#C、高电平#D、低电平', '3', '66666', NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('21', '1', NULL, NULL, '判断题', '软件与硬件的等价性原理说明软硬件在功能、性能和成本等方面是等价的。', 'A、正确#B、错误', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('22', '1', NULL, NULL, '判断题', 'IA-64结构是IA-32结构的64位扩展，也就是Intel 64结构。', 'A、正确#B、错误', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('23', '1', NULL, NULL, '判断题', '8086的数据总线为16位，也就是说8086的数据总线的个数或者说条数、位数是16。', 'A、正确#B、错误', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('24', '1', NULL, NULL, '判断题', '微机主存只要使用RAM芯片就可以了。', 'A、正确#B、错误', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('25', '1', NULL, NULL, '判断题', '处理器并不直接连接外设，而是通过I/O接口电路与外设连接。', 'A、正确#B、错误', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('26', '1', NULL, NULL, '判断题', '处理器是微机的控制中心，内部只包括5大功能部件的控制器。', 'A、正确#B、错误', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('27', '1', NULL, NULL, '判断题', 'Windows的模拟DOS环境与控制台环境是一样的。', 'A、正确#B、错误', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('28', '1', NULL, NULL, '判断题', '16位IBM PC/AT采用ISA系统总线。', 'A、正确#B、错误', '1', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('29', '1', NULL, NULL, '判断题', 'IA-32处理器吸取了RISC技术特长。RISC是指复杂指令集计算机。', 'A、正确#B、错误', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('3', '1', NULL, NULL, '单选题', '8088CPU 中的 CS 寄存器是一个多少位的寄存器？', 'A、8位#B、16位#C、24位#D、32位', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('30', '1', NULL, NULL, '判断题', '处理器进行读操作，就是把数据从处理器内部读出传送给主存或外设。', 'A、正确#B、错误', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('4', '1', NULL, NULL, '单选题', '属于只读存贮器的芯片是？', 'A、SRAM#B、DRAM#C、EPROM#D、SDRAM', '3', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('5', '1', NULL, NULL, '单选题', '内存从 A4000H 到 CBFFFH，共有？', 'A、124K#B、160K#C、180K#D、224K', '2', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('6', '1', NULL, NULL, '单选题', '擦除 EPROM 是用？', 'A、＋5V 电压#B、＋15V 电压#C、＋21V 电压#D、紫外光照射', '4', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('7', '1', NULL, NULL, '单选题', '采用查询方式来实现输入输出是因为它？', 'A、速度最快#B、实现起来比较容易#C、CPU 可以不介入#D、在对多个事件查询工作时，能对突发事件做出实时响应', '3', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('8', '1', NULL, NULL, '单选题', '实 现 DMA传 送 ， 需 要？', 'A、CPU 通过执行指令来完成#B、CPU 利用中断方式来完成#C、CPU 利用查询方式来完成#D、不需要 CPU 参与即可完成', '4', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `course_question` VALUES ('9', '1', NULL, NULL, '单选题', '堆栈指针的作用是用来指示？', 'A、栈底地址#B、栈顶地址#C、下一条要执行指令的地址#D、上一条要执行指令的地址', '2', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for course_question_comment
-- ----------------------------
DROP TABLE IF EXISTS `course_question_comment`;
CREATE TABLE `course_question_comment`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `course_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程id',
  `question_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试题id',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '试题评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_question_comment
-- ----------------------------
INSERT INTO `course_question_comment` VALUES ('1235559357018673152', '1234119223710715904', '1', '1', 'yh', '666', NULL, NULL, NULL, NULL);
INSERT INTO `course_question_comment` VALUES ('1235559357018673153', '1234119223710715904', '1', '1', 'yh', '666', NULL, NULL, NULL, NULL);
INSERT INTO `course_question_comment` VALUES ('1235559357018673154', '1234119223710715904', '1', '1', 'yh', '666', NULL, NULL, NULL, NULL);
INSERT INTO `course_question_comment` VALUES ('1235559436815306752', '1234119223710715904', '1', '1', 'yh', '这么牛逼的吗', NULL, NULL, NULL, NULL);
INSERT INTO `course_question_comment` VALUES ('1235559516536442880', '1234119223710715904', '1', '1', 'yh', '这道题要怎么做?', NULL, NULL, NULL, NULL);
INSERT INTO `course_question_comment` VALUES ('1235571165540519936', '1234119223710715904', '1', '9', 'yh', '这道题怎么做啊?', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for course_resource
-- ----------------------------
DROP TABLE IF EXISTS `course_resource`;
CREATE TABLE `course_resource`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `course_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `summary` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `res_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资料链接',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程资源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_resource
-- ----------------------------
INSERT INTO `course_resource` VALUES ('1234509443093991424', '1', '第01章  接口概述', 'PPT', NULL, NULL, 'http://localhost:9000/resource/download/1234509443093991424', NULL, '2020-03-05 18:16:21', NULL, '2020-03-05 18:16:21');
INSERT INTO `course_resource` VALUES ('1235498042191384576', '1', '第02章  处理器结构', 'PPT', NULL, NULL, 'http://localhost:9000/resource/download/1235498042191384576', NULL, '2020-03-05 17:31:02', NULL, '2020-03-05 17:31:02');
INSERT INTO `course_resource` VALUES ('1235498139981582336', '1', '第05章  微机总线', 'PPT', NULL, NULL, 'http://localhost:9000/resource/download/1235498139981582336', NULL, '2020-03-05 17:31:26', NULL, '2020-03-05 17:31:26');
INSERT INTO `course_resource` VALUES ('1235498247519342592', '1', '第06章  存储系统', 'PPT', NULL, NULL, 'http://localhost:9000/resource/download/1235498247519342592', NULL, '2020-03-05 17:31:51', NULL, '2020-03-05 17:31:51');
INSERT INTO `course_resource` VALUES ('1235498367149281280', '1', '第07章  输入输出接口', 'PPT', NULL, NULL, 'http://localhost:9000/resource/download/1235498367149281280', NULL, '2020-03-05 17:32:20', NULL, '2020-03-05 17:32:20');
INSERT INTO `course_resource` VALUES ('1239548961522585600', '1', '222', '111', '3333', '3-1239548961522585600.png', 'http://localhost:9000/resource/download/1239548961522585600', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for course_video
-- ----------------------------
DROP TABLE IF EXISTS `course_video`;
CREATE TABLE `course_video`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `course_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程id',
  `section_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章节id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `summary` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '简介',
  `time` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频时长',
  `size` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频大小',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `video_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频链接',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程视频' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_video
-- ----------------------------
INSERT INTO `course_video` VALUES ('1241306892081434624', '1', '3', '教学安排', '第1章 Java初体验 -教学安排', NULL, NULL, '微机原理与接口技术_1.0 教学安排-1241306892081434624.mp4', 'http://localhost:9000/resource/download/1241306892081434624', NULL, NULL, NULL, NULL);
INSERT INTO `course_video` VALUES ('1241314308391047168', '1', '31', '发展概况', '1-1 Java简介', NULL, NULL, '微机原理与接口技术_1.1 发展概况-1241314308391047168.mp4', 'http://localhost:9000/resource/download/1241314308391047168', NULL, NULL, NULL, NULL);
INSERT INTO `course_video` VALUES ('1241314434794786816', '1', '32', '硬件结构', '1-2 Java开发环境搭建', NULL, NULL, '微机原理与接口技术_1.2 硬件结构-1241314434794786816.mp4', 'http://localhost:9000/resource/download/1241314434794786816', NULL, NULL, NULL, NULL);
INSERT INTO `course_video` VALUES ('1241314549378977792', '1', '33', '数据表示', '1-3 使用Eclipse开发Java程序', NULL, NULL, '微机原理与接口技术_1.3 数据表示-1241314549378977792.mp4', 'http://localhost:9000/resource/download/1241314549378977792', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'add', '添加', NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('2', 'edit', '编辑', NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('3', 'del', '删除', NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('4', 'upload', '上传', NULL, NULL, NULL, NULL);
INSERT INTO `permission` VALUES ('5', 'download', '下载', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '超级管理员', 'admin', NULL, 'admin', NULL);
INSERT INTO `role` VALUES ('2', 'dev', '开发人员', NULL, NULL, NULL, NULL);
INSERT INTO `role` VALUES ('3', 'test', '测试人员', NULL, NULL, NULL, NULL);
INSERT INTO `role` VALUES ('4', 'teacher', '教师', NULL, NULL, NULL, NULL);
INSERT INTO `role` VALUES ('5', 'student', '学生', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `role_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限id',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('10', '1', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('11', '1', '2', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('12', '1', '3', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('1238360430200623104', '4', '2', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('1238360432830451712', '4', '4', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('1238360435636441088', '4', '5', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('13', '1', '4', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('14', '1', '5', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('20', '2', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('21', '2', '2', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('22', '2', '3', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('23', '2', '4', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('24', '2', '5', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('30', '3', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('31', '3', '2', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('32', '3', '3', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('33', '3', '4', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('34', '3', '5', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('40', '4', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('41', '4', '3', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('50', '5', '1', NULL, NULL, NULL, NULL);
INSERT INTO `role_permission` VALUES ('51', '5', '3', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `mobile` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `nickname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
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
INSERT INTO `user` VALUES ('1234119223710715901', 'admin', '$2a$10$ogqzDygYCQ72KhHw5lblpubKVenDHR8e6wbZDa7/lX/tSmRSajOd.', '18608212510', '超管', '男', NULL, NULL, '1027928543@qq.com', '2020-03-06 11:10:40', '2020-03-06 11:10:40', '2020-03-06 11:10:40', 0, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES ('1234119223710715902', 'dev', '$2a$10$ogqzDygYCQ72KhHw5lblpubKVenDHR8e6wbZDa7/lX/tSmRSajOd.', '18608212510', '开发人员', '男', NULL, NULL, '1027928543@qq.com', '2020-03-01 22:12:07', '2020-03-01 22:12:07', '2020-03-01 22:12:07', 0, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES ('1234119223710715903', 'test', '$2a$10$ogqzDygYCQ72KhHw5lblpubKVenDHR8e6wbZDa7/lX/tSmRSajOd.', '18608212510', '测试', NULL, NULL, NULL, '1027928543@qq.com', '2020-03-07 17:44:21', '2020-03-07 17:44:21', '2020-03-07 17:44:21', 0, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES ('1234119223710715904', 'teacher', '$2a$10$ogqzDygYCQ72KhHw5lblpubKVenDHR8e6wbZDa7/lX/tSmRSajOd.', '18608212510', '教师', '男', NULL, NULL, '1027928543@qq.com', '2020-03-01 22:12:07', '2020-03-01 22:12:07', '2020-03-01 22:12:07', 0, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES ('1234119223710715905', 'student', '$2a$10$ogqzDygYCQ72KhHw5lblpubKVenDHR8e6wbZDa7/lX/tSmRSajOd.', '18608212510', '学生', '男', NULL, NULL, '1027928543@qq.com', '2020-03-01 22:12:07', '2020-03-01 22:12:07', '2020-03-01 22:12:07', 0, NULL, NULL, 0, 0);
INSERT INTO `user` VALUES ('1237767310413008896', 'wcndy', '$2a$10$lm1OcRGu76rQCSr1I6X2Peh3W5nDdz5VGm1oLhj9VkWtP5iYabbOK', '17738285197', '我问候你大爷', NULL, NULL, NULL, '1027928543@qq.com', '2020-03-11 23:48:18', '2020-03-11 23:48:18', '2020-03-11 23:48:18', 0, NULL, NULL, 0, 0);

-- ----------------------------
-- Table structure for user_course
-- ----------------------------
DROP TABLE IF EXISTS `user_course`;
CREATE TABLE `user_course`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `course_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程id',
  `section_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章节id',
  `status` int(11) NULL DEFAULT NULL COMMENT '0-学习中,1-学习结束',
  `rate` int(11) NULL DEFAULT NULL COMMENT '学习进度',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT ' 创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT ' 更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户课程' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_course
-- ----------------------------
INSERT INTO `user_course` VALUES ('1235173074094133248', '1234119223710715904', '17', NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user_course` VALUES ('1235173104976793600', '1234119223710715904', '6', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_favorite
-- ----------------------------
DROP TABLE IF EXISTS `user_favorite`;
CREATE TABLE `user_favorite`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `course_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程id',
  `question_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试题id',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收藏类型',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT ' 创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT ' 更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户收藏' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_favorite
-- ----------------------------
INSERT INTO `user_favorite` VALUES ('1235208535898460160', '1234119223710715904', NULL, '2', '试题', NULL, NULL, NULL, NULL);
INSERT INTO `user_favorite` VALUES ('1235212375473393664', '1234119223710715904', '12', NULL, '课程', NULL, NULL, NULL, NULL);
INSERT INTO `user_favorite` VALUES ('1235212392607125504', '1234119223710715904', '11', NULL, '课程', NULL, NULL, NULL, NULL);
INSERT INTO `user_favorite` VALUES ('1235396122328043520', '1234119223710715904', NULL, '21', '试题', NULL, NULL, NULL, NULL);
INSERT INTO `user_favorite` VALUES ('1235399626295742464', '1234119223710715904', '18', NULL, '课程', NULL, NULL, NULL, NULL);
INSERT INTO `user_favorite` VALUES ('1237305258628222976', '1234119223710715901', '6', NULL, '课程', NULL, NULL, NULL, NULL);
INSERT INTO `user_favorite` VALUES ('1243814628887236608', '1234119223710715901', '1', NULL, '课程', NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
  `create_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间 ',
  `update_user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1238132438434189312', '1234119223710715901', '1', NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES ('1238305620101304320', '1238305231960412160', '1238305585934503936', NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES ('1238347522087456768', '1234119223710715901', '2', NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES ('1238347523530297344', '1234119223710715901', '3', NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES ('1238360174201278464', '1234119223710715902', '2', NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES ('1238360176986296320', '1234119223710715902', '3', NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES ('1238360197517414400', '1234119223710715903', '3', NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES ('1238360218300190720', '1234119223710715904', '4', NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES ('1238360238101499904', '1234119223710715905', '5', NULL, NULL, NULL, NULL);
INSERT INTO `user_role` VALUES ('1238360290769375232', '1237767310413008896', '6', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
