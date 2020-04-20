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
  `cityid` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKchurch853019` (`cityid`),
  CONSTRAINT `FKchurch853019` FOREIGN KEY (`cityid`) REFERENCES `city` (`id`)
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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `populationNumber` int(10) NOT NULL,
  `countryid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKcity428336` (`countryid`),
  CONSTRAINT `FKcity428336` FOREIGN KEY (`countryid`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
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
  KEY `FKcity_model319136` (`cityid`),
  KEY `FKcity_model582739` (`modelsid`),
  CONSTRAINT `FKcity_model319136` FOREIGN KEY (`cityid`) REFERENCES `city` (`id`),
  CONSTRAINT `FKcity_model582739` FOREIGN KEY (`modelsid`) REFERENCES `models` (`id`)
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
-- Table structure for table `contagiousday`
--

DROP TABLE IF EXISTS `contagiousday`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contagiousday` (
  `symptomsid` int(10) NOT NULL,
  `modelsid` int(10) NOT NULL,
  `dayNumber` int(10) NOT NULL,
  PRIMARY KEY (`symptomsid`,`modelsid`),
  KEY `FKcontagious716136` (`symptomsid`),
  KEY `FKcontagious857981` (`modelsid`),
  CONSTRAINT `FKcontagious716136` FOREIGN KEY (`symptomsid`) REFERENCES `symptoms` (`id`),
  CONSTRAINT `FKcontagious857981` FOREIGN KEY (`modelsid`) REFERENCES `models` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contagiousday`
--

LOCK TABLES `contagiousday` WRITE;
/*!40000 ALTER TABLE `contagiousday` DISABLE KEYS */;
/*!40000 ALTER TABLE `contagiousday` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
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
  `cityid` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKdisplaceme874861` (`cityid`),
  CONSTRAINT `FKdisplaceme874861` FOREIGN KEY (`cityid`) REFERENCES `city` (`id`)
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
  `cityid` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKhospital709366` (`cityid`),
  CONSTRAINT `FKhospital709366` FOREIGN KEY (`cityid`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
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
  `cityid` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKhouse611133` (`cityid`),
  CONSTRAINT `FKhouse611133` FOREIGN KEY (`cityid`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `house`
--

LOCK TABLES `house` WRITE;
/*!40000 ALTER TABLE `house` DISABLE KEYS */;
/*!40000 ALTER TABLE `house` ENABLE KEYS */;
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
-- Table structure for table `humanagetype`
--

DROP TABLE IF EXISTS `humanagetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humanagetype` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `minAge` int(10) NOT NULL,
  `maxAge` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humanagetype`
--

LOCK TABLES `humanagetype` WRITE;
/*!40000 ALTER TABLE `humanagetype` DISABLE KEYS */;
/*!40000 ALTER TABLE `humanagetype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humanagetype_models`
--

DROP TABLE IF EXISTS `humanagetype_models`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humanagetype_models` (
  `humanAgeTypeid` int(10) NOT NULL,
  `modelsid` int(10) NOT NULL,
  `percentage` double NOT NULL,
  PRIMARY KEY (`humanAgeTypeid`,`modelsid`),
  KEY `FKhumanAgeTy449016` (`humanAgeTypeid`),
  KEY `FKhumanAgeTy917263` (`modelsid`),
  CONSTRAINT `FKhumanAgeTy449016` FOREIGN KEY (`humanAgeTypeid`) REFERENCES `humanagetype` (`id`),
  CONSTRAINT `FKhumanAgeTy917263` FOREIGN KEY (`modelsid`) REFERENCES `models` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humanagetype_models`
--

LOCK TABLES `humanagetype_models` WRITE;
/*!40000 ALTER TABLE `humanagetype_models` DISABLE KEYS */;
/*!40000 ALTER TABLE `humanagetype_models` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humanagetypedeathpercentage`
--

DROP TABLE IF EXISTS `humanagetypedeathpercentage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humanagetypedeathpercentage` (
  `modelsid` int(10) NOT NULL,
  `humanAgeTypeid` int(10) NOT NULL,
  `percentage` double NOT NULL,
  PRIMARY KEY (`modelsid`,`humanAgeTypeid`),
  KEY `FKhumanAgeTy914540` (`modelsid`),
  KEY `FKhumanAgeTy446293` (`humanAgeTypeid`),
  CONSTRAINT `FKhumanAgeTy446293` FOREIGN KEY (`humanAgeTypeid`) REFERENCES `humanagetype` (`id`),
  CONSTRAINT `FKhumanAgeTy914540` FOREIGN KEY (`modelsid`) REFERENCES `models` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humanagetypedeathpercentage`
--

LOCK TABLES `humanagetypedeathpercentage` WRITE;
/*!40000 ALTER TABLE `humanagetypedeathpercentage` DISABLE KEYS */;
/*!40000 ALTER TABLE `humanagetypedeathpercentage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `humandeathpercetage`
--

DROP TABLE IF EXISTS `humandeathpercetage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `humandeathpercetage` (
  `symptomsid` int(10) NOT NULL,
  `modelsid` int(10) NOT NULL,
  `percentage` double DEFAULT NULL,
  PRIMARY KEY (`symptomsid`,`modelsid`),
  KEY `FKhumanDeath919699` (`symptomsid`),
  KEY `FKhumanDeath777854` (`modelsid`),
  CONSTRAINT `FKhumanDeath777854` FOREIGN KEY (`modelsid`) REFERENCES `models` (`id`),
  CONSTRAINT `FKhumanDeath919699` FOREIGN KEY (`symptomsid`) REFERENCES `symptoms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `humandeathpercetage`
--

LOCK TABLES `humandeathpercetage` WRITE;
/*!40000 ALTER TABLE `humandeathpercetage` DISABLE KEYS */;
/*!40000 ALTER TABLE `humandeathpercetage` ENABLE KEYS */;
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
  `stayHomePercentage` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `models`
--

LOCK TABLES `models` WRITE;
/*!40000 ALTER TABLE `models` DISABLE KEYS */;
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
  `cityid` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKmosque549481` (`cityid`),
  CONSTRAINT `FKmosque549481` FOREIGN KEY (`cityid`) REFERENCES `city` (`id`)
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
  `cityid` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKrefugeeCam2950` (`cityid`),
  CONSTRAINT `FKrefugeeCam2950` FOREIGN KEY (`cityid`) REFERENCES `city` (`id`)
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
  `cityid` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKschool912493` (`cityid`),
  CONSTRAINT `FKschool912493` FOREIGN KEY (`cityid`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
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
  `cityid` int(100) NOT NULL,
  `shopTypeid` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKshop20247` (`shopTypeid`),
  KEY `FKshop550855` (`cityid`),
  CONSTRAINT `FKshop20247` FOREIGN KEY (`shopTypeid`) REFERENCES `shoptype` (`id`),
  CONSTRAINT `FKshop550855` FOREIGN KEY (`cityid`) REFERENCES `city` (`id`)
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
-- Table structure for table `shoptype`
--

DROP TABLE IF EXISTS `shoptype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shoptype` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoptype`
--

LOCK TABLES `shoptype` WRITE;
/*!40000 ALTER TABLE `shoptype` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoptype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sympomstages`
--

DROP TABLE IF EXISTS `sympomstages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sympomstages` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sympomstages`
--

LOCK TABLES `sympomstages` WRITE;
/*!40000 ALTER TABLE `sympomstages` DISABLE KEYS */;
/*!40000 ALTER TABLE `sympomstages` ENABLE KEYS */;
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `symptoms`
--

LOCK TABLES `symptoms` WRITE;
/*!40000 ALTER TABLE `symptoms` DISABLE KEYS */;
/*!40000 ALTER TABLE `symptoms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `symptoms_sympomstages`
--

DROP TABLE IF EXISTS `symptoms_sympomstages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `symptoms_sympomstages` (
  `symptomsid` int(10) NOT NULL,
  `sympomStagesid` int(10) NOT NULL,
  `modelsid` int(10) NOT NULL,
  `day` int(10) NOT NULL,
  PRIMARY KEY (`symptomsid`,`sympomStagesid`),
  KEY `FKsymptoms_s312348` (`symptomsid`),
  KEY `FKsymptoms_s170503` (`modelsid`),
  KEY `FKsymptoms_s666300` (`sympomStagesid`),
  CONSTRAINT `FKsymptoms_s170503` FOREIGN KEY (`modelsid`) REFERENCES `models` (`id`),
  CONSTRAINT `FKsymptoms_s312348` FOREIGN KEY (`symptomsid`) REFERENCES `symptoms` (`id`),
  CONSTRAINT `FKsymptoms_s666300` FOREIGN KEY (`sympomStagesid`) REFERENCES `sympomstages` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `symptoms_sympomstages`
--

LOCK TABLES `symptoms_sympomstages` WRITE;
/*!40000 ALTER TABLE `symptoms_sympomstages` DISABLE KEYS */;
/*!40000 ALTER TABLE `symptoms_sympomstages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `symptomsdistributionpercentage`
--

DROP TABLE IF EXISTS `symptomsdistributionpercentage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `symptomsdistributionpercentage` (
  `symptomsid` int(10) NOT NULL,
  `modelsid` int(10) NOT NULL,
  `percentage` double NOT NULL,
  PRIMARY KEY (`symptomsid`,`modelsid`),
  KEY `FKsymptomsDi868022` (`symptomsid`),
  KEY `FKsymptomsDi726177` (`modelsid`),
  CONSTRAINT `FKsymptomsDi726177` FOREIGN KEY (`modelsid`) REFERENCES `models` (`id`),
  CONSTRAINT `FKsymptomsDi868022` FOREIGN KEY (`symptomsid`) REFERENCES `symptoms` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `symptomsdistributionpercentage`
--

LOCK TABLES `symptomsdistributionpercentage` WRITE;
/*!40000 ALTER TABLE `symptomsdistributionpercentage` DISABLE KEYS */;
/*!40000 ALTER TABLE `symptomsdistributionpercentage` ENABLE KEYS */;
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
  `cityid` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `FKuniversity752117` (`cityid`),
  CONSTRAINT `FKuniversity752117` FOREIGN KEY (`cityid`) REFERENCES `city` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `university`
--

LOCK TABLES `university` WRITE;
/*!40000 ALTER TABLE `university` DISABLE KEYS */;
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

-- Dump completed on 2020-04-20 11:22:53
