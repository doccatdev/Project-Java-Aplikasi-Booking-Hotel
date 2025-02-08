-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2023 at 03:20 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `akhir_oop`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_multiuser`
--

CREATE TABLE `tbl_multiuser` (
  `id` int(50) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama lengkap` varchar(255) NOT NULL,
  `level` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_multiuser`
--

INSERT INTO `tbl_multiuser` (`id`, `username`, `password`, `nama lengkap`, `level`) VALUES
(1, 'yusuf', '123', 'Muhamad Yusuf Hidayat', 'Admin'),
(2, 'user', '123', 'Muhamad Yusuf Hidayat', 'User');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_tamu`
--

CREATE TABLE `tbl_tamu` (
  `id` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `jenis_kelamin` varchar(50) NOT NULL,
  `kartu_kredit` varchar(50) NOT NULL,
  `nomor_telepon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_tamu`
--

INSERT INTO `tbl_tamu` (`id`, `nama`, `alamat`, `jenis_kelamin`, `kartu_kredit`, `nomor_telepon`) VALUES
(8, 'Yusuf', 'Antapani', 'Laki - laki', '12414122', '081212141');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_transaksi`
--

CREATE TABLE `tbl_transaksi` (
  `kode_pemesanan` varchar(225) NOT NULL,
  `pemesan` varchar(10) DEFAULT NULL,
  `nomor_kamar` int(11) DEFAULT NULL,
  `check_in` datetime DEFAULT NULL,
  `check_out` datetime DEFAULT NULL,
  `pembayaran` varchar(50) DEFAULT NULL,
  `dibayarkan` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_transaksi`
--

INSERT INTO `tbl_transaksi` (`kode_pemesanan`, `pemesan`, `nomor_kamar`, `check_in`, `check_out`, `pembayaran`, `dibayarkan`) VALUES
('11', 'P0001', 11, '2023-06-06 06:06:06', '2023-06-06 05:05:05', 'Cash', '0.0'),
('12', 'P0002', 11, '2023-06-06 06:06:06', '2023-06-12 05:05:05', 'Cash', '500000.0'),
('13', 'P0003', 121, '2023-06-06 05:05:05', '2023-06-12 05:05:05', 'Cash', '600000.0');

--
-- Triggers `tbl_transaksi`
--
DELIMITER $$
CREATE TRIGGER `tr_auto_increment_pemesan` BEFORE INSERT ON `tbl_transaksi` FOR EACH ROW BEGIN
  SET NEW.pemesan = CONCAT('P', LPAD((SELECT COUNT(*) + 1 FROM tbl_transaksi), 4, '0'));
END
$$
DELIMITER ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_multiuser`
--
ALTER TABLE `tbl_multiuser`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `tbl_tamu`
--
ALTER TABLE `tbl_tamu`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_transaksi`
--
ALTER TABLE `tbl_transaksi`
  ADD PRIMARY KEY (`kode_pemesanan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_multiuser`
--
ALTER TABLE `tbl_multiuser`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tbl_tamu`
--
ALTER TABLE `tbl_tamu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
