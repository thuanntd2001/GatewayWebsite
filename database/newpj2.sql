-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: localhost    Database: kinhdoanh
-- ------------------------------------------------------
-- Server version	8.0.33-0ubuntu0.22.04.2

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES (1,'admin'),(2,'user');
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctddh`
--

DROP TABLE IF EXISTS `ctddh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ctddh` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `danhgia` longtext,
  `diem` int DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  `tongtien` int DEFAULT NULL,
  `maddh` bigint DEFAULT NULL,
  `sanpham` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctddh`
--

LOCK TABLES `ctddh` WRITE;
/*!40000 ALTER TABLE `ctddh` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctddh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ctpn`
--

DROP TABLE IF EXISTS `ctpn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ctpn` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dongia` int DEFAULT NULL,
  `soluong` int DEFAULT NULL,
  `mapn` bigint DEFAULT NULL,
  `sanpham` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ctpn`
--

LOCK TABLES `ctpn` WRITE;
/*!40000 ALTER TABLE `ctpn` DISABLE KEYS */;
/*!40000 ALTER TABLE `ctpn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dondathang`
--

DROP TABLE IF EXISTS `dondathang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dondathang` (
  `maddh` bigint NOT NULL AUTO_INCREMENT,
  `ngaythuchien` datetime DEFAULT NULL,
  `tinhtrang` int DEFAULT NULL,
  `makh` bigint DEFAULT NULL,
  `nvxacnhan` bigint DEFAULT NULL,
  PRIMARY KEY (`maddh`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dondathang`
--

LOCK TABLES `dondathang` WRITE;
/*!40000 ALTER TABLE `dondathang` DISABLE KEYS */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'234','qrfwe@dsfg',1,'gfsd','sdaf','sdfgsdf','2001-10-03 00:00:00','2001-10-03','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','3e45435345',1,'khachhang1');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loaisp`
--

DROP TABLE IF EXISTS `loaisp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loaisp` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `tenloai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loaisp`
--

LOCK TABLES `loaisp` WRITE;
/*!40000 ALTER TABLE `loaisp` DISABLE KEYS */;
/*!40000 ALTER TABLE `loaisp` ENABLE KEYS */;
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
  PRIMARY KEY (`manv`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'1234567890','55 jjj','werf',1,'thuan','LOGO.WEBM',2000000,'2001-10-03','2001-10-03','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','0900909009090',1,'admin'),(2,'1234567890','55 jjj','werf',1,'thuan2','LOGO.WEBM',2000000,'2001-10-03','2001-10-03','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','0900909009090',1,'nhanvien1');
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
  `id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien_chucvu`
--

LOCK TABLES `nhanvien_chucvu` WRITE;
/*!40000 ALTER TABLE `nhanvien_chucvu` DISABLE KEYS */;
INSERT INTO `nhanvien_chucvu` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `nhanvien_chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieunhap` (
  `mapn` bigint NOT NULL AUTO_INCREMENT,
  `nhacc` varchar(255) DEFAULT NULL,
  `ngay` datetime DEFAULT NULL,
  `tinhtrang` int DEFAULT NULL,
  `manv` bigint DEFAULT NULL,
  PRIMARY KEY (`mapn`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieunhap`
--

LOCK TABLES `phieunhap` WRITE;
/*!40000 ALTER TABLE `phieunhap` DISABLE KEYS */;
/*!40000 ALTER TABLE `phieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `donvitinh` varchar(255) DEFAULT NULL,
  `gia` int DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `mota` longtext,
  `soluongton` int DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `trangthai` int DEFAULT NULL,
  `loai` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
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

-- Dump completed on 2023-08-23 18:58:13
