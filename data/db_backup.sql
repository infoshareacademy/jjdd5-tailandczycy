-- MySQL dump 10.13  Distrib 8.0.13, for Linux (x86_64)
--
-- Host: localhost    Database: tailandczycy
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `BUDGETS`
--

DROP TABLE IF EXISTS `BUDGETS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `BUDGETS` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BUDGETS`
--

LOCK TABLES `BUDGETS` WRITE;
/*!40000 ALTER TABLE `BUDGETS` DISABLE KEYS */;
INSERT INTO `BUDGETS` VALUES (1,8000.00);
/*!40000 ALTER TABLE `BUDGETS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATEGORIES`
--

DROP TABLE IF EXISTS `CATEGORIES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CATEGORIES` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `spending_limit` decimal(19,2) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATEGORIES`
--

LOCK TABLES `CATEGORIES` WRITE;
/*!40000 ALTER TABLE `CATEGORIES` DISABLE KEYS */;
INSERT INTO `CATEGORIES` VALUES (1,1500.00,'work'),(2,1000.00,'wife'),(3,300.00,'pub'),(4,2000.00,'home'),(5,800.00,'kids');
/*!40000 ALTER TABLE `CATEGORIES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CATEGORIES_TO_EXPENSES`
--

DROP TABLE IF EXISTS `CATEGORIES_TO_EXPENSES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `CATEGORIES_TO_EXPENSES` (
  `category_id` bigint(20) NOT NULL,
  `expense_id` bigint(20) NOT NULL,
  UNIQUE KEY `UKa80o7wnyv82y4wky0xl0mcopp` (`category_id`,`expense_id`),
  KEY `FKi81y8f71x8dpusp1k6rpsilhx` (`expense_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CATEGORIES_TO_EXPENSES`
--

LOCK TABLES `CATEGORIES_TO_EXPENSES` WRITE;
/*!40000 ALTER TABLE `CATEGORIES_TO_EXPENSES` DISABLE KEYS */;
INSERT INTO `CATEGORIES_TO_EXPENSES` VALUES (1,3),(2,1),(3,2);
/*!40000 ALTER TABLE `CATEGORIES_TO_EXPENSES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXPENSES`
--

DROP TABLE IF EXISTS `EXPENSES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `EXPENSES` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` decimal(19,2) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXPENSES`
--

LOCK TABLES `EXPENSES` WRITE;
/*!40000 ALTER TABLE `EXPENSES` DISABLE KEYS */;
INSERT INTO `EXPENSES` VALUES (1,500.00,'black and white','2017-09-09','sofa'),(2,10.00,'tesco','2017-02-06','mug'),(3,200.00,'dress','2018-07-02','gift'),(4,80.00,'lager','2018-03-01','beer'),(5,700.00,'console, games ,pads','2018-12-17','playstation');
/*!40000 ALTER TABLE `EXPENSES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EXPENSES_TO_CATEGORIES`
--

DROP TABLE IF EXISTS `EXPENSES_TO_CATEGORIES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `EXPENSES_TO_CATEGORIES` (
  `expense_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  UNIQUE KEY `UKijyn6cv9hwxoewqo91v55xpkm` (`expense_id`,`category_id`),
  KEY `FKnt3vk858n01b970vs754hbf81` (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EXPENSES_TO_CATEGORIES`
--

LOCK TABLES `EXPENSES_TO_CATEGORIES` WRITE;
/*!40000 ALTER TABLE `EXPENSES_TO_CATEGORIES` DISABLE KEYS */;
INSERT INTO `EXPENSES_TO_CATEGORIES` VALUES (1,4),(2,1),(3,2),(4,3),(5,5);
/*!40000 ALTER TABLE `EXPENSES_TO_CATEGORIES` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-17 21:35:22
