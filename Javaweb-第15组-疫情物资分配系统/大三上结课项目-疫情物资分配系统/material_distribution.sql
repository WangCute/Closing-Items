/*
SQLyog Community v13.1.8 (64 bit)
MySQL - 8.0.30 : Database - material_distribution
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`material_distribution` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `material_distribution`;

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '标识',
  `order` char(50) NOT NULL COMMENT '订单号',
  `region_id` char(50) NOT NULL COMMENT '地区编码',
  `name` char(50) NOT NULL COMMENT '名称',
  `code` char(20) NOT NULL COMMENT '编码',
  `type` char(10) NOT NULL COMMENT '类型',
  `number` double NOT NULL COMMENT '数量',
  `company` char(10) DEFAULT NULL COMMENT '单位',
  `people` int NOT NULL COMMENT '区域人数',
  `urgency` char(10) NOT NULL COMMENT '紧急程度',
  `state` char(10) DEFAULT '待审批' COMMENT '状态',
  `apply_date` char(50) NOT NULL COMMENT '申请日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `apply` */

insert  into `apply`(`id`,`order`,`region_id`,`name`,`code`,`type`,`number`,`company`,`people`,`urgency`,`state`,`apply_date`) values 
(1,'SF20221216815X','S_001CD','防护服','PC_9129','防护类',5000,'件',82301,'高','已出库','2022-12-16'),
(2,'CD202212172316','S_001CD','大米','R_2863','生活类',30000,'件',82301,'中','已审批','2022-12-17'),
(3,'CD202212181530','CD_001','N95口罩','N_9516','防护类',2343,'盒',82301,'高','已签收','2022-12-18'),
(4,'CD202212181841','CD_001','帐篷','F_0023','防护类',3200,'件',82301,'中','待审批','2022-12-18'),
(7,'202212182233527070001','CD_001','土豆','S_1203','生活类',237812,'箱',82301,'默认','待审批','2022-12-18'),
(12,'202212210825280070001','CD_001','衣服','R_1234','生活类',134,'件',82301,'中','已出库','2022-12-21'),
(13,'202212271105362140001','CD_001','洋芋','Q_123','生活类',200,'箱',10000,'中','已签收','2022-12-27');

/*Table structure for table `destruction` */

DROP TABLE IF EXISTS `destruction`;

CREATE TABLE `destruction` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '标识',
  `name` char(50) NOT NULL COMMENT '名称',
  `code` char(20) NOT NULL COMMENT '编码',
  `type` char(10) NOT NULL COMMENT '类型',
  `warehous` char(50) NOT NULL COMMENT '入库时间',
  `valid` char(50) NOT NULL COMMENT '有效期',
  `invalid` char(50) DEFAULT NULL COMMENT '失效日期',
  `number` double NOT NULL COMMENT '数量',
  `company` char(10) DEFAULT NULL COMMENT '单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `destruction` */

insert  into `destruction`(`id`,`name`,`code`,`type`,`warehous`,`valid`,`invalid`,`number`,`company`) values 
(19,'防护服','PC_9129','防护类','2022-12-16','180','2023-05-12',12,'件'),
(20,'防护服','PC_9129','防护类','2022-12-16','180','2023-05-12',12,'件'),
(21,'防护服','PC_9129','防护类','2022-11-11','180','2021-04-11',12,'件'),
(23,'4','PC_9129','防护类','2022-12-16','180','2023-05-12',12,'件'),
(24,'4','PC_9129','防护类','2022-12-16','180','2023-05-12',12,'件'),
(25,'2','M_8312','防护类','2022-12-17','360','2023-12-16',1,'盒'),
(26,'2','M_8312','防护类','2022-12-17','360','2023-12-16',1,'盒'),
(27,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',10,'盒'),
(28,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',12,'盒'),
(29,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',1,'盒'),
(30,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',1,'盒'),
(31,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',1,'盒'),
(32,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',1,'盒'),
(33,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',1,'盒'),
(34,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',12,'盒'),
(35,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',1,'盒'),
(36,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',12,'盒'),
(37,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',12,'盒'),
(38,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',1,'盒'),
(39,'防护服','PC_9129','防护类','2022-12-16','180','2023-05-12',1000,'件');

/*Table structure for table `distribute` */

DROP TABLE IF EXISTS `distribute`;

CREATE TABLE `distribute` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '标识',
  `region_id` char(50) NOT NULL,
  `name` char(50) NOT NULL COMMENT '名称',
  `code` char(20) NOT NULL COMMENT '编码',
  `type` char(10) NOT NULL COMMENT '类型',
  `number` double NOT NULL COMMENT '数量',
  `company` char(10) DEFAULT NULL COMMENT '单位',
  `owner` char(20) NOT NULL COMMENT '业主',
  `address` char(200) NOT NULL COMMENT '地址',
  `telephone` char(20) NOT NULL COMMENT '联系电话',
  `card_id` char(18) NOT NULL COMMENT '身份证号',
  `time` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `distribute` */

insert  into `distribute`(`id`,`region_id`,`name`,`code`,`type`,`number`,`company`,`owner`,`address`,`telephone`,`card_id`,`time`) values 
(1,'CD_001','防护服','PC_1216','防护类',20,'件','王狼','四川省巴中市平昌县望京镇','17345449129','51192320011216815X','2022-12-26'),
(2,'CD_001','普通医用口罩','M_8312','防护类',200,NULL,'王海鹏','四川省巴中市平昌县望京镇','17345449129','51192320011216815X','2022-12-26'),
(3,'CD_001','普通医用口罩','M_8312','防护类',200,'件','12','四川省巴中市平昌县望京镇','17345449129','51192320011216815X','2022-12-27');

/*Table structure for table `issue` */

DROP TABLE IF EXISTS `issue`;

CREATE TABLE `issue` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '标识',
  `name` char(50) NOT NULL COMMENT '名称',
  `code` char(20) NOT NULL COMMENT '编码',
  `type` char(10) NOT NULL COMMENT '类型',
  `warehous` char(50) NOT NULL COMMENT '入库日期',
  `valid` char(50) NOT NULL COMMENT '有效期',
  `invalid` char(50) DEFAULT NULL COMMENT '失效日期',
  `number` double NOT NULL COMMENT '数量',
  `company` char(10) DEFAULT NULL COMMENT '单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `issue` */

insert  into `issue`(`id`,`name`,`code`,`type`,`warehous`,`valid`,`invalid`,`number`,`company`) values 
(7,'防护服','PC_9129','防护类','2022-12-16','180','2023-05-12',5000,'件'),
(8,'普通医用口罩','PC_9129','防护类','2022-12-17','360','2023-12-16',5000,'盒'),
(9,'棉签','PC_9129','医用类','2022-12-17','360','2022-12-12',5000,'盒'),
(10,'防护服','PC_9129','防护类','2022-11-11','180','2021-04-11',5000,'件'),
(14,'防护服','PC_9129','防护类','2022-12-16','180','2023-05-12',5000,'件'),
(15,'普通医用口罩','PC_9129','防护类','2022-12-17','360','2023-12-16',5000,'盒'),
(16,'棉签','PC_9129','医用类','2022-12-17','360','2022-12-12',5000,'盒'),
(17,'防护服','PC_9129','防护类','2022-11-11','180','2021-04-11',5000,'件'),
(21,'防护服','PC_9129','防护类','2022-12-16','180','2023-05-12',5000,'件'),
(22,'普通医用口罩','PC_9129','防护类','2022-12-17','360','2023-12-16',5000,'盒'),
(23,'棉签','PC_9129','医用类','2022-12-17','360','2022-12-12',5000,'盒'),
(24,'防护服','PC_9129','防护类','2022-11-11','180','2021-04-11',5000,'件'),
(25,'防护服','R_1234','防护类','2022-12-16','180','2023-05-12',134,'件'),
(26,'普通医用口罩','R_1234','防护类','2022-12-17','360','2023-12-16',134,'盒'),
(27,'12','R_1234','防护类','2022-12-17','12','2023-12-16',134,'件'),
(28,'防护服','R_1234','防护类','2022-11-11','180','2021-04-11',134,'件'),
(29,'防护服','Q_123','防护类','2022-12-16','180','2023-05-12',200,'件'),
(30,'普通医用口罩','Q_123','防护类','2022-12-17','360','2023-12-16',200,'盒'),
(31,'棉签','Q_123','防护类','2022-12-17','12','2023-12-16',200,'件');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` char(11) NOT NULL,
  `password` char(16) NOT NULL,
  `region_id` char(50) NOT NULL,
  `type` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '中央、社区',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `login` */

insert  into `login`(`id`,`account`,`password`,`region_id`,`type`) values 
(1,'C_001','123456','CD_001','中央'),
(2,'22010730405','123456','CD_001','社区'),
(3,'22010730406','123456','P_1216','社区'),
(4,'22010730407','123456','T_2001','社区'),
(5,'22010730408','123456','E_04551','社区');

/*Table structure for table `material` */

DROP TABLE IF EXISTS `material`;

CREATE TABLE `material` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '标识',
  `name` char(50) NOT NULL COMMENT '名称',
  `code` char(20) NOT NULL COMMENT '编码',
  `type` char(10) NOT NULL COMMENT '类型',
  `warehous` char(50) NOT NULL COMMENT '入库时间',
  `valid` char(50) DEFAULT NULL COMMENT '有效期',
  `invalid` char(50) DEFAULT NULL COMMENT '失效日期',
  `stock` double DEFAULT NULL COMMENT '库存',
  `company` char(10) DEFAULT NULL COMMENT '单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `material` */

insert  into `material`(`id`,`name`,`code`,`type`,`warehous`,`valid`,`invalid`,`stock`,`company`) values 
(1,'防护服','PC_9129','防护类','2022-12-16','180','2023-05-12',98940,'件'),
(2,'普通医用口罩','M_8312','防护类','2022-12-17','360','2023-12-16',82652,'盒'),
(3,'棉签','C_6823','防护类','2022-12-17','12','2023-12-16',0,'件');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` char(50) NOT NULL,
  `content` varchar(5000) NOT NULL,
  `type` char(20) NOT NULL,
  `time` char(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `notice` */

insert  into `notice`(`id`,`name`,`content`,`type`,`time`) values 
(2,'王志宇','快去填写','通知','2022-12-26'),
(3,'物资信息','尊重的各位群众：\r\n	根据防控要求，目前该地区不能进行外向交流，即日起由该网站进行信息登记，便于我们发放物资，进行物资发放，谢谢！社区\r\n','通知','2022-12-26');

/*Table structure for table `personal` */

DROP TABLE IF EXISTS `personal`;

CREATE TABLE `personal` (
  `id` int NOT NULL AUTO_INCREMENT,
  `region_id` char(50) DEFAULT NULL,
  `name` char(20) NOT NULL,
  `sex` char(10) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `card_id` char(18) NOT NULL,
  `province` char(20) DEFAULT NULL,
  `city` char(20) DEFAULT NULL,
  `county` char(20) DEFAULT NULL,
  `address` char(100) DEFAULT NULL,
  `telephone` char(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `personal` */

insert  into `personal`(`id`,`region_id`,`name`,`sex`,`age`,`card_id`,`province`,`city`,`county`,`address`,`telephone`) values 
(1,'P_1216','王狼','男',20,'51192320011216815X','四川省','巴中市','平昌县','望京镇','17345449129'),
(2,'P_1216','wanglang','男',20,'51192320011216815X','四川省','巴中市','平昌县','望京镇','17345449129');

/*Table structure for table `regioncode` */

DROP TABLE IF EXISTS `regioncode`;

CREATE TABLE `regioncode` (
  `id` int NOT NULL AUTO_INCREMENT,
  `region_id` char(50) DEFAULT NULL,
  `province` char(20) DEFAULT NULL,
  `city` char(20) DEFAULT NULL,
  `county` char(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `regioncode` */

insert  into `regioncode`(`id`,`region_id`,`province`,`city`,`county`) values 
(1,'P_1216','四川省','巴中市','平昌县'),
(2,'T_2001','四川省','巴中市','通江县'),
(3,'E_04551','四川省','巴中市','恩阳区');

/*Table structure for table `warehous` */

DROP TABLE IF EXISTS `warehous`;

CREATE TABLE `warehous` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '标识',
  `name` char(50) NOT NULL COMMENT '名称',
  `code` char(20) NOT NULL COMMENT '编码',
  `type` char(10) NOT NULL COMMENT '类型',
  `warehous` char(50) NOT NULL COMMENT '入库时间',
  `valid` char(50) NOT NULL COMMENT '有效期',
  `invalid` char(50) DEFAULT NULL COMMENT '失效日期',
  `number` double NOT NULL COMMENT '数量',
  `company` char(255) DEFAULT NULL COMMENT '单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `warehous` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
