CREATE DATABASE `bank` /*!40100 DEFAULT CHARACTER SET utf8 */;

--
-- Table structure for table `beneficiaries`
--
DROP TABLE IF EXISTS `beneficiaries`;
CREATE TABLE `beneficiaries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `accounts`
--
DROP TABLE IF EXISTS `accounts`;
CREATE TABLE `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beneficiaries_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `accounts_beneficiaries_FK` (`beneficiaries_id`),
  CONSTRAINT `accounts_beneficiaries_FK` FOREIGN KEY (`beneficiaries_id`) REFERENCES `beneficiaries` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Table structure for table `transactions`
--
DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `accounts_id` int(11) NOT NULL,
  `amount` decimal(15,2) NOT NULL,
  `type` varchar(100) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `transactions_accounts_FK` (`accounts_id`),
  CONSTRAINT `transactions_accounts_FK` FOREIGN KEY (`accounts_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;