-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 14, 2020 at 07:53 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `zavrsniprojekat_februar2019`
--

-- --------------------------------------------------------

--
-- Table structure for table `aerodrom`
--

CREATE TABLE `aerodrom` (
  `id_aerodrom` int(11) NOT NULL,
  `naziv` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aerodrom`
--

INSERT INTO `aerodrom` (`id_aerodrom`, `naziv`) VALUES
(7, 'fgv'),
(8, 'sd'),
(9, 'ddd'),
(10, 'nikola tesla');

-- --------------------------------------------------------

--
-- Table structure for table `aviokomapnije`
--

CREATE TABLE `aviokomapnije` (
  `id_avio_kompanije` int(11) NOT NULL,
  `naziv` varchar(15) NOT NULL,
  `id_aerodrom` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `aviokomapnije`
--

INSERT INTO `aviokomapnije` (`id_avio_kompanije`, `naziv`, `id_aerodrom`) VALUES
(1, '12', 8),
(3, '1', 7),
(4, 'dd', 9),
(5, 'dd', 9),
(6, 'ae', 8),
(7, 'drf', 7),
(8, 'er srbija', 10),
(9, 'ddd', 7);

-- --------------------------------------------------------

--
-- Table structure for table `kupac`
--

CREATE TABLE `kupac` (
  `id` int(11) NOT NULL,
  `ime` varchar(12) NOT NULL,
  `prezime` varchar(12) NOT NULL,
  `email` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `let`
--

CREATE TABLE `let` (
  `id_let` int(11) NOT NULL,
  `mesto_polaska` varchar(15) NOT NULL,
  `mesto_dolaska` varchar(15) NOT NULL,
  `id_aviokomanije` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `let`
--

INSERT INTO `let` (`id_let`, `mesto_polaska`, `mesto_dolaska`, `id_aviokomanije`) VALUES
(1, 'dd', 'gg', 5),
(2, 'beograd', 'tivat', 8),
(3, 'Beograd', 'Bec', 5);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `id_rezervacija` int(11) NOT NULL,
  `broj_karata` int(11) NOT NULL,
  `id_usera` int(11) NOT NULL,
  `id_termin` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`id_rezervacija`, `broj_karata`, `id_usera`, `id_termin`) VALUES
(1, 4, 5, 1),
(2, 6, 5, 1),
(4, 12, 5, 1),
(5, 12, 5, 1),
(6, 12, 5, 1),
(7, 8, 5, 1),
(8, 10, 5, 1),
(9, 10, 5, 1),
(10, 10, 5, 1),
(11, 1, 5, 3),
(12, 23, 5, 4),
(13, 234, 5, 4),
(14, 1, 5, 4);

-- --------------------------------------------------------

--
-- Table structure for table `termin`
--

CREATE TABLE `termin` (
  `id_termin` int(11) NOT NULL,
  `datum` date NOT NULL,
  `vreme` time NOT NULL,
  `id_leta` int(11) NOT NULL,
  `ukupan_broj_karata` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `termin`
--

INSERT INTO `termin` (`id_termin`, `datum`, `vreme`, `id_leta`, `ukupan_broj_karata`) VALUES
(1, '2019-06-21', '03:02:00', 2, 134),
(2, '2019-06-19', '03:00:00', 2, 130),
(3, '2020-02-14', '03:02:00', 2, 1),
(4, '2020-02-15', '02:10:00', 3, 250);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_usera` int(11) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_usera`, `username`, `password`, `status`) VALUES
(1, 'dejan', 'dejan', 'admin'),
(2, 'ff', 'ff', '0'),
(3, 'dejan', 'dejan', '0'),
(4, 'marko', 'marko', '0'),
(5, 'danilo', 'danilo', 'user'),
(6, '', '', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aerodrom`
--
ALTER TABLE `aerodrom`
  ADD PRIMARY KEY (`id_aerodrom`);

--
-- Indexes for table `aviokomapnije`
--
ALTER TABLE `aviokomapnije`
  ADD PRIMARY KEY (`id_avio_kompanije`),
  ADD KEY `id_aerodrom` (`id_aerodrom`);

--
-- Indexes for table `kupac`
--
ALTER TABLE `kupac`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `let`
--
ALTER TABLE `let`
  ADD PRIMARY KEY (`id_let`),
  ADD KEY `id_aviokomanije` (`id_aviokomanije`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`id_rezervacija`),
  ADD KEY `id_usera` (`id_usera`),
  ADD KEY `id_termin` (`id_termin`);

--
-- Indexes for table `termin`
--
ALTER TABLE `termin`
  ADD PRIMARY KEY (`id_termin`),
  ADD KEY `id_leta` (`id_leta`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_usera`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `aerodrom`
--
ALTER TABLE `aerodrom`
  MODIFY `id_aerodrom` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `aviokomapnije`
--
ALTER TABLE `aviokomapnije`
  MODIFY `id_avio_kompanije` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `kupac`
--
ALTER TABLE `kupac`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `let`
--
ALTER TABLE `let`
  MODIFY `id_let` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
  MODIFY `id_rezervacija` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `termin`
--
ALTER TABLE `termin`
  MODIFY `id_termin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_usera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `aviokomapnije`
--
ALTER TABLE `aviokomapnije`
  ADD CONSTRAINT `aviokomapnije_ibfk_1` FOREIGN KEY (`id_aerodrom`) REFERENCES `aerodrom` (`id_aerodrom`);

--
-- Constraints for table `let`
--
ALTER TABLE `let`
  ADD CONSTRAINT `let_ibfk_1` FOREIGN KEY (`id_aviokomanije`) REFERENCES `aviokomapnije` (`id_avio_kompanije`);

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`id_usera`) REFERENCES `user` (`id_usera`),
  ADD CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`id_termin`) REFERENCES `termin` (`id_termin`);

--
-- Constraints for table `termin`
--
ALTER TABLE `termin`
  ADD CONSTRAINT `termin_ibfk_1` FOREIGN KEY (`id_leta`) REFERENCES `let` (`id_let`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
