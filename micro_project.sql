-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2023 at 03:48 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `micro_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `acc_number` varchar(20) NOT NULL,
  `acc_type` varchar(20) NOT NULL,
  `acc_name` varchar(40) NOT NULL,
  `balance` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `user_id`, `acc_number`, `acc_type`, `acc_name`, `balance`) VALUES
(1, 1, '1234512345', 'Kredit', 'Visa', NULL),
(2, 1, '123123123', 'Debit', 'BCA Xpresi', NULL),
(3, 1, '1212121212', 'VA', 'Lending', 1005000),
(4, 2, '1234567890', 'Kredit', 'MasterCard', NULL),
(5, 2, '11112222333', 'VA', 'Lending', 25000);

-- --------------------------------------------------------

--
-- Table structure for table `lending_product`
--

CREATE TABLE `lending_product` (
  `id` int(11) NOT NULL,
  `user_id_lender` int(11) DEFAULT NULL,
  `user_id_borrower` int(11) DEFAULT NULL,
  `account_lender` varchar(50) DEFAULT NULL,
  `account_borrower` varchar(50) DEFAULT NULL,
  `interest` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `total_reimbursement` int(11) DEFAULT NULL,
  `due_time` date DEFAULT NULL,
  `reference` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lending_product`
--

INSERT INTO `lending_product` (`id`, `user_id_lender`, `user_id_borrower`, `account_lender`, `account_borrower`, `interest`, `amount`, `total_reimbursement`, `due_time`, `reference`, `status`) VALUES
(7, 1, 2, '1212121212', '11112222333', 10, 50000, 55000, '2023-06-08', '381300b3-ec57-4819-b548-e528a2381d31', 'PAIDOFF'),
(8, 1, 2, '1212121212', '11112222333', 10, 50000, 55000, '2023-06-08', '598df619-123a-4483-8ab1-6ca09d3ec6e1', 'PAIDOFF');

-- --------------------------------------------------------

--
-- Table structure for table `travel_history`
--

CREATE TABLE `travel_history` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(100) NOT NULL,
  `account_number` varchar(20) NOT NULL,
  `package_name` varchar(40) NOT NULL,
  `count` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `travel_history`
--

INSERT INTO `travel_history` (`id`, `name`, `email`, `account_number`, `package_name`, `count`, `total`, `status`) VALUES
(1, 'Hugo', 'hugo@test.com', '123123123', 'Jalan jalan jogja', 2, 600000, 'SUCCESS'),
(2, 'Hugo', 'hugo@test.com', '123123123', 'Jalan jalan jogja', 2, 600000, 'SUCCESS'),
(3, 'Hugo', 'hugo@test.com', '123123123', 'Jalan jalan jogja', 1, 300000, 'SUCCESS');

-- --------------------------------------------------------

--
-- Table structure for table `travel_package`
--

CREATE TABLE `travel_package` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `price` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `travel_package`
--

INSERT INTO `travel_package` (`id`, `name`, `price`) VALUES
(1, 'Jalan jalan jogja', 300000),
(2, 'jalan jalan jakarta', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(100) NOT NULL,
  `pin` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `pin`) VALUES
(1, 'Hugo', 'hugo@test.com', '123456'),
(2, 'candra', 'candra@sad.com', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `lending_product`
--
ALTER TABLE `lending_product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `travel_history`
--
ALTER TABLE `travel_history`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `travel_package`
--
ALTER TABLE `travel_package`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `lending_product`
--
ALTER TABLE `lending_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `travel_history`
--
ALTER TABLE `travel_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `travel_package`
--
ALTER TABLE `travel_package`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
