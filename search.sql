/*
SQLyog Community v13.1.7 (64 bit)
MySQL - 8.0.25 : Database - search
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`search` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `search`;

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `updateDate` datetime NOT NULL,
  `loginId` char(20) NOT NULL,
  `loginPw` char(100) NOT NULL,
  `name` char(20) NOT NULL,
  `nickname` char(20) NOT NULL,
  `email` char(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `loginId` (`loginId`),
  UNIQUE KEY `loginPw` (`loginPw`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `member` */

insert  into `member`(`id`,`regDate`,`updateDate`,`loginId`,`loginPw`,`name`,`nickname`,`email`) values 
(1,'2021-06-17 21:13:14','2021-06-17 21:13:14','user1','user1','운영자','운영자','user1@test.com');

/*Table structure for table `shorturi` */

DROP TABLE IF EXISTS `shorturi`;

CREATE TABLE `shorturi` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `regDate` datetime NOT NULL,
  `memberId` int NOT NULL,
  `updateDate` datetime NOT NULL,
  `shortCode` char(3) NOT NULL,
  `originUri` char(150) NOT NULL,
  `text` char(200) DEFAULT NULL,
  `blanklessText` char(100) DEFAULT NULL,
  `accessCount` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `blank` (`memberId`,`blanklessText`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `shorturi` */

insert  into `shorturi`(`id`,`regDate`,`memberId`,`updateDate`,`shortCode`,`originUri`,`text`,`blanklessText`,`accessCount`) values 
(1,'2021-06-19 00:26:47',0,'2021-06-19 00:26:47','?','?','?','1',0),
(2,'2021-06-19 00:37:51',0,'2021-06-19 00:37:51','N2V','https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=lk3436&logNo=220718892372','mysql 및 mariadb - jsp 연동 : 네이버 블로그','mysql및mariadb-jsp연동:네이버블로그',0),
(4,'2021-06-19 00:48:26',0,'2021-06-19 00:48:26','?','?','?','?',0),
(5,'2021-06-19 19:20:07',0,'2021-06-19 19:20:07','4oe','https://stackoverflow.com/questions/48070781/exception-java-sql-sqlexception-could-not-set-parameter-at-position-whit','mysql - Exception java.sql.SQLException: Could not set parameter at position (...). whit mariadb - Stack Overflow','mysql-Exceptionjava.sql.SQLException:Couldnotsetparameteratposition(...).whitmariadb-StackOverflow',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
