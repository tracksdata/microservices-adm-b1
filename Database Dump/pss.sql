/*
 Navicat Premium Data Transfer

 Source Server         : MYSQL-MAC
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : pss

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 01/02/2021 03:54:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `airline_info`;
CREATE TABLE `airline_info` (
  `airline_id` int(11) NOT NULL,
  `airline_logo` varchar(255) DEFAULT NULL,
  `airline_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`airline_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `airline_info` VALUES (2, 'airindia.png', 'Air India');
INSERT INTO `airline_info` VALUES (19, 'indigo.png', 'Indigo');
INSERT INTO `airline_info` VALUES (36, 'air-asia.png', 'Air Asia');
INSERT INTO `airline_info` VALUES (50, 'spicejet.png', 'Spicejet');
INSERT INTO `airline_info` VALUES (61, 'vistara.png', 'Vistara');
INSERT INTO `airline_info` VALUES (78, 'truejet.png', 'Trujet');
COMMIT;


DROP TABLE IF EXISTS `booking_record`;
CREATE TABLE `booking_record` (
  `booking_id` int(11) NOT NULL,
  `booking_date` datetime DEFAULT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `fare` double NOT NULL,
  `flight_date` date DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `flight_time` time DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `airline_id` int(11) DEFAULT NULL,
  `passenger_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FKpx7tkcf7t3cm7oh373crxu416` (`airline_id`),
  KEY `FKgdvxsjoo1fp4yvsqkovgvyii5` (`passenger_id`),
  CONSTRAINT `FKgdvxsjoo1fp4yvsqkovgvyii5` FOREIGN KEY (`passenger_id`) REFERENCES `passenger` (`passenger_id`),
  CONSTRAINT `FKpx7tkcf7t3cm7oh373crxu416` FOREIGN KEY (`airline_id`) REFERENCES `airline_info` (`airline_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `booking_record` VALUES (94, '2021-02-01 03:50:31', 'CHENNAI', 4800, '2021-02-26', 'AI-840', '02:12:00', 'DELHI', 'CONFIRMED', 2, 95);
INSERT INTO `booking_record` VALUES (98, '2021-02-01 03:50:31', 'DELHI', 10000, '2021-02-26', '6E-6685', '03:15:00', 'BENGULURU', 'CONFIRMED', 19, 99);
INSERT INTO `booking_record` VALUES (103, '2021-02-01 03:50:31', 'CHENNAI', 6200, '2021-02-26', 'UK-830', '10:15:00', 'DELHI', 'CONFIRMED', 61, 104);
COMMIT;


DROP TABLE IF EXISTS `check_in`;
CREATE TABLE `check_in` (
  `checkin_id` int(11) NOT NULL,
  `checkin_time` datetime DEFAULT NULL,
  `seat_number` varchar(255) DEFAULT NULL,
  `booking_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`checkin_id`),
  KEY `FK8k5la9brl7xc93rn3e9isrlhv` (`booking_id`),
  CONSTRAINT `FK8k5la9brl7xc93rn3e9isrlhv` FOREIGN KEY (`booking_id`) REFERENCES `booking_record` (`booking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `check_in` VALUES (106, '2021-02-01 03:50:31', 'A4', 94);
INSERT INTO `check_in` VALUES (107, '2021-02-01 03:50:31', 'A3', 98);
INSERT INTO `check_in` VALUES (108, '2021-02-01 03:50:31', 'B2', 103);
COMMIT;


DROP TABLE IF EXISTS `co_passenger`;
CREATE TABLE `co_passenger` (
  `copassenger_id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`copassenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `co_passenger` VALUES (96, 'James', 'Male', 'Goedic');
INSERT INTO `co_passenger` VALUES (97, 'Rose', 'Female', 'Ella');
INSERT INTO `co_passenger` VALUES (100, 'Bucky', 'Male', 'Wall');
INSERT INTO `co_passenger` VALUES (101, 'Reet', 'Female', 'Kour');
INSERT INTO `co_passenger` VALUES (102, 'Sameera', 'Female', 'Reddy');
INSERT INTO `co_passenger` VALUES (105, 'Ravi', 'Male', 'Kumar');
COMMIT;

DROP TABLE IF EXISTS `copassengers`;
CREATE TABLE `copassengers` (
  `passenger_id` int(11) NOT NULL,
  `copassenger_id` int(11) NOT NULL,
  UNIQUE KEY `UK_im48nvjcav3osabs8ycwapr7t` (`copassenger_id`),
  KEY `FK2qqxnku2kv60m6gita7bxya5k` (`passenger_id`),
  CONSTRAINT `FK2qqxnku2kv60m6gita7bxya5k` FOREIGN KEY (`passenger_id`) REFERENCES `passenger` (`passenger_id`),
  CONSTRAINT `FKtnwfeul2ki9yfca0wwv7grpg4` FOREIGN KEY (`copassenger_id`) REFERENCES `co_passenger` (`copassenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `copassengers` VALUES (95, 96);
INSERT INTO `copassengers` VALUES (95, 97);
INSERT INTO `copassengers` VALUES (99, 100);
INSERT INTO `copassengers` VALUES (99, 101);
INSERT INTO `copassengers` VALUES (99, 102);
INSERT INTO `copassengers` VALUES (104, 105);
COMMIT;


DROP TABLE IF EXISTS `fare`;
CREATE TABLE `fare` (
  `fare_id` int(11) NOT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `fare` double NOT NULL,
  PRIMARY KEY (`fare_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `fare` VALUES (7, 'INR', 4800);
INSERT INTO `fare` VALUES (10, 'INR', 3500);
INSERT INTO `fare` VALUES (13, 'INR', 5000);
INSERT INTO `fare` VALUES (16, 'INR', 2546);
INSERT INTO `fare` VALUES (24, 'INR', 7500);
INSERT INTO `fare` VALUES (27, 'INR', 10000);
INSERT INTO `fare` VALUES (30, 'INR', 7438);
INSERT INTO `fare` VALUES (33, 'INR', 8743);
INSERT INTO `fare` VALUES (41, 'INR', 1955);
INSERT INTO `fare` VALUES (44, 'INR', 2500);
INSERT INTO `fare` VALUES (47, 'INR', 4943);
INSERT INTO `fare` VALUES (55, 'INR', 4943);
INSERT INTO `fare` VALUES (58, 'INR', 4500);
INSERT INTO `fare` VALUES (66, 'INR', 6200);
INSERT INTO `fare` VALUES (69, 'INR', 5000);
INSERT INTO `fare` VALUES (72, 'INR', 1200);
INSERT INTO `fare` VALUES (75, 'INR', 1389);
INSERT INTO `fare` VALUES (83, 'INR', 11000);
INSERT INTO `fare` VALUES (86, 'INR', 15000);
INSERT INTO `fare` VALUES (89, 'INR', 3000);
INSERT INTO `fare` VALUES (92, 'INR', 9000);
COMMIT;


DROP TABLE IF EXISTS `flight`;
CREATE TABLE `flight` (
  `id` int(11) NOT NULL,
  `destination` varchar(255) DEFAULT NULL,
  `duration` varchar(255) DEFAULT NULL,
  `flight_date` date DEFAULT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `flight_time` time DEFAULT NULL,
  `origin` varchar(255) DEFAULT NULL,
  `airline_id` int(11) DEFAULT NULL,
  `fare_id` int(11) DEFAULT NULL,
  `inv_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKshx1jfsscmwqnfvmcch6k349g` (`airline_id`),
  KEY `FKpekyhxlpp2g4l0emd9vj9qjvc` (`fare_id`),
  KEY `FKi31ay2wj2odp6ij5uvfunmk0y` (`inv_id`),
  CONSTRAINT `FKi31ay2wj2odp6ij5uvfunmk0y` FOREIGN KEY (`inv_id`) REFERENCES `inventory` (`inv_id`),
  CONSTRAINT `FKpekyhxlpp2g4l0emd9vj9qjvc` FOREIGN KEY (`fare_id`) REFERENCES `fare` (`fare_id`),
  CONSTRAINT `FKshx1jfsscmwqnfvmcch6k349g` FOREIGN KEY (`airline_id`) REFERENCES `airline_info` (`airline_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `flight` VALUES (1, 'CHENNAI', '2 hrs 15 mins', '2021-02-26', 'AI-840', '02:12:00', 'DELHI', 2, 7, 8);
INSERT INTO `flight` VALUES (9, 'HYDERABAD', '2 hrs 45 mins', '2021-02-26', 'AI-850', '01:15:00', 'DELHI', 2, 10, 11);
INSERT INTO `flight` VALUES (12, 'MUMBAI', '2 hrs 50 mins', '2021-02-26', 'AI-860', '02:30:00', 'CHENNAI', 2, 13, 14);
INSERT INTO `flight` VALUES (15, 'HYDERABAD', '1 hrs 45 mins', '2021-02-18', 'AI-870', '02:45:00', 'PUNE', 2, 16, 17);
INSERT INTO `flight` VALUES (18, 'PORTBLAIR', '3 hrs 00 mins', '2021-02-21', '6E-6684', '03:00:00', 'CHENNAI', 19, 24, 25);
INSERT INTO `flight` VALUES (26, 'DELHI', '3 hrs 15 mins', '2021-02-26', '6E-6685', '03:15:00', 'BENGULURU', 19, 27, 28);
INSERT INTO `flight` VALUES (29, 'PUNE', '3 hrs 07 mins', '2021-04-24', '6E-6686', '03:15:00', 'DELHI', 19, 30, 31);
INSERT INTO `flight` VALUES (32, 'MANGALORE', '3 hrs 30 mins', '2021-03-18', '6E-6687', '03:15:00', 'HYDERABAD', 19, 33, 34);
INSERT INTO `flight` VALUES (35, 'AHMADABAD', '6 hrs 00 mins', '2021-02-13', 'I5-755', '04:30:00', 'MUMBAI', 36, 41, 42);
INSERT INTO `flight` VALUES (43, 'KOLKATA', '3 hrs 15 mins', '2021-02-27', 'I5-756', '04:45:00', 'HYDERABAD', 36, 44, 45);
INSERT INTO `flight` VALUES (46, 'DELHI', '1 hrs 00 mins', '2021-02-26', 'I5-757', '07:45:00', 'KOLKATA', 36, 47, 48);
INSERT INTO `flight` VALUES (49, 'MUMBAI', '1 hrs 20 mins', '2021-02-26', 'SG-434', '11:45:00', 'DELHI', 50, 55, 56);
INSERT INTO `flight` VALUES (57, 'CHENNAI', '2 hrs 10 mins', '2021-02-26', 'SG-435', '02:45:00', 'DELHI', 50, 58, 59);
INSERT INTO `flight` VALUES (60, 'CHENNAI', '2 hrs 05 mins', '2021-02-26', 'UK-830', '10:15:00', 'DELHI', 61, 66, 67);
INSERT INTO `flight` VALUES (68, 'CHENNAI', '2 hrs 14 mins', '2021-02-26', 'UK-831', '11:30:00', 'DELHI', 61, 69, 70);
INSERT INTO `flight` VALUES (71, 'CHENNAI', '2 hrs 12 mins', '2021-03-17', 'UK-832', '11:55:00', 'DELHI', 61, 72, 73);
INSERT INTO `flight` VALUES (74, 'CHENNAI', '1 hrs 55 mins', '2021-02-23', 'UK-833', '11:55:00', 'DELHI', 61, 75, 76);
INSERT INTO `flight` VALUES (77, 'CHENNAI', '2 hrs 10 mins', '2021-02-26', '2T-518', '10:15:00', 'DELHI', 78, 83, 84);
INSERT INTO `flight` VALUES (85, 'CHENNAI', '2 hrs 22 mins', '2021-02-26', '2T-519', '19:35:00', 'DELHI', 78, 86, 87);
INSERT INTO `flight` VALUES (88, 'CHENNAI', '1 hrs 45 mins', '2021-02-26', '2T-519', '06:15:00', 'DELHI', 78, 89, 90);
INSERT INTO `flight` VALUES (91, 'CHENNAI', '1 hrs 55 mins', '2021-02-26', '2T-520', '22:45:00', 'DELHI', 78, 92, 93);
COMMIT;


DROP TABLE IF EXISTS `flight_info`;
CREATE TABLE `flight_info` (
  `flight_infoid` int(11) NOT NULL,
  `flight_number` varchar(255) DEFAULT NULL,
  `flight_type` varchar(255) DEFAULT NULL,
  `seat_capacity` int(11) NOT NULL,
  PRIMARY KEY (`flight_infoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `flight_info` VALUES (3, 'AI-840', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (4, 'AI-850', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (5, 'AI-860', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (6, 'AI-870', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (20, '6E-6684', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (21, '6E-6685', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (22, '6E-6686', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (23, '6E-6687', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (37, 'I5-755', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (38, 'I5-756', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (39, 'I5-757', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (40, 'I5-758', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (51, 'SG-432', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (52, 'SG-433', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (53, 'SG-434', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (54, 'SG-435', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (62, 'UK-830', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (63, 'UK-831', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (64, 'UK-832', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (65, 'UK-833', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (79, '2T-518', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (80, '2T-519', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (81, '2T-520', 'Airbus', 150);
INSERT INTO `flight_info` VALUES (82, '2T-521', 'Airbus', 150);
COMMIT;


DROP TABLE IF EXISTS `flights_information`;
CREATE TABLE `flights_information` (
  `airline_id` int(11) NOT NULL,
  `flight_infoid` int(11) NOT NULL,
  UNIQUE KEY `UK_t4uf6llaxda45m2xm6dg2w2ii` (`flight_infoid`),
  KEY `FKebbst4qj3l844fim55ndpqt0f` (`airline_id`),
  CONSTRAINT `FKebbst4qj3l844fim55ndpqt0f` FOREIGN KEY (`airline_id`) REFERENCES `airline_info` (`airline_id`),
  CONSTRAINT `FKnb6d7f7aetfn5v9weg4cdho` FOREIGN KEY (`flight_infoid`) REFERENCES `flight_info` (`flight_infoid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `flights_information` VALUES (2, 3);
INSERT INTO `flights_information` VALUES (2, 4);
INSERT INTO `flights_information` VALUES (2, 5);
INSERT INTO `flights_information` VALUES (2, 6);
INSERT INTO `flights_information` VALUES (19, 20);
INSERT INTO `flights_information` VALUES (19, 21);
INSERT INTO `flights_information` VALUES (19, 22);
INSERT INTO `flights_information` VALUES (19, 23);
INSERT INTO `flights_information` VALUES (36, 37);
INSERT INTO `flights_information` VALUES (36, 38);
INSERT INTO `flights_information` VALUES (36, 39);
INSERT INTO `flights_information` VALUES (36, 40);
INSERT INTO `flights_information` VALUES (50, 51);
INSERT INTO `flights_information` VALUES (50, 52);
INSERT INTO `flights_information` VALUES (50, 53);
INSERT INTO `flights_information` VALUES (50, 54);
INSERT INTO `flights_information` VALUES (61, 62);
INSERT INTO `flights_information` VALUES (61, 63);
INSERT INTO `flights_information` VALUES (61, 64);
INSERT INTO `flights_information` VALUES (61, 65);
INSERT INTO `flights_information` VALUES (78, 79);
INSERT INTO `flights_information` VALUES (78, 80);
INSERT INTO `flights_information` VALUES (78, 81);
INSERT INTO `flights_information` VALUES (78, 82);
COMMIT;


DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `hibernate_sequence` VALUES (109);
COMMIT;


DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `inv_id` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`inv_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `inventory` VALUES (8, 100);
INSERT INTO `inventory` VALUES (11, 100);
INSERT INTO `inventory` VALUES (14, 100);
INSERT INTO `inventory` VALUES (17, 100);
INSERT INTO `inventory` VALUES (25, 100);
INSERT INTO `inventory` VALUES (28, 100);
INSERT INTO `inventory` VALUES (31, 100);
INSERT INTO `inventory` VALUES (34, 100);
INSERT INTO `inventory` VALUES (42, 100);
INSERT INTO `inventory` VALUES (45, 100);
INSERT INTO `inventory` VALUES (48, 100);
INSERT INTO `inventory` VALUES (56, 100);
INSERT INTO `inventory` VALUES (59, 100);
INSERT INTO `inventory` VALUES (67, 100);
INSERT INTO `inventory` VALUES (70, 100);
INSERT INTO `inventory` VALUES (73, 120);
INSERT INTO `inventory` VALUES (76, 100);
INSERT INTO `inventory` VALUES (84, 100);
INSERT INTO `inventory` VALUES (87, 100);
INSERT INTO `inventory` VALUES (90, 100);
INSERT INTO `inventory` VALUES (93, 100);
COMMIT;


DROP TABLE IF EXISTS `passenger`;
CREATE TABLE `passenger` (
  `passenger_id` int(11) NOT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile_number` bigint(20) NOT NULL,
  PRIMARY KEY (`passenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


BEGIN;
INSERT INTO `passenger` VALUES (95, 'praveen@abc.com', 'Praveen', 'Male', 'Reddy', 9776565434);
INSERT INTO `passenger` VALUES (99, 'geet@abc.com', 'Geetha', 'Female', 'Kumari', 9876565432);
INSERT INTO `passenger` VALUES (104, 'saru@abc.com', 'Saravanan', 'Male', 'Valli', 9376568754);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
