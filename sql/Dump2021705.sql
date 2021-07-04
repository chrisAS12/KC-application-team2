-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: bootcamp
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `knowledge_check`
--

DROP TABLE IF EXISTS `knowledge_check`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `knowledge_check` (
  `kc_id` int NOT NULL AUTO_INCREMENT,
  `kc_name` varchar(45) NOT NULL,
  `kc_show` tinyint NOT NULL,
  `kc_start_time` datetime DEFAULT NULL,
  `kc_finish_time` datetime DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`kc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `knowledge_check`
--

LOCK TABLES `knowledge_check` WRITE;
/*!40000 ALTER TABLE `knowledge_check` DISABLE KEYS */;
INSERT INTO `knowledge_check` VALUES (1,'Knowledge Check 1',0,NULL,NULL,NULL),(2,'Test',1,'2021-07-03 17:05:35','2021-07-03 17:05:35',4);
/*!40000 ALTER TABLE `knowledge_check` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_KC_delete` AFTER DELETE ON `knowledge_check` FOR EACH ROW delete from questions
where question_kc_id = old.kc_id */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `offered_answers`
--

DROP TABLE IF EXISTS `offered_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offered_answers` (
  `answer_id` int NOT NULL AUTO_INCREMENT,
  `answer_text` varchar(999) NOT NULL,
  `question_id` int NOT NULL,
  PRIMARY KEY (`answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offered_answers`
--

LOCK TABLES `offered_answers` WRITE;
/*!40000 ALTER TABLE `offered_answers` DISABLE KEYS */;
/*!40000 ALTER TABLE `offered_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `question_title` varchar(999) NOT NULL,
  `question_type` varchar(45) NOT NULL,
  `question_answer` varchar(45) DEFAULT NULL,
  `question_kc_id` int NOT NULL,
  `question_variants` varchar(999) DEFAULT NULL,
  `opt1` varchar(300) DEFAULT NULL,
  `opt2` varchar(300) DEFAULT NULL,
  `opt3` varchar(300) DEFAULT NULL,
  `opt4` varchar(300) DEFAULT NULL,
  `marks` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'1. Please write your name and surname with Latin characters only, e.g.','free',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL),(2,'2. What is valid method signature as an entry point into Java program:','radio','d',1,NULL,'a) public static main()',' b) public void static main (String [] args)','c) public static int main (String [] args)',' d) public static void main (String args [])',NULL),(3,'3. How to check, which Java version is supported in runtime? Choose all correct ','mult','bd',1,NULL,'a) Runtime.getRuntime.getVersion();','b) System.getProperty(\"java.version\");','c) System.getenv();','d) System.getProperty(\"java.specification.version\");',NULL),(4,'4. Match the descriptions in the list on the left with the correct concept from the list on the ','match','cab',1,NULL,'Zip archive with Java classes and metadata. A. *.class','File containing Java bytecode. B. *.java','Plain text file with Java source code. C. *.jar',NULL,NULL),(5,'5. Please choose true/false: Java is object-oriented language.','boolean','true',1,NULL,'true','false',NULL,NULL,NULL),(6,'6. Please choose true/false: Java is compiled language','boolean','true',1,NULL,'true','false',NULL,NULL,NULL),(7,'7. Please choose true/false: Java language supports multi threaded programming.','boolean','true',1,NULL,'true','false',NULL,NULL,NULL),(8,'8. Please choose true/false: Java is mostly imperative language.','boolean','true',1,NULL,'true','false',NULL,NULL,NULL),(9,'9. Please choose true/false: Java is mostly declarative language.','boolean','false',1,NULL,'true','false',NULL,NULL,NULL),(10,'10. Please choose true/false: Java is platform neutral language.','boolean','true',1,NULL,'true','false',NULL,NULL,NULL),(11,'11. What JRE means in programming area?','radio','d',1,NULL,'a) Java Random Environment.','b) Junior Resource Editor.','c) Joe Rogan Experience.','d) Java Runtime Environment',NULL),(12,'12. What JDK means in programming area?','radio','c',1,NULL,'a) Java Development Keyword.','b) Just Define Kit.','c) Java Development Kit.','d) Javadoc Developer Keyword.',NULL),(13,'13. Mark true statement about OpenJDK Java implementation.','radio','c',1,NULL,'a) 1.x.y... (where x<=8) supports features* up till version x including','b) x or x.y.z (where x>8) supports features* till version x including','c) a and b are both true',' d) neither a nor b is true','(* backported features from newer versions are not considered)'),(14,'14. Mark, which is NOT popular integrated Java development environment:','radio','d',1,NULL,'a) Eclipse','b) IntelliJ IDEA','c) NetBeans',' d) Visual Studio',NULL),(15,'15. How default Java version is set in Debian-like GNU/Linux distributions? Choose','mult','ab',1,NULL,'a) Using command: sudo update-alternatives --config java and choosing ','b) Changing symbolic link in /etc/default/java to appropriate folder e.g. ','c) Entering command: regedit HKEY_LOCAL_MACHINE\\SOFTWARE\\Oracle\\Java\\','d) Entering command: export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/jre/',NULL),(16,'16. Which data type is NOT primitive data type in Java:','radio','c',1,NULL,'a) int','b) double','c) String','d) char',NULL),(17,'17. Which two Java types takes precisely/approximately 1 byte in JVM.','mult','bc',1,NULL,'a) int','b) boolean','c) byte',' d) char',NULL),(18,'18. What do you need to do to copy value of int x into int y:','radio','c',1,NULL,'a) int y = x;','b) int y = x.getValue();','c) int y = valueOf(x);','d) int y = x.clone();',NULL),(19,'19. In JAVA which type conversion can be done without type casts:','radio','b',1,NULL,'a) long to int','b) int to long','c) double to float','d) int to bytecode',NULL),(20,'20. When following code is executed: ','radio','c',1,NULL,'a) Compilation error will occur at 2nd line','b) yourchar will contain value of mychar','c) Compilation error will occur at 3rd line','d) yourchar will contain numeric value of mychar',NULL);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_login` varchar(255) NOT NULL,
  `user_email` varchar(255) NOT NULL,
  `user_password` varchar(255) NOT NULL,
  `user_role` varchar(45) NOT NULL,
  `user_name` varchar(200) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Student','test@test.com','$2a$06$RGkvCtgXLe9DHGiQphspxOd7T.Dnan/9cXq/Tl6MGkcNoOpXmoKAa','st','student'),(2,'Admin','admin@test.com','$2a$06$RGkvCtgXLe9DHGiQphspxOd7T.Dnan/9cXq/Tl6MGkcNoOpXmoKAa','adm','admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_answers`
--

DROP TABLE IF EXISTS `user_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_answers` (
  `user_answer_id` int NOT NULL AUTO_INCREMENT,
  `user_answer` varchar(45) DEFAULT NULL,
  `user_answer_iscorrect` tinyint NOT NULL,
  `user_id` int DEFAULT NULL,
  `question_id` int DEFAULT NULL,
  `question_kc_id` int DEFAULT NULL,
  PRIMARY KEY (`user_answer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_answers`
--

LOCK TABLES `user_answers` WRITE;
/*!40000 ALTER TABLE `user_answers` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bootcamp'
--

--
-- Dumping routines for database 'bootcamp'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-04 23:01:15
