-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 19 sep. 2019 à 09:50
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `e-motion`
--

-- --------------------------------------------------------

--
-- Structure de la table `facture`
--

DROP TABLE IF EXISTS `facture`;
CREATE TABLE IF NOT EXISTS `facture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idLocation` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `duration` int(11) NOT NULL,
  `startKilometer` int(11) NOT NULL,
  `endKilometer` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idLocation` (`idLocation`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date NOT NULL,
  `endDate` date NOT NULL,
  `startHour` time NOT NULL,
  `endHour` time NOT NULL,
  `idUser` int(11) NOT NULL,
  `idVehicule` int(11) NOT NULL,
  `state` varchar(10) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idUser` (`idUser`),
  KEY `idVehicule` (`idVehicule`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `firstname` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `bearth` date NOT NULL,
  `num` int(11) NOT NULL,
  `street` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `town` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `zipCode` int(11) NOT NULL,
  `phone` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `mail` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `password` varchar(15) COLLATE latin1_general_ci NOT NULL,
  `role` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `permit` varchar(35) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `brand` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `type` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `category` varchar(15) COLLATE latin1_general_ci NOT NULL,
  `color` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `serialNumber` int(11) NOT NULL,
  `registering` varchar(10) COLLATE latin1_general_ci NOT NULL COMMENT 'immatriculation',
  `available` tinyint(1) NOT NULL,
  `purchaseDate` date NOT NULL,
  `purchasePrice` int(11) NOT NULL,
  `placeNumber` int(11) NOT NULL,
  `kilometers` int(11) NOT NULL,
  `state` text COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `facture`
--
ALTER TABLE `facture`
  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`idLocation`) REFERENCES `location` (`id`);

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `location_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `location_ibfk_2` FOREIGN KEY (`idVehicule`) REFERENCES `vehicle` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
