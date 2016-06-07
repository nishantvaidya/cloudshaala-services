-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: cloudshaala.com    Database: cloudshaala
-- ------------------------------------------------------
-- Server version	5.1.73

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
-- Table structure for table `country_state_district`
--

DROP TABLE IF EXISTS `country_state_district`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country_state_district` (
  `country_code` varchar(5) NOT NULL,
  `country_name` varchar(50) NOT NULL,
  `state_code` varchar(5) NOT NULL,
  `state_name` varchar(50) NOT NULL,
  `district_code` varchar(5) NOT NULL,
  `district_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country_state_district`
--

LOCK TABLES `country_state_district` WRITE;
/*!40000 ALTER TABLE `country_state_district` DISABLE KEYS */;
INSERT INTO `country_state_district` VALUES ('in','india','mp','madhya pradesh','ind','indore'),('in','india','mp','madhya pradesh','ujj','ujjain'),('in','india','up','utter  pradesh','agr','agra'),('in','india','up','utter  pradesh','luk','lucknow'),('in','india','bh','bihar','pat','patna'),('in','india','mp','madhya pradesh','ind','indore'),('in','india','mp','madhya pradesh','ujj','ujjain'),('in','india','up','utter  pradesh','agr','agra'),('in','india','up','utter  pradesh','luk','lucknow'),('in','india','bh','bihar','pat','patna');
/*!40000 ALTER TABLE `country_state_district` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-29 16:44:20
