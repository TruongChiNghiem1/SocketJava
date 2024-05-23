-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.3.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for onsocket
CREATE DATABASE IF NOT EXISTS `onsocket` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `onsocket`;

-- Dumping data for table onsocket.department: ~2 rows (approximately)
INSERT INTO `department` (`id`, `location`, `name`) VALUES
	('dept1', 'Quan3', 'Cardi'),
	('dept2', 'Quan4', 'Neu');

-- Dumping data for table onsocket.doctor: ~3 rows (approximately)
INSERT INTO `doctor` (`department_id`, `email`, `firstName`, `id`, `lastName`, `phone`, `specialty`, `certification`) VALUES
	('dept1', 'john.doe@example.com', 'John', 'doc1', 'Doe', '555-1234', 'Cardiology', _binary 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a6578700000000277040000000274000f426f617264204365727469666965647400044641434378),
	('dept2', 'jane.smith@example.com', 'Jane', 'doc2', 'Smith', '555-5678', 'Neurology', _binary 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a657870000000027704000000027400044142504e74000f426f6172642043657274696669656478),
	('dept2', 'Kime@example.com', 'HAn', 'doc3', 'Kine', '147589', 'Neurology', _binary 0xaced0005737200136a6176612e7574696c2e41727261794c6973747881d21d99c7619d03000149000473697a657870000000027704000000027400044142504e74000f426f6172642043657274696669656478);

-- Dumping data for table onsocket.patient: ~1 rows (approximately)
INSERT INTO `patient` (`age`, `address`, `firstName`, `gender`, `id`, `lastName`, `phone`) VALUES
	(30, '123 Main St', 'John', 'Male', 'PT-1', 'Doe', '555-1234');

-- Dumping data for table onsocket.treatment: ~0 rows (approximately)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
