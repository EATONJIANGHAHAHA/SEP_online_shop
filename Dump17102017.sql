-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sep
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_tbl`
--

DROP TABLE IF EXISTS `admin_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_tbl` (
  `admin_id` int(10) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(40) NOT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_tbl`
--

LOCK TABLES `admin_tbl` WRITE;
/*!40000 ALTER TABLE `admin_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_tbl`
--

DROP TABLE IF EXISTS `customer_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_tbl` (
  `customer_id` int(10) NOT NULL,
  `customer_name` varchar(40) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `email` varchar(50) NOT NULL,
  `credit_cardno` int(20) NOT NULL,
  `order_id` int(20) DEFAULT NULL,
  `dob` date NOT NULL,
  PRIMARY KEY (`customer_id`) USING BTREE,
  KEY `customer_order` (`order_id`) USING BTREE,
  CONSTRAINT `customer_order` FOREIGN KEY (`order_id`) REFERENCES `order_tbl` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_tbl`
--

LOCK TABLES `customer_tbl` WRITE;
/*!40000 ALTER TABLE `customer_tbl` DISABLE KEYS */;
INSERT INTO `customer_tbl` VALUES (1,'joey','sydney','joey.lu.au@gmail.com',12345678,12345678,'2017-08-20');
/*!40000 ALTER TABLE `customer_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_tbl`
--

DROP TABLE IF EXISTS `item_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_tbl` (
  `item_id` int(20) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(50) NOT NULL,
  `item_description` varchar(200) DEFAULT NULL,
  `stock` int(255) NOT NULL,
  `item_status` int(1) NOT NULL,
  `price` double(10,2) NOT NULL,
  `image` varchar(100) DEFAULT NULL,
  `owner_id` int(11) NOT NULL,
  PRIMARY KEY (`item_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_tbl`
--

LOCK TABLES `item_tbl` WRITE;
/*!40000 ALTER TABLE `item_tbl` DISABLE KEYS */;
INSERT INTO `item_tbl` VALUES (1,'socks','new item list display test with a long description that goes for multiple lines to see how it looks hopefully it turns out well socks and how i expect it to ',20,1,5.00,'socks.jpg',5),(2,'shoes','new item list display test with a long description that goes for multiple lines to see how it looks hopefully it turns out well and shoes how i expect it to ',10,1,10.00,'shoes.jpg',4),(3,'boat shoes','new item list display test with a long description that goes for multiple lines to see how it looks hopefully it turns out well and how boat shoes i expect it to ',5,1,20.00,'boatshoes.jpg',4),(4,'nike','new item list display test with a long description that goes for multiple lines to see how it looks hopefully it turns out well and how i nike running shoes expect it to ',2,1,50.00,'nike.jpg',1),(21,'adidas','new item list display test with a long description that goes for multiple lines to see how it looks hopefully it turns out well and how i adidas shoes expect it to ',1,1,10.00,'adidas.jpg',1),(22,'asics socks','new item list display test with a long description that goes for multiple lines to see how it looks hopefully it turns out well and how i asics socks expect it to ',1,1,5.00,'asocks.jpg',2),(42,'Bat','used for baseball made of wood used only in america made in china',1,1,50.00,'bat.jpg',3),(43,'Ball','can be used for basketball baseball football handball bowling its an all in one ball for the price of 10 balls only wow',1,1,100.00,'ball.jpg',3),(57,'Moyo\'s item','item of moyo',1,1,1.00,'yellowtick.jpg',1),(58,'Grand piano','Old piano, wear and tear, missing some keys. sounds ok',1,1,1000.00,'piano.jpg',5),(59,'Turntables','new turntables music DJ used only once',1,1,200.00,'turntables.jpg',2),(60,'Sofa','lounge sofa single use only great price',1,1,100.00,'sofa.jpg',1),(64,'harry potter book collection','harry potter book collection books 1 through to 7 wizards ',1,1,80.00,'harry_potter.jpg',1),(65,'iphone','iPhone 7 brand new',1,1,23.00,'iphone_7.jpg',4),(66,'Doorstop','The best door stop in the world',1,1,900.00,'doorstop.jpg',6);
/*!40000 ALTER TABLE `item_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail_tbl`
--

DROP TABLE IF EXISTS `order_detail_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail_tbl` (
  `order_id` int(20) NOT NULL,
  `item_id` int(20) NOT NULL,
  `quantity` int(255) NOT NULL,
  `order_detail_name` varchar(50) NOT NULL,
  `unitCost` double(10,2) NOT NULL,
  `subtotal` double(10,2) NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `item_id` (`item_id`) USING BTREE,
  KEY `order_id` (`order_id`) USING BTREE,
  CONSTRAINT `order_detail_1` FOREIGN KEY (`order_id`) REFERENCES `order_tbl` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail_tbl`
--

LOCK TABLES `order_detail_tbl` WRITE;
/*!40000 ALTER TABLE `order_detail_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_tbl`
--

DROP TABLE IF EXISTS `order_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_tbl` (
  `order_id` int(20) NOT NULL AUTO_INCREMENT,
  `order_status` int(10) DEFAULT NULL,
  `date_created` datetime(6) NOT NULL,
  `customer_id` int(20) NOT NULL,
  `shipping_id` int(20) NOT NULL,
  `payment` double(10,0) DEFAULT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  KEY `order_shipping` (`shipping_id`) USING BTREE,
  CONSTRAINT `order_shipping` FOREIGN KEY (`shipping_id`) REFERENCES `shipping_tbl` (`shipping_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12345679 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_tbl`
--

LOCK TABLES `order_tbl` WRITE;
/*!40000 ALTER TABLE `order_tbl` DISABLE KEYS */;
INSERT INTO `order_tbl` VALUES (12345678,0,'2017-08-20 15:38:11.000000',12345678,1,1000);
/*!40000 ALTER TABLE `order_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shipping_tbl`
--

DROP TABLE IF EXISTS `shipping_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shipping_tbl` (
  `shipping_id` int(20) NOT NULL DEFAULT '1',
  `shipping_type` varchar(50) NOT NULL,
  `shipping_Region` varchar(50) NOT NULL,
  `shipping_address` varchar(50) NOT NULL,
  `shipping_status` int(1) NOT NULL,
  `shipping_cost` double(10,2) NOT NULL,
  `delivery_date` date NOT NULL,
  PRIMARY KEY (`shipping_id`,`delivery_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipping_tbl`
--

LOCK TABLES `shipping_tbl` WRITE;
/*!40000 ALTER TABLE `shipping_tbl` DISABLE KEYS */;
INSERT INTO `shipping_tbl` VALUES (1,'0','Australia','city',1,1000.00,'2017-08-20');
/*!40000 ALTER TABLE `shipping_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart_tbl`
--

DROP TABLE IF EXISTS `shopping_cart_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shopping_cart_tbl` (
  `cart_id` int(10) NOT NULL AUTO_INCREMENT,
  `item_id` int(20) NOT NULL,
  `user_id` int(20) NOT NULL,
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart_tbl`
--

LOCK TABLES `shopping_cart_tbl` WRITE;
/*!40000 ALTER TABLE `shopping_cart_tbl` DISABLE KEYS */;
INSERT INTO `shopping_cart_tbl` VALUES (1,66,1),(2,65,1),(3,59,1),(5,58,1),(12,43,6),(13,42,6),(14,22,4),(15,21,4),(16,2,6);
/*!40000 ALTER TABLE `shopping_cart_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_tbl`
--

DROP TABLE IF EXISTS `user_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_tbl` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `user_password` varchar(30) NOT NULL,
  `login_status` int(1) NOT NULL,
  `user_email` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_tbl`
--

LOCK TABLES `user_tbl` WRITE;
/*!40000 ALTER TABLE `user_tbl` DISABLE KEYS */;
INSERT INTO `user_tbl` VALUES (1,'Moyo','123456',1,'fake@gmail.com'),(2,'Wax','123456',1,'NOW@gmail.com'),(3,'Jade','123456',1,'jade@gmail.com'),(4,'Lennon','123456',1,'lennon@gmail.com'),(5,'Zappa','123456',1,'zappa@gmail.com'),(6,'edric','123456',1,'edjomendoza@gmail.com');
/*!40000 ALTER TABLE `user_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-17 14:42:04
