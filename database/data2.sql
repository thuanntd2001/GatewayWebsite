-- MySQL dump 10.13  Distrib 8.0.35, for Linux (x86_64)
--
-- Host: localhost    Database: gateway
-- ------------------------------------------------------
-- Server version	8.0.35-0ubuntu0.22.04.1

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
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES (1,'ADMIN'),(2,'SALES'),(3,'DOCS');
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `confirmtoken`
--

LOCK TABLES `confirmtoken` WRITE;
/*!40000 ALTER TABLE `confirmtoken` DISABLE KEYS */;
INSERT INTO `confirmtoken` VALUES (1,NULL,'2024-03-17 10:54:57','2024-03-17 11:09:57','bc09c985-e33d-4188-9cd4-f3321189ea03',1);
/*!40000 ALTER TABLE `confirmtoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `dondathang`
--

LOCK TABLES `dondathang` WRITE;
/*!40000 ALTER TABLE `dondathang` DISABLE KEYS */;
INSERT INTO `dondathang` VALUES (1,2,2,0,'Luu y','Do choi','2024-03-15 00:00:00',1,'tu 20/3 den 25/3',1,1,2,1);
/*!40000 ALTER TABLE `dondathang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `giohang`
--

LOCK TABLES `giohang` WRITE;
/*!40000 ALTER TABLE `giohang` DISABLE KEYS */;
/*!40000 ALTER TABLE `giohang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,NULL,'thiensudanduong12234@gmail.com',0,NULL,'logo.webp',1,0,NULL,NULL,'password123',NULL,1);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'1234567890','55 jjj','werf',1,'thuan','LOGO.WEBM',2000000,'2001-10-03','2001-10-03','123456','0900909009090',1,'admin',1),(2,'1234567890','55 jjj','werf',1,'thuan2','LOGO.WEBM',2000000,'2001-10-03','2001-10-03','123456','0900909009090',1,'sale1',2),(3,'1234567890','55 jjj','werf',1,'thuan2','LOGO.WEBM',2000000,'2001-10-03','2001-10-03','123456','0900909009090',1,'doc1',3);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nhanvien_chucvu`
--

LOCK TABLES `nhanvien_chucvu` WRITE;
/*!40000 ALTER TABLE `nhanvien_chucvu` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhanvien_chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'oocl',10000,8,NULL,1,'','SYD','HCM',NULL,NULL,0,30000,0,20000,0,40000,0,50000,'LCL Ho cChi Minh - Sydney',20,1,1),(2,'KMTC',10000,8,NULL,0,'','BKK','HCM',NULL,NULL,0,30000,0,20000,0,40000,0,50000,'LCL Ho cChi Minh - Bangkok',5,1,1);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-17 13:16:29
