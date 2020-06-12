-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: covid-19simulator
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `church`
--

DROP TABLE IF EXISTS `church`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `church` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` double NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `openTime` int(11) DEFAULT NULL,
  `closeTime` int(11) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKchurch812349` (`locationCategoryId`),
  CONSTRAINT `FKchurch812349` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `church`
--

LOCK TABLES `church` WRITE;
/*!40000 ALTER TABLE `church` DISABLE KEYS */;
/*!40000 ALTER TABLE `church` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cities`
--

DROP TABLE IF EXISTS `cities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cities` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `population` int(10) DEFAULT NULL,
  `width` int(10) DEFAULT NULL,
  `heigth` int(10) DEFAULT NULL,
  `main` int(11) NOT NULL DEFAULT '0',
  `countryId` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKcities335233` (`countryId`),
  CONSTRAINT `FKcities335233` FOREIGN KEY (`countryId`) REFERENCES `country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cities`
--

LOCK TABLES `cities` WRITE;
/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` VALUES (74,'zgharta',0,1976,988,1,1);
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city_models`
--

DROP TABLE IF EXISTS `city_models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city_models` (
  `cityid` int(100) NOT NULL,
  `modelsid` int(10) NOT NULL,
  PRIMARY KEY (`cityid`,`modelsid`),
  KEY `FKcity_model887892` (`cityid`),
  KEY `FKcity_model582739` (`modelsid`),
  CONSTRAINT `FKcity_model582739` FOREIGN KEY (`modelsid`) REFERENCES `models` (`id`),
  CONSTRAINT `FKcity_model887892` FOREIGN KEY (`cityid`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_models`
--

LOCK TABLES `city_models` WRITE;
/*!40000 ALTER TABLE `city_models` DISABLE KEYS */;
/*!40000 ALTER TABLE `city_models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city_models_populationtype`
--

DROP TABLE IF EXISTS `city_models_populationtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city_models_populationtype` (
  `city_modelscityid` int(100) NOT NULL,
  `city_modelsmodelsid` int(10) NOT NULL,
  `populationTypeid` int(10) NOT NULL,
  `date` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `HumanNumber` int(10) NOT NULL,
  PRIMARY KEY (`city_modelscityid`,`city_modelsmodelsid`,`populationTypeid`),
  KEY `FKcity_model682030` (`city_modelscityid`,`city_modelsmodelsid`),
  KEY `FKcity_model504518` (`populationTypeid`),
  CONSTRAINT `FKcity_model504518` FOREIGN KEY (`populationTypeid`) REFERENCES `populationtype` (`id`),
  CONSTRAINT `FKcity_model682030` FOREIGN KEY (`city_modelscityid`, `city_modelsmodelsid`) REFERENCES `city_models` (`cityid`, `modelsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_models_populationtype`
--

LOCK TABLES `city_models_populationtype` WRITE;
/*!40000 ALTER TABLE `city_models_populationtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `city_models_populationtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `citysextype`
--

DROP TABLE IF EXISTS `citysextype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `citysextype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `percentage` double NOT NULL,
  `cityid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cityid` (`cityid`),
  CONSTRAINT `citysextype_ibfk_1` FOREIGN KEY (`cityid`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citysextype`
--

LOCK TABLES `citysextype` WRITE;
/*!40000 ALTER TABLE `citysextype` DISABLE KEYS */;
INSERT INTO `citysextype` VALUES (61,'Male',10,74),(62,'Female',10,74);
/*!40000 ALTER TABLE `citysextype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'Lebanon');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `displacementcmap`
--

DROP TABLE IF EXISTS `displacementcmap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `displacementcmap` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` double NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKdisplaceme431359` (`locationCategoryId`),
  CONSTRAINT `FKdisplaceme431359` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `displacementcmap`
--

LOCK TABLES `displacementcmap` WRITE;
/*!40000 ALTER TABLE `displacementcmap` DISABLE KEYS */;
/*!40000 ALTER TABLE `displacementcmap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factory`
--

DROP TABLE IF EXISTS `factory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `factory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) DEFAULT NULL,
  `width` int(10) DEFAULT NULL,
  `height` int(10) DEFAULT NULL,
  `sickPercentage` double DEFAULT NULL,
  `locationCategoryId` int(10) DEFAULT NULL,
  `openTime` int(10) DEFAULT NULL,
  `closeTime` int(10) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `locationCategoryId` (`locationCategoryId`),
  CONSTRAINT `factory_ibfk_1` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factory`
--

LOCK TABLES `factory` WRITE;
/*!40000 ALTER TABLE `factory` DISABLE KEYS */;
INSERT INTO `factory` VALUES (1,' ',468,754,75,75,50,81,7,15,'Monday Tuesday Wednesday Thursday Friday ',0),(2,' ',988,260,75,75,50,81,7,15,'Monday Tuesday Wednesday Thursday Friday ',0),(3,' ',1430,182,75,75,50,81,7,15,'Monday Tuesday Wednesday Thursday Friday ',0);
/*!40000 ALTER TABLE `factory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hospital` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` double NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `openTime` int(11) DEFAULT NULL,
  `closeTime` int(11) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKhospital403145` (`locationCategoryId`),
  CONSTRAINT `FKhospital403145` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (74,' ',1066,572,75,75,50,75,0,23,'Monday Friday Tuesday Saturday Wednesday Sunday Thursday ',1),(75,' ',1248,468,75,75,50,75,0,23,'Monday Friday Tuesday Saturday Wednesday Sunday Thursday ',1);
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `house`
--

DROP TABLE IF EXISTS `house`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `house` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` double NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKhouse304912` (`locationCategoryId`),
  CONSTRAINT `FKhouse304912` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2707 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
INSERT INTO `house` VALUES (2607,' ',858,546,25,25,50,74,0),(2608,' ',858,650,25,25,50,74,0),(2609,' ',546,26,25,25,50,74,0),(2610,' ',338,832,25,25,50,74,0),(2611,' ',520,832,25,25,50,74,0),(2612,' ',1144,286,25,25,50,74,0),(2613,' ',1690,676,25,25,50,74,0),(2614,' ',598,754,25,25,50,74,0),(2615,' ',1846,130,25,25,50,74,0),(2616,' ',988,910,25,25,50,74,0),(2617,' ',312,208,25,25,50,74,0),(2618,' ',1014,806,25,25,50,74,0),(2619,' ',1170,572,25,25,50,74,0),(2620,' ',312,780,25,25,50,74,0),(2621,' ',1170,364,25,25,50,74,0),(2622,' ',1560,832,25,25,50,74,0),(2623,' ',1300,52,25,25,50,74,0),(2624,' ',364,130,25,25,50,74,0),(2625,' ',1508,208,25,25,50,74,0),(2626,' ',1898,26,25,25,50,74,0),(2627,' ',546,858,25,25,50,74,0),(2628,' ',1534,780,25,25,50,74,0),(2629,' ',962,104,25,25,50,74,0),(2630,' ',598,182,25,25,50,74,0),(2631,' ',1794,208,25,25,50,74,0),(2632,' ',1456,572,25,25,50,74,0),(2633,' ',156,286,25,25,50,74,0),(2634,' ',806,494,25,25,50,74,0),(2635,' ',1898,702,25,25,50,74,0),(2636,' ',52,234,25,25,50,74,0),(2637,' ',754,494,25,25,50,74,0),(2638,' ',312,468,25,25,50,74,0),(2639,' ',962,546,25,25,50,74,0),(2640,' ',1924,390,25,25,50,74,0),(2641,' ',1898,832,25,25,50,74,0),(2642,' ',1196,78,25,25,50,74,0),(2643,' ',1690,104,25,25,50,74,0),(2644,' ',728,806,25,25,50,74,0),(2645,' ',130,832,25,25,50,74,0),(2646,' ',858,364,25,25,50,74,0),(2647,' ',572,624,25,25,50,74,0),(2648,' ',702,390,25,25,50,74,0),(2649,' ',1534,182,25,25,50,74,0),(2650,' ',1274,572,25,25,50,74,0),(2651,' ',1170,520,25,25,50,74,0),(2652,' ',546,416,25,25,50,74,0),(2653,' ',1898,338,25,25,50,74,0),(2654,' ',312,260,25,25,50,74,0),(2655,' ',1118,754,25,25,50,74,0),(2656,' ',988,208,25,25,50,74,0),(2657,' ',1924,624,25,25,50,78,0),(2658,' ',1014,624,25,25,50,78,0),(2659,' ',1118,520,25,25,50,78,0),(2660,' ',442,806,25,25,50,78,0),(2661,' ',598,676,25,25,50,78,0),(2662,' ',104,26,25,25,50,78,0),(2663,' ',52,832,25,25,50,78,0),(2664,' ',442,390,25,25,50,78,0),(2665,' ',1768,312,25,25,50,78,0),(2666,' ',1768,442,25,25,50,78,0),(2667,' ',442,702,25,25,50,78,0),(2668,' ',208,286,25,25,50,78,0),(2669,' ',26,416,25,25,50,78,0),(2670,' ',1508,78,25,25,50,78,0),(2671,' ',988,390,25,25,50,78,0),(2672,' ',130,728,25,25,50,78,0),(2673,' ',1638,156,25,25,50,78,0),(2674,' ',910,754,25,25,50,78,0),(2675,' ',650,390,25,25,50,78,0),(2676,' ',676,702,25,25,50,78,0),(2677,' ',1872,728,25,25,50,78,0),(2678,' ',52,650,25,25,50,78,0),(2679,' ',104,364,25,25,50,78,0),(2680,' ',468,182,25,25,50,78,0),(2681,' ',910,208,25,25,50,78,0),(2682,' ',52,884,25,25,50,78,0),(2683,' ',1768,494,25,25,50,78,0),(2684,' ',1300,130,25,25,50,78,0),(2685,' ',1560,182,25,25,50,78,0),(2686,' ',1482,676,25,25,50,78,0),(2687,' ',1144,182,25,25,50,78,0),(2688,' ',1846,858,25,25,50,78,0),(2689,' ',624,312,25,25,50,78,0),(2690,' ',286,156,25,25,50,78,0),(2691,' ',936,624,25,25,50,78,0),(2692,' ',1872,442,25,25,50,78,0),(2693,' ',1586,182,25,25,50,78,0),(2694,' ',78,676,25,25,50,78,0),(2695,' ',1170,468,25,25,50,78,0),(2696,' ',78,286,25,25,50,78,0),(2697,' ',1716,754,25,25,50,78,0),(2698,' ',1794,338,25,25,50,78,0),(2699,' ',1924,676,25,25,50,78,0),(2700,' ',1716,390,25,25,50,78,0),(2701,' ',1144,806,25,25,50,78,0),(2702,' ',130,468,25,25,50,78,0),(2703,' ',910,104,25,25,50,78,0),(2704,' ',598,52,25,25,50,78,0),(2705,' ',858,832,25,25,50,78,0),(2706,' ',780,598,25,25,50,78,0);
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `housepopulation`
--

DROP TABLE IF EXISTS `housepopulation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `housepopulation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `percentage` double NOT NULL,
  `cityid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `city` (`cityid`),
  CONSTRAINT `city` FOREIGN KEY (`cityid`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=303 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `housepopulation`
--

LOCK TABLES `housepopulation` WRITE;
/*!40000 ALTER TABLE `housepopulation` DISABLE KEYS */;
INSERT INTO `housepopulation` VALUES (294,0,10,74),(295,1,10,74),(296,2,10,74),(297,3,10,74),(298,4,10,74),(299,5,10,74),(300,6,10,74),(301,7,10,74),(302,8,10,74);
/*!40000 ALTER TABLE `housepopulation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `human`
--

DROP TABLE IF EXISTS `human`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `human` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `age` int(10) NOT NULL,
  `houseid` int(100) NOT NULL,
  `religionid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKhuman948632` (`religionid`),
  KEY `FKhuman629750` (`houseid`),
  CONSTRAINT `FKhuman629750` FOREIGN KEY (`houseid`) REFERENCES `house` (`id`),
  CONSTRAINT `FKhuman948632` FOREIGN KEY (`religionid`) REFERENCES `religion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `human`
--

LOCK TABLES `human` WRITE;
/*!40000 ALTER TABLE `human` DISABLE KEYS */;
/*!40000 ALTER TABLE `human` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `human_human`
--

DROP TABLE IF EXISTS `human_human`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `human_human` (
  `humanid` int(100) NOT NULL,
  `humanid2` int(100) NOT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `date` varchar(255) NOT NULL,
  `time` varchar(255) NOT NULL,
  `city_modelscityid` int(100) NOT NULL,
  `city_modelsmodelsid` int(10) NOT NULL,
  PRIMARY KEY (`humanid`,`humanid2`),
  KEY `FKhuman_huma831855` (`humanid`),
  KEY `FKhuman_huma631157` (`city_modelscityid`,`city_modelsmodelsid`),
  KEY `FKhuman_huma392318` (`humanid2`),
  CONSTRAINT `FKhuman_huma392318` FOREIGN KEY (`humanid2`) REFERENCES `human` (`id`),
  CONSTRAINT `FKhuman_huma631157` FOREIGN KEY (`city_modelscityid`, `city_modelsmodelsid`) REFERENCES `city_models` (`cityid`, `modelsid`),
  CONSTRAINT `FKhuman_huma831855` FOREIGN KEY (`humanid`) REFERENCES `human` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `human_human`
--

LOCK TABLES `human_human` WRITE;
/*!40000 ALTER TABLE `human_human` DISABLE KEYS */;
/*!40000 ALTER TABLE `human_human` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humanage`
--

DROP TABLE IF EXISTS `humanage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humanage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `minAge` int(11) DEFAULT NULL,
  `maxAge` int(11) DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  `symptomId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `symptomId_idx` (`symptomId`),
  CONSTRAINT `symptomId` FOREIGN KEY (`symptomId`) REFERENCES `symptoms` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2041 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humanage`
--

LOCK TABLES `humanage` WRITE;
/*!40000 ALTER TABLE `humanage` DISABLE KEYS */;
INSERT INTO `humanage` VALUES (1993,'under 4',0,4,0,1844),(1994,'between 5 and 10',5,10,0,1844),(1995,'between 11 and 20',11,20,0,1844),(1996,'between 21 and 30',21,30,0,1844),(1997,'between 31 and 40',31,40,0,1844),(1998,'between 41 and 50',41,50,0,1844),(1999,'between 51 and 60',51,60,0,1844),(2000,'between 61 and 70',61,70,0,1844),(2001,'between 71 and 80',71,80,0,1844),(2002,'above 80',81,100,0,1844),(2003,'above 100',100,120,0,1844),(2004,'above 200',200,300,0,1844),(2005,'under 4',0,4,0,1845),(2006,'between 5 and 10',5,10,0,1845),(2007,'between 11 and 20',11,20,0,1845),(2008,'between 21 and 30',21,30,0,1845),(2009,'between 31 and 40',31,40,0,1845),(2010,'between 41 and 50',41,50,0,1845),(2011,'between 51 and 60',51,60,0,1845),(2012,'between 61 and 70',61,70,0,1845),(2013,'between 71 and 80',71,80,0,1845),(2014,'above 80',81,100,0,1845),(2015,'above 100',100,120,0,1845),(2016,'above 200',200,300,0,1845),(2017,'under 4',0,4,0,1846),(2018,'between 5 and 10',5,10,0,1846),(2019,'between 11 and 20',11,20,0,1846),(2020,'between 21 and 30',21,30,0,1846),(2021,'between 31 and 40',31,40,0,1846),(2022,'between 41 and 50',41,50,0,1846),(2023,'between 51 and 60',51,60,0,1846),(2024,'between 61 and 70',61,70,0,1846),(2025,'between 71 and 80',71,80,0,1846),(2026,'above 80',81,100,0,1846),(2027,'above 100',100,120,0,1846),(2028,'above 200',200,300,0,1846),(2029,'under 4',0,4,0,1847),(2030,'between 5 and 10',5,10,0,1847),(2031,'between 11 and 20',11,20,0,1847),(2032,'between 21 and 30',21,30,0,1847),(2033,'between 31 and 40',31,40,0,1847),(2034,'between 41 and 50',41,50,0,1847),(2035,'between 51 and 60',51,60,0,1847),(2036,'between 61 and 70',61,70,0,1847),(2037,'between 71 and 80',71,80,0,1847),(2038,'above 80',81,100,0,1847),(2039,'above 100',100,120,0,1847),(2040,'above 200',200,300,0,1847);
/*!40000 ALTER TABLE `humanage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humanagemodel`
--

DROP TABLE IF EXISTS `humanagemodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humanagemodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `minAge` int(11) DEFAULT NULL,
  `maxAge` int(11) DEFAULT NULL,
  `modelId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `modelId` (`modelId`),
  CONSTRAINT `humanagemodel_ibfk_1` FOREIGN KEY (`modelId`) REFERENCES `models` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=501 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humanagemodel`
--

LOCK TABLES `humanagemodel` WRITE;
/*!40000 ALTER TABLE `humanagemodel` DISABLE KEYS */;
INSERT INTO `humanagemodel` VALUES (489,'under 4',0,4,230),(490,'between 5 and 10',5,10,230),(491,'between 11 and 20',11,20,230),(492,'between 21 and 30',21,30,230),(493,'between 31 and 40',31,40,230),(494,'between 41 and 50',41,50,230),(495,'between 51 and 60',51,60,230),(496,'between 61 and 70',61,70,230),(497,'between 71 and 80',71,80,230),(498,'above 80',81,100,230),(499,'above 100',100,120,230),(500,'above 200',200,300,230);
/*!40000 ALTER TABLE `humanagemodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humanagename`
--

DROP TABLE IF EXISTS `humanagename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humanagename` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `minAge` int(11) DEFAULT NULL,
  `maxAge` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humanagename`
--

LOCK TABLES `humanagename` WRITE;
/*!40000 ALTER TABLE `humanagename` DISABLE KEYS */;
INSERT INTO `humanagename` VALUES (1,'under 4',0,4),(9,'between 5 and 10',5,10),(10,'between 11 and 20',11,20),(11,'between 21 and 30',21,30),(12,'between 31 and 40',31,40),(13,'between 41 and 50',41,50),(14,'between 51 and 60',51,60),(15,'between 61 and 70',61,70),(16,'between 71 and 80',71,80),(17,'above 80',81,100),(18,'above 100',100,120),(19,'above 200',200,300);
/*!40000 ALTER TABLE `humanagename` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humancityagetype`
--

DROP TABLE IF EXISTS `humancityagetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humancityagetype` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `minAge` int(10) NOT NULL,
  `maxAge` int(10) NOT NULL,
  `cityId` int(100) NOT NULL,
  `humanPercentage` double DEFAULT NULL,
  `placeNumber` int(11) DEFAULT NULL,
  `workPercentage` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKhumanCityA245940` (`cityId`),
  CONSTRAINT `FKhumanCityA245940` FOREIGN KEY (`cityId`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=425 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humancityagetype`
--

LOCK TABLES `humancityagetype` WRITE;
/*!40000 ALTER TABLE `humancityagetype` DISABLE KEYS */;
INSERT INTO `humancityagetype` VALUES (413,'under 4',0,4,74,5,1,0),(414,'between 5 and 10',5,10,74,10,2,0),(415,'between 11 and 20',11,20,74,10,3,5),(416,'between 21 and 30',21,30,74,15,3,30),(417,'between 31 and 40',31,40,74,14,4,70),(418,'between 41 and 50',41,50,74,12,2,60),(419,'between 51 and 60',51,60,74,13,4,50),(420,'between 61 and 70',61,70,74,12,2,40),(421,'between 71 and 80',71,80,74,10,1,10),(422,'above 80',81,100,74,5,0,0),(423,'above 100',100,120,74,0,0,0),(424,'above 200',200,300,74,0,0,0);
/*!40000 ALTER TABLE `humancityagetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humanstate`
--

DROP TABLE IF EXISTS `humanstate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humanstate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `colorName` varchar(50) DEFAULT NULL,
  `symptomStageId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `symptomStageId` (`symptomStageId`),
  CONSTRAINT `humanstate_ibfk_1` FOREIGN KEY (`symptomStageId`) REFERENCES `symptomstagesmodel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=464 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humanstate`
--

LOCK TABLES `humanstate` WRITE;
/*!40000 ALTER TABLE `humanstate` DISABLE KEYS */;
INSERT INTO `humanstate` VALUES (457,'Health','Green',985),(458,'Health','Green',986),(459,'Health','Green',987),(460,'Health','Green',988),(461,'Health','Green',989),(462,'Health','Green',990),(463,'Health','Green',991);
/*!40000 ALTER TABLE `humanstate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humanstatename`
--

DROP TABLE IF EXISTS `humanstatename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humanstatename` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humanstatename`
--

LOCK TABLES `humanstatename` WRITE;
/*!40000 ALTER TABLE `humanstatename` DISABLE KEYS */;
INSERT INTO `humanstatename` VALUES (1,'Health','Green'),(2,'Sick','Red');
/*!40000 ALTER TABLE `humanstatename` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locationcategories`
--

DROP TABLE IF EXISTS `locationcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locationcategories` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `cityid` int(100) NOT NULL,
  `kind` varchar(45) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `percentageToBeSick` double DEFAULT NULL,
  `openTime` int(11) DEFAULT NULL,
  `closeTime` int(11) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `fixed` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKlocationCa697528` (`cityid`),
  CONSTRAINT `FKlocationCa697528` FOREIGN KEY (`cityid`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locationcategories`
--

LOCK TABLES `locationcategories` WRITE;
/*!40000 ALTER TABLE `locationcategories` DISABLE KEYS */;
INSERT INTO `locationcategories` VALUES (73,'school',74,'School',2,50,7,14,'Monday ',1),(74,'house',74,'House',50,50,0,0,'',0),(75,'hospital',74,'Hospital',2,50,0,23,'Monday Friday Tuesday Saturday Wednesday Sunday Thursday ',1),(76,'university',74,'University',2,50,7,18,'Monday Tuesday Wednesday Thursday Friday ',1),(77,'restaurant',74,'Restaurant',2,50,9,22,'Monday Tuesday Wednesday Thursday Friday Saturday Sunday ',0),(78,'house1',74,'House',50,50,0,0,'',0),(81,'factory',74,'Factory',3,50,7,15,'Monday Tuesday Wednesday Thursday Friday ',0);
/*!40000 ALTER TABLE `locationcategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locationtogo`
--

DROP TABLE IF EXISTS `locationtogo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locationtogo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `percentage` double DEFAULT NULL,
  `ageId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ageId` (`ageId`),
  CONSTRAINT `locationtogo_ibfk_1` FOREIGN KEY (`ageId`) REFERENCES `humancityagetype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1645 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locationtogo`
--

LOCK TABLES `locationtogo` WRITE;
/*!40000 ALTER TABLE `locationtogo` DISABLE KEYS */;
INSERT INTO `locationtogo` VALUES (1561,'House',0,413),(1562,'University',0,413),(1563,'School',0,413),(1564,'Church',60,413),(1565,'Mosque',0,413),(1566,'Restaurant',5,413),(1567,'Shop',0,413),(1568,'House',0,414),(1569,'University',0,414),(1570,'School',80,414),(1571,'Church',70,414),(1572,'Mosque',70,414),(1573,'Restaurant',10,414),(1574,'Shop',6,414),(1575,'House',0,415),(1576,'University',10,415),(1577,'School',70,415),(1578,'Church',70,415),(1579,'Mosque',70,415),(1580,'Restaurant',20,415),(1581,'Shop',30,415),(1582,'House',0,416),(1583,'University',60,416),(1584,'School',0,416),(1585,'Church',70,416),(1586,'Mosque',70,416),(1587,'Restaurant',60,416),(1588,'Shop',10,416),(1589,'House',0,417),(1590,'University',3,417),(1591,'School',0,417),(1592,'Church',60,417),(1593,'Mosque',60,417),(1594,'Restaurant',40,417),(1595,'Shop',40,417),(1596,'House',0,418),(1597,'University',4,418),(1598,'School',0,418),(1599,'Church',50,418),(1600,'Mosque',50,418),(1601,'Restaurant',50,418),(1602,'Shop',80,418),(1603,'House',0,419),(1604,'University',2,419),(1605,'School',0,419),(1606,'Church',60,419),(1607,'Mosque',60,419),(1608,'Restaurant',50,419),(1609,'Shop',40,419),(1610,'House',0,420),(1611,'University',3,420),(1612,'School',0,420),(1613,'Church',50,420),(1614,'Mosque',50,420),(1615,'Restaurant',40,420),(1616,'Shop',20,420),(1617,'House',0,421),(1618,'University',0,421),(1619,'School',0,421),(1620,'Church',80,421),(1621,'Mosque',80,421),(1622,'Restaurant',20,421),(1623,'Shop',20,421),(1624,'House',0,422),(1625,'University',0,422),(1626,'School',0,422),(1627,'Church',20,422),(1628,'Mosque',20,422),(1629,'Restaurant',10,422),(1630,'Shop',10,422),(1631,'House',0,423),(1632,'University',0,423),(1633,'School',0,423),(1634,'Church',0,423),(1635,'Mosque',0,423),(1636,'Restaurant',0,423),(1637,'Shop',0,423),(1638,'House',0,424),(1639,'University',0,424),(1640,'School',0,424),(1641,'Church',0,424),(1642,'Mosque',0,424),(1643,'Restaurant',0,424),(1644,'Shop',0,424);
/*!40000 ALTER TABLE `locationtogo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locationtogocity`
--

DROP TABLE IF EXISTS `locationtogocity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `locationtogocity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `cityId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cityId` (`cityId`),
  CONSTRAINT `locationtogocity_ibfk_1` FOREIGN KEY (`cityId`) REFERENCES `cities` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locationtogocity`
--

LOCK TABLES `locationtogocity` WRITE;
/*!40000 ALTER TABLE `locationtogocity` DISABLE KEYS */;
INSERT INTO `locationtogocity` VALUES (126,'House',74),(127,'Univerity',74),(128,'School',74),(129,'Church',74),(130,'Mosque',74),(131,'Restaurant',74),(132,'Shop',74);
/*!40000 ALTER TABLE `locationtogocity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `models`
--

DROP TABLE IF EXISTS `models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `models` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `ismain` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=231 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
INSERT INTO `models` VALUES (230,'first model',1);
/*!40000 ALTER TABLE `models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mosque`
--

DROP TABLE IF EXISTS `mosque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mosque` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` double NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `openTime` int(11) DEFAULT NULL,
  `closeTime` int(11) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKmosque115888` (`locationCategoryId`),
  CONSTRAINT `FKmosque115888` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mosque`
--

LOCK TABLES `mosque` WRITE;
/*!40000 ALTER TABLE `mosque` DISABLE KEYS */;
/*!40000 ALTER TABLE `mosque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `populationtype`
--

DROP TABLE IF EXISTS `populationtype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `populationtype` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `populationtype`
--

LOCK TABLES `populationtype` WRITE;
/*!40000 ALTER TABLE `populationtype` DISABLE KEYS */;
/*!40000 ALTER TABLE `populationtype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refugeecamp`
--

DROP TABLE IF EXISTS `refugeecamp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refugeecamp` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` double NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `openTime` double DEFAULT NULL,
  `closeTime` double DEFAULT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKrefugeeCam303271` (`locationCategoryId`),
  CONSTRAINT `FKrefugeeCam303271` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refugeecamp`
--

LOCK TABLES `refugeecamp` WRITE;
/*!40000 ALTER TABLE `refugeecamp` DISABLE KEYS */;
/*!40000 ALTER TABLE `refugeecamp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `religion`
--

DROP TABLE IF EXISTS `religion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `religion` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `religion`
--

LOCK TABLES `religion` WRITE;
/*!40000 ALTER TABLE `religion` DISABLE KEYS */;
/*!40000 ALTER TABLE `religion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `religionname`
--

DROP TABLE IF EXISTS `religionname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `religionname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `prayLoc` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `religionname`
--

LOCK TABLES `religionname` WRITE;
/*!40000 ALTER TABLE `religionname` DISABLE KEYS */;
INSERT INTO `religionname` VALUES (5,'Christian','Church'),(6,'Muslem','Mosque'),(7,'Hello','Item 2');
/*!40000 ALTER TABLE `religionname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `religiontype`
--

DROP TABLE IF EXISTS `religiontype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `religiontype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `percentage` double NOT NULL,
  `cityid` int(11) DEFAULT NULL,
  `prayPlace` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cityid_idx` (`cityid`),
  CONSTRAINT `cityid` FOREIGN KEY (`cityid`) REFERENCES `cities` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `religiontype`
--

LOCK TABLES `religiontype` WRITE;
/*!40000 ALTER TABLE `religiontype` DISABLE KEYS */;
INSERT INTO `religiontype` VALUES (115,'Christian',33,74,'Church'),(116,'Muslem',33,74,'Mosque'),(117,'Hello',33,74,'Item 2');
/*!40000 ALTER TABLE `religiontype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant`
--

DROP TABLE IF EXISTS `restaurant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` int(10) NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `openTime` int(11) DEFAULT NULL,
  `closeTime` int(11) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKrestaurant728323` (`locationCategoryId`),
  CONSTRAINT `FKrestaurant728323` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant`
--

LOCK TABLES `restaurant` WRITE;
/*!40000 ALTER TABLE `restaurant` DISABLE KEYS */;
INSERT INTO `restaurant` VALUES (3,' ',676,286,50,50,50,77,9,22,'Monday Tuesday Wednesday Thursday Friday Saturday Sunday ',0),(4,' ',780,390,50,50,50,77,9,22,'Monday Tuesday Wednesday Thursday Friday Saturday Sunday ',0);
/*!40000 ALTER TABLE `restaurant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` double NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `openTime` int(11) DEFAULT NULL,
  `closeTime` int(11) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKschool752875` (`locationCategoryId`),
  CONSTRAINT `FKschool752875` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (28,' ',1638,416,50,50,50,73,7,14,'Monday',1),(29,' ',1456,416,50,50,50,73,7,14,'Monday ',1);
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexetypes`
--

DROP TABLE IF EXISTS `sexetypes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sexetypes` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `percentage` double NOT NULL,
  `modelId` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `id` (`id`),
  KEY `FKsexeTypes607371` (`modelId`),
  CONSTRAINT `FKsexeTypes607371` FOREIGN KEY (`modelId`) REFERENCES `models` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexetypes`
--

LOCK TABLES `sexetypes` WRITE;
/*!40000 ALTER TABLE `sexetypes` DISABLE KEYS */;
/*!40000 ALTER TABLE `sexetypes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shop` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` double NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `openTime` int(11) DEFAULT NULL,
  `closeTime` int(11) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKshop244634` (`locationCategoryId`),
  CONSTRAINT `FKshop244634` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supermarket`
--

DROP TABLE IF EXISTS `supermarket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supermarket` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` double NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `openTime` int(11) DEFAULT NULL,
  `closeTime` int(11) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKsuperMarke456250` (`locationCategoryId`),
  CONSTRAINT `FKsuperMarke456250` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supermarket`
--

LOCK TABLES `supermarket` WRITE;
/*!40000 ALTER TABLE `supermarket` DISABLE KEYS */;
/*!40000 ALTER TABLE `supermarket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `symptomname`
--

DROP TABLE IF EXISTS `symptomname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `symptomname` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `symptomname`
--

LOCK TABLES `symptomname` WRITE;
/*!40000 ALTER TABLE `symptomname` DISABLE KEYS */;
INSERT INTO `symptomname` VALUES (1,'No Symptom'),(2,'Mild symptoms'),(3,'Severe Symptoms'),(14,'critical Symptoms');
/*!40000 ALTER TABLE `symptomname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `symptoms`
--

DROP TABLE IF EXISTS `symptoms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `symptoms` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `contagiousDay` int(10) DEFAULT NULL,
  `modelId` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKsymptoms228602` (`modelId`),
  CONSTRAINT `FKsymptoms228602` FOREIGN KEY (`modelId`) REFERENCES `models` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1848 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `symptoms`
--

LOCK TABLES `symptoms` WRITE;
/*!40000 ALTER TABLE `symptoms` DISABLE KEYS */;
INSERT INTO `symptoms` VALUES (1844,'No Symptom',0,230),(1845,'Mild symptoms',0,230),(1846,'Severe Symptoms',0,230),(1847,'critical Symptoms',0,230);
/*!40000 ALTER TABLE `symptoms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `symptomstagename`
--

DROP TABLE IF EXISTS `symptomstagename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `symptomstagename` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `symptomstagename`
--

LOCK TABLES `symptomstagename` WRITE;
/*!40000 ALTER TABLE `symptomstagename` DISABLE KEYS */;
INSERT INTO `symptomstagename` VALUES (1,'No symptoms'),(2,'Mild symptoms'),(3,'Severe symptoms'),(4,'Hospitalization'),(5,'Icu'),(6,'Dead'),(9,'critical');
/*!40000 ALTER TABLE `symptomstagename` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `symptomstages`
--

DROP TABLE IF EXISTS `symptomstages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `symptomstages` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `day` int(10) DEFAULT NULL,
  `deathPercentage` double DEFAULT NULL,
  `immunePercentage` int(10) DEFAULT NULL,
  `symptomId` int(10) NOT NULL,
  `col` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKsymptomSta671993` (`symptomId`),
  CONSTRAINT `FKsymptomSta671993` FOREIGN KEY (`symptomId`) REFERENCES `symptoms` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11949 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `symptomstages`
--

LOCK TABLES `symptomstages` WRITE;
/*!40000 ALTER TABLE `symptomstages` DISABLE KEYS */;
INSERT INTO `symptomstages` VALUES (11921,'No symptoms',0,0,0,1844,0),(11922,'Mild symptoms',0,0,0,1844,0),(11923,'Severe symptoms',0,0,0,1844,0),(11924,'Hospitalization',0,0,0,1844,0),(11925,'Icu',0,0,0,1844,0),(11926,'Dead',0,0,0,1844,0),(11927,'critical',0,0,0,1844,0),(11928,'No symptoms',0,0,0,1845,0),(11929,'Mild symptoms',0,0,0,1845,0),(11930,'Severe symptoms',0,0,0,1845,0),(11931,'Hospitalization',0,0,0,1845,0),(11932,'Icu',0,0,0,1845,0),(11933,'Dead',0,0,0,1845,0),(11934,'critical',0,0,0,1845,0),(11935,'No symptoms',0,0,0,1846,0),(11936,'Mild symptoms',0,0,0,1846,0),(11937,'Severe symptoms',0,0,0,1846,0),(11938,'Hospitalization',0,0,0,1846,0),(11939,'Icu',0,0,0,1846,0),(11940,'Dead',0,0,0,1846,0),(11941,'critical',0,0,0,1846,0),(11942,'No symptoms',0,0,0,1847,0),(11943,'Mild symptoms',0,0,0,1847,0),(11944,'Severe symptoms',0,0,0,1847,0),(11945,'Hospitalization',0,0,0,1847,0),(11946,'Icu',0,0,0,1847,0),(11947,'Dead',0,0,0,1847,0),(11948,'critical',0,0,0,1847,0);
/*!40000 ALTER TABLE `symptomstages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `symptomstagesmodel`
--

DROP TABLE IF EXISTS `symptomstagesmodel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `symptomstagesmodel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `immunePercentage` double DEFAULT NULL,
  `deathPercentage` double DEFAULT NULL,
  `modelId` int(11) DEFAULT NULL,
  `col` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `modelId_idx` (`modelId`),
  CONSTRAINT `modelId` FOREIGN KEY (`modelId`) REFERENCES `models` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=992 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `symptomstagesmodel`
--

LOCK TABLES `symptomstagesmodel` WRITE;
/*!40000 ALTER TABLE `symptomstagesmodel` DISABLE KEYS */;
INSERT INTO `symptomstagesmodel` VALUES (985,'No symptoms',0,0,230,0),(986,'Mild symptoms',0,0,230,1),(987,'Severe symptoms',0,0,230,2),(988,'Hospitalization',0,0,230,3),(989,'Icu',0,0,230,4),(990,'Dead',0,0,230,5),(991,'critical',0,0,230,6);
/*!40000 ALTER TABLE `symptomstagesmodel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `university`
--

DROP TABLE IF EXISTS `university`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `university` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `x` int(10) NOT NULL,
  `y` int(10) NOT NULL,
  `width` int(10) NOT NULL,
  `height` int(10) NOT NULL,
  `sickPercentage` double NOT NULL,
  `locationCategoryId` int(10) NOT NULL,
  `openTime` int(11) DEFAULT NULL,
  `closeTime` int(11) DEFAULT NULL,
  `days` varchar(200) DEFAULT NULL,
  `fixed` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKuniversity445896` (`locationCategoryId`),
  CONSTRAINT `FKuniversity445896` FOREIGN KEY (`locationCategoryId`) REFERENCES `locationcategories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `university`
--

LOCK TABLES `university` WRITE;
/*!40000 ALTER TABLE `university` DISABLE KEYS */;
INSERT INTO `university` VALUES (16,' ',884,442,75,75,50,76,7,18,'Monday Tuesday Wednesday Thursday Friday ',1),(17,' ',806,182,75,75,50,76,7,18,'Monday Tuesday Wednesday Thursday Friday ',1);
/*!40000 ALTER TABLE `university` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-12  9:51:42
