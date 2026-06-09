-- MySQL dump 10.13  Distrib 8.4.9, for Win64 (x86_64)
--
-- Host: localhost    Database: mbasic
-- ------------------------------------------------------
-- Server version	8.4.9

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alter_coffee2`
--

DROP TABLE IF EXISTS `alter_coffee2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alter_coffee2` (
  `cno` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cprice` int NOT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alter_coffee2`
--

LOCK TABLES `alter_coffee2` WRITE;
/*!40000 ALTER TABLE `alter_coffee2` DISABLE KEYS */;
/*!40000 ALTER TABLE `alter_coffee2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atest`
--

DROP TABLE IF EXISTS `atest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `atest` (
  `num` bigint NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atest`
--

LOCK TABLES `atest` WRITE;
/*!40000 ALTER TABLE `atest` DISABLE KEYS */;
INSERT INTO `atest` VALUES (1),(2),(3),(4),(5),(6);
/*!40000 ALTER TABLE `atest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `auth` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('first@gmail.com','ROLE_MEMBER'),('aaa@aaa.com','ROLE_MEMBER'),('aaa@aaa.com','ROLE_ADMIN'),('a@a','ROLE_MEMBER'),('a@a','ROLE_ADMIN'),('b@b','ROLE_MEMBER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coffee`
--

DROP TABLE IF EXISTS `coffee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coffee` (
  `cno` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cprice` int NOT NULL,
  PRIMARY KEY (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coffee`
--

LOCK TABLES `coffee` WRITE;
/*!40000 ALTER TABLE `coffee` DISABLE KEYS */;
/*!40000 ALTER TABLE `coffee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `control`
--

DROP TABLE IF EXISTS `control`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `control` (
  `no` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `control`
--

LOCK TABLES `control` WRITE;
/*!40000 ALTER TABLE `control` DISABLE KEYS */;
INSERT INTO `control` VALUES (1),(2),(3);
/*!40000 ALTER TABLE `control` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `date_userinfo`
--

DROP TABLE IF EXISTS `date_userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `date_userinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `date_userinfo`
--

LOCK TABLES `date_userinfo` WRITE;
/*!40000 ALTER TABLE `date_userinfo` DISABLE KEYS */;
INSERT INTO `date_userinfo` VALUES (1,'aaa',11,'2022-12-30 00:00:00'),(2,'bbb',22,'2022-11-30 00:00:00'),(3,'ccc',33,'2022-10-30 00:00:00'),(4,'ddd',44,'2022-09-30 00:00:00');
/*!40000 ALTER TABLE `date_userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delete_emp`
--

DROP TABLE IF EXISTS `delete_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delete_emp` (
  `empno` int NOT NULL DEFAULT '0',
  `ename` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `job` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mgr` int DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` int DEFAULT NULL,
  `comm` int DEFAULT NULL,
  `dept` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delete_emp`
--

LOCK TABLES `delete_emp` WRITE;
/*!40000 ALTER TABLE `delete_emp` DISABLE KEYS */;
/*!40000 ALTER TABLE `delete_emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept`
--

DROP TABLE IF EXISTS `dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept` (
  `deptno` int NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `loc` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept`
--

LOCK TABLES `dept` WRITE;
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
INSERT INTO `dept` VALUES (10,'ACCOUNTING','NEW YORK'),(20,'RESEARCH','DALLAS'),(30,'SALES','CHICAGO'),(40,'OPERATIONS','BOSTON');
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp`
--

DROP TABLE IF EXISTS `emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp` (
  `empno` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `job` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mgr` int DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` int DEFAULT NULL,
  `comm` int DEFAULT NULL,
  `deptno` int DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB AUTO_INCREMENT=7936 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp`
--

LOCK TABLES `emp` WRITE;
/*!40000 ALTER TABLE `emp` DISABLE KEYS */;
INSERT INTO `emp` VALUES (7369,'SMITH','CLERK',7902,'1980-12-17',800,NULL,20),(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30),(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,500,30),(7566,'JONES','MANAGER',7839,'1981-04-02',2975,NULL,20),(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,1400,30),(7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,NULL,30),(7782,'CLARK','MANAGER',7839,'1981-06-09',2450,NULL,10),(7788,'SCOTT','ANALYST',7566,'1987-04-19',3000,NULL,20),(7839,'KING','PRESIDENT',NULL,'1981-11-17',5000,NULL,10),(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30),(7876,'ADAMS','CLERK',7788,'1987-05-23',1100,NULL,20),(7900,'JAMES','CLERK',7698,'1981-12-03',950,NULL,30),(7902,'FORD','ANALYST',7566,'1981-12-03',3000,NULL,20),(7934,'MILLER','CLERK',7782,'1982-01-23',1300,NULL,10);
/*!40000 ALTER TABLE `emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fn_select_userinfo2`
--

DROP TABLE IF EXISTS `fn_select_userinfo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fn_select_userinfo2` (
  `no` int NOT NULL DEFAULT '0',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int NOT NULL,
  `email` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fn_select_userinfo2`
--

LOCK TABLES `fn_select_userinfo2` WRITE;
/*!40000 ALTER TABLE `fn_select_userinfo2` DISABLE KEYS */;
INSERT INTO `fn_select_userinfo2` VALUES (2,'bbb',22,'bbb@gmail.com'),(3,'ccc',33,'ccc@gmail.com'),(4,'ddd',44,'ddd@gmail.com'),(5,'abc',55,'abc@gmail.com'),(6,'bca',66,'bca@gmail.com'),(1,'aaa',11,'aaa@gmail.com');
/*!40000 ALTER TABLE `fn_select_userinfo2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_userinfo`
--

DROP TABLE IF EXISTS `group_userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_userinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int NOT NULL,
  `sex` char(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `kor` int DEFAULT NULL,
  `eng` int DEFAULT NULL,
  `math` int DEFAULT NULL,
  `ban` char(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sns` char(2) COLLATE utf8mb4_unicode_ci DEFAULT 'y',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_userinfo`
--

LOCK TABLES `group_userinfo` WRITE;
/*!40000 ALTER TABLE `group_userinfo` DISABLE KEYS */;
INSERT INTO `group_userinfo` VALUES (1,'first',11,NULL,100,100,99,'A','n'),(2,'second',22,'m',89,92,78,'B','y'),(3,'third',33,'m',90,92,97,'A','y'),(4,'fourth',44,'f',40,42,67,'C','n'),(5,'fifth',55,'f',89,86,99,'B','y'),(6,'sixth',66,'m',10,20,44,'C','n');
/*!40000 ALTER TABLE `group_userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `if_userinfo`
--

DROP TABLE IF EXISTS `if_userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `if_userinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int DEFAULT NULL,
  `sex` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sns` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `if_userinfo`
--

LOCK TABLES `if_userinfo` WRITE;
/*!40000 ALTER TABLE `if_userinfo` DISABLE KEYS */;
INSERT INTO `if_userinfo` VALUES (1,'first',11,NULL,'n'),(2,'second',22,'m','y'),(3,'third',33,'m','y'),(4,'fourth',44,'f','n'),(5,'fifth',55,'f','y'),(6,'sixth',66,'m','n');
/*!40000 ALTER TABLE `if_userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `join_userban`
--

DROP TABLE IF EXISTS `join_userban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `join_userban` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ban` char(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `join_userban`
--

LOCK TABLES `join_userban` WRITE;
/*!40000 ALTER TABLE `join_userban` DISABLE KEYS */;
INSERT INTO `join_userban` VALUES (1,'first','A'),(2,'second','B'),(3,'third','A'),(4,'fourth','C'),(5,'fifth','B'),(6,'sixth','C');
/*!40000 ALTER TABLE `join_userban` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `join_userinfo`
--

DROP TABLE IF EXISTS `join_userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `join_userinfo` (
  `no` int NOT NULL DEFAULT '0',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `join_userinfo`
--

LOCK TABLES `join_userinfo` WRITE;
/*!40000 ALTER TABLE `join_userinfo` DISABLE KEYS */;
INSERT INTO `join_userinfo` VALUES (1,'first',11),(2,'second',22),(3,'third',33),(4,'fourth',44);
/*!40000 ALTER TABLE `join_userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milk`
--

DROP TABLE IF EXISTS `milk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `milk` (
  `mno` int NOT NULL AUTO_INCREMENT,
  `mname` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mprice` int NOT NULL,
  `mnum` int DEFAULT NULL,
  `mtotal` int DEFAULT NULL,
  PRIMARY KEY (`mno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milk`
--

LOCK TABLES `milk` WRITE;
/*!40000 ALTER TABLE `milk` DISABLE KEYS */;
INSERT INTO `milk` VALUES (1,'white',1500,NULL,NULL),(2,'choco',1800,NULL,NULL),(3,'banana',1800,NULL,NULL);
/*!40000 ALTER TABLE `milk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `milk_order`
--

DROP TABLE IF EXISTS `milk_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `milk_order` (
  `ono` int NOT NULL AUTO_INCREMENT,
  `oname` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `onum` int NOT NULL,
  `odate` datetime DEFAULT CURRENT_TIMESTAMP,
  `oip` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ono`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `milk_order`
--

LOCK TABLES `milk_order` WRITE;
/*!40000 ALTER TABLE `milk_order` DISABLE KEYS */;
INSERT INTO `milk_order` VALUES (1,'choco',80,'2026-05-20 16:51:59','192.168.40.25');
/*!40000 ALTER TABLE `milk_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mvcboard1`
--

DROP TABLE IF EXISTS `mvcboard1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mvcboard1` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `bname` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bpass` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `btitle` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bcontent` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `bdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bhit` int NOT NULL DEFAULT '0',
  `bip` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mvcboard1`
--

LOCK TABLES `mvcboard1` WRITE;
/*!40000 ALTER TABLE `mvcboard1` DISABLE KEYS */;
INSERT INTO `mvcboard1` VALUES (1,'qwe','qwe','qwe','qwe','2026-05-22 06:01:19',5,'192.168.40.25'),(3,'123123','123123','123123','123123','2026-05-22 06:21:02',25,'192.168.40.25'),(9,'aaaa','aaaa','asdasdasd','asdasdsadsad','2026-05-26 01:54:37',7,'192.168.40.25'),(10,'4444','4444','4444','4444','2026-05-26 01:59:03',7,'192.168.40.25');
/*!40000 ALTER TABLE `mvcboard1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mvcboard2`
--

DROP TABLE IF EXISTS `mvcboard2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mvcboard2` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `bname` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bpass` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `btitle` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bcontent` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `bdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bhit` int NOT NULL DEFAULT '0',
  `bip` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bimg` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT 'the703.png',
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=513 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mvcboard2`
--

LOCK TABLES `mvcboard2` WRITE;
/*!40000 ALTER TABLE `mvcboard2` DISABLE KEYS */;
INSERT INTO `mvcboard2` VALUES (1,'aaa','aaa','bbb','bbb','2026-06-04 01:35:46',4,'192.168.40.25',NULL),(7,'qweqwe','123','123123','123','2026-06-05 07:01:03',3,'192.168.40.45',NULL),(8,'qweqweqwe','123','qweqwe','123123','2026-06-05 07:06:50',17,'192.168.40.45','ddd.png'),(12,'aaa','aaa','aaabbb','aaa','2026-06-08 03:42:03',12,'192.168.40.45','ddd.png'),(13,'qwe','qwe','qweqwe','qwe','2026-06-08 05:47:08',4,'192.168.40.45','the703.png'),(14,'aaa','aaa','bbb','bbb','2026-06-08 06:35:13',0,'192.168.40.25',NULL),(15,'qweqwe','123','123123','123','2026-06-08 06:35:13',0,'192.168.40.45',NULL),(16,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:13',0,'192.168.40.45','ddd.png'),(17,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:13',0,'192.168.40.45','ddd.png'),(18,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:13',0,'192.168.40.45','the703.png'),(21,'aaa','aaa','bbb','bbb','2026-06-08 06:35:14',0,'192.168.40.25',NULL),(22,'qweqwe','123','123123','123','2026-06-08 06:35:14',0,'192.168.40.45',NULL),(23,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:14',0,'192.168.40.45','ddd.png'),(24,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:14',0,'192.168.40.45','ddd.png'),(25,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:14',0,'192.168.40.45','the703.png'),(26,'aaa','aaa','bbb','bbb','2026-06-08 06:35:14',0,'192.168.40.25',NULL),(27,'qweqwe','123','123123','123','2026-06-08 06:35:14',0,'192.168.40.45',NULL),(28,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:14',0,'192.168.40.45','ddd.png'),(29,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:14',0,'192.168.40.45','ddd.png'),(30,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:14',0,'192.168.40.45','the703.png'),(36,'aaa','aaa','bbb','bbb','2026-06-08 06:35:15',0,'192.168.40.25',NULL),(37,'qweqwe','123','123123','123','2026-06-08 06:35:15',0,'192.168.40.45',NULL),(38,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:15',0,'192.168.40.45','ddd.png'),(39,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:15',0,'192.168.40.45','ddd.png'),(40,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:15',0,'192.168.40.45','the703.png'),(41,'aaa','aaa','bbb','bbb','2026-06-08 06:35:15',0,'192.168.40.25',NULL),(42,'qweqwe','123','123123','123','2026-06-08 06:35:15',0,'192.168.40.45',NULL),(43,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:15',0,'192.168.40.45','ddd.png'),(44,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:15',0,'192.168.40.45','ddd.png'),(45,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:15',0,'192.168.40.45','the703.png'),(46,'aaa','aaa','bbb','bbb','2026-06-08 06:35:15',0,'192.168.40.25',NULL),(47,'qweqwe','123','123123','123','2026-06-08 06:35:15',0,'192.168.40.45',NULL),(48,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:15',0,'192.168.40.45','ddd.png'),(49,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:15',0,'192.168.40.45','ddd.png'),(50,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:15',0,'192.168.40.45','the703.png'),(51,'aaa','aaa','bbb','bbb','2026-06-08 06:35:15',0,'192.168.40.25',NULL),(52,'qweqwe','123','123123','123','2026-06-08 06:35:15',0,'192.168.40.45',NULL),(53,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:15',0,'192.168.40.45','ddd.png'),(54,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:15',0,'192.168.40.45','ddd.png'),(55,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:15',0,'192.168.40.45','the703.png'),(67,'aaa','aaa','bbb','bbb','2026-06-08 06:35:21',0,'192.168.40.25',NULL),(68,'qweqwe','123','123123','123','2026-06-08 06:35:21',0,'192.168.40.45',NULL),(69,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(70,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(71,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:21',0,'192.168.40.45','the703.png'),(72,'aaa','aaa','bbb','bbb','2026-06-08 06:35:21',0,'192.168.40.25',NULL),(73,'qweqwe','123','123123','123','2026-06-08 06:35:21',0,'192.168.40.45',NULL),(74,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(75,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(76,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:21',0,'192.168.40.45','the703.png'),(77,'aaa','aaa','bbb','bbb','2026-06-08 06:35:21',0,'192.168.40.25',NULL),(78,'qweqwe','123','123123','123','2026-06-08 06:35:21',0,'192.168.40.45',NULL),(79,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(80,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(81,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:21',0,'192.168.40.45','the703.png'),(82,'aaa','aaa','bbb','bbb','2026-06-08 06:35:21',0,'192.168.40.25',NULL),(83,'qweqwe','123','123123','123','2026-06-08 06:35:21',0,'192.168.40.45',NULL),(84,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(85,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(86,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:21',0,'192.168.40.45','the703.png'),(87,'aaa','aaa','bbb','bbb','2026-06-08 06:35:21',0,'192.168.40.25',NULL),(88,'qweqwe','123','123123','123','2026-06-08 06:35:21',0,'192.168.40.45',NULL),(89,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(90,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(91,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:21',0,'192.168.40.45','the703.png'),(92,'aaa','aaa','bbb','bbb','2026-06-08 06:35:21',0,'192.168.40.25',NULL),(93,'qweqwe','123','123123','123','2026-06-08 06:35:21',0,'192.168.40.45',NULL),(94,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(95,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(96,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:21',0,'192.168.40.45','the703.png'),(97,'aaa','aaa','bbb','bbb','2026-06-08 06:35:21',0,'192.168.40.25',NULL),(98,'qweqwe','123','123123','123','2026-06-08 06:35:21',0,'192.168.40.45',NULL),(99,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(100,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(101,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:21',0,'192.168.40.45','the703.png'),(102,'aaa','aaa','bbb','bbb','2026-06-08 06:35:21',0,'192.168.40.25',NULL),(103,'qweqwe','123','123123','123','2026-06-08 06:35:21',0,'192.168.40.45',NULL),(104,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(105,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:21',0,'192.168.40.45','ddd.png'),(106,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:21',0,'192.168.40.45','the703.png'),(130,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(131,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(132,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(133,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(134,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(135,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(136,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(137,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(138,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(139,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(140,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(141,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(142,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(143,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(144,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(145,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(146,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(147,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(148,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(149,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(150,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(151,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(152,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(153,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(154,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(155,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(156,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(157,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(158,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(159,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(160,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(161,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(162,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(163,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(164,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(165,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(166,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(167,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(168,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(169,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(170,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(171,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(172,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(173,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(174,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(175,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(176,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(177,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(178,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(179,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(180,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(181,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(182,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(183,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(184,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(185,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(186,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(187,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(188,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(189,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(190,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(191,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(192,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(193,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(194,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(195,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(196,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(197,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(198,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(199,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(200,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(201,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(202,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(203,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(204,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(205,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(206,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(207,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(208,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(209,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(257,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(258,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(259,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(260,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(261,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(262,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(263,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(264,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(265,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(266,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(267,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(268,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(269,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(270,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(271,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(272,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(273,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(274,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(275,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(276,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(277,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(278,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(279,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(280,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(281,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(282,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(283,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(284,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(285,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(286,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(287,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(288,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(289,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(290,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(291,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(292,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(293,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(294,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(295,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(296,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(297,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(298,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(299,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(300,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(301,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(302,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(303,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(304,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(305,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(306,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(307,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(308,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(309,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(310,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(311,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(312,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(313,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(314,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(315,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(316,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(317,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(318,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(319,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(320,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(321,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(322,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(323,'qweqwe','123','123123','123','2026-06-08 06:35:22',1,'192.168.40.45',NULL),(324,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(325,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(326,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(327,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(328,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(329,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(330,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(331,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(332,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(333,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(334,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(335,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(336,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(337,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(338,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(339,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(340,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(341,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(342,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(343,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(344,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(345,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(346,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(347,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(348,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(349,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(350,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(351,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(352,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(353,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(354,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(355,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(356,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(357,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(358,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(359,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(360,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(361,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(362,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(363,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(364,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(365,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(366,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(367,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(368,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(369,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(370,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(371,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(372,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(373,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(374,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(375,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(376,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(377,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(378,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(379,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(380,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(381,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(382,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(383,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(384,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(385,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(386,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(387,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(388,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(389,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',1,'192.168.40.45','ddd.png'),(390,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(391,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(392,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(393,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(394,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(395,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(396,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(397,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(398,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(399,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(400,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(401,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(402,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(403,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(404,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(405,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(406,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(407,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',1,'192.168.40.25',NULL),(408,'qweqwe','123','123123','123','2026-06-08 06:35:22',0,'192.168.40.45',NULL),(409,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(410,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(411,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',0,'192.168.40.45','the703.png'),(412,'aaa','aaa','bbb','bbb','2026-06-08 06:35:22',0,'192.168.40.25',NULL),(413,'qweqwe','123','123123','123','2026-06-08 06:35:22',2,'192.168.40.45',NULL),(414,'qweqweqwe','123','qweqwe','123123','2026-06-08 06:35:22',0,'192.168.40.45','ddd.png'),(415,'aaa','aaa','aaabbb','aaa','2026-06-08 06:35:22',1,'192.168.40.45','ddd.png'),(416,'qwe','qwe','qweqwe','qwe','2026-06-08 06:35:22',3,'192.168.40.45','the703.png'),(512,'rrr','rrr','rrr','rrr','2026-06-08 08:19:44',1,'192.168.40.45',NULL);
/*!40000 ALTER TABLE `mvcboard2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salgrade`
--

DROP TABLE IF EXISTS `salgrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salgrade` (
  `grade` int NOT NULL AUTO_INCREMENT,
  `losal` int DEFAULT NULL,
  `hisal` int DEFAULT NULL,
  PRIMARY KEY (`grade`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salgrade`
--

LOCK TABLES `salgrade` WRITE;
/*!40000 ALTER TABLE `salgrade` DISABLE KEYS */;
INSERT INTO `salgrade` VALUES (1,700,1200),(2,1201,1400),(3,1401,2000),(4,2001,3000),(5,3001,9999);
/*!40000 ALTER TABLE `salgrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `score`
--

DROP TABLE IF EXISTS `score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `score` (
  `sno` int NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sjava` int NOT NULL,
  `sjsp` int NOT NULL,
  `sspring` int NOT NULL,
  `sproject` int NOT NULL,
  `sstotal` int DEFAULT NULL,
  `ssavg` double DEFAULT NULL,
  `semail` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `score`
--

LOCK TABLES `score` WRITE;
/*!40000 ALTER TABLE `score` DISABLE KEYS */;
INSERT INTO `score` VALUES (1,'aaa',100,100,100,100,400,100,'first@gmail.com'),(2,'second',92,78,88,100,358,89.5,'second@gamil.com'),(3,'ccc',90,90,90,80,350,87.5,'ccc@gmail.com'),(4,'ddd',78,89,68,98,333,83.25,'admin@gamil.com'),(5,'abd',89,98,69,77,333,83.25,'blackstudent@gmail.com');
/*!40000 ALTER TABLE `score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `select_userinfo`
--

DROP TABLE IF EXISTS `select_userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `select_userinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `select_userinfo`
--

LOCK TABLES `select_userinfo` WRITE;
/*!40000 ALTER TABLE `select_userinfo` DISABLE KEYS */;
INSERT INTO `select_userinfo` VALUES (1,'first',NULL),(2,'second',22),(3,'third',33);
/*!40000 ALTER TABLE `select_userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `select_userinfo2`
--

DROP TABLE IF EXISTS `select_userinfo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `select_userinfo2` (
  `no` int NOT NULL DEFAULT '0',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int NOT NULL,
  `email` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `select_userinfo2`
--

LOCK TABLES `select_userinfo2` WRITE;
/*!40000 ALTER TABLE `select_userinfo2` DISABLE KEYS */;
INSERT INTO `select_userinfo2` VALUES (2,'bbaab',22,'bbb@gmail.com'),(3,'ccaac',33,'ccc@gmail.com'),(4,'daadd',44,'ddd@gmail.com'),(5,'abc',55,'abc@gmail.com'),(6,'daaca',66,'bca@gmail.com'),(1,'aaaa',11,'aaa@gmail.com');
/*!40000 ALTER TABLE `select_userinfo2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sub_userinfo`
--

DROP TABLE IF EXISTS `sub_userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sub_userinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int NOT NULL,
  `sex` char(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `kor` int DEFAULT NULL,
  `eng` int DEFAULT NULL,
  `math` int DEFAULT NULL,
  `ban` char(2) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sns` char(2) COLLATE utf8mb4_unicode_ci DEFAULT 'y',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sub_userinfo`
--

LOCK TABLES `sub_userinfo` WRITE;
/*!40000 ALTER TABLE `sub_userinfo` DISABLE KEYS */;
INSERT INTO `sub_userinfo` VALUES (1,'first',11,NULL,100,100,99,'A','n'),(2,'second',22,'m',89,92,78,'B','y'),(3,'third',33,'m',90,92,97,'A','y'),(4,'fourth',44,'f',40,42,67,'C','n'),(5,'fifth',55,'f',89,86,99,'B','y'),(6,'sixth',66,'m',10,20,44,'C','n');
/*!40000 ALTER TABLE `sub_userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t1`
--

DROP TABLE IF EXISTS `t1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t1` (
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t1`
--

LOCK TABLES `t1` WRITE;
/*!40000 ALTER TABLE `t1` DISABLE KEYS */;
/*!40000 ALTER TABLE `t1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t2`
--

DROP TABLE IF EXISTS `t2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t2` (
  `jumin` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`jumin`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t2`
--

LOCK TABLES `t2` WRITE;
/*!40000 ALTER TABLE `t2` DISABLE KEYS */;
INSERT INTO `t2` VALUES (1,'aaa',1),(2,'bbb',NULL);
/*!40000 ALTER TABLE `t2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testp`
--

DROP TABLE IF EXISTS `testp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testp` (
  `test1` int NOT NULL,
  `test2` int DEFAULT NULL,
  `test3` int DEFAULT NULL,
  PRIMARY KEY (`test1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testp`
--

LOCK TABLES `testp` WRITE;
/*!40000 ALTER TABLE `testp` DISABLE KEYS */;
/*!40000 ALTER TABLE `testp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tests`
--

DROP TABLE IF EXISTS `tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tests` (
  `test2` int NOT NULL,
  `author_test1` int DEFAULT NULL,
  PRIMARY KEY (`test2`),
  KEY `author_test1` (`author_test1`),
  CONSTRAINT `tests_ibfk_1` FOREIGN KEY (`author_test1`) REFERENCES `testp` (`test1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tests`
--

LOCK TABLES `tests` WRITE;
/*!40000 ALTER TABLE `tests` DISABLE KEYS */;
/*!40000 ALTER TABLE `tests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES (1,'first',11),(2,'second',22),(3,'third',33),(4,'fourth',44),(5,'first',11),(6,'first',11),(7,'ccc',NULL),(8,'bbb',NULL),(9,'abc',NULL),(10,'first',11),(11,'first',11),(12,'abc',NULL),(13,'bbb',NULL),(14,'ccc',NULL),(18,'길동',11);
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo2`
--

DROP TABLE IF EXISTS `userinfo2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo2` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo2`
--

LOCK TABLES `userinfo2` WRITE;
/*!40000 ALTER TABLE `userinfo2` DISABLE KEYS */;
/*!40000 ALTER TABLE `userinfo2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo_e`
--

DROP TABLE IF EXISTS `userinfo_e`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo_e` (
  `no` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int DEFAULT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo_e`
--

LOCK TABLES `userinfo_e` WRITE;
/*!40000 ALTER TABLE `userinfo_e` DISABLE KEYS */;
INSERT INTO `userinfo_e` VALUES (1,'aaa',11),(2,'second',22);
/*!40000 ALTER TABLE `userinfo_e` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo_ex`
--

DROP TABLE IF EXISTS `userinfo_ex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo_ex` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo_ex`
--

LOCK TABLES `userinfo_ex` WRITE;
/*!40000 ALTER TABLE `userinfo_ex` DISABLE KEYS */;
INSERT INTO `userinfo_ex` VALUES (1,'first',11),(2,'second',22),(3,'third',33),(4,'fourth',44);
/*!40000 ALTER TABLE `userinfo_ex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo_re1`
--

DROP TABLE IF EXISTS `userinfo_re1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userinfo_re1` (
  `no` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `age` int NOT NULL,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo_re1`
--

LOCK TABLES `userinfo_re1` WRITE;
/*!40000 ALTER TABLE `userinfo_re1` DISABLE KEYS */;
INSERT INTO `userinfo_re1` VALUES (1,'first',11),(2,'second',22),(3,'third',33),(4,'fourth',44);
/*!40000 ALTER TABLE `userinfo_re1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `uno` int NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bpass` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mobile` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `udate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `bip` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`uno`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'aaa','aaa','aaa@aaa.com','000-2222-2222','2026-05-26 08:29:36','192.168.40.25'),(2,'bbb','bbb','bbb@bbb.com','000-2222-2222','2026-05-26 09:10:44','192.168.40.25'),(3,'aaaa','aaaa','aaaa@aaa.com','000-1111-4444','2026-05-27 05:46:24','192.168.40.25'),(8,'qwe123','qwe123','qwe123@qwe.com','000-1234-1234','2026-05-29 05:34:38','192.168.40.25'),(9,'321','321','321@321','321','2026-05-29 07:55:30','192.168.40.25'),(11,'bbb','bbb','bbb@bbb.com','000-1111-2222','2026-06-09 02:16:16','111.111.111.111'),(12,'ccc','ccc','ccc@ccc.com','000-3333-3333','2026-06-09 02:40:05','192.168.40.45'),(13,'qwe123','qwe123','qwe123@aa.com','000-1111-2222','2026-06-09 02:59:30','192.168.40.45'),(14,'a','$2a$10$t75g7Ge14.DtM7st8oZh1.25zDT318QaC.Twk12rsiG7r9qwwt/hO','a@a','000-1111-2222','2026-06-09 07:52:11','111.111.111.111'),(17,'b','$2a$10$Krs.qm/S.MDjdkBZuo8Q.O1KArGonnW6wks62G0UsYM4rM44bXjpu','b@b','000-1111-2222','2026-06-09 08:38:32','111.111.111.111');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-09 18:21:36
