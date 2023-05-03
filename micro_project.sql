-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2023 at 04:57 PM
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
  `balance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `user_id`, `acc_number`, `acc_type`, `acc_name`, `balance`) VALUES
(1, 1, '123123123', 'Kredit', 'Hugo ', 0);

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
(1, 1, 1, '123123', '12345', 10, 1000000, 1100000, '2023-04-25', 'A123BC', 'PAIDOFF'),
(2, NULL, 1, NULL, '123123123', 10, 1000000, 10000000, NULL, 'e736db01-7341-475b-b60c-799497b21172', 'REQUESTED'),
(3, NULL, 1, NULL, '123123123', 10, 1000000, 1100000, NULL, '3b6135d6-eaba-455f-acd0-0c416960d972', 'REQUESTED');

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
(2, 'Hugo', 'hugo@test.com', '123123123', 'Jalan jalan jogja', 2, 600000, 'SUCCESS');

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
  `pin` varchar(10) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `pin`, `role`) VALUES
(1, 'Hugo', 'hugo@test.com', '123456', '');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `lending_product`
--
ALTER TABLE `lending_product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `travel_history`
--
ALTER TABLE `travel_history`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `travel_package`
--
ALTER TABLE `travel_package`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
