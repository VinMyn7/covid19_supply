-- MySQL dump 10.13  Distrib 8.0.27, for macos11 (x86_64)
--
-- Host: localhost    Database: covid19_supply
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_id` varchar(10) NOT NULL,
  `customer_name` char(50) NOT NULL,
  `customer_address` char(100) NOT NULL,
  `customer_age` tinyint unsigned DEFAULT NULL,
  `delivery_id` varchar(10) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE KEY `customer_id` (`customer_id`),
  UNIQUE KEY `customer_address` (`customer_address`),
  UNIQUE KEY `delivery_id` (`delivery_id`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_staff` (`delivery_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('00001A','Barney Stinson','MacLaren\'s Pub, New York',32,'DEL212'),('12340B','Ted Mosby','New GNB Headquarters, New York',31,'DEL442'),('61234C','Marshall Eriksen','Wesleyan University, Illinois',36,'DEL001'),('77777E','Robin Scherbatsky','Hoser Hut, New York',23,'DEL345'),('78423D','Lily Aldrin','Marshall and Lily\'s apartment, New York',34,'DEL108');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_order`
--

DROP TABLE IF EXISTS `customer_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_order` (
  `customer_id` varchar(10) NOT NULL,
  `product_id` varchar(10) NOT NULL,
  `product_quantity` smallint unsigned NOT NULL,
  PRIMARY KEY (`customer_id`,`product_id`),
  UNIQUE KEY `customer_id` (`customer_id`),
  UNIQUE KEY `product_id` (`product_id`),
  CONSTRAINT `customer_order_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `customer_order_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product_stock` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_order`
--

LOCK TABLES `customer_order` WRITE;
/*!40000 ALTER TABLE `customer_order` DISABLE KEYS */;
INSERT INTO `customer_order` VALUES ('00001A','010A',20),('12340B','010B',50),('61234C','010C',60),('77777E','717S',1),('78423D','777M',5);
/*!40000 ALTER TABLE `customer_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_staff`
--

DROP TABLE IF EXISTS `delivery_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_staff` (
  `delivery_id` varchar(10) NOT NULL,
  `delivery_staff_id` varchar(10) NOT NULL,
  `delivery_date` date NOT NULL,
  `supplier_id` varchar(10) NOT NULL,
  PRIMARY KEY (`delivery_id`),
  UNIQUE KEY `delivery_id` (`delivery_id`),
  UNIQUE KEY `delivery_staff_id` (`delivery_staff_id`),
  UNIQUE KEY `supplier_id` (`supplier_id`),
  CONSTRAINT `delivery_staff_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_staff`
--

LOCK TABLES `delivery_staff` WRITE;
/*!40000 ALTER TABLE `delivery_staff` DISABLE KEYS */;
INSERT INTO `delivery_staff` VALUES ('DEL001','ST031','2021-12-01','SUP111'),('DEL108','ST021','2021-12-15','SUP333'),('DEL212','ST001','2021-11-01','SUP672'),('DEL345','ST011','2021-10-27','SUP222'),('DEL442','ST007','2021-11-05','SUP000');
/*!40000 ALTER TABLE `delivery_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital` (
  `hospital_id` varchar(10) NOT NULL,
  `hospital_name` char(50) NOT NULL,
  `hospital_address` char(100) NOT NULL,
  `delivery_id` varchar(10) NOT NULL,
  PRIMARY KEY (`hospital_id`),
  UNIQUE KEY `hospital_id` (`hospital_id`),
  UNIQUE KEY `hospital_address` (`hospital_address`),
  UNIQUE KEY `delivery_id` (`delivery_id`),
  CONSTRAINT `hospital_ibfk_1` FOREIGN KEY (`delivery_id`) REFERENCES `delivery_staff` (`delivery_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES ('0A1','Mayo Clinic','Rochester, Minnesota','DEL212'),('0A2','NewYork-Presbyterian Hospital','NY Metropolitan area, New York','DEL345'),('0B2','UCLA Medical Center','Los Angeles','DEL442'),('0C3','Johns Hopkins Hospital',' 1800 Orleans St, Baltimore, MD 21287','DEL001'),('0D4','Massachusetts General Hospital','55 Fruit St, Boston, MA 02114','DEL108');
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital_order`
--

DROP TABLE IF EXISTS `hospital_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital_order` (
  `hospital_id` varchar(10) NOT NULL,
  `product_id` varchar(10) NOT NULL,
  `product_quantity` smallint unsigned NOT NULL,
  PRIMARY KEY (`hospital_id`,`product_id`),
  UNIQUE KEY `hospital_id` (`hospital_id`),
  UNIQUE KEY `product_id` (`product_id`),
  CONSTRAINT `hospital_order_ibfk_1` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`hospital_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `hospital_order_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product_stock` (`product_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital_order`
--

LOCK TABLES `hospital_order` WRITE;
/*!40000 ALTER TABLE `hospital_order` DISABLE KEYS */;
INSERT INTO `hospital_order` VALUES ('0A1','010A',200),('0A2','717S',10),('0B2','010B',500),('0C3','010C',500),('0D4','777M',40);
/*!40000 ALTER TABLE `hospital_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_stock`
--

DROP TABLE IF EXISTS `product_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_stock` (
  `product_id` varchar(10) NOT NULL,
  `product_name` char(20) NOT NULL,
  `available_quantity` smallint unsigned DEFAULT NULL,
  `supplier_id` varchar(10) NOT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `product_id` (`product_id`),
  UNIQUE KEY `product_name` (`product_name`),
  UNIQUE KEY `supplier_id` (`supplier_id`),
  UNIQUE KEY `available_quantity` (`available_quantity`),
  CONSTRAINT `product_stock_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`supplier_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_stock`
--

LOCK TABLES `product_stock` WRITE;
/*!40000 ALTER TABLE `product_stock` DISABLE KEYS */;
INSERT INTO `product_stock` VALUES ('010A','Hand Sanitizers',1000,'SUP111'),('010B','N95 Mask',5000,'SUP222'),('010C','Gloves, surgical',3000,'SUP333'),('717S','Oxygen Cylinders',70,'SUP000'),('777M','RT-PCR Kits',400,'SUP672');
/*!40000 ALTER TABLE `product_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `supplier_id` varchar(10) NOT NULL,
  `supplier_name` char(20) NOT NULL,
  `delivery_id` varchar(10) NOT NULL,
  PRIMARY KEY (`supplier_id`),
  UNIQUE KEY `supplier_id` (`supplier_id`),
  UNIQUE KEY `delivery_id` (`delivery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('SUP000','Amy','DEL442'),('SUP111','Jon','DEL001'),('SUP222','Ben','DEL345'),('SUP333','Adam','DEL007'),('SUP672','Elena','DEL212');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-11 20:46:26
