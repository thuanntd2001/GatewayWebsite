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
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucvu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tenchucvu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES (1,'ADMIN'),(2,'SALES'),(3,'DOCS');
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dondathang`
--

DROP TABLE IF EXISTS `dondathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dondathang` (
  `maddh` bigint NOT NULL AUTO_INCREMENT,
  `dkgh` int DEFAULT NULL,
  `dknh` int DEFAULT NULL,
  `isfcl` int DEFAULT NULL,
  `luuy` varchar(255) DEFAULT NULL,
  `motahh` varchar(255) DEFAULT NULL,
  `ngaythuchien` datetime DEFAULT NULL,
  `nhomhang` int DEFAULT NULL,
  `tgkh` varchar(255) DEFAULT NULL,
  `tinhtrang` int DEFAULT NULL,
  `makh` bigint DEFAULT NULL,
  `nvxacnhan` bigint DEFAULT NULL,
  `sanpham` bigint DEFAULT NULL,
  PRIMARY KEY (`maddh`),
  KEY `FK7mfty2m79o98uk1b6vmht5pn8` (`makh`),
  KEY `FKqu0hxpglbow8gvmc6rco62crm` (`nvxacnhan`),
  KEY `FKfyvbgmfw1gdjmtoo7lhrer2hs` (`sanpham`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dondathang`
--

LOCK TABLES `dondathang` WRITE;
/*!40000 ALTER TABLE `dondathang` DISABLE KEYS */;
INSERT INTO `dondathang` VALUES (1,2,2,0,'Luu y','Do choi','2024-03-15 00:00:00',1,'tu 20/3 den 25/3',1,1,2,1);
/*!40000 ALTER TABLE `dondathang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giohang`
--

DROP TABLE IF EXISTS `giohang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giohang` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `soluong` int DEFAULT NULL,
  `makh` bigint DEFAULT NULL,
  `sanpham` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3a5g8iyvgpwxy37062hwv5339` (`makh`),
  KEY `FKh66e48rmycmnjfbsmfo3ir9ce` (`sanpham`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giohang`
--

LOCK TABLES `giohang` WRITE;
/*!40000 ALTER TABLE `giohang` DISABLE KEYS */;
/*!40000 ALTER TABLE `giohang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `makh` bigint NOT NULL AUTO_INCREMENT,
  `diachi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gioitinh` int DEFAULT NULL,
  `hoten` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `maxacthuc` varchar(255) DEFAULT NULL,
  `ngaydangky` datetime DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `trangthai` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`makh`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'','thiensudanduong12@gmail.com',1,'Nguyen Tran Duc Thuan','','asdfasdf','2024-03-10 00:00:00','2001-03-10','123456','0921672953',1,'thuannguyen');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `manv` bigint NOT NULL AUTO_INCREMENT,
  `cmnd` varchar(255) DEFAULT NULL,
  `diachi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gioitinh` int DEFAULT NULL,
  `hoten` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `luong` int DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `ngayvaolam` date DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `sdt` varchar(255) DEFAULT NULL,
  `trangthai` int DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `chucvuchinh` bigint DEFAULT NULL,
  PRIMARY KEY (`manv`),
  KEY `FKl3n530wv53k75nl0mgrh4or14` (`chucvuchinh`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'1234567890','55 jjj','werf',1,'thuan','LOGO.WEBM',2000000,'2001-10-03','2001-10-03','123456','0900909009090',1,'admin',1),(2,'1234567890','55 jjj','werf',1,'thuan2','LOGO.WEBM',2000000,'2001-10-03','2001-10-03','123456','0900909009090',1,'sale1',2),(3,'1234567890','55 jjj','werf',1,'thuan2','LOGO.WEBM',2000000,'2001-10-03','2001-10-03','123456','0900909009090',1,'doc1',3);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien_chucvu`
--

DROP TABLE IF EXISTS `nhanvien_chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien_chucvu` (
  `manv` bigint NOT NULL,
  `id` bigint NOT NULL,
  KEY `FKg6tteauf5w8dqa32dyxusminy` (`id`),
  KEY `FKa5xmthd9pd8qn9w5l45nyn74h` (`manv`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien_chucvu`
--

LOCK TABLES `nhanvien_chucvu` WRITE;
/*!40000 ALTER TABLE `nhanvien_chucvu` DISABLE KEYS */;
/*!40000 ALTER TABLE `nhanvien_chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dvvc` varchar(255) DEFAULT NULL,
  `cuocvc` int DEFAULT NULL,
  `etd` int DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `loai` bigint DEFAULT NULL,
  `mota` longtext,
  `noiden` varchar(255) DEFAULT NULL,
  `noidi` varchar(255) DEFAULT NULL,
  `notephiden` varchar(255) DEFAULT NULL,
  `notephidi` varchar(255) DEFAULT NULL,
  `phidenbl` int DEFAULT NULL,
  `phidencmb` int DEFAULT NULL,
  `phidencont` int DEFAULT NULL,
  `phidenset` int DEFAULT NULL,
  `phidibl` int DEFAULT NULL,
  `phidicmb` int DEFAULT NULL,
  `phidicont` int DEFAULT NULL,
  `phidiset` int DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `tgvc` int DEFAULT NULL,
  `trangthai` int DEFAULT NULL,
  `nvtao` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj8y7du2gtp3n0mghldybndi9a` (`nvtao`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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

-- Dump completed on 2024-03-15 13:38:44
