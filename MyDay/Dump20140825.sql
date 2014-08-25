CREATE DATABASE  IF NOT EXISTS `myday` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `myday`;
-- MySQL dump 10.13  Distrib 5.5.38, for debian-linux-gnu (i686)
--
-- Host: 127.0.0.1    Database: myday
-- ------------------------------------------------------
-- Server version	5.5.38-0ubuntu0.14.04.1

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
-- Table structure for table `POSTS`
--

DROP TABLE IF EXISTS `POSTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `POSTS` (
  `POST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(250) DEFAULT NULL,
  `CREATED` datetime DEFAULT NULL,
  `LAST_MODIFIED` datetime DEFAULT NULL,
  `AUTHOR` int(11) DEFAULT NULL,
  `BODY` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`POST_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `POSTS`
--

LOCK TABLES `POSTS` WRITE;
/*!40000 ALTER TABLE `POSTS` DISABLE KEYS */;
INSERT INTO `POSTS` VALUES (4,'Japan landslide','2014-08-23 10:19:17',NULL,2,'Rescuers have been searching desperately for survivors in Japan\'s Hiroshima prefecture where a landslide killed at least 42 people.\r\n\r\nAt least 43 others are missing, officials told the Kyodo news agency.\r\n\r\nPolice quoted by the agency say that more people could be unaccounted for, buried by mudslides and not yet reported as missing.\r\n\r\nAbout 3,000 rescue personnel have been trying to remove mud and debris hampering the search.\r\n\r\nTorrential rains have led to the evacuation of up to 100,000 people.\r\n\r\nExperts say the chances of survival for people trapped without food or water in such a disaster decreases significantly after the first 72 hours, which passed early on Saturday.'),(5,'Japan landslide','2014-08-23 10:19:22',NULL,3,'Rescuers have been searching desperately for survivors in Japan\'s Hiroshima prefecture where a landslide killed at least 42 people.\r\n\r\nAt least 43 others are missing, officials told the Kyodo news agency.\r\n\r\nPolice quoted by the agency say that more people could be unaccounted for, buried by mudslides and not yet reported as missing.\r\n\r\nAbout 3,000 rescue personnel have been trying to remove mud and debris hampering the search.\r\n\r\nTorrential rains have led to the evacuation of up to 100,000 people.\r\n\r\nExperts say the chances of survival for people trapped without food or water in such a disaster decreases significantly after the first 72 hours, which passed early on Saturday.'),(6,'Japan landslide','2014-08-23 10:19:26',NULL,1,'Rescuers have been searching desperately for survivors in Japan\'s Hiroshima prefecture where a landslide killed at least 42 people.\r\n\r\nAt least 43 others are missing, officials told the Kyodo news agency.\r\n\r\nPolice quoted by the agency say that more people could be unaccounted for, buried by mudslides and not yet reported as missing.\r\n\r\nAbout 3,000 rescue personnel have been trying to remove mud and debris hampering the search.\r\n\r\nTorrential rains have led to the evacuation of up to 100,000 people.\r\n\r\nExperts say the chances of survival for people trapped without food or water in such a disaster decreases significantly after the first 72 hours, which passed early on Saturday.'),(7,'NSA and GCHQ agents \'leak Tor bugs\'','2014-08-23 10:20:07',NULL,1,'British and American intelligence agents attempting to hack the \"dark web\" are being deliberately undermined by colleagues, it has been alleged.\r\n\r\nSpies from both countries have been working on finding flaws in Tor, a popular way of anonymously accessing \"hidden\" sites.\r\n\r\nBut the team behind Tor says other spies are tipping them off, allowing them to quickly fix any vulnerabilities.\r\n\r\nThe agencies declined to comment.\r\n\r\nThe allegations were made in an interview given to the BBC by Andrew Lewman, who is responsible for all the Tor Project\'s operations.\r\n\r\nHe said leaks had come from both the UK Government Communications Headquarters (GCHQ) and the US National Security Agency (NSA).\r\n\r\nBy fixing these flaws, the project can protect users\' anonymity, he said.'),(8,'NSA and GCHQ agents \'leak Tor bugs\'','2014-08-23 10:20:11',NULL,2,'British and American intelligence agents attempting to hack the \"dark web\" are being deliberately undermined by colleagues, it has been alleged.\r\n\r\nSpies from both countries have been working on finding flaws in Tor, a popular way of anonymously accessing \"hidden\" sites.\r\n\r\nBut the team behind Tor says other spies are tipping them off, allowing them to quickly fix any vulnerabilities.\r\n\r\nThe agencies declined to comment.\r\n\r\nThe allegations were made in an interview given to the BBC by Andrew Lewman, who is responsible for all the Tor Project\'s operations.\r\n\r\nHe said leaks had come from both the UK Government Communications Headquarters (GCHQ) and the US National Security Agency (NSA).\r\n\r\nBy fixing these flaws, the project can protect users\' anonymity, he said.'),(9,'NSA and GCHQ agents \'leak Tor bugs\'','2014-08-23 10:20:14',NULL,3,'British and American intelligence agents attempting to hack the \"dark web\" are being deliberately undermined by colleagues, it has been alleged.\r\n\r\nSpies from both countries have been working on finding flaws in Tor, a popular way of anonymously accessing \"hidden\" sites.\r\n\r\nBut the team behind Tor says other spies are tipping them off, allowing them to quickly fix any vulnerabilities.\r\n\r\nThe agencies declined to comment.\r\n\r\nThe allegations were made in an interview given to the BBC by Andrew Lewman, who is responsible for all the Tor Project\'s operations.\r\n\r\nHe said leaks had come from both the UK Government Communications Headquarters (GCHQ) and the US National Security Agency (NSA).\r\n\r\nBy fixing these flaws, the project can protect users\' anonymity, he said.'),(10,'Gmail smartphone app hacked by researchers','2014-08-23 10:20:51',NULL,3,'US researchers say they have been able to hack into Gmail accounts with a 92% success rate by exploiting a weakness in smartphone memory.\r\n\r\nThe researchers were able to gain access to a number of apps, including Gmail, by disguising malicious software as another downloaded app.\r\n\r\nGmail was among the easiest to access from the popular apps tested.\r\n\r\nThe hack was tested on an Android phone, but the researchers believe it could work on other operating systems.\r\n\r\nA Google spokeswoman said the technology giant welcomed the research. \"Third-party research is one of the ways Android is made stronger and more secure,\" she said.\r\n\r\nThe research is being presented later at a cybersecurity conference in San Diego by academics from the universities of Michigan and California.\r\n\r\nOther apps hacked included H&R Block, Newegg, WebMD, Chase Bank, Hotels.com and Amazon.');
/*!40000 ALTER TABLE `POSTS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-08-25  8:55:53
