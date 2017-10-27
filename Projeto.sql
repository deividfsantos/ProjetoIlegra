-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: projeto_financeiro
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.17.04.1

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
) ENGINE=InnoDB AUTO_INCREMENT=198 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lancamento`
--

LOCK TABLES `lancamento` WRITE;
/*!40000 ALTER TABLE `lancamento` DISABLE KEYS */;
INSERT INTO `lancamento` VALUES (1,'Salario','r',2000,8,'0017-10-12','f'),(2,'Salario','r',2000,8,'0017-11-12','f'),(3,'Salario','r',2000,8,'0017-12-12','f'),(4,'Salario','r',2000,8,'0018-01-12','f'),(5,'Salario','r',2000,8,'0018-02-12','f'),(6,'Salario','r',2000,8,'0018-03-12','f'),(7,'Salario','r',2000,8,'0018-04-12','f'),(8,'Salario','r',2000,8,'0018-05-12','f'),(9,'Salario','r',2000,8,'0018-06-12','f'),(10,'Salario','r',2000,8,'0018-07-12','f'),(11,'Salario','r',2000,8,'0018-08-12','f'),(12,'Salario','r',2000,8,'0018-09-12','f'),(13,'Comida','d',500,8,'2017-11-12','f'),(14,'Comida','d',500,8,'2017-12-12','f'),(15,'Comida','d',500,8,'2018-01-12','f'),(16,'Comida','d',500,8,'2018-02-12','f'),(17,'Comida','d',500,8,'2018-03-12','f'),(18,'Comida','d',500,8,'2018-04-12','f'),(19,'Comida','d',500,8,'2018-05-12','f'),(20,'Comida','d',500,8,'2018-06-12','f'),(21,'Comida','d',500,8,'2018-07-12','f'),(22,'Comida','d',500,8,'2018-08-12','f'),(23,'Comida','d',500,8,'2018-09-12','f'),(24,'Comida','d',500,8,'2018-10-12','f'),(25,'Cartão (1)','d',200,8,'2017-11-12','p'),(26,'Cartão (2)','d',200,8,'2017-12-12','p'),(27,'Cartão (3)','d',200,8,'2018-01-12','p'),(28,'Cartão (4)','d',200,8,'2018-02-12','p'),(29,'Cartão (5)','d',200,8,'2018-03-12','p'),(30,'Cartão (6)','d',200,8,'2018-04-12','p'),(31,'Cartão (7)','d',200,8,'2018-05-12','p'),(32,'Cartão (8)','d',200,8,'2018-06-12','p'),(33,'Cartão (9)','d',200,8,'2018-07-12','p'),(34,'Cartão (10)','d',200,8,'2018-08-12','p'),(35,'Jogo','d',100,8,'0017-11-12','a'),(36,'Salario','r',2000,13,'2017-08-12','f'),(37,'Salario','r',2000,13,'2017-09-12','f'),(38,'Salario','r',2000,13,'2017-10-12','f'),(39,'Salario','r',2000,13,'2017-11-12','f'),(40,'Salario','r',2000,13,'2017-12-12','f'),(41,'Salario','r',2000,13,'2018-01-12','f'),(42,'Salario','r',2000,13,'2018-02-12','f'),(43,'Salario','r',2000,13,'2018-03-12','f'),(44,'Salario','r',2000,13,'2018-04-12','f'),(45,'Salario','r',2000,13,'2018-05-12','f'),(46,'Salario','r',2000,13,'2018-06-12','f'),(47,'Salario','r',2000,13,'2018-07-12','f'),(48,'Geladeira (1)','d',500,13,'2017-10-12','p'),(49,'Geladeira (2)','d',500,13,'2017-11-12','p'),(50,'Geladeira (3)','d',500,13,'2017-12-12','p'),(51,'Geladeira (4)','d',500,13,'2018-01-12','p'),(52,'ssalario2','r',1000,12,'2017-11-01','f'),(53,'ssalario2','r',1000,12,'2017-12-01','f'),(54,'ssalario2','r',1000,12,'2018-01-01','f'),(55,'ssalario2','r',1000,12,'2018-02-01','f'),(56,'ssalario2','r',1000,12,'2018-03-01','f'),(57,'ssalario2','r',1000,12,'2018-04-01','f'),(58,'ssalario2','r',1000,12,'2018-05-01','f'),(59,'ssalario2','r',1000,12,'2018-06-01','f'),(60,'ssalario2','r',1000,12,'2018-07-01','f'),(61,'ssalario2','r',1000,12,'2018-08-01','f'),(62,'ssalario2','r',1000,12,'2018-09-01','f'),(63,'ssalario2','r',1000,12,'2018-10-01','f'),(64,'Xbox (1)','d',200,12,'2017-12-01','p'),(65,'Xbox (2)','d',200,12,'2018-01-01','p'),(66,'Xbox (3)','d',200,12,'2018-02-01','p'),(67,'Xbox (4)','d',200,12,'2018-03-01','p'),(68,'Xbox (5)','d',200,12,'2018-04-01','p'),(69,'Xbox (6)','d',200,12,'2018-05-01','p'),(130,'fsdaf','r',123,12,'2018-11-01','f'),(131,'fsdaf','r',123,12,'2018-12-01','f'),(132,'fsdaf','r',123,12,'2019-01-01','f'),(133,'fsdaf','r',123,12,'2019-02-01','f'),(134,'fsdaf','r',123,12,'2019-03-01','f'),(135,'fsdaf','r',123,12,'2019-04-01','f'),(136,'fsdaf','r',123,12,'2019-05-01','f'),(137,'fsdaf','r',123,12,'2019-06-01','f'),(138,'fsdaf','r',123,12,'2019-07-01','f'),(139,'fsdaf','r',123,12,'2019-08-01','f'),(140,'fsdaf','r',123,12,'2019-09-01','f'),(141,'fsdaf','r',123,12,'2019-10-01','f'),(142,'comida','d',500,12,'2017-11-01','f'),(143,'comida','d',500,12,'2017-12-01','f'),(144,'comida','d',500,12,'2018-01-01','f'),(145,'comida','d',500,12,'2018-02-01','f'),(146,'comida','d',500,12,'2018-03-01','f'),(147,'comida','d',500,12,'2018-04-01','f'),(148,'comida','d',500,12,'2018-05-01','f'),(149,'comida','d',500,12,'2018-06-01','f'),(150,'comida','d',500,12,'2018-07-01','f'),(151,'comida','d',500,12,'2018-08-01','f'),(152,'comida','d',500,12,'2018-09-01','f'),(153,'comida','d',500,12,'2018-10-01','f'),(154,'sadgfsdg (1)','d',255.6,12,'2018-01-01','p'),(155,'sadgfsdg (2)','d',255.6,12,'2018-02-01','p'),(156,'sadgfsdg (3)','d',255.6,12,'2018-03-01','p'),(157,'sadgfsdg (4)','d',255.6,12,'2018-04-01','p'),(158,'sadgfsdg (5)','d',255.6,12,'2018-05-01','p'),(159,'sadgfsdg (6)','d',255.6,12,'2018-06-01','p'),(160,'sadgfsdg (7)','d',255.6,12,'2018-07-01','p'),(161,'sadgfsdg (8)','d',255.6,12,'2018-08-01','p'),(162,'sadgfsdg (9)','d',255.6,12,'2018-09-01','p'),(163,'sadgfsdg (10)','d',255.6,12,'2018-10-01','p'),(164,'TEStFixo13','r',1000,12,'2018-12-01','f'),(165,'TEStFixo13','r',1000,12,'2019-01-01','f'),(166,'TEStFixo13','r',1000,12,'2019-02-01','f'),(167,'TEStFixo13','r',1000,12,'2019-03-01','f'),(168,'TEStFixo13','r',1000,12,'2019-04-01','f'),(169,'TEStFixo13','r',1000,12,'2019-05-01','f'),(170,'TEStFixo13','r',1000,12,'2019-06-01','f'),(171,'TEStFixo13','r',1000,12,'2019-07-01','f'),(172,'TEStFixo13','r',1000,12,'2019-08-01','f'),(173,'TEStFixo13','r',1000,12,'2019-09-01','f'),(174,'TEStFixo13','r',1000,12,'2019-10-01','f'),(175,'TEStFixo13','r',1000,12,'2019-11-01','f'),(176,'testevariavel (1)','d',60,12,'2017-10-01','p'),(177,'testevariavel (2)','d',60,12,'2017-11-01','p'),(178,'testevariavel (3)','d',60,12,'2017-12-01','p'),(179,'testevariavel (4)','d',60,12,'2018-01-01','p'),(180,'testevariavel (5)','d',60,12,'2018-02-01','p'),(181,'testevariavel (6)','d',60,12,'2018-03-01','p'),(182,'testevariavel (7)','d',60,12,'2018-04-01','p'),(183,'testevariavel (8)','d',60,12,'2018-05-01','p'),(184,'testevariavel (9)','d',60,12,'2018-06-01','p'),(185,'testevariavel (10)','d',60,12,'2018-07-01','p'),(186,'Teste','r',506,12,'0001-11-01','f'),(187,'Teste','r',506,12,'0001-12-01','f'),(188,'Teste','r',506,12,'0002-01-01','f'),(189,'Teste','r',506,12,'0002-02-01','f'),(190,'Teste','r',506,12,'0002-03-01','f'),(191,'Teste','r',506,12,'0002-04-01','f'),(192,'Teste','r',506,12,'0002-05-01','f'),(193,'Teste','r',506,12,'0002-06-01','f'),(194,'Teste','r',506,12,'0002-07-01','f'),(195,'Teste','r',506,12,'0002-08-01','f'),(196,'Teste','r',506,12,'0002-09-01','f'),(197,'Teste','r',506,12,'0002-10-01','f');
/*!40000 ALTER TABLE `lancamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `cod_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Luiz'),(2,'Joao'),(3,'Joao'),(4,'Deivid'),(5,'Deivid'),(6,'Deivid'),(7,'Deivid'),(8,'Deivid'),(9,'ANA'),(10,'Maria'),(11,'Joaquim'),(12,'Deivid'),(13,'Joao'),(14,'Josney'),(15,'Dougras'),(16,'Teste232'),(17,'Dougras2'),(18,'fgadsg'),(19,'Joase');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-27 17:10:05
