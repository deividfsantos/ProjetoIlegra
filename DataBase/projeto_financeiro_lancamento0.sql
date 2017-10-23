-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: projeto_financeiro
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `lancamento`
--

DROP TABLE IF EXISTS `lancamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lancamento` (
  `cod_lancamento` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(50) NOT NULL,
  `tipo` varchar(1) NOT NULL,
  `valor` double NOT NULL,
  `cod_responsavel` int(11) NOT NULL,
  `data_parcela` date NOT NULL,
  `tipo_parcela` varchar(1) NOT NULL,
  PRIMARY KEY (`cod_lancamento`),
  KEY `cod_responsavel` (`cod_responsavel`),
  CONSTRAINT `lancamento_ibfk_1` FOREIGN KEY (`cod_responsavel`) REFERENCES `usuario` (`cod_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lancamento`
--

LOCK TABLES `lancamento` WRITE;
/*!40000 ALTER TABLE `lancamento` DISABLE KEYS */;
INSERT INTO `lancamento` VALUES (1,'Teste','p',100,1,'2017-01-01',''),(2,'Teste2','p',100,2,'2017-05-24',''),(4,'Teste2','a',100,3,'2017-05-24',''),(5,'Teste5','a',100,7,'2017-05-24',''),(6,'Teste5','a',100,7,'2017-05-24',''),(7,'Teste5','a',100,7,'2017-05-24',''),(8,'Teste5','a',100,7,'2017-05-24',''),(9,'Teste10','a',100,1,'2017-05-24',''),(10,'Teste10','a',100,1,'2018-01-24',''),(11,'Teste10','a',100,1,'2055-06-24',''),(12,'Teste10','a',100,1,'2000-02-24',''),(13,'Teste10','a',100,1,'2000-02-24',''),(14,'Teste11','a',100,1,'2017-02-24',''),(15,'Teste11','a',100,1,'2017-02-24',''),(16,'Teste11','a',100,1,'2017-02-24','f'),(17,'Teste11','a',100,1,'2017-02-24','f'),(18,'Teste11','a',100,1,'2017-02-24','f'),(19,'Teste11','a',100,1,'2017-02-24','f'),(20,'Teste11','a',100,1,'2017-12-24','f'),(21,'Teste11','a',100,1,'2017-12-24','f'),(22,'T','a',100,1,'2017-12-24','f');
/*!40000 ALTER TABLE `lancamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-22 23:35:49
