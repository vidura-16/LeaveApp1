-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Nov 18, 2021 at 08:37 AM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `leave`
--

-- --------------------------------------------------------

--
-- Table structure for table `leavetbl`
--

DROP TABLE IF EXISTS `leavetbl`;
CREATE TABLE IF NOT EXISTS `leavetbl` (
  `LeaveID` int(20) NOT NULL AUTO_INCREMENT,
  `LeaveType` varchar(20) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `Reason` varchar(50) NOT NULL,
  `EmpID` varchar(20) NOT NULL,
  `LeaveStatus` varchar(20) NOT NULL,
  PRIMARY KEY (`LeaveID`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `leavetbl`
--

INSERT INTO `leavetbl` (`LeaveID`, `LeaveType`, `StartDate`, `EndDate`, `Reason`, `EmpID`, `LeaveStatus`) VALUES
(1, 'Anual Leave', '2021-11-02', '2021-11-03', 'ss', '', 'Rejected'),
(2, 'Casual Leave', '2021-11-17', '2021-11-03', 'ssdd', '', 'Rejected'),
(3, 'Casual Leave', '2021-11-17', '2021-11-24', 'ssddee', '', 'Rejected'),
(4, 'Casual Leave', '2021-11-15', '2021-12-11', 'Adf', '', 'Rejected'),
(5, 'Casual Leave', '2021-11-15', '2021-12-11', 'Adf', '', 'Rejected'),
(6, 'Anual Leave', '2021-12-01', '2021-12-31', 'Adfjjj', '', 'Rejected'),
(7, 'Anual Leave', '2021-12-01', '2021-12-31', 'Adfjjj', '', 'Rejected'),
(8, 'Anual Leave', '2021-11-11', '2021-11-17', 'dd', 'ddd', ''),
(9, 'Anual Leave', '2021-11-17', '2021-11-26', ' cccc', 'ccc', 'Approved'),
(10, 'Anual Leave', '2021-11-04', '2021-11-04', 'dd', 'dd', 'Approved'),
(11, 'Anual Leave', '2021-11-04', '2021-11-11', 'vvv', 'vvv', 'Rejected'),
(12, 'Anual Leave', '2021-11-02', '2021-11-02', 'ddd', 'dd', 'Approved'),
(13, 'Anual Leave', '2021-11-10', '2021-11-03', '', '', 'Rejected'),
(14, 'Anual Leave', '2021-11-11', '2021-11-03', 'sddd', 'dd', 'Pending'),
(15, 'Anual Leave', '2021-11-19', '2021-12-01', 'dd', '', 'Pending');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
