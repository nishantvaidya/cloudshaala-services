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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` varchar(50) NOT NULL,
  `password` varchar(12) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `country_code` varchar(5) DEFAULT NULL,
  `state_code` varchar(5) DEFAULT NULL,
  `district_code` varchar(5) DEFAULT NULL,
  `city_village` varchar(50) DEFAULT NULL,
  `street_address` varchar(150) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `landline` varchar(15) DEFAULT NULL,
  `mobile` varchar(15) NOT NULL,
  `loc_latitude` varchar(12) DEFAULT NULL,
  `loc_longitude` varchar(12) DEFAULT NULL,
  `registered_by_user` varchar(30) DEFAULT NULL,
  `registration_platform` varchar(15) NOT NULL,
  `community_login_by` varchar(10) DEFAULT NULL,
  `community_id` varchar(50) DEFAULT NULL,
  `profile_pic` varchar(100) DEFAULT NULL,
  `secondary_lang_code` varchar(10) DEFAULT NULL,
  `primaryInstitutionType` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `mobile` (`mobile`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1457491850872','852598','sourabbh','panchaal',NULL,NULL,NULL,NULL,NULL,NULL,'sourcabhp@gmail.com',NULL,'7889232356',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('1457577885590','880470','somanshu','vijay',NULL,NULL,NULL,NULL,NULL,NULL,'somanshu@gmail.com',NULL,'222211122',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('1457578157570','152299','s1','v1',NULL,NULL,NULL,NULL,NULL,NULL,'s1@gmail.com',NULL,'12341234',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('1457578394399','387108','s2','v2',NULL,NULL,NULL,NULL,NULL,NULL,'s2@gmail.com',NULL,'12341235',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('1460041466348','467151','hello123','222',NULL,NULL,NULL,NULL,NULL,NULL,'hello123@gmail.com',NULL,'888686',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('1460475039135','47833','s5','v5',NULL,NULL,NULL,NULL,NULL,NULL,'s3@gmail.com',NULL,'1234541235',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('1463892029840','20511','nishant','vaidya',NULL,NULL,NULL,NULL,NULL,NULL,'nishant@abc.com',NULL,'99999999',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('1464115537611','534586','jaroori','hai',NULL,NULL,NULL,NULL,NULL,NULL,'jaroori@gmail.com',NULL,'1122889911',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('1464115720279','729822','jaroori2','hai2',NULL,NULL,NULL,NULL,NULL,NULL,'jaroori2@gmail.com',NULL,'11228899113',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('1464115954316','945968','','',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,'',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('1464115986464','977270','kalu','kk',NULL,NULL,NULL,NULL,NULL,NULL,'qqqq',NULL,'7888',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('cuid123456','112233','aman','jha','m',NULL,NULL,NULL,NULL,NULL,'amanajha@gmail.com',NULL,'9922331212',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('cuid1457490482341496935432','82341','aniket','gupta',NULL,NULL,NULL,NULL,NULL,NULL,'aniket@gmail.com',NULL,'99342334',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL),('cuid223344','112233','mohit','sharma','m',NULL,NULL,NULL,NULL,NULL,'mohits@gmail.com',NULL,'8899889981',NULL,NULL,NULL,'android',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-29 16:44:24
