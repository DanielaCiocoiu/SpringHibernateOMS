DROP SCHEMA IF EXISTS `oms1`;
CREATE SCHEMA `oms1`;
use `oms1`;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `oms_user`;
CREATE TABLE `oms_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `USER_NAME_UNIQUE` (`user_name`),
  KEY `username` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
 

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_code` int(11) DEFAULT NULL,
  `product_name` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  UNIQUE KEY `PRODUCT_CODE` (`product_code`),
  UNIQUE KEY `QUANTITY` (`quantity`),
  KEY `FK_CATEGORY_idx` (`category_id`),
  CONSTRAINT `FK_CATEGORY` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Cat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_time` date DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `FK_USER_NAME_idx` (`user_name`),
  CONSTRAINT `FK_USER_NAME` FOREIGN KEY (`user_name`) REFERENCES `oms_user` (`user_name`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `order_product`;
CREATE TABLE `order_product` (
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `product_code` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`product_id`,`order_id`),
  KEY `FK_ORDER_idx` (`order_id`),
  KEY `FK_PRODUCT_CODE` (`product_code`),
  KEY `FK_QUANTITY` (`quantity`),
  CONSTRAINT `FK_ORDER_idx` FOREIGN KEY (`order_id`) REFERENCES `oms_order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PRODUCT_CODE` FOREIGN KEY (`product_code`) REFERENCES `product` (`product_code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_PRODUCT_05` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_QUANTITY` FOREIGN KEY (`quantity`) REFERENCES `product` (`quantity`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

  
INSERT INTO `oms_order`  VALUES (1,'2019-03-13','Mia');
INSERT INTO `oms_order`  VALUES (2,'2019-03-14','Nico');
INSERT INTO `oms_order`  VALUES (3,'2019-03-15','Mario');
INSERT INTO `oms_order`  VALUES (4,'2019-03-16','Vio');
INSERT INTO `oms_order`  VALUES (5,'2019-01-12','Petro');
INSERT INTO `oms_order`  VALUES (6,'2019-09-29','Vio');

INSERT INTO `category` (`id`,`Cat`) VALUES (1,'Vehicle');
INSERT INTO `category` (`id`,`Cat`) VALUES (2,'TV');
INSERT INTO `category` (`id`,`Cat`) VALUES (3,'Computer');

INSERT INTO `oms_user` (`id`,`user_name`,`full_name`) VALUES (1,'Mario','Mariana Iliut');
INSERT INTO `oms_user` (`id`,`user_name`,`full_name`) VALUES (2,'Mia','Mioara Mateescu');
INSERT INTO `oms_user` (`id`,`user_name`,`full_name`) VALUES (3,'Nico','Nicoleta Amar');
INSERT INTO `oms_user` (`id`,`user_name`,`full_name`) VALUES (4,'Vio','Violeta Iliescu');
INSERT INTO `oms_user` (`id`,`user_name`,`full_name`) VALUES (5,'Petro','Mirica Gabriela');
INSERT INTO `oms_user` (`id`,`user_name`,`full_name`) VALUES (6,'Niky','Nicoleta Marinescu');

INSERT INTO `order_product` (`product_id`,`order_id`,`product_code`,`quantity`) VALUES (1,1,222,1);
INSERT INTO `order_product` (`product_id`,`order_id`,`product_code`,`quantity`) VALUES (2,2,333,5);
INSERT INTO `order_product` (`product_id`,`order_id`,`product_code`,`quantity`) VALUES (3,3,444,2);

INSERT INTO `product` (`product_id`,`product_code`,`product_name`,`description`,`quantity`,`category_id`) VALUES (1,222,'Laptop','Acer',1,3);
INSERT INTO `product` (`product_id`,`product_code`,`product_name`,`description`,`quantity`,`category_id`) VALUES (2,333,'TV','Samsung',5,2);
INSERT INTO `product` (`product_id`,`product_code`,`product_name`,`description`,`quantity`,`category_id`) VALUES (3,444,'Audi','A6',2,1);
INSERT INTO `product` (`product_id`, `product_code`, `product_name`, `description`, `quantity`, `category_id`) VALUES ('4', '555', 'BMW', 'Seria 5', '6', '1');
INSERT INTO `product` (`product_id`, `product_code`, `product_name`, `description`, `quantity`, `category_id`) VALUES ('5', '666', 'TV', 'LG', '4', '2');
INSERT INTO `product` (`product_id`, `product_code`, `product_name`, `description`, `quantity`, `category_id`) VALUES ('6', '777', 'Laptop', 'Lenovo', '3', '3');
INSERT INTO `product` (`product_id`, `product_code`, `product_name`, `description`, `quantity`, `category_id`) VALUES ('7', '888', 'Opel', 'Vectra', '7', '1');


SET FOREIGN_KEY_CHECKS = 1;
	

