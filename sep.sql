/*
 Navicat MySQL Data Transfer

 Source Server         : sep
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : sep

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 22/08/2017 20:39:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_tbl
-- ----------------------------
DROP TABLE IF EXISTS `admin_tbl`;
CREATE TABLE `admin_tbl`  (
  `admin_id` int(10) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_tbl
-- ----------------------------
DROP TABLE IF EXISTS `customer_tbl`;
CREATE TABLE `customer_tbl`  (
  `customer_id` int(10) NOT NULL,
  `customer_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `customer_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credit_cardno` int(20) NOT NULL,
  `order_id` int(20) DEFAULT NULL,
  `dob` date NOT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE,
  INDEX `customer_order`(`order_id`) USING BTREE,
  CONSTRAINT `customer_order` FOREIGN KEY (`order_id`) REFERENCES `order_tbl` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer_tbl
-- ----------------------------
INSERT INTO `customer_tbl` VALUES (1, 'joey', 'sydney', 'joey.lu.au@gmail.com', 12345678, 12345678, '2017-08-20');

-- ----------------------------
-- Table structure for item_tbl
-- ----------------------------
DROP TABLE IF EXISTS `item_tbl`;
CREATE TABLE `item_tbl`  (
  `item_id` int(20) NOT NULL,
  `item_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `item_description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `stock` int(255) NOT NULL,
  `item_status` int(1) NOT NULL,
  `price` double(10, 2) NOT NULL,
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_detail_tbl
-- ----------------------------
DROP TABLE IF EXISTS `order_detail_tbl`;
CREATE TABLE `order_detail_tbl`  (
  `order_id` int(20) NOT NULL,
  `item_id` int(20) NOT NULL,
  `quantity` int(255) NOT NULL,
  `order_detail_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `unitCost` double(10, 2) NOT NULL,
  `subtotal` double(10, 2) NOT NULL,
  PRIMARY KEY (`order_id`, `item_id`) USING BTREE,
  INDEX `item_id`(`item_id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  CONSTRAINT `order_detail_1` FOREIGN KEY (`order_id`) REFERENCES `order_tbl` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_detail_2` FOREIGN KEY (`item_id`) REFERENCES `item_tbl` (`item_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_tbl
-- ----------------------------
DROP TABLE IF EXISTS `order_tbl`;
CREATE TABLE `order_tbl`  (
  `order_id` int(20) NOT NULL AUTO_INCREMENT,
  `order_status` int(10) DEFAULT NULL,
  `date_created` datetime(6) NOT NULL,
  `customer_id` int(20) NOT NULL,
  `shipping_id` int(20) NOT NULL,
  `payment` double(10, 0) DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `order_shipping`(`shipping_id`) USING BTREE,
  CONSTRAINT `order_shipping` FOREIGN KEY (`shipping_id`) REFERENCES `shipping_tbl` (`shipping_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12345679 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_tbl
-- ----------------------------
INSERT INTO `order_tbl` VALUES (12345678, 0, '2017-08-20 15:38:11.000000', 12345678, 1, 1000);

-- ----------------------------
-- Table structure for shipping_tbl
-- ----------------------------
DROP TABLE IF EXISTS `shipping_tbl`;
CREATE TABLE `shipping_tbl`  (
  `shipping_id` int(20) NOT NULL DEFAULT 1,
  `shipping_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipping_Region` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipping_address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shipping_status` int(1) NOT NULL,
  `shipping_cost` double(10, 2) NOT NULL,
  `delivery_date` date NOT NULL,
  PRIMARY KEY (`shipping_id`, `delivery_date`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shipping_tbl
-- ----------------------------
INSERT INTO `shipping_tbl` VALUES (1, '0', 'Australia', 'city', 1, 1000.00, '2017-08-20');

-- ----------------------------
-- Table structure for user_tbl
-- ----------------------------
DROP TABLE IF EXISTS `user_tbl`;
CREATE TABLE `user_tbl`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `login_status` int(1) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
