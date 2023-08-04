-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: exams
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `applicant`
--

DROP TABLE IF EXISTS `applicant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `applicant` (
  `id` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `average` double DEFAULT NULL,
  `date_of_birth` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `encoded_image` longblob,
  `faculty_id` int DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `verified` varchar(255) DEFAULT NULL,
  `faculty_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `applicant`
--

LOCK TABLES `applicant` WRITE;
/*!40000 ALTER TABLE `applicant` DISABLE KEYS */;
INSERT INTO `applicant` VALUES (15,'Odessa, Main str., 19',9,'12.05.2002','petr@gmail.com','',11,'Petr','Simonov','+380505670945',NULL,'YES',NULL),(19,'Lutzk, First square, 11',8,'06.03.2003','dub@mail.com','',11,'Olga','Dub','0505670945, +390678934',NULL,'YES',NULL),(23,'Lviv, Kaliny prsp., 25',10,'02.03.2001','bel@gmail.com','',11,'Ivan','Belyi','0675670945',NULL,'YES',NULL),(27,'Lviv, Svobody str., 1',9,'10.10.2003','andre_kul@gmail.com',NULL,11,'Andrey','Kulik','0955670945',NULL,'YES',NULL),(58,'Wisloboki Sadova 14 123',11,'10.12.2001','alex@gmail.com',_binary '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',11,'Alexandr','Schwarz','+38095 8532329',NULL,'YES',NULL);
/*!40000 ALTER TABLE `applicant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculty` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `seat_capacity` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (1,'Faculty of Biology',5),(6,'Faculty of Architecture',5),(11,'Faculty of Education',3),(31,'Faculty of Mathematics',5),(36,'Faculty of Psychology',4),(40,'Faculty of Physics',4);
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (327);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `id` int NOT NULL,
  `applicant_id` int DEFAULT NULL,
  `faculty_id` int DEFAULT NULL,
  `mark` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (2,0,1,0,'Biology'),(3,0,1,0,'Chemistry'),(4,0,1,0,'English'),(5,0,1,0,'Mathematics'),(7,0,6,0,'Art'),(8,0,6,0,'Drawing'),(9,0,6,0,'English'),(10,0,6,0,'Mathematics'),(12,0,11,0,'Literature'),(13,0,11,0,'English'),(14,0,11,0,'Mathematics'),(16,15,11,8,'Literature'),(17,15,11,10,'English'),(18,15,11,9,'Mathematics'),(20,19,11,6,'Literature'),(21,19,11,10,'English'),(22,19,11,8,'Mathematics'),(24,23,11,11,'Literature'),(25,23,11,9,'English'),(26,23,11,10,'Mathematics'),(28,27,11,9,'Literature'),(29,27,11,11,'English'),(30,27,11,7,'Mathematics'),(32,0,31,0,'Physics'),(33,0,31,0,'Geometry'),(34,0,31,0,'English'),(35,0,31,0,'Mathematics'),(37,0,36,0,'Psychology'),(38,0,36,0,'English'),(39,0,36,0,'Mathematics'),(41,0,40,0,'Physics'),(42,0,40,0,'English'),(43,0,40,0,'Mathematics'),(65,58,11,11,'Mathematics'),(66,58,11,12,'Literature'),(67,58,11,10,'English');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `password_confirm` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (71,'admin@mail.com','Admin','Andreev','$2a$10$.K6beejJWyXhe31zEjCBP.hntmZ.oRhYQwhM3.8FC8u2T97yumnLy','1','ROLE_ADMIN'),(72,'user@mail.com','User','Ukaev','$2a$10$H92egC2Wh12fOSu/hxyR8.1MQ.352NrBV8dqQ7FFQeYmvEoLUg5dm','1','ROLE_USER');
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

-- Dump completed on 2023-07-26 11:39:33
