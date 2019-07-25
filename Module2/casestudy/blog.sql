-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nameCategories` varchar(50) NOT NULL,
  `creator` varchar(50) NOT NULL DEFAULT 'Admin',
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `finalEditor` varchar(50) DEFAULT 'Admin',
  `lastModifiedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Javascipt','rong9x','2019-06-26 00:00:00','rong9x','2019-06-27 11:25:56'),(2,'Java','Admin','2019-06-27 11:29:55','Admin','2019-06-27 11:29:55'),(4,'Python','Admin','2019-06-27 11:30:27','Admin','2019-06-27 11:30:27');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contents` text NOT NULL,
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lastModifiedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `idUsers` int(11) DEFAULT NULL,
  `idPosts` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idPosts` (`idPosts`),
  KEY `idUsers` (`idUsers`),
  CONSTRAINT `comments_ibfk_1` FOREIGN KEY (`idPosts`) REFERENCES `posts` (`id`),
  CONSTRAINT `comments_ibfk_2` FOREIGN KEY (`idUsers`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
INSERT INTO `comments` VALUES (1,'noi dung comment','2019-06-27 08:37:08','2019-06-27 08:37:08',1,1),(2,'comment thu 2','2019-06-27 10:59:41','2019-06-27 10:59:41',1,1),(3,'comment thu 1','2019-06-27 10:59:41','2019-06-27 10:59:41',2,2),(4,'comment thu 2','2019-06-27 10:59:41','2019-06-27 10:59:41',2,2);
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `introduce` text NOT NULL,
  `content` text NOT NULL,
  `image` varchar(255) NOT NULL,
  `creator` varchar(50) NOT NULL DEFAULT 'rong9x',
  `dateCreated` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `finalEditor` varchar(50) NOT NULL DEFAULT 'rong9x',
  `lastModifiedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `idCategories` int(11) NOT NULL,
  `idUsers` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCategories` (`idCategories`),
  KEY `idUsers` (`idUsers`),
  CONSTRAINT `posts_ibfk_1` FOREIGN KEY (`idCategories`) REFERENCES `categories` (`id`),
  CONSTRAINT `posts_ibfk_2` FOREIGN KEY (`idUsers`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `posts`
--

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;
INSERT INTO `posts` VALUES (1,'Java','Introduce of Java','Introduce of Java Introduce of Java Introduce of Java Introduce of Java','null','rong9x','2019-06-26 00:00:00','rong9x','2019-06-26 00:00:00',1,1),(2,'PreparedStatement trong java','PreparedStatement trong java PreparedStatement trong java PreparedStatement trong java','PreparedStatement trong java PreparedStatement trong java PreparedStatement trong java\r\nPreparedStatement trong java PreparedStatement trong java PreparedStatement trong java\r\nPreparedStatement trong java PreparedStatement trong java PreparedStatement trong java\r\nPreparedStatement trong java PreparedStatement trong java PreparedStatement trong java','2','rong9x','2019-06-26 14:56:53','rong9x','2019-06-26 14:56:53',1,1),(4,'Java Tutorial','Java is a programming language. Java is used to develop mobile apps, web apps, desktop apps, games and much more.','Java is a programming language. Java is used to develop mobile apps, web apps, desktop apps, games and much more.\r\nJava is a programming language. Java is used to develop mobile apps, web apps, desktop apps, games and much more.\r\nJava is a programming language. Java is used to develop mobile apps, web apps, desktop apps, games and much more.','1','rong9x','2019-06-27 14:41:21','rong9x','2019-06-27 14:41:21',2,1),(5,'PHP 5 Tutorial','PHP is a server scripting language, and a powerful tool for making dynamic and interactive Web pages. PHP is a widely-used, free, and efficient alternative to competitors such as Microsoft\'s ASP.','PHP is a server scripting language, and a powerful tool for making dynamic and interactive Web pages. PHP is a widely-used, free, and efficient alternative to competitors such as Microsoft\'s ASP.\r\nPHP is a server scripting language, and a powerful tool for making dynamic and interactive Web pages. PHP is a widely-used, free, and efficient alternative to competitors such as Microsoft\'s ASP.\r\nPHP is a server scripting language, and a powerful tool for making dynamic and interactive Web pages. PHP is a widely-used, free, and efficient alternative to competitors such as Microsoft\'s ASP.','2','rong9x','2019-06-27 14:43:31','rong9x','2019-06-27 14:43:31',4,1);
/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(15) NOT NULL DEFAULT 'user',
  `salt` varchar(33) NOT NULL,
  `image` varchar(255) NOT NULL DEFAULT 'noavatar.png',
  `creator` varchar(50) DEFAULT 'user',
  `dateCreated` datetime DEFAULT CURRENT_TIMESTAMP,
  `finalEditor` varchar(50) DEFAULT NULL,
  `lastModifiedDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'rong9x','123456','admin','qwe','null','1','2019-06-25 00:00:00','1','2019-06-25 00:00:00'),(2,'hai','123456','user','ewq','null','1','2019-06-25 00:00:00','1','2019-06-25 00:00:00'),(3,'nhat','BE49682E5883C40D29D44891F0D95FD1','user','ÂGˆ`Õ£','noavatar.png','user','2019-06-27 09:00:15',NULL,NULL);
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

-- Dump completed on 2019-06-27 16:30:48
