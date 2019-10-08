/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : dubbo_one

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-10-08 11:04:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `item_info`
-- ----------------------------
DROP TABLE IF EXISTS `item_info`;
CREATE TABLE `item_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) DEFAULT NULL COMMENT '商品编码',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `price` decimal(15,2) DEFAULT NULL COMMENT '销售价',
  `is_active` int(11) DEFAULT '1' COMMENT '是否有效 (1=是；0=否)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_code` (`code`) USING BTREE COMMENT '商品编码唯一'
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Records of item_info
-- ----------------------------
INSERT INTO `item_info` VALUES ('1', '10010 ', 'Java', '58.50', '1', '2019-08-23 21:31:47', null);
INSERT INTO `item_info` VALUES ('2', '10011', 'demo', '45.50', '1', '2019-08-23 21:32:09', '2019-09-30 21:20:55');
INSERT INTO `item_info` VALUES ('3', '10012', 'spring学习', '68.00', '1', '2019-08-23 21:33:18', null);
INSERT INTO `item_info` VALUES ('4', '10013', '文化孤岛', '38.50', '1', '2019-08-23 21:33:53', null);
INSERT INTO `item_info` VALUES ('5', '10014', 'cloud引入', '56.50', '1', '2019-08-23 21:34:26', null);
INSERT INTO `item_info` VALUES ('6', '10015', 'Mysql建立', '64.00', '1', '2019-08-23 21:34:54', null);
INSERT INTO `item_info` VALUES ('7', '10017', '消息接入转接', '75.50', '1', '2019-08-23 21:35:37', null);

-- ----------------------------
-- Table structure for `order_record`
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `item_id` int(11) NOT NULL COMMENT '商品id',
  `total` int(11) NOT NULL COMMENT '数量',
  `customer_name` varchar(255) DEFAULT NULL COMMENT '客户姓名',
  `order_time` datetime DEFAULT NULL COMMENT '下单时间',
  `is_active` int(255) DEFAULT '1' COMMENT '是否有效（1=是：0=否）',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='下单记录表';

-- ----------------------------
-- Records of order_record
-- ----------------------------
INSERT INTO `order_record` VALUES ('1', '1', '2', 'jack', '2019-09-26 03:17:08', '1', null);
INSERT INTO `order_record` VALUES ('2', '1', '2', 'jack', '2019-09-27 03:25:57', '1', null);
INSERT INTO `order_record` VALUES ('3', '2', '4', 'jack', '2019-09-27 03:26:15', '1', null);
INSERT INTO `order_record` VALUES ('4', '3', '5', 'liang', '2019-09-27 03:27:42', '1', null);
INSERT INTO `order_record` VALUES ('5', '7', '8', 'fei', '2019-09-30 20:30:51', '1', null);
INSERT INTO `order_record` VALUES ('6', '7', '8', 'fei', '2019-09-30 21:15:23', '1', null);
INSERT INTO `order_record` VALUES ('7', '7', '28', '4396upup', '2019-09-30 21:30:47', '1', null);
INSERT INTO `order_record` VALUES ('8', '5', '1', '4396upup', '2019-10-02 01:15:51', '1', null);
INSERT INTO `order_record` VALUES ('9', '5', '6', '4396upup', '2019-10-06 01:56:49', '1', null);
INSERT INTO `order_record` VALUES ('10', '5', '16', '4396upup', '2019-10-06 02:03:25', '1', null);
INSERT INTO `order_record` VALUES ('11', '5', '26', '4396upup', '2019-10-06 02:03:56', '1', null);
INSERT INTO `order_record` VALUES ('12', '2', '7', '4396upup', '2019-10-06 02:15:19', '1', null);
INSERT INTO `order_record` VALUES ('13', '3', '17', '4396upup', '2019-10-06 02:18:48', '1', null);
INSERT INTO `order_record` VALUES ('14', '3', '17', '4396upup', '2019-10-06 02:20:41', '1', null);
INSERT INTO `order_record` VALUES ('15', '4', '7', 'innovation', '2019-10-06 02:40:18', '1', null);
