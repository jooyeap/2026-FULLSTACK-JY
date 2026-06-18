-- MySQL dump 10.13  Distrib 8.4.9, for Win64 (x86_64)
--
-- Host: localhost    Database: sb_erp_db
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
-- Table structure for table `appr_doc`
--

DROP TABLE IF EXISTS `appr_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appr_doc` (
  `doc_id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int NOT NULL,
  `for_id` int NOT NULL,
  `com_id` int NOT NULL,
  `doc_title` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `doc_content` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `doc_status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'WAI',
  `doc_created` datetime NOT NULL,
  `doc_updated` datetime NOT NULL,
  PRIMARY KEY (`doc_id`),
  KEY `fk_appr_doc_appr_form1_idx` (`for_id`),
  KEY `fk_appr_doc_company1_idx` (`com_id`),
  KEY `fk_appr_doc_employee1_idx` (`emp_id`),
  CONSTRAINT `fk_appr_doc_appr_form1` FOREIGN KEY (`for_id`) REFERENCES `appr_form` (`for_id`),
  CONSTRAINT `fk_appr_doc_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`),
  CONSTRAINT `fk_appr_doc_employee1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appr_doc`
--

LOCK TABLES `appr_doc` WRITE;
/*!40000 ALTER TABLE `appr_doc` DISABLE KEYS */;
/*!40000 ALTER TABLE `appr_doc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appr_form`
--

DROP TABLE IF EXISTS `appr_form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appr_form` (
  `for_id` int NOT NULL AUTO_INCREMENT,
  `com_id` int NOT NULL,
  `for_code` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `for_title` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `for_content` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `for_status` tinyint(1) NOT NULL,
  `for_created` datetime NOT NULL,
  `for_updated` datetime NOT NULL,
  PRIMARY KEY (`for_id`),
  KEY `fk_appr_form_company1_idx` (`com_id`),
  CONSTRAINT `fk_appr_form_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appr_form`
--

LOCK TABLES `appr_form` WRITE;
/*!40000 ALTER TABLE `appr_form` DISABLE KEYS */;
INSERT INTO `appr_form` VALUES (1,60,'ããã','ããã','asdasdsad',1,'2026-06-16 19:18:21','2026-06-16 19:18:21');
/*!40000 ALTER TABLE `appr_form` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appr_line`
--

DROP TABLE IF EXISTS `appr_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appr_line` (
  `lin_id` int NOT NULL,
  `doc_id` int NOT NULL,
  `emp_id` int NOT NULL,
  `lin_order` int NOT NULL,
  `lin_status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lin_approved` datetime DEFAULT NULL,
  PRIMARY KEY (`lin_id`),
  KEY `fk_appr_line_appr_doc1_idx` (`doc_id`),
  KEY `fk_appr_line_employee1_idx` (`emp_id`),
  CONSTRAINT `fk_appr_line_appr_doc1` FOREIGN KEY (`doc_id`) REFERENCES `appr_doc` (`doc_id`),
  CONSTRAINT `fk_appr_line_employee1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appr_line`
--

LOCK TABLES `appr_line` WRITE;
/*!40000 ALTER TABLE `appr_line` DISABLE KEYS */;
/*!40000 ALTER TABLE `appr_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `aut_id` int NOT NULL,
  `com_id` int NOT NULL,
  `aut_name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`aut_id`),
  KEY `fk_authority_company1_idx` (`com_id`),
  CONSTRAINT `fk_authority_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `com_id` int NOT NULL,
  `indust_code` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `indust_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `com_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `com_ceo` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `biz_no` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `com_tel` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `com_logo` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`com_id`),
  UNIQUE KEY `biz_no_UNIQUE` (`biz_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'IT001','IT·플랫폼','네이버','최수연','220-81-00006','1588-3820',NULL,'2018-03-15 09:00:00','2024-01-10 10:00:00'),(2,'IT001','IT·플랫폼','카카오','정신아','130-81-00005','1577-3754',NULL,'2018-07-22 09:00:00','2024-02-05 10:00:00'),(3,'IT001','IT·플랫폼','라인플러스','이은정','119-86-00999','1577-1004',NULL,'2019-04-10 09:00:00','2023-11-20 10:00:00'),(4,'IT001','IT·플랫폼','NHN','정우진','144-81-00367','1544-2772',NULL,'2020-01-08 09:00:00','2024-03-15 10:00:00'),(5,'IT001','IT·플랫폼','네이버클라우드','박원기','220-81-00781','1588-3000',NULL,'2021-05-20 09:00:00','2024-04-01 10:00:00'),(6,'IT002','IT·서비스','카카오엔터프라이즈','강봉구','130-87-00321','1577-9999',NULL,'2020-11-12 09:00:00','2024-01-22 10:00:00'),(7,'IT002','IT·서비스','토스','이승건','379-88-00193','1599-4905',NULL,'2020-06-01 09:00:00','2023-12-10 10:00:00'),(8,'IT002','IT·서비스','비바리퍼블리카','이승건','379-88-00500','1599-1234',NULL,'2021-03-07 09:00:00','2024-02-18 10:00:00'),(9,'IT002','IT·서비스','당근','황도연','119-86-00123','1666-0723',NULL,'2020-09-18 09:00:00','2024-01-05 10:00:00'),(10,'IT002','IT·서비스','직방','안성우','120-87-00455','1670-7766',NULL,'2022-05-17 09:00:00','2024-03-08 10:00:00'),(11,'ECOM001','이커머스','쿠팡','박대준','120-88-00767','1577-7011',NULL,'2019-05-30 09:00:00','2024-05-01 10:00:00'),(12,'ECOM001','이커머스','컬리','김슬아','119-86-00789','1644-1107',NULL,'2022-09-03 09:00:00','2024-02-28 10:00:00'),(13,'ECOM001','이커머스','무신사','조만호','211-88-00231','1544-7733',NULL,'2023-01-25 09:00:00','2024-04-10 10:00:00'),(14,'ECOM001','이커머스','11번가','하형일','220-81-00441','1599-0011',NULL,'2018-09-14 09:00:00','2023-10-30 10:00:00'),(15,'ECOM001','이커머스','G마켓','전항일','220-81-00189','1566-5701',NULL,'2019-02-20 09:00:00','2023-12-15 10:00:00'),(16,'ECOM001','이커머스','옥션','전항일','220-81-00246','1566-5702',NULL,'2019-03-05 09:00:00','2023-12-20 10:00:00'),(17,'ECOM002','이커머스·대형','SSG닷컴','이인영','217-88-00088','1644-0055',NULL,'2020-03-12 09:00:00','2024-01-18 10:00:00'),(18,'ECOM002','이커머스·대형','롯데온','조영제','209-81-00201','1899-0005',NULL,'2020-04-28 09:00:00','2024-02-10 10:00:00'),(19,'ECOM002','이커머스·대형','위메프','류화현','220-88-00312','1661-9400',NULL,'2021-06-15 09:00:00','2024-03-20 10:00:00'),(20,'ECOM002','이커머스·대형','티몬','장윤석','220-88-00556','1588-9880',NULL,'2021-07-09 09:00:00','2024-03-25 10:00:00'),(21,'O2O001','O2O·배달','배달의민족','이국환','105-88-00120','1600-0987',NULL,'2020-02-11 09:00:00','2024-01-14 10:00:00'),(22,'O2O001','O2O·배달','우아한형제들','박재욱','105-87-00219','1600-1234',NULL,'2021-11-30 09:00:00','2024-02-22 10:00:00'),(23,'O2O001','O2O·배달','요기요','박서진','138-81-00121','1544-3399',NULL,'2020-05-19 09:00:00','2023-11-05 10:00:00'),(24,'O2O001','O2O·배달','쿠팡이츠','박대준','120-88-00891','1600-9827',NULL,'2021-09-08 09:00:00','2024-04-03 10:00:00'),(25,'O2O002','O2O·여행','야놀자','이수진','220-88-00133','1644-1346',NULL,'2022-02-09 09:00:00','2024-01-30 10:00:00'),(26,'O2O002','O2O·여행','여기어때','최일석','119-87-00211','1670-1234',NULL,'2022-04-14 09:00:00','2024-02-14 10:00:00'),(27,'O2O002','O2O·여행','카카오모빌리티','류긍선','130-87-00288','1644-7777',NULL,'2021-08-20 09:00:00','2024-03-01 10:00:00'),(28,'O2O002','O2O·여행','타다','박재욱','220-88-00601','1600-5678',NULL,'2022-07-11 09:00:00','2024-04-20 10:00:00'),(29,'O2O003','O2O·홈리빙','오늘의집','이승재','119-86-00401','1644-2424',NULL,'2023-03-22 09:00:00','2024-05-05 10:00:00'),(30,'O2O003','O2O·홈리빙','집닥','박성민','120-88-00333','1599-3388',NULL,'2023-05-18 09:00:00','2024-05-10 10:00:00'),(31,'FIN001','금융·카드','신한카드','문동권','359-81-00091','1544-7000',NULL,'2019-01-10 09:00:00','2024-01-25 10:00:00'),(32,'FIN001','금융·카드','삼성카드','김대환','125-81-00070','1588-8700',NULL,'2019-03-22 09:00:00','2024-02-05 10:00:00'),(33,'FIN001','금융·카드','현대카드','김덕환','201-81-00219','1577-6000',NULL,'2024-02-14 09:00:00','2024-03-01 10:00:00'),(34,'FIN001','금융·카드','KB국민카드','이창권','365-81-00007','1588-1688',NULL,'2019-07-04 09:00:00','2024-01-08 10:00:00'),(35,'FIN001','금융·카드','롯데카드','조좌진','209-81-00088','1588-8000',NULL,'2020-10-19 09:00:00','2024-02-17 10:00:00'),(36,'FIN002','금융·IT','하나금융티아이','박근영','314-81-00777','1599-1111',NULL,'2024-07-21 09:00:00','2024-07-21 10:00:00'),(37,'FIN002','금융·IT','신한금융투자','이준호','359-81-00444','1588-0365',NULL,'2020-04-05 09:00:00','2023-12-12 10:00:00'),(38,'FIN002','금융·IT','카카오뱅크','윤호영','323-88-00118','1599-3333',NULL,'2021-02-28 09:00:00','2024-03-10 10:00:00'),(39,'FIN002','금융·IT','케이뱅크','최우형','221-88-00050','1522-1111',NULL,'2021-05-11 09:00:00','2024-04-01 10:00:00'),(40,'FIN002','금융·IT','토스뱅크','홍민택','379-88-00777','1599-6070',NULL,'2022-01-25 09:00:00','2024-04-15 10:00:00'),(41,'TELCO001','통신','SK텔레콤','유영상','104-81-00120','1599-0012',NULL,'2023-04-12 09:00:00','2024-01-06 10:00:00'),(42,'TELCO001','통신','KT','김영섭','102-81-00031','1588-0100',NULL,'2023-08-20 09:00:00','2024-02-01 10:00:00'),(43,'TELCO001','통신','LG유플러스','홍범식','107-81-00059','1544-0010',NULL,'2023-12-01 09:00:00','2024-03-03 10:00:00'),(44,'TELCO002','통신·인터넷','SK브로드밴드','이형호','104-81-00332','1588-0106',NULL,'2021-09-15 09:00:00','2024-01-20 10:00:00'),(45,'TELCO002','통신·인터넷','LG헬로비전','송구영','107-86-00044','1855-1188',NULL,'2022-03-07 09:00:00','2024-02-09 10:00:00'),(46,'GAME001','게임','넥슨','이정헌','144-81-00088','1588-7701',NULL,'2021-01-05 09:00:00','2024-01-10 10:00:00'),(47,'GAME001','게임','엔씨소프트','김택진','220-81-00059','1588-3324',NULL,'2021-03-22 09:00:00','2024-01-15 10:00:00'),(48,'GAME001','게임','크래프톤','김창한','215-87-00114','1670-1003',NULL,'2021-08-14 09:00:00','2024-02-20 10:00:00'),(49,'GAME001','게임','넷마블','권영식','169-81-00021','1588-3995',NULL,'2020-11-02 09:00:00','2024-03-05 10:00:00'),(50,'GAME002','게임·모바일','카카오게임즈','조계현','130-87-00399','1599-2255',NULL,'2022-04-29 09:00:00','2024-01-28 10:00:00'),(51,'GAME002','게임·모바일','스마일게이트','권혁빈','220-88-00718','1588-5440',NULL,'2022-06-17 09:00:00','2024-02-16 10:00:00'),(52,'GAME002','게임·모바일','컴투스','남재관','104-81-00554','1577-9000',NULL,'2023-02-08 09:00:00','2024-03-22 10:00:00'),(53,'GAME002','게임·모바일','게임빌','송재준','220-81-00633','1599-7000',NULL,'2023-04-11 09:00:00','2024-04-05 10:00:00'),(54,'SI001','IT·SI','삼성SDS','이준희','120-81-00114','1566-0079',NULL,'2024-05-09 09:00:00','2024-05-09 10:00:00'),(55,'SI001','IT·SI','LG CNS','현신균','107-81-00313','1800-0880',NULL,'2023-07-03 09:00:00','2024-01-11 10:00:00'),(56,'SI001','IT·SI','SK C&C','윤풍영','104-81-00605','1588-2600',NULL,'2023-09-19 09:00:00','2024-02-07 10:00:00'),(57,'SI001','IT·SI','롯데정보통신','노준형','209-81-00337','1588-0630',NULL,'2022-11-23 09:00:00','2024-03-14 10:00:00'),(58,'SI002','IT·솔루션','포스코ICT','정덕균','280-81-00056','1588-0015',NULL,'2022-08-16 09:00:00','2024-04-08 10:00:00'),(59,'SI002','IT·솔루션','한화시스템','어성철','128-81-00089','1800-8000',NULL,'2021-12-06 09:00:00','2024-01-03 10:00:00'),(60,'SI002','IT·솔루션','현대오토에버','서정식','201-81-00454','1899-1000',NULL,'2021-10-14 09:00:00','2023-12-28 10:00:00'),(61,'ELEC001','반도체·전자','삼성전자','한종희','124-81-00998','1588-3366',NULL,'2018-01-15 09:00:00','2024-05-20 10:00:00'),(62,'ELEC001','반도체·전자','SK하이닉스','박정호','120-81-00071','1800-0011',NULL,'2018-04-22 09:00:00','2024-04-25 10:00:00'),(63,'ELEC001','반도체·전자','LG전자','조주완','107-81-00073','1544-7777',NULL,'2018-07-30 09:00:00','2024-03-30 10:00:00'),(64,'ELEC002','디스플레이','삼성디스플레이','최주선','124-88-00221','1588-3535',NULL,'2019-06-11 09:00:00','2024-02-26 10:00:00'),(65,'ELEC002','디스플레이','LG디스플레이','정철동','107-81-00555','1544-1200',NULL,'2019-08-05 09:00:00','2024-01-31 10:00:00'),(66,'DIST001','물류','CJ대한통운','강신호','123-81-00007','1588-1255',NULL,'2019-11-20 09:00:00','2024-01-07 10:00:00'),(67,'DIST001','물류','한진택배','노삼석','122-81-00006','1588-0011',NULL,'2020-01-13 09:00:00','2024-02-03 10:00:00'),(68,'DIST001','물류','롯데글로벌로지스','박찬복','209-81-00617','1588-2121',NULL,'2020-03-25 09:00:00','2024-02-28 10:00:00'),(69,'DIST002','유통','이마트','한채양','129-81-00006','1234-1234',NULL,'2018-08-10 09:00:00','2024-03-18 10:00:00'),(70,'DIST002','유통','롯데마트','강성현','209-81-00442','1661-2345',NULL,'2018-10-02 09:00:00','2024-04-13 10:00:00'),(71,'DIST002','유통','GS리테일','허연수','118-81-00002','1577-4088',NULL,'2019-01-28 09:00:00','2024-05-07 10:00:00'),(72,'DIST002','유통','BGF리테일','이건준','220-81-00770','1577-5975',NULL,'2019-04-09 09:00:00','2024-01-16 10:00:00'),(73,'MEDIA001','미디어·콘텐츠','CJ ENM','구창근','120-81-00001','1588-5000',NULL,'2020-07-07 09:00:00','2024-01-21 10:00:00'),(74,'MEDIA001','미디어·콘텐츠','HYBE','박지원','220-88-00940','1544-0404',NULL,'2021-04-18 09:00:00','2024-02-13 10:00:00'),(75,'MEDIA001','미디어·콘텐츠','SM엔터테인먼트','탁영준','220-81-00395','1588-2006',NULL,'2021-06-29 09:00:00','2024-03-06 10:00:00'),(76,'MEDIA002','엔터테인먼트','YG엔터테인먼트','황보경','220-87-00007','1588-4540',NULL,'2022-01-12 09:00:00','2024-04-22 10:00:00'),(77,'MEDIA002','엔터테인먼트','JYP엔터테인먼트','정욱','220-88-00177','1566-0600',NULL,'2022-03-30 09:00:00','2024-05-01 10:00:00'),(78,'MEDIA002','엔터테인먼트','카카오엔터테인먼트','김성수','130-88-00123','1588-9700',NULL,'2022-09-21 09:00:00','2024-01-09 10:00:00'),(79,'BIO001','바이오','셀트리온','서정진','124-81-00881','1899-9944',NULL,'2021-11-05 09:00:00','2024-02-04 10:00:00'),(80,'BIO001','바이오','삼성바이오로직스','존림','124-88-00215','1800-7100',NULL,'2022-05-23 09:00:00','2024-03-11 10:00:00'),(81,'BIO001','바이오','한미약품','임종훈','128-81-00044','1566-3336',NULL,'2022-08-30 09:00:00','2024-04-17 10:00:00'),(82,'BIO002','제약','녹십자','허은철','128-81-00022','1588-9891',NULL,'2023-02-14 09:00:00','2024-05-12 10:00:00'),(83,'BIO002','제약','유한양행','조욱제','104-81-00041','1544-9876',NULL,'2023-04-06 09:00:00','2024-01-02 10:00:00'),(84,'BIO002','제약','대웅제약','전승호','106-81-00001','1600-2002',NULL,'2023-06-19 09:00:00','2024-02-19 10:00:00'),(85,'CONST001','건설','현대건설','윤영준','202-81-00001','1544-2000',NULL,'2019-09-03 09:00:00','2024-03-27 10:00:00'),(86,'CONST001','건설','삼성물산','오세철','114-81-00008','1588-5001',NULL,'2019-12-11 09:00:00','2024-04-02 10:00:00'),(87,'CONST001','건설','GS건설','허윤홍','214-81-00011','1588-4633',NULL,'2020-02-26 09:00:00','2024-04-29 10:00:00'),(88,'CONST002','건설·개발','DL이앤씨','마창민','102-81-00166','1588-3800',NULL,'2020-08-17 09:00:00','2024-01-24 10:00:00'),(89,'CONST002','건설·개발','포스코이앤씨','한성희','280-81-00033','1800-3000',NULL,'2020-10-08 09:00:00','2024-02-12 10:00:00'),(90,'CONST002','건설·개발','호반건설','김선규','220-81-00523','1522-2222',NULL,'2021-01-20 09:00:00','2024-03-09 10:00:00'),(91,'ENRG001','에너지·정유','SK에너지','오종훈','104-81-00208','1588-1234',NULL,'2021-07-27 09:00:00','2024-01-17 10:00:00'),(92,'ENRG001','에너지·정유','GS칼텍스','허세홍','107-81-00141','1588-5002',NULL,'2021-09-13 09:00:00','2024-02-24 10:00:00'),(93,'ENRG002','에너지·전력','LS ELECTRIC','구자은','107-81-00004','1800-5700',NULL,'2022-02-28 09:00:00','2024-03-16 10:00:00'),(94,'ENRG002','에너지·전력','한화솔루션','류두형','128-81-00311','1588-7000',NULL,'2022-06-07 09:00:00','2024-04-23 10:00:00'),(95,'EDU001','교육','클래스101','권오형','220-88-00821','1670-1010',NULL,'2022-10-31 09:00:00','2024-05-14 10:00:00'),(96,'EDU001','교육','패스트캠퍼스','이강민','119-88-00234','1544-7800',NULL,'2023-01-16 09:00:00','2024-01-29 10:00:00'),(97,'EDU002','교육·HR','휴넷','조영탁','220-81-00288','1899-1200',NULL,'2023-03-05 09:00:00','2024-02-20 10:00:00'),(98,'EDU002','교육·HR','원티드랩','이복기','220-88-00605','1588-6080',NULL,'2023-05-29 09:00:00','2024-03-24 10:00:00'),(99,'AUTO001','자동차','현대자동차','장재훈','120-81-00175','1800-1700',NULL,'2018-05-19 09:00:00','2024-04-30 10:00:00'),(100,'AUTO001','자동차','기아','송호성','104-81-00601','1833-4959',NULL,'2018-11-07 09:00:00','2024-05-18 10:00:00');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `dept_id` int NOT NULL,
  `com_id` int NOT NULL,
  `parent_id` int DEFAULT NULL,
  `dept_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dept_code` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `depth` int DEFAULT NULL,
  `sort_order` int DEFAULT NULL,
  `emp_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`dept_id`),
  UNIQUE KEY `com_dept_UNIQUE` (`com_id`,`dept_code`) /*!80000 INVISIBLE */,
  KEY `fk_department_company1_idx` (`com_id`),
  KEY `fk_department_department1_idx` (`parent_id`),
  CONSTRAINT `fk_department_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`) ON UPDATE RESTRICT,
  CONSTRAINT `fk_department_department1` FOREIGN KEY (`parent_id`) REFERENCES `department` (`dept_id`) ON DELETE CASCADE ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,1,NULL,'경영지원본부','NVR-MGT',1,1,NULL,'2018-04-01 09:00:00','2024-01-10 10:00:00'),(2,1,NULL,'개발본부','NVR-DEV',1,2,NULL,'2018-04-01 09:00:00','2024-01-10 10:00:00'),(3,1,NULL,'서비스본부','NVR-SVC',1,3,NULL,'2018-04-01 09:00:00','2024-01-10 10:00:00'),(4,1,NULL,'데이터본부','NVR-DATA',1,4,NULL,'2019-03-01 09:00:00','2024-01-10 10:00:00'),(5,1,1,'인사팀','NVR-HR',2,1,NULL,'2018-05-01 09:00:00','2024-01-10 10:00:00'),(6,1,1,'재무팀','NVR-FIN',2,2,NULL,'2018-05-01 09:00:00','2024-01-10 10:00:00'),(7,1,1,'법무팀','NVR-LEG',2,3,NULL,'2019-01-01 09:00:00','2024-01-10 10:00:00'),(8,1,2,'백엔드개발팀','NVR-BE',2,1,NULL,'2018-05-01 09:00:00','2024-01-10 10:00:00'),(9,1,2,'프론트개발팀','NVR-FE',2,2,NULL,'2018-05-01 09:00:00','2024-01-10 10:00:00'),(10,1,2,'인프라팀','NVR-INFRA',2,3,NULL,'2018-05-01 09:00:00','2024-01-10 10:00:00'),(11,1,3,'검색서비스팀','NVR-SRCH',2,1,NULL,'2018-06-01 09:00:00','2024-01-10 10:00:00'),(12,1,3,'광고서비스팀','NVR-AD',2,2,NULL,'2018-06-01 09:00:00','2024-01-10 10:00:00'),(13,1,4,'AI연구팀','NVR-AI',2,1,NULL,'2019-04-01 09:00:00','2024-01-10 10:00:00'),(14,1,4,'데이터분석팀','NVR-DA',2,2,NULL,'2019-04-01 09:00:00','2024-01-10 10:00:00'),(15,1,8,'API파트','NVR-BE-API',3,1,NULL,'2020-01-01 09:00:00','2024-01-10 10:00:00'),(16,1,8,'DB파트','NVR-BE-DB',3,2,NULL,'2020-01-01 09:00:00','2024-01-10 10:00:00'),(17,2,NULL,'경영지원본부','KKO-MGT',1,1,NULL,'2018-08-01 09:00:00','2024-02-05 10:00:00'),(18,2,NULL,'기술본부','KKO-TEC',1,2,NULL,'2018-08-01 09:00:00','2024-02-05 10:00:00'),(19,2,NULL,'플랫폼본부','KKO-PLT',1,3,NULL,'2018-08-01 09:00:00','2024-02-05 10:00:00'),(20,2,17,'인사팀','KKO-HR',2,1,NULL,'2018-09-01 09:00:00','2024-02-05 10:00:00'),(21,2,17,'재무팀','KKO-FIN',2,2,NULL,'2018-09-01 09:00:00','2024-02-05 10:00:00'),(22,2,18,'백엔드팀','KKO-BE',2,1,NULL,'2018-09-01 09:00:00','2024-02-05 10:00:00'),(23,2,18,'프론트팀','KKO-FE',2,2,NULL,'2018-09-01 09:00:00','2024-02-05 10:00:00'),(24,2,18,'AI팀','KKO-AI',2,3,NULL,'2019-06-01 09:00:00','2024-02-05 10:00:00'),(25,2,19,'카카오톡팀','KKO-TALK',2,1,NULL,'2018-09-01 09:00:00','2024-02-05 10:00:00'),(26,2,19,'카카오페이팀','KKO-PAY',2,2,NULL,'2019-01-01 09:00:00','2024-02-05 10:00:00'),(27,2,22,'서버파트','KKO-BE-SV',3,1,NULL,'2020-03-01 09:00:00','2024-02-05 10:00:00'),(28,2,22,'보안파트','KKO-BE-SC',3,2,NULL,'2020-03-01 09:00:00','2024-02-05 10:00:00'),(29,3,NULL,'개발본부','LINE-DEV',1,1,NULL,'2019-05-01 09:00:00','2023-11-20 10:00:00'),(30,3,NULL,'서비스본부','LINE-SVC',1,2,NULL,'2019-05-01 09:00:00','2023-11-20 10:00:00'),(31,3,NULL,'경영지원본부','LINE-MGT',1,3,NULL,'2019-05-01 09:00:00','2023-11-20 10:00:00'),(32,3,29,'플랫폼개발팀','LINE-PLT',2,1,NULL,'2019-06-01 09:00:00','2023-11-20 10:00:00'),(33,3,29,'메신저개발팀','LINE-MSG',2,2,NULL,'2019-06-01 09:00:00','2023-11-20 10:00:00'),(34,3,30,'글로벌서비스팀','LINE-GLB',2,1,NULL,'2019-06-01 09:00:00','2023-11-20 10:00:00'),(35,3,31,'인사팀','LINE-HR',2,1,NULL,'2019-06-01 09:00:00','2023-11-20 10:00:00'),(36,3,32,'API파트','LINE-API',3,1,NULL,'2021-01-01 09:00:00','2023-11-20 10:00:00'),(37,4,NULL,'기술본부','NHN-TEC',1,1,NULL,'2020-02-01 09:00:00','2024-03-15 10:00:00'),(38,4,NULL,'게임본부','NHN-GAME',1,2,NULL,'2020-02-01 09:00:00','2024-03-15 10:00:00'),(39,4,NULL,'경영본부','NHN-MGT',1,3,NULL,'2020-02-01 09:00:00','2024-03-15 10:00:00'),(40,4,37,'클라우드팀','NHN-CLD',2,1,NULL,'2020-03-01 09:00:00','2024-03-15 10:00:00'),(41,4,37,'인프라팀','NHN-INFRA',2,2,NULL,'2020-03-01 09:00:00','2024-03-15 10:00:00'),(42,4,38,'모바일게임팀','NHN-MOB',2,1,NULL,'2020-03-01 09:00:00','2024-03-15 10:00:00'),(43,4,38,'PC게임팀','NHN-PC',2,2,NULL,'2020-03-01 09:00:00','2024-03-15 10:00:00'),(44,4,39,'인사팀','NHN-HR',2,1,NULL,'2020-03-01 09:00:00','2024-03-15 10:00:00'),(45,4,40,'K8S파트','NHN-K8S',3,1,NULL,'2021-05-01 09:00:00','2024-03-15 10:00:00'),(46,5,NULL,'인프라본부','NVC-INFRA',1,1,NULL,'2021-06-01 09:00:00','2024-04-01 10:00:00'),(47,5,NULL,'개발본부','NVC-DEV',1,2,NULL,'2021-06-01 09:00:00','2024-04-01 10:00:00'),(48,5,NULL,'영업본부','NVC-SALE',1,3,NULL,'2021-06-01 09:00:00','2024-04-01 10:00:00'),(49,5,46,'서버운영팀','NVC-SRV',2,1,NULL,'2021-07-01 09:00:00','2024-04-01 10:00:00'),(50,5,46,'네트워크팀','NVC-NET',2,2,NULL,'2021-07-01 09:00:00','2024-04-01 10:00:00'),(51,5,47,'플랫폼개발팀','NVC-PLT',2,1,NULL,'2021-07-01 09:00:00','2024-04-01 10:00:00'),(52,5,47,'AI개발팀','NVC-AI',2,2,NULL,'2021-07-01 09:00:00','2024-04-01 10:00:00'),(53,5,48,'기업영업팀','NVC-ENT',2,1,NULL,'2021-07-01 09:00:00','2024-04-01 10:00:00'),(54,5,49,'데이터센터파트','NVC-DC',3,1,NULL,'2022-01-01 09:00:00','2024-04-01 10:00:00'),(55,7,NULL,'프로덕트본부','TOSS-PRD',1,1,NULL,'2020-07-01 09:00:00','2023-12-10 10:00:00'),(56,7,NULL,'엔지니어링본부','TOSS-ENG',1,2,NULL,'2020-07-01 09:00:00','2023-12-10 10:00:00'),(57,7,NULL,'경영지원본부','TOSS-MGT',1,3,NULL,'2020-07-01 09:00:00','2023-12-10 10:00:00'),(58,7,55,'결제서비스팀','TOSS-PAY',2,1,NULL,'2020-08-01 09:00:00','2023-12-10 10:00:00'),(59,7,55,'대출서비스팀','TOSS-LOAN',2,2,NULL,'2020-08-01 09:00:00','2023-12-10 10:00:00'),(60,7,56,'백엔드팀','TOSS-BE',2,1,NULL,'2020-08-01 09:00:00','2023-12-10 10:00:00'),(61,7,56,'프론트팀','TOSS-FE',2,2,NULL,'2020-08-01 09:00:00','2023-12-10 10:00:00'),(62,7,56,'보안팀','TOSS-SEC',2,3,NULL,'2020-08-01 09:00:00','2023-12-10 10:00:00'),(63,7,57,'인사팀','TOSS-HR',2,1,NULL,'2020-08-01 09:00:00','2023-12-10 10:00:00'),(64,7,60,'API파트','TOSS-API',3,1,NULL,'2021-03-01 09:00:00','2023-12-10 10:00:00'),(65,9,NULL,'프로덕트본부','DRN-PRD',1,1,NULL,'2020-10-01 09:00:00','2024-01-05 10:00:00'),(66,9,NULL,'엔지니어링본부','DRN-ENG',1,2,NULL,'2020-10-01 09:00:00','2024-01-05 10:00:00'),(67,9,NULL,'비즈니스본부','DRN-BIZ',1,3,NULL,'2020-10-01 09:00:00','2024-01-05 10:00:00'),(68,9,65,'중고거래팀','DRN-MKT',2,1,NULL,'2020-11-01 09:00:00','2024-01-05 10:00:00'),(69,9,65,'동네생활팀','DRN-LOC',2,2,NULL,'2020-11-01 09:00:00','2024-01-05 10:00:00'),(70,9,66,'백엔드팀','DRN-BE',2,1,NULL,'2020-11-01 09:00:00','2024-01-05 10:00:00'),(71,9,66,'프론트팀','DRN-FE',2,2,NULL,'2020-11-01 09:00:00','2024-01-05 10:00:00'),(72,9,67,'광고팀','DRN-AD',2,1,NULL,'2021-01-01 09:00:00','2024-01-05 10:00:00'),(73,9,70,'API파트','DRN-API',3,1,NULL,'2021-06-01 09:00:00','2024-01-05 10:00:00'),(74,9,70,'DB파트','DRN-DB',3,2,NULL,'2021-06-01 09:00:00','2024-01-05 10:00:00'),(75,11,NULL,'기술본부','CPG-TEC',1,1,NULL,'2019-06-01 09:00:00','2024-05-01 10:00:00'),(76,11,NULL,'물류본부','CPG-LOG',1,2,NULL,'2019-06-01 09:00:00','2024-05-01 10:00:00'),(77,11,NULL,'커머스본부','CPG-COM',1,3,NULL,'2019-06-01 09:00:00','2024-05-01 10:00:00'),(78,11,NULL,'경영지원본부','CPG-MGT',1,4,NULL,'2019-06-01 09:00:00','2024-05-01 10:00:00'),(79,11,75,'백엔드팀','CPG-BE',2,1,NULL,'2019-07-01 09:00:00','2024-05-01 10:00:00'),(80,11,75,'데이터팀','CPG-DATA',2,2,NULL,'2019-07-01 09:00:00','2024-05-01 10:00:00'),(81,11,75,'AI팀','CPG-AI',2,3,NULL,'2020-01-01 09:00:00','2024-05-01 10:00:00'),(82,11,76,'배송운영팀','CPG-DLV',2,1,NULL,'2019-07-01 09:00:00','2024-05-01 10:00:00'),(83,11,76,'물류센터팀','CPG-WHS',2,2,NULL,'2019-07-01 09:00:00','2024-05-01 10:00:00'),(84,11,77,'상품기획팀','CPG-MD',2,1,NULL,'2019-07-01 09:00:00','2024-05-01 10:00:00'),(85,11,77,'마케팅팀','CPG-MKT',2,2,NULL,'2019-07-01 09:00:00','2024-05-01 10:00:00'),(86,11,78,'인사팀','CPG-HR',2,1,NULL,'2019-07-01 09:00:00','2024-05-01 10:00:00'),(87,11,78,'재무팀','CPG-FIN',2,2,NULL,'2019-07-01 09:00:00','2024-05-01 10:00:00'),(88,11,79,'서버파트','CPG-SRV',3,1,NULL,'2020-06-01 09:00:00','2024-05-01 10:00:00'),(89,11,79,'DB파트','CPG-DB',3,2,NULL,'2020-06-01 09:00:00','2024-05-01 10:00:00'),(90,31,NULL,'영업본부','SHC-SALE',1,1,NULL,'2019-02-01 09:00:00','2024-01-25 10:00:00'),(91,31,NULL,'IT본부','SHC-IT',1,2,NULL,'2019-02-01 09:00:00','2024-01-25 10:00:00'),(92,31,NULL,'리스크본부','SHC-RISK',1,3,NULL,'2019-02-01 09:00:00','2024-01-25 10:00:00'),(93,31,NULL,'경영지원본부','SHC-MGT',1,4,NULL,'2019-02-01 09:00:00','2024-01-25 10:00:00'),(94,31,90,'개인영업팀','SHC-RTL',2,1,NULL,'2019-03-01 09:00:00','2024-01-25 10:00:00'),(95,31,90,'법인영업팀','SHC-CORP',2,2,NULL,'2019-03-01 09:00:00','2024-01-25 10:00:00'),(96,31,91,'시스템개발팀','SHC-DEV',2,1,NULL,'2019-03-01 09:00:00','2024-01-25 10:00:00'),(97,31,91,'정보보안팀','SHC-SEC',2,2,NULL,'2019-03-01 09:00:00','2024-01-25 10:00:00'),(98,31,92,'심사팀','SHC-EVAL',2,1,NULL,'2019-03-01 09:00:00','2024-01-25 10:00:00'),(99,31,93,'인사팀','SHC-HR',2,1,NULL,'2019-03-01 09:00:00','2024-01-25 10:00:00'),(100,31,96,'백엔드파트','SHC-BE',3,1,NULL,'2020-05-01 09:00:00','2024-01-25 10:00:00');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_auth`
--

DROP TABLE IF EXISTS `emp_auth`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_auth` (
  `emp_aut_id` int NOT NULL,
  `emp_id` int NOT NULL,
  `aut_id` int NOT NULL,
  PRIMARY KEY (`emp_aut_id`),
  KEY `fk_emp_auth_employee1_idx` (`emp_id`),
  KEY `fk_emp_auth_authority1_idx` (`aut_id`),
  CONSTRAINT `fk_emp_auth_authority1` FOREIGN KEY (`aut_id`) REFERENCES `authority` (`aut_id`),
  CONSTRAINT `fk_emp_auth_employee1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_auth`
--

LOCK TABLES `emp_auth` WRITE;
/*!40000 ALTER TABLE `emp_auth` DISABLE KEYS */;
/*!40000 ALTER TABLE `emp_auth` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_position`
--

DROP TABLE IF EXISTS `emp_position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_position` (
  `pos_id` int NOT NULL AUTO_INCREMENT,
  `com_id` int NOT NULL,
  `pos_code` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pos_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pos_order` int NOT NULL,
  PRIMARY KEY (`pos_id`),
  KEY `fk_emp_position_company1_idx` (`com_id`),
  CONSTRAINT `fk_emp_position_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_position`
--

LOCK TABLES `emp_position` WRITE;
/*!40000 ALTER TABLE `emp_position` DISABLE KEYS */;
/*!40000 ALTER TABLE `emp_position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `emp_id` int NOT NULL AUTO_INCREMENT,
  `com_id` int NOT NULL,
  `pos_id` int NOT NULL,
  `dept_id` int NOT NULL,
  `emp_no` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `emp_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `emp_pass` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `emp_email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `emp_mobile` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `emp_status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT '재직',
  `hire_date` date DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`emp_id`),
  KEY `fk_employee_company1_idx` (`com_id`),
  KEY `fk_employee_emp_position1_idx` (`pos_id`),
  KEY `fk_employee_department1_idx` (`dept_id`),
  CONSTRAINT `fk_employee_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`),
  CONSTRAINT `fk_employee_department1` FOREIGN KEY (`dept_id`) REFERENCES `department` (`dept_id`),
  CONSTRAINT `fk_employee_emp_position1` FOREIGN KEY (`pos_id`) REFERENCES `emp_position` (`pos_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `bno` int NOT NULL AUTO_INCREMENT,
  `emp_id` int NOT NULL,
  `com_id` int NOT NULL,
  `btitle` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bcontent` varchar(1000) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bhit` int NOT NULL DEFAULT '0',
  `bfile` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`bno`),
  KEY `fk_notice_employee1_idx` (`emp_id`),
  KEY `fk_notice_company1_idx` (`com_id`),
  CONSTRAINT `fk_notice_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`),
  CONSTRAINT `fk_notice_employee1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `pro_id` int NOT NULL AUTO_INCREMENT,
  `emp_id` int NOT NULL,
  `com_id` int NOT NULL,
  `pro_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pro_desc` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pro_status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `start_date` datetime NOT NULL,
  `end_date` datetime NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `fk_project_employee1_idx` (`emp_id`),
  KEY `fk_project_company1_idx` (`com_id`),
  CONSTRAINT `fk_project_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`),
  CONSTRAINT `fk_project_employee1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_member`
--

DROP TABLE IF EXISTS `project_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_member` (
  `pm_id` int NOT NULL AUTO_INCREMENT,
  `project_pro_id` int NOT NULL,
  `emp_id` int NOT NULL,
  `role` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `joined_at` datetime NOT NULL,
  PRIMARY KEY (`pm_id`),
  KEY `fk_project_member_project1_idx` (`project_pro_id`),
  KEY `fk_project_member_employee1_idx` (`emp_id`),
  CONSTRAINT `fk_project_member_employee1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `fk_project_member_project1` FOREIGN KEY (`project_pro_id`) REFERENCES `project` (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_member`
--

LOCK TABLES `project_member` WRITE;
/*!40000 ALTER TABLE `project_member` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservation` (
  `rev_id` int NOT NULL AUTO_INCREMENT,
  `res_id` int NOT NULL,
  `com_id` int NOT NULL,
  `emp_id` int NOT NULL,
  `quantity` int NOT NULL,
  `status` enum('WAI','APP','REJ') COLLATE utf8mb4_unicode_ci NOT NULL,
  `req_date` datetime DEFAULT NULL,
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`rev_id`),
  KEY `fk_reservation_employee1_idx` (`emp_id`),
  KEY `fk_reservation_company1_idx` (`com_id`),
  KEY `fk_reservation_resource1_idx` (`res_id`),
  CONSTRAINT `fk_reservation_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`),
  CONSTRAINT `fk_reservation_employee1` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`),
  CONSTRAINT `fk_reservation_resource1` FOREIGN KEY (`res_id`) REFERENCES `resource` (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource`
--

DROP TABLE IF EXISTS `resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resource` (
  `res_id` int NOT NULL AUTO_INCREMENT,
  `com_id` int NOT NULL,
  `res_code` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `res_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `res_type` enum('Romm') COLLATE utf8mb4_unicode_ci NOT NULL,
  `quantity` int NOT NULL,
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`res_id`),
  KEY `fk_resource_company1_idx` (`com_id`),
  CONSTRAINT `fk_resource_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource`
--

LOCK TABLES `resource` WRITE;
/*!40000 ALTER TABLE `resource` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `task` (
  `task_id` int NOT NULL AUTO_INCREMENT,
  `pro_id` int NOT NULL,
  `pm_id` int NOT NULL,
  `com_id` int NOT NULL,
  `task_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `task_desc` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `task_status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pm_id_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `task_start_date` datetime NOT NULL,
  `task_end_date` datetime NOT NULL,
  `task_created_at` datetime NOT NULL,
  `task_updated_at` datetime NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `fk_task_project1_idx` (`pro_id`),
  KEY `fk_task_project_member1_idx` (`pm_id`),
  KEY `fk_task_company1_idx` (`com_id`),
  CONSTRAINT `fk_task_company1` FOREIGN KEY (`com_id`) REFERENCES `company` (`com_id`),
  CONSTRAINT `fk_task_project1` FOREIGN KEY (`pro_id`) REFERENCES `project` (`pro_id`),
  CONSTRAINT `fk_task_project_member1` FOREIGN KEY (`pm_id`) REFERENCES `project_member` (`pm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-16 20:15:09
