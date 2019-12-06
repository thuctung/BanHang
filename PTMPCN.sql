-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: localhost    Database: PTMPCN
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `Account`
--

DROP TABLE IF EXISTS `Account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Account` (
  `idAccount` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Password` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Role` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAccount`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Account`
--

LOCK TABLES `Account` WRITE;
/*!40000 ALTER TABLE `Account` DISABLE KEYS */;
INSERT INTO `Account` VALUES (1,'admin','admin',0),(2,'thuctung','thuctung',1);
/*!40000 ALTER TABLE `Account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ChiTietDonHang`
--

DROP TABLE IF EXISTS `ChiTietDonHang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ChiTietDonHang` (
  `idDonHang` int(11) DEFAULT NULL,
  `idSanPham` int(11) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ChiTietDonHang`
--

LOCK TABLES `ChiTietDonHang` WRITE;
/*!40000 ALTER TABLE `ChiTietDonHang` DISABLE KEYS */;
INSERT INTO `ChiTietDonHang` VALUES (1,1,1),(1,27,1);
/*!40000 ALTER TABLE `ChiTietDonHang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DanhGiaSanPham`
--

DROP TABLE IF EXISTS `DanhGiaSanPham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DanhGiaSanPham` (
  `idkhachhang` int(11) DEFAULT NULL,
  `ngaydanhgia` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `noidung` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `masanpham` int(11) DEFAULT NULL,
  `diem` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DanhGiaSanPham`
--

LOCK TABLES `DanhGiaSanPham` WRITE;
/*!40000 ALTER TABLE `DanhGiaSanPham` DISABLE KEYS */;
INSERT INTO `DanhGiaSanPham` VALUES (2,'18/11/2019','ngu nef',1,4),(2,'18/11/2019','Camera chụp tốt. Pin hơi yếu',27,3),(1,'18/11/2019','Quá ngon trong tầm giá',27,5),(1,'22/11/2019','Điện thoại tốt. Nhưng nay buồn nên cho 1 sao!',1,2);
/*!40000 ALTER TABLE `DanhGiaSanPham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DanhMuc`
--

DROP TABLE IF EXISTS `DanhMuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DanhMuc` (
  `madanhmuc` int(11) NOT NULL,
  `tendanhmuc` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DanhMuc`
--

LOCK TABLES `DanhMuc` WRITE;
/*!40000 ALTER TABLE `DanhMuc` DISABLE KEYS */;
INSERT INTO `DanhMuc` VALUES (1,'Điện thoại'),(2,'Tablet');
/*!40000 ALTER TABLE `DanhMuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DonHang`
--

DROP TABLE IF EXISTS `DonHang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DonHang` (
  `idDonHang` int(11) NOT NULL,
  `NgayTao` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TrangThai` int(11) DEFAULT NULL,
  `sodienthoai` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LoaiDonHang` int(11) DEFAULT NULL,
  `GiamGia` int(11) DEFAULT NULL,
  `TongTien` int(11) DEFAULT NULL,
  `ThanhTien` int(11) DEFAULT NULL,
  `YeuCau` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`idDonHang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DonHang`
--

LOCK TABLES `DonHang` WRITE;
/*!40000 ALTER TABLE `DonHang` DISABLE KEYS */;
INSERT INTO `DonHang` VALUES (1,'23-11-2019 12:18:33',0,'0385323666',1,25480000,2000000,23480000,'Giao trong ngày');
/*!40000 ALTER TABLE `DonHang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `HangSanXuat`
--

DROP TABLE IF EXISTS `HangSanXuat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `HangSanXuat` (
  `mahang` int(11) NOT NULL,
  `tenhang` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `HangSanXuat`
--

LOCK TABLES `HangSanXuat` WRITE;
/*!40000 ALTER TABLE `HangSanXuat` DISABLE KEYS */;
INSERT INTO `HangSanXuat` VALUES (1,'Apple'),(2,'Huawei'),(3,'Oppo'),(4,'Samsung');
/*!40000 ALTER TABLE `HangSanXuat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `KhachHang`
--

DROP TABLE IF EXISTS `KhachHang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `KhachHang` (
  `idKhachHang` int(11) NOT NULL,
  `HoTen` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SoDienThoai` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DiaChi` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idKhachHang`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `KhachHang`
--

LOCK TABLES `KhachHang` WRITE;
/*!40000 ALTER TABLE `KhachHang` DISABLE KEYS */;
INSERT INTO `KhachHang` VALUES (1,'Nguyễn Thúc Tùng','0385323666','Quy Nhơn','thuc@gmail.com'),(2,'Trần Văn A','0935246578','Đà Nẵng','thuctung@gmail.com');
/*!40000 ALTER TABLE `KhachHang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SanPham`
--

DROP TABLE IF EXISTS `SanPham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SanPham` (
  `masanpham` int(11) NOT NULL,
  `tensanpham` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `dongia` int(11) NOT NULL,
  `hinhanh` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `mota` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `madanhmuc` int(11) NOT NULL,
  `hangsanxuat` int(11) NOT NULL,
  `KhuyenMai` int(11) DEFAULT NULL,
  `diemdanhgia` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SanPham`
--

LOCK TABLES `SanPham` WRITE;
/*!40000 ALTER TABLE `SanPham` DISABLE KEYS */;
INSERT INTO `SanPham` VALUES (1,'Huawei P30 Pro',20690000,'huaweip30pro.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác)',1,2,1,6),(2,'Huawei Mate 20',15900000,'huaweimax20.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). (click xem chi tiết)\r\n',1,2,NULL,0),(3,'Huawei Nova 3i',4999000,'huaweinova3i.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). (click xem chi tiết)\r\n',1,2,1,0),(4,'Huawei Nova 3i Trắng',4990000,'huaweinova3itrang.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). (click xem chi tiết)\r\n',1,2,NULL,0),(5,'Huawei P30',15290000,'huaweip30.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). (click xem chi tiết)\r\n',1,2,NULL,0),(6,'Huawei P30 Lite',6290000,'huaweip30lite.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). (click xem chi tiết)\r\n',1,2,NULL,0),(7,'Huawei Y6 Prime',2390000,'huaweiy6prime.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). (click xem chi tiết)\r\n',1,2,NULL,0),(8,'Huawei Y7 Pro',4690000,'huaweiy7pro.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). (click xem chi tiết)\r\n',1,2,NULL,0),(9,'Huawei Y9',4490000,'huaweiy9.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). (click xem chi tiết)\r\n',1,2,NULL,0),(10,'Huawei Y9 Blue',5390000,'huaweiy9blue.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). (click xem chi tiết)\r\n',1,2,NULL,0),(11,'Iphone 6+',9490000,'iphone6splus.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(12,'Iphone 7+ 32G',11490000,'iphone7plus32g.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(13,'Iphone 8+ 64G',19450000,'iphone8plus64g.jpg	','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(14,'Iphone 7 32G',12590000,'iphone732g.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(15,'Iphone X 32G',22590000,'iphonex32g.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(16,'Iphone X 64G',23490000,'iphonex64g.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(17,'Iphone X 256G',24390000,'iphonex256g.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(18,'Iphone XR 128G',19990000,'iphonexr128g.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(19,'Iphone XR 256G',21990000,'iphonexr256g.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(20,'Iphone XS',26490000,'iphonexs.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(21,'Iphone XS Max	',34590000,'iphonexsmax.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(22,'Iphone XS Max 64G',37390000,'iphonexsmax64g.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,1,NULL,0),(23,'Oppo A1 K',3290000,'oppoa1k.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). ',1,3,NULL,0),(24,'Oppo A3 S',4999000,'oppoa3s.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). ',1,3,NULL,0),(25,'Oppo A5 S',3990000,'oppoa5s.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). ',1,3,NULL,0),(26,'Oppo A7',3590000,'oppoa7.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). ',1,3,NULL,0),(27,'Oppo A9 ',4790000,'oppoa9.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). ',1,3,1,8),(28,'Oppo A9 2020',5190000,'oppoa92020.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). ',1,3,NULL,0),(29,'Oppo F11',6290000,'oppof11.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). ',1,3,NULL,0),(30,'Oppo K3',5990000,'oppok3.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). ',1,3,NULL,0),(31,'Oppo R17 Pro',10990000,'oppor17pro.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác). ',1,3,1,0),(32,'Oppo Reno',11990000,'opporeno.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,3,NULL,0),(33,'Oppo Reno 10X',14990000,'opporeno10x.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,3,NULL,0),(34,'Samsung Galaxy Note 9',20490000,'samsunggalaxynote9.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,NULL,0),(35,'Samsung Galaxy A9',12490000,'samsunggalaxya9.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,NULL,0),(36,'Samsung Glaxy A50',6290000,'samsunggalaxya50.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,NULL,0),(37,'Samsung Galaxy A50S',7790000,'samsunggalaxya50s.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,NULL,0),(38,'Samsung Galaxy A70',7590000,'samsunggalaxya70.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,NULL,0),(39,'Samsung Galaxy A80',7890000,'samsunggalaxya80.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,NULL,0),(40,'Samsung Galaxy A80 Star',8590000,'samsunggalaxya80star.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,1,0),(41,'Samsung Galaxy Note 10',22990000,'samsunggalaxynote10.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,NULL,0),(42,'Samsung Galaxy Note 10+',24900000,'samsunggalaxynote10plus.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,NULL,0),(43,'Samsung Galaxy S10+ ',23990000,'samsunggalaxys10plus.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,NULL,0),(44,'Samsung Galaxy Tab S6',6990000,'samsunggalaxytabs6.jpg','Tặng suất mua Đồng hồ thời trang, mắt kính giảm ngay 40% (HSD: 7 ngày từ ngày mua hàng, không áp dụng KM khác).',1,4,NULL,0),(45,'Ipad Air 10.5 inch 2019',12490000,'ipadair105inch2019.jpg','Mua kèm Office 365 Personal ưu đãi giảm 600.000đ\r\n',2,1,NULL,0),(46,'Ipad Mini 2019',14590000,'ipadmini2019.jpg','Mua kèm Office 365 Personal ưu đãi giảm 600.000đ',2,1,NULL,0),(47,'Ipad Pro 11 inch 2017',22590000,'ipadpro11inch2019.jpg','Mua kèm Office 365 Personal ưu đãi giảm 600.000đ',2,1,1,0),(48,'Ipad Pro 10.5 inch 2017',13990000,'ipadpro105inch2017.jpg','Mua kèm Office 365 Personal ưu đãi giảm 600.000đ',2,1,NULL,0),(49,'Ipad Wifi 32G 2018',8990000,'ipadwifi32g2018.jpg','Mua kèm Office 365 Personal ưu đãi giảm 600.000đ',2,1,1,0),(50,'Ipad Wifi 128G 2018',9990000,'ipadwifi128g2018.jpg','Mua kèm Office 365 Personal ưu đãi giảm 600.000đ',2,1,1,0),(51,'Ipad Wifi Cellular 32G',11990000,'ipadwificellular32g2018.jpg','Mua kèm Office 365 Personal ưu đãi giảm 600.000đ',2,1,NULL,0),(52,'SamSung Galaxy Tab S6',18490000,'samsunggalaxytab.jpg','Mua kèm Office 365 Personal ưu đãi giảm 600.000đ',2,4,1,0),(53,'Ipad 10.2 inch Wifi (2019) 32G',9990000,'ipad10.2inchwifi2019.jpg','Mua kèm Office 365 Personal giảm 600.000đ',2,1,1,0);
/*!40000 ALTER TABLE `SanPham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ThongTinNguoiMuaHang`
--

DROP TABLE IF EXISTS `ThongTinNguoiMuaHang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ThongTinNguoiMuaHang` (
  `sodienthoai` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `HoTen` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Tinh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Huyen` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `Phuong` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `SoNha` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ThongTinNguoiMuaHang`
--

LOCK TABLES `ThongTinNguoiMuaHang` WRITE;
/*!40000 ALTER TABLE `ThongTinNguoiMuaHang` DISABLE KEYS */;
INSERT INTO `ThongTinNguoiMuaHang` VALUES ('0385323666','Nguyễn Thúc Tùng','Quy Nhơn','Ngu','Quang Trung','863- Nguyễn Thái Học');
/*!40000 ALTER TABLE `ThongTinNguoiMuaHang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ThongTinSanPham`
--

DROP TABLE IF EXISTS `ThongTinSanPham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ThongTinSanPham` (
  `masanpham` int(11) NOT NULL,
  `manghinh` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hedieuhanh` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `camerasau` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `cammeratruoc` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `cpu` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ram` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `bonhotrong` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `theso` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `sim` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `dungluongpin` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ThongTinSanPham`
--

LOCK TABLES `ThongTinSanPham` WRITE;
/*!40000 ALTER TABLE `ThongTinSanPham` DISABLE KEYS */;
INSERT INTO `ThongTinSanPham` VALUES (1,'OLED, 6.47\", Full HD+','Android 9.0 (Pie)','Chính 40 MP & Phụ 20 MP, 8 MP, TOF 3D','32 MP','Hisilicon Kirin 980 8 nhân 64-bit','8G','32G','NM card, hỗ trợ tối đa 256 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4200mAh'),(2,'OLED, 6.39\", Quad HD+ (2K+)','Android 9.0 (Pie)','Chính 40 MP & Phụ 20 MP, 8 MP','24MP','Hisilicon Kirin 980 8 nhân 64-bit','6G','128G','NM card, hỗ trợ tối đa 256 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4800mAh, có sạc nhanh'),(3,'LTPS LCD, 6.3\", Full HD+','Android 8.1 (Oreo)','Chính 16 MP & Phụ 2 MP','Chính 24 MP & Phụ 2 MP','HiSilicon Kirin 710','4 GB','128G','MicroSD, hỗ trợ tối đa 256 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','3340 mAh'),(4,'LTPS LCD, 6.3\", Full HD+','Android 8.1 (Oreo)','Chính 16 MP & Phụ 2 MP','Chính 24 MP & Phụ 2 MP','HiSilicon Kirin 710','6G','32G','MicroSD, hỗ trợ tối đa 256 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','3500mAh'),(5,'OLED, 6.1\", Full HD+','Android 9.0 (Pie)','Chính 40 MP & Phụ 16 MP, 8 MP','32 MP','Hisilicon Kirin 980 8 nhân 64-bit','8G','32G','NM card, hỗ trợ tối đa 256 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4800mAh'),(6,'IPS LCD, 6.15\", Full HD+','Android 9.0 (Pie)','Chính 24 MP & Phụ 8 MP, 2 MP','32 MP','HiSilicon Kirin 710','6G','128G','MicroSD, hỗ trợ tối đa 512 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','3340 mAh, có sạc nhanh'),(7,'LTPS LCD, 6.59\", Full HD','Android 9.0 (Pie)','Chính 16 MP & Phụ 8 MP, 2 MP','16 MP','HiSilicon Kirin 710F 8 nhân','8G','32G','MicroSD, hỗ trợ tối đa 512 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4100mAh'),(8,'LTPS LCD, 6.59\", Full HD+','Android 9.0 (Pie)','Chính 16 MP & Phụ 8 MP, 2 MP','16 MP','HiSilicon Kirin 710F 8 nhân','4G','32G','MicroSD, hỗ trợ tối đa 512 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','3600mAh'),(9,'LTPS LCD, 6.59\", Full HD+','Android 9.0 (Pie)','Chính 16 MP & Phụ 8 MP, 2 MP','16 MP','HiSilicon Kirin 710F 8 nhân','4G','64G','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4200mAh'),(10,'LTPS LCD, 6.59\", Full HD+','Android 9.0 (Pie)','Chính 16 MP & Phụ 8 MP, 2 MP','16 MP','HiSilicon Kirin 710F 8 nhân','8G','64G','MicroSD, hỗ trợ tối đa 512 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4000mAh'),(11,'LED-backlit IPS LCD, 5.5\", Retina HD','iOS 12','12 MP','5 MP','Apple A9 2 nhân 64-bit','2 GB','32 GB','Không','1 Nano SIM, Hỗ trợ 4G','4800mAh'),(12,'LED-backlit IPS LCD, 5.5\", Retina HD','iOS 12','Chính 12 MP & Phụ 12 MP','7 MP','Apple A10 Fusion 4 nhân 64-bit','3G','32G','Không','1 Nano SIM, Hỗ trợ 4G','3800mAh'),(13,'LED-backlit IPS LCD, 5.5\", Retina HD','iOS 12','Chính 12 MP & Phụ 12 MP','7 MP','Apple A11 Bionic 6 nhân','3G','64G','Không','1 Nano SIM, Hỗ trợ 4G','4000mAh'),(14,'LED-backlit IPS LCD, 4.7\", Retina HD','iOS 12','12 MP','7 MP','Apple A10 Fusion 4 nhân 64-bit','3G','32G','Không','1 Nano SIM, Hỗ trợ 4G','1960mAh'),(15,'OLED, 5.8\", Super Retina','iOS 12','Chính 12 MP & Phụ 12 MP','7 MP','Apple A11 Bionic 6 nhân\r\n','3G','32G','Không','1 Nano SIM, Hỗ trợ 4G','2167mAh'),(16,'OLED, 5.8\", Super Retina','iOA 12','Chính 12 MP & Phụ 12 MP','7 MP','Apple A11 Bionic 6 nhân','3G','64G','Không','1 Nano SIM, Hỗ trợ 4G','2167mAh'),(17,'OLED, 5.8\", Super Retina','iOS 12','Chính 12 MP & Phụ 12 MP','7 MP','Apple A11 Bionic 6 nhân','3G','256G','Không','1 Nano SIM, Hỗ trợ 4G','2167mAh'),(18,'IPS LCD, 6.1\", Liquid Retina','iOS 12','12 MP','7 MP','Apple A12 Bionic 6 nhân','3G','128G','Không','Nano SIM & eSIM, Hỗ trợ 4G','2376mAh'),(19,'IPS LCD, 6.1\", Liquid Retina','iOS 12','12 MP','7 MP','Apple A12 Bionic 6 nhân','3G','256G','Không','Nano SIM & eSIM, Hỗ trợ 4G','2974mAh'),(20,'OLED, 5.8\", Super Retina','iOS 12','Chính 12 MP & Phụ 12 MP','7 MP','Apple A12 Bionic 6 nhân','4G','32G','Không','Nano SIM & eSIM, Hỗ trợ 4G','3120mAh'),(21,'OLED, 6.5\", Super Retina','iOS 12','Chính 12 MP & Phụ 12 MP','7 MP','Apple A12 Bionic 6 nhân','4G','256G','Không','Nano SIM & eSIM, Hỗ trợ 4G','3174 mAh, có sạc nhanh'),(22,'OLED, 6.5\", Super Retina','iOS 12','Chính 12 MP & Phụ 12 MP','7 MP','Apple A12 Bionic 6 nhân','4G','64G','Không','Nano SIM & eSIM, Hỗ trợ 4G','2460mAh'),(23,'IPS LCD, 6.1\", HD+','Android 9.0 (Pie)','8 MP','5 MP','MediaTek MT6762R 8 nhân','2 GB','32G','MicroSD, hỗ trợ tối đa 256 GB','MicroSD, hỗ trợ tối đa 256 GB','4000mAh'),(24,'IPS LCD, 6.2\", HD+','Android 8.1 (Oreo)','Chính 13 MP & Phụ 2 MP','8 MP','Qualcomm Snapdragon 450 8 nhân 64-bit','2 G','16 G','MicroSD, hỗ trợ tối đa 256 GB','2 Nano SIM, Hỗ trợ 4G','4230 mAhIPS LCD, 6.2\", HD+'),(25,'IPS LCD, 6.2\", HD+','Android 8.1 (Oreo)','Chính 13 MP & Phụ 2 MP','8 MP','MediaTek Helio P35 8 nhân 64-bit','3 G','32 G','MicroSD, hỗ trợ tối đa 256 GB','2 Nano SIM, Hỗ trợ 4G','4230 mAh'),(26,'IPS LCD, 6.2\", HD+','ColorOS 5.2 (Android 8.1)','Chính 13 MP & Phụ 2 MP','16 MP','Qualcomm Snapdragon 450 8 nhân 64-bit','4 GB','64 GB','MicroSD, hỗ trợ tối đa 256 GB','2 Nano SIM, Hỗ trợ 4G','4230 mAh'),(27,'LTPS LCD, 6.3\", Full HD+','ColorOS 5.2 (Android 8.1)','Chính 16 MP & Phụ 2 MP','25 MP','MediaTek Helio P60 8 nhân 64-bit','4 GB','64 GB','MicroSD, hỗ trợ tối đa 256 GB','2 Nano SIM, Hỗ trợ 4G','3500 mAh, có sạc nhanh'),(28,'LTPS LCD, 6.3\", Full HD+','ColorOS 5.2 (Android 8.1)','Chính 16 MP & Phụ 2 MP','25 MP','MediaTek Helio P60 8 nhân 64-bit','4 GB','64 GB','MicroSD, hỗ trợ tối đa 256 GB','2 Nano SIM, Hỗ trợ 4G','3500 mAh, có sạc nhanh'),(29,'LTPS LCD, 6.5\", Full HD+','Android 9.0 (Pie)','Chính 48 MP & Phụ 5 MP','16 MP','MediaTek Helio P70 8 nhân','6 GB','64 GB','MicroSD, hỗ trợ tối đa 256 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4020 mAh, có sạc nhanh'),(30,'AMOLED, 6.5\", Full HD+','Android 9.0 (Pie)','Chính 16 MP & Phụ 2 MP','16 MP','Snapdragon 710 8 nhân 64-bit','6 GB','64 GB','Không','2 Nano SIM, Hỗ trợ 4G','3765 mAh, có sạc nhanh'),(31,'AMOLED, 6.4\", Full HD+','ColorOS 5.2 (Android 8.1)','Chính 12 MP & Phụ 20 MP, TOF 3D','25 MP','Snapdragon 710 8 nhân 64-bit','8 GB','128 GB','Không','2 Nano SIM, Hỗ trợ 4G','3700 mAh, có sạc nhanh'),(32,'AMOLED, 6.4\", Full HD+','Android 9.0 (Pie)','Chính 48 MP & Phụ 5 MP','16 MP','Snapdragon 710 8 nhân 64-bit','6 GB','256 GB','Không','2 Nano SIM, Hỗ trợ 4G','3765 mAh, có sạc nhanh'),(33,'AMOLED, 6.6\", Full HD+','Android 9.0 (Pie)','Chính 48 MP & Phụ 13 MP, 8 MP','16 MP','Snapdragon 855 8 nhân 64-bit','8 GB','256 GB','MicroSD, hỗ trợ tối đa 256 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4065 mAh, có sạc nhanh\r\n'),(34,'Super AMOLED, 6.4\", Quad HD+ (2K+)','Android 8.1 (Oreo)','Chính 12 MP & Phụ 12 MP','8 MP','Exynos 9810 8 nhân 64-bit','6 GB','128 GB','MicroSD, hỗ trợ tối đa 512 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4000 mAh, có sạc nhanh'),(35,'Super AMOLED, 6.3\", Full HD+','Android 8.0 (Oreo)','Chính 24 MP & Phụ 10 MP, 8 MP, 5 MP','24 MP','Qualcomm Snapdragon 660 8 nhân','6 GB','128 GB','MicroSD, hỗ trợ tối đa 512 GB','2 Nano SIM, Hỗ trợ 4G','3800 mAh, có sạc nhanh'),(36,'Super AMOLED, 6.4\", Full HD+','Android 9.0 (Pie)','Chính 25 MP & Phụ 8 MP, 5 MP','25 MP','Exynos 9610 8 nhân 64-bit','6 GB','128 GB','MicroSD, hỗ trợ tối đa 512 GB','2 Nano SIM, Hỗ trợ 4G','4000 mAh, có sạc nhanh'),(37,'Super AMOLED, 6.4\", Full HD+','Android 9.0 (Pie)','Chính 48 MP & Phụ 8 MP, 5 MP','32 MP','Exynos 9610 8 nhân 64-bit','4 GB','64 GB','MicroSD, hỗ trợ tối đa 512 GB',' Nano SIM, Hỗ trợ 4G','4000 mAh, có sạc nhanh'),(38,'Super AMOLED, 6.7\", Full HD+','Android 9.0 (Pie)','Chính 32 MP & Phụ 8 MP, 5 MP','32 MP','Snapdragon 675 8 nhân 64-bit','6 GB','128 GB','MicroSD, hỗ trợ tối đa 512 GB','2 Nano SIM, Hỗ trợ 4G','4500 mAh, có sạc nhanh'),(39,'Super AMOLED, 6.7\", Full HD+','Android 9.0 (Pie)','Chính 48 MP & Phụ 8 MP, TOF 3D','Chính 48 MP & Phụ 8 MP, TOF 3D','Snapdragon 730 8 nhân','8 GB','128 GB','Không','2 Nano SIM, Hỗ trợ 4G','3700 mAh, có sạc nhanh'),(40,'Super AMOLED, 6.3\", Full HD+','Android 8.0 (Oreo)','Chính 16 MP & Phụ 24 MP','24 MP','Qualcomm Snapdragon 660 8 nhân','4 GB','64 GB','MicroSD, hỗ trợ tối đa 400 GB','2 Nano SIM, Hỗ trợ 4G','3700 mAh, có sạc nhanh'),(41,'Dynamic AMOLED, 6.3\", Full HD+','Android 9.0 (Pie)','Chính 12 MP & Phụ 12 MP, 16 MP','10 MP','Exynos 9825 8 nhân 64-bit','8 GB','256 GB','Không','2 Nano SIM, Hỗ trợ 4G','3500 mAh, có sạc nhanh'),(42,'Dynamic AMOLED, 6.8\", Quad HD+ (2K+)','Android 9.0 (Pie)','Chính 12 MP & Phụ 12 MP, 16 MP, TOF 3D','10 MP','Exynos 9825 8 nhân 64-bit','12 GB','256 GB','MicroSD, hỗ trợ tối đa 1 TB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4300 mAh, có sạc nhanh'),(43,'Dynamic AMOLED, 6.4\", Quad HD+ (2K+)','Android 9.0 (Pie)','Chính 12 MP & Phụ 12 MP, 16 MP','Chính 10 MP & Phụ 8 MP','Exynos 9820 8 nhân 64-bit','8 GB','512 GB','MicroSD, hỗ trợ tối đa 512 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','4100 mAh, có sạc nhanh'),(44,'Super AMOLED, 6\", Full HD+','Android 8.0 (Oreo)','Chính 16 MP & Phụ 5 MP24 MP','24 MP','Qualcomm Snapdragon 450 8 nhân 64-bit','4 GB','32 GB','MicroSD, hỗ trợ tối đa 256 GB','2 Nano SIM, Hỗ trợ 4G','3500 mAh'),(45,'LED backlit LCD, 10.5\"','iOS 12','8 MP','7 MP','Apple A12 Bionic 6 nhân, 2 nhân 2.5 GHz Vortex & 4 nhân 1.6 GHz Tempest','3G','64G','Không','WiFi, Không hỗ trợ 3G, Không hỗ trợ 4G','4600mAh'),(46,'LED backlit LCD, 10.5\"','iOS 12','8 MP','7 MP','Apple A12 Bionic 6 nhân, 2 nhân 2.5 GHz Vortex & 4 nhân 1.6 GHz Tempest','3G','32G','Không','WiFi, Không hỗ trợ 3G, Không hỗ trợ 4G','4500mAh'),(47,'Liquid Retina, 11\"','iOS 12','12 MP','7 MP','Apple A12X Bionic 64-bit','4 GB','64G','Không','WiFi, Không hỗ trợ 3G, Không hỗ trợ 4G','5600mAh'),(48,'IPS LCD, 10.5\"','iOS 12','12 MP','7 MP','Apple A10X 6 nhân 64-bit','4 GB','64G','Không','WiFi, Không hỗ trợ 3G, Không hỗ trợ 4G','4600mAh'),(50,'LED backlit LCD, 9.7\"','iOS 12','8 MP','8 MP','Apple A10 Fusion, 2.34 GHz','3G','128G','Không','WiFi, Không hỗ trợ 3G, Không hỗ trợ 4G\r\n','3900mAh'),(51,'LED backlit LCD, 9.7\"','iOS 12','8 MP','1.2 MP','Apple A10 Fusion, 2.34 GHz','2 GB','32 GB','Không','Nano Sim','4200mAh'),(49,'LED backlit LCD, 9.7\"','iOS 12','8 MP','1.4 MP','Apple A10 Fusion, 2.34 GHz','2G','32G','Không','WiFi, Không hỗ trợ 3G, Không hỗ trợ 4G','4700mAh'),(52,'Super AMOLED, 10.5\"','Android 9.0 (Pie)','Chính 13 MP & Phụ 5 MP','8 MP','Qualcomm Snapdragon 855 8 nhân, 1 nhân 2.84 GHz, 3 nhân 2.41 GHz & 4 nhân 1.78 GHz','6 GB','128 GB','2 SIM Nano (SIM 2 chung khe thẻ nhớ), Hỗ trợ 4G','WiFi, 3G, 4G LTE','4200mAh');
/*!40000 ALTER TABLE `ThongTinSanPham` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-23 19:36:28
