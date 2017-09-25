/*
 Navicat Premium Data Transfer

 Source Server         : eaton
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : sep

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 25/09/2017 20:16:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_tbl
-- ----------------------------
DROP TABLE IF EXISTS `admin_tbl`;
CREATE TABLE `admin_tbl`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `authority_level` int(5) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `admin_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customer_tbl
-- ----------------------------
DROP TABLE IF EXISTS `customer_tbl`;
CREATE TABLE `customer_tbl`  (
  `user_id` int(10) NOT NULL,
  `customer_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `credit_cardno` int(20) NOT NULL,
  `order_id` int(20) NULL DEFAULT NULL,
  `dob` date NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `customer_order`(`order_id`) USING BTREE,
  CONSTRAINT `customer_order` FOREIGN KEY (`order_id`) REFERENCES `order_tbl` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `customer_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for item_tbl
-- ----------------------------
DROP TABLE IF EXISTS `item_tbl`;
CREATE TABLE `item_tbl`  (
  `item_id` int(20) NOT NULL,
  `item_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `item_description` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `stock` int(255) NOT NULL,
  `item_status` int(1) NOT NULL,
  `price` double(10, 2) NOT NULL,
  `item_pic_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
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
  CONSTRAINT `order_detail_item` FOREIGN KEY (`item_id`) REFERENCES `item_tbl` (`item_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_detail_order` FOREIGN KEY (`order_id`) REFERENCES `order_tbl` (`order_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for order_tbl
-- ----------------------------
DROP TABLE IF EXISTS `order_tbl`;
CREATE TABLE `order_tbl`  (
  `order_id` int(20) NOT NULL AUTO_INCREMENT,
  `order_status` int(10) NULL DEFAULT NULL,
  `date_created` datetime(6) NOT NULL,
  `customer_id` int(20) NOT NULL,
  `shipping_id` int(20) NOT NULL,
  `payment` double(10, 0) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `order_shipping`(`shipping_id`) USING BTREE,
  CONSTRAINT `order_shipping` FOREIGN KEY (`shipping_id`) REFERENCES `shipping_tbl` (`shipping_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12345679 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seller_tbl
-- ----------------------------
DROP TABLE IF EXISTS `seller_tbl`;
CREATE TABLE `seller_tbl`  (
  `user_id` int(10) NOT NULL,
  `seller_credit` int(255) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `seller_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_tbl` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
  PRIMARY KEY (`shipping_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shopping_cart_item_tbl
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart_item_tbl`;
CREATE TABLE `shopping_cart_item_tbl`  (
  `item_id` int(20) NOT NULL,
  `shopping_cart_id` int(20) NOT NULL,
  PRIMARY KEY (`item_id`, `shopping_cart_id`) USING BTREE,
  INDEX `shopping_cart_id`(`shopping_cart_id`) USING BTREE,
  INDEX `item_id`(`item_id`) USING BTREE,
  CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `item_tbl` (`item_id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `shopping_cart_id` FOREIGN KEY (`shopping_cart_id`) REFERENCES `shopping_cart_tbl` (`shopping_cart_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shopping_cart_tbl
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart_tbl`;
CREATE TABLE `shopping_cart_tbl`  (
  `shopping_cart_id` int(20) NOT NULL,
  `customer_id` int(20) NOT NULL,
  PRIMARY KEY (`shopping_cart_id`) USING BTREE,
  INDEX `shopping_cart_tbl`(`customer_id`) USING BTREE,
  INDEX `shopping_cart_id`(`shopping_cart_id`) USING BTREE,
  CONSTRAINT `shopping_cart_tbl` FOREIGN KEY (`customer_id`) REFERENCES `customer_tbl` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_tbl
-- ----------------------------
DROP TABLE IF EXISTS `user_tbl`;
CREATE TABLE `user_tbl`  (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `login_status` int(1) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
