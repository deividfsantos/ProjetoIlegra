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
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lancamento`
--

LOCK TABLES `lancamento` WRITE;
/*!40000 ALTER TABLE `lancamento` DISABLE KEYS */;
INSERT INTO `lancamento` VALUES (1,'presente','d',500,675,'2017-12-15','a'),(2,'salario','r',1170,675,'2017-11-15','f'),(3,'salario','r',1170,675,'2017-12-15','f'),(4,'salario','r',1170,675,'2018-01-15','f'),(5,'salario','r',1170,675,'2018-02-15','f'),(6,'salario','r',1170,675,'2018-03-15','f'),(7,'salario','r',1170,675,'2018-04-15','f'),(8,'salario','r',1170,675,'2018-05-15','f'),(9,'salario','r',1170,675,'2018-06-15','f'),(10,'salario','r',1170,675,'2018-07-15','f'),(11,'salario','r',1170,675,'2018-08-15','f'),(12,'salario','r',1170,675,'2018-09-15','f'),(13,'salario','r',1170,675,'2018-10-15','f'),(14,'aluguel (1)','r',60,10,'2017-11-15','p'),(15,'aluguel (2)','r',60,10,'2017-12-15','p'),(16,'aluguel (3)','r',60,10,'2018-01-15','p'),(17,'aluguel (4)','r',60,10,'2018-02-15','p'),(18,'aluguel (5)','r',60,10,'2018-03-15','p'),(19,'aluguel (6)','r',60,10,'2018-04-15','p'),(20,'aluguel (7)','r',60,10,'2018-05-15','p'),(21,'aluguel (8)','r',60,10,'2018-06-15','p'),(22,'aluguel (9)','r',60,10,'2018-07-15','p'),(23,'aluguel (10)','r',60,10,'2018-08-15','p'),(24,'testeParcelamento (1)','r',83.33333333333333,10,'2017-11-15','p'),(25,'testeParcelamento (2)','r',83.33333333333333,10,'2017-12-15','p'),(26,'testeParcelamento (3)','r',83.33333333333333,10,'2018-01-15','p'),(27,'testeParcelamento (4)','r',83.33333333333333,10,'2018-02-15','p'),(28,'testeParcelamento (5)','r',83.33333333333333,10,'2018-03-15','p'),(29,'testeParcelamento (6)','r',83.33333333333333,10,'2018-04-15','p'),(30,'testeNovo','r',400,10,'2017-11-15','f'),(31,'testeNovo','r',400,10,'2017-12-15','f'),(32,'testeNovo','r',400,10,'2018-01-15','f'),(33,'testeNovo','r',400,10,'2018-02-15','f'),(34,'testeNovo','r',400,10,'2018-03-15','f'),(35,'testeNovo','r',400,10,'2018-04-15','f'),(36,'testeNovo','r',400,10,'2018-05-15','f'),(37,'testeNovo','r',400,10,'2018-06-15','f'),(38,'testeNovo','r',400,10,'2018-07-15','f'),(39,'testeNovo','r',400,10,'2018-08-15','f'),(40,'testeNovo','r',400,10,'2018-09-15','f'),(41,'testeNovo','r',400,10,'2018-10-15','f'),(42,'testesepse (1)','d',20,10,'2017-11-15','p'),(43,'testesepse (2)','d',20,10,'2017-12-15','p'),(44,'testesepse (3)','d',20,10,'2018-01-15','p'),(45,'testesepse (4)','d',20,10,'2018-02-15','p'),(46,'testesepse (5)','d',20,10,'2018-03-15','p'),(47,'teste21 (1)','d',17.571428571428573,10,'2017-12-15','p'),(48,'teste21 (2)','d',17.571428571428573,10,'2018-01-15','p'),(49,'teste21 (3)','d',17.571428571428573,10,'2018-02-15','p'),(50,'teste21 (4)','d',17.571428571428573,10,'2018-03-15','p'),(51,'teste21 (5)','d',17.571428571428573,10,'2018-04-15','p'),(52,'teste21 (6)','d',17.571428571428573,10,'2018-05-15','p'),(53,'teste21 (7)','d',17.571428571428573,10,'2018-06-15','p'),(54,'123 (1)','d',20.5,10,'2017-12-15','p'),(55,'123 (2)','d',20.5,10,'2018-01-15','p'),(56,'123 (3)','d',20.5,10,'2018-02-15','p'),(57,'123 (4)','d',20.5,10,'2018-03-15','p'),(58,'123 (5)','d',20.5,10,'2018-04-15','p'),(59,'123 (6)','d',20.5,10,'2018-05-15','p'),(60,'teste','r',123,10,'2017-11-15','a');
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
) ENGINE=InnoDB AUTO_INCREMENT=676 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'Jose'),(10,'deivid'),(666,'UsuarioTestes'),(667,'sdfgads'),(668,'dfgadsf&'),(669,'fsafs@$@'),(670,'dsagdgsgdsgds'),(671,'dgfdsg'),(672,'asgfsafgs'),(673,'joaquimsouza'),(674,'sfsaf'),(675,'Carol');
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

-- Dump completed on 2017-11-03  2:21:01
