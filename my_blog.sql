/*
 Navicat MySQL Data Transfer

 Source Server         : nenu_oa
 Source Server Version : 50623
 Source Host           : localhost
 Source Database       : my_blog

 Target Server Version : 50623
 File Encoding         : utf-8

 Date: 09/30/2015 23:59:59 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_about_me`
-- ----------------------------
DROP TABLE IF EXISTS `t_about_me`;
CREATE TABLE `t_about_me` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` longtext NOT NULL,
  `content_html` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_blog`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `content` longtext NOT NULL,
  `content_html` longtext NOT NULL,
  `classification_id` int(11) NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `click_count` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_blog_classification`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_classification`;
CREATE TABLE `t_blog_classification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classification_name` char(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_blog_label`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog_label`;
CREATE TABLE `t_blog_label` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) NOT NULL,
  `label_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_comments`
-- ----------------------------
DROP TABLE IF EXISTS `t_comments`;
CREATE TABLE `t_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `blog_id` int(11) NOT NULL,
  `content` text NOT NULL,
  `nick_name` char(50) NOT NULL,
  `email` char(50) NOT NULL,
  `reply_comment_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_lable`
-- ----------------------------
DROP TABLE IF EXISTS `t_lable`;
CREATE TABLE `t_lable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_resource_classification`
-- ----------------------------
DROP TABLE IF EXISTS `t_resource_classification`;
CREATE TABLE `t_resource_classification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classification_name` char(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_resources`
-- ----------------------------
DROP TABLE IF EXISTS `t_resources`;
CREATE TABLE `t_resources` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` char(50) NOT NULL,
  `resource_path` varchar(255) NOT NULL,
  `classification_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_users`
-- ----------------------------
DROP TABLE IF EXISTS `t_users`;
CREATE TABLE `t_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(60) NOT NULL,
  `password` char(60) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_users`
-- ----------------------------
BEGIN;
INSERT INTO `t_users` VALUES ('1', 'lishicao', 'aa0e0e3e358e6a464e8f35799c30ba5b');
COMMIT;

-- ----------------------------
--  Table structure for `t_visitor_count`
-- ----------------------------
DROP TABLE IF EXISTS `t_visitor_count`;
CREATE TABLE `t_visitor_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
