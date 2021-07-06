-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bootcamp
-- ------------------------------------------------------
-- Server version	8.0.23

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
INSERT INTO `knowledge_check` VALUES (1,'Knowledge Check 1',1,NULL,NULL,NULL),(4,'Knowledge Check 2',1,NULL,NULL,NULL),(5,'Knowledge Check 3',1,NULL,NULL,NULL),(6,'Knowledge Check 4',1,NULL,NULL,NULL),(7,'Knowledge Check 5',1,NULL,NULL,NULL),(8,'Knowledge Check 6',1,NULL,NULL,NULL),(9,'Knowledge Check 7',1,NULL,NULL,NULL),(10,'Knowledge Check 8',1,NULL,NULL,NULL),(11,'Knowledge Check 9',1,NULL,NULL,NULL),(12,'Knowledge Check 10',1,NULL,NULL,NULL),(13,'Final Knowledge Check ',1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `knowledge_check` ENABLE KEYS */;
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
  `opt1` varchar(300) DEFAULT NULL,
  `opt2` varchar(300) DEFAULT NULL,
  `opt3` varchar(300) DEFAULT NULL,
  `opt4` varchar(300) DEFAULT NULL,
  `marks` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'1. Please write your name and surname with Latin characters only, e.g. Janis Berzins where Jānis Bērziņš is your actual name and surname)','free','identifier',1,'','','','','0'),(2,'2. What is valid method signature as an entry point into Java program:','radio','d',1,'a) public static main()',' b) public void static main (String [] args)','c) public static int main (String [] args)',' d) public static void main (String args [])','0'),(3,'3. How to check, which Java version is supported in runtime? Choose all correct answers ','mult','bd',1,'a) Runtime.getRuntime.getVersion();','b) System.getProperty(\"java.version\");','c) System.getenv();','d) System.getProperty(\"java.specification.version\");','0'),(4,'4. Match the descriptions in the list on the left with the correct concept from the list on the right ','match','cab',1,'Zip archive with Java classes and metadata. A. *.class','File containing Java bytecode. B. *.java','Plain text file with Java source code. C. *.jar','','0'),(5,'5. Please choose true/false: Java is object-oriented language.','boolean','true',1,'true','false','','','0'),(6,'6. Please choose true/false: Java is compiled language','boolean','true',1,'true','false','','','0'),(7,'7. Please choose true/false: Java language supports multi threaded programming.','boolean','true',1,'true','false','','','0'),(8,'8. Please choose true/false: Java is mostly imperative language.','boolean','true',1,'true','false','','','0'),(9,'9. Please choose true/false: Java is mostly declarative language.','boolean','false',1,'true','false','','','0'),(10,'10. Please choose true/false: Java is platform neutral language.','boolean','true',1,'true','false','','','0'),(11,'11. What JRE means in programming area?','radio','d',1,'a) Java Random Environment.','b) Junior Resource Editor.','c) Joe Rogan Experience.','d) Java Runtime Environment','0'),(12,'12. What JDK means in programming area?','radio','c',1,'a) Java Development Keyword.','b) Just Define Kit.','c) Java Development Kit.','d) Javadoc Developer Keyword.','0'),(13,'13. Mark true statement about OpenJDK Java implementation. If java -version returns java version \"…\" and \"…\" is:','radio','c',1,'a) 1.x.y... (where x<=8) supports features* up till version x including','b) x or x.y.z (where x>8) supports features* till version x including','c) a and b are both true',' d) neither a nor b is true','0'),(14,'14. Mark, which is NOT popular integrated Java development environment:','radio','d',1,'a) Eclipse','b) IntelliJ IDEA','c) NetBeans',' d) Visual Studio','0'),(15,'15. How default Java version is set in Debian-like GNU/Linux distributions? Choose ALL correct answers','mult','ab',1,'a) Using command: sudo update-alternatives --config java and choosing ','b) Changing symbolic link in /etc/default/java to appropriate folder e.g. ','c) Entering command: regedit HKEY_LOCAL_MACHINE\\SOFTWARE\\Oracle\\Java\\','d) Entering command: export JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64/jre/','0'),(16,'16. Which data type is NOT primitive data type in Java:','radio','c',1,'a) int','b) double','c) String','d) char','0'),(17,'17. Which two Java types takes precisely/approximately 1 byte in JVM.','mult','bc',1,'a) int','b) boolean','c) byte',' d) char','0'),(18,'18. What do you need to do to copy value of int x into int y:','radio','c',1,'a) int y = x;','b) int y = x.getValue();','c) int y = valueOf(x);','d) int y = x.clone();','0'),(19,'19. In JAVA which type conversion can be done without type casts:','radio','b',1,'a) long to int','b) int to long','c) double to float','d) int to bytecode','0'),(20,'20. When following code is executed: char mychar = \'ā\'; int myint = mychar; char yourchar = myint; What will happen?','radio','c',1,'a) Compilation error will occur at 2nd line','b) yourchar will contain value of mychar','c) Compilation error will occur at 3rd line','d) yourchar will contain numeric value of mychar','0'),(34,'1. How could you declare character variable a with value Q?','radio','d',4,'a) String s = \"Q\";','b) character c = \'Q\';','c) char c = \"Q\";','d) char c = \'Q\';','0'),(35,'2. Variables declared in body of the class without static keyword can be described as ','mult','abd',4,'a) fields, member or instance variables, which belongs to particular object of the class','b) in jargon you can call them “template for the object structure”','c) you can refer tho them with Class.variable notation',' d) you can refer tho them with this.variable notation','0'),(36,'3. Variables declared in body of the class with static keyword can be described as (mark ','mult','acd',4,'a) in jargon you can call it as “static structure” of the class','b) you can\'t access these variables from member or instance methods','c) you refer to them with Class.variable notation','d) can be used as shared point of information between several objects of the class (in ','0'),(37,'4. Methods declared without static keyword can be described as (mark two correct ','mult','ad',4,'a) you call them member or instance methods','b) you can refer to these variables with Class.variable notation','c) you can declare local variables with static keyword in such methods','d) you can refer to the current object using this keyword in them','0'),(38,'5. Methods declared with static keyword can be described as (mark two correct ','mult','ab',4,'a) you call them class members, which belongs to the class of all objects','b) you invoke them with Class.member() notation','c) you can invoke these methods only if you have reference to the object','d) you can use this keyword inside body of such methods',NULL),(39,'6. Match the descriptions in the list on the left with the correct concept from the list on the ','match','bcad',4,'Java API documentation generator. A. java','Creator and manager of Java archive files. B. javac','Launcher for Java applications, Java virtual machine. C. jar','Compiler for the Java programming language. D. javadoc',NULL),(40,'7. Please choose true/false:  Variables declared inside method or smaller block of code are called ','boolean','true',4,'true','false',NULL,NULL,NULL),(41,'8. Please choose true/false: You can call public static final variables as “global constants”','boolean','true',4,'true','false',NULL,NULL,NULL),(42,'9. Please choose true/false: You can use uninitialized local variable in Java','boolean','false',4,'true','false',NULL,NULL,NULL),(43,'10. Please choose true/false: The same literal value of String is stored only once in memory ','boolean','true',4,'true','false',NULL,NULL,NULL),(44,'11. Please choose true/false: Several Java versions can be installed and run simultaneously','boolean','true',4,'true','false',NULL,NULL,NULL),(45,'12. Please choose true/false: In Java all lines must be ended with semicolon ;','boolean','false',4,'true','false',NULL,NULL,NULL),(49,'13. Please choose true/false: In Java variables must start with a letter','boolean','false',4,'true','false',NULL,NULL,NULL),(50,'14. Please choose true/false: for (;;) {…} and while (true) {…} will work the same','boolean','true',4,'true','false',NULL,NULL,NULL),(51,'15. Please choose true/false: In Java i++; and ++i; is the same','boolean','false',4,'true','false',NULL,NULL,NULL),(52,'16. Please choose true/false: In Java variable names are case-sensitive','boolean','true',4,'true','false',NULL,NULL,NULL),(53,'17. How can you execute method of the class, which is NOT such method: public static void main (String [] args) {...} A: If it is static method, call it from ... main (…) or unit test in like this: B: If it is object method, create object of this class in ... main (…) method, then call this TestClass testObject = new TestClass(); ','radio','c',4,'a) A is true','b) B is true','c) both A and B are true','d) neither A nor B is true',NULL),(54,'18. For the following code: int i = 0; do { System.out.println(\"Are you finished yet?\"); #1 ; } while (i < 10);   System.out.println(\"Done\"); Which of the following should be placed on #1 to make this cycle repeat 10 times?','radio','b',4,'a) i;','b) i++;','c) i--;','d) i+i;',NULL),(55,'19. For following code: String[] str = { \"a\", // 1 byte in UTF-8, 2 bytes in UTF-16  \"ā\", // 2 bytes in UTF-8, 2 bytes in UTF-16  \"東\", // 3 bytes in UTF-8, 2 bytes in UTF-16  \"?\" // 4 bytes in UTF-8, 4 bytes in UTF-16}; for (String cstr : str)  System.out.print(cstr.charAt(0)); which characters will be properly printed out on console: ','radio','c',4,'a) all four characters','b) only aā, because they fit into two bytes of char','c) first three characters aā 東, because 3 bytes of 東 are converted into 2 bytes  internally','d) all four characters, because all are just single characte',NULL),(56,'20. If last line of the previous code is replaced with following: // Get first byte of string and then covert it to char System.out.print((char)cstr.getBytes()[0]); which characters will be printed out properly on console:','radio','b',4,'a) program will crash and will not print anything','b) only a because only its significant value fits into single byte','c) aā, because these are Latin characters supported by ASCII standard','d) neither value will be correct, because char needs two bytes to be shown properly',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Student','test@test.com','$2a$06$RGkvCtgXLe9DHGiQphspxOd7T.Dnan/9cXq/Tl6MGkcNoOpXmoKAa','student','student'),(2,'Admin','admin@test.com','$2a$06$RGkvCtgXLe9DHGiQphspxOd7T.Dnan/9cXq/Tl6MGkcNoOpXmoKAa','admin','admin'),(10,'chris123','chris@gmail.com','$2a$06$5ky5pQSBMQCgA91p6Njot.POhFy0IWeyHtPRAodGU37xbevxJmOt.','admin','chriss');
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

-- Dump completed on 2021-07-05 23:35:58
