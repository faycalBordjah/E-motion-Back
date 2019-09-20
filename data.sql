-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 20 sep. 2019 à 13:05
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

--
-- Déchargement des données de la table `facture`
--

INSERT INTO `facture` (`id`, `idLocation`, `price`, `duration`, `startKilometer`, `endKilometer`) VALUES
(1, 1, 200, 48, 1000, 1042);

--
-- Déchargement des données de la table `location`
--

INSERT INTO `location` (`id`, `startDate`, `endDate`, `startHour`, `endHour`, `idUser`, `idVehicule`, `state`) VALUES
(1, '2019-09-02', '2019-09-04', '12:00:00', '17:00:00', 4, 4, ''),
(2, '2019-09-22', '2019-09-27', '10:00:00', '18:00:00', 5, 3, '');

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `lastname`, `firstname`, `bearth`, `num`, `street`, `town`, `zipCode`, `phone`, `mail`, `password`, `role`, `permit`) VALUES
(4, 'Alves', 'Kevin', '1990-10-05', 15, 'boulevard d\'Angular', 'develoville', 75750, '0154789532', 'Alves.Kevin@gmail.com', 'kevin.alves', 'admin', 'rgthdytfug987645312'),
(5, 'Stupnicki', 'adrien', '1996-06-16', 20, 'place du code', 'develoville', 75750, '0123654789', 'adrien.stupnicki@gmail.com', 'adrien', 'admin', 'edrfgty1456'),
(6, 'Coulibaly', 'Ibrahim', '2000-05-27', 45, 'rue de la maquette', 'Develoville', 75750, '0198745612', 'ibrahim.coubaly@gmail.com', 'azerty', 'user', 'esrdtrfg495'),
(7, 'Borjah', 'Faycal', '0200-10-25', 39, 'Rue de projet', 'Develoville', 75750, '0123654544', 'borjah.faycal@gmail.com', 'azerty', 'user', 'esfdf7416');

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`id`, `model`, `brand`, `type`, `category`, `color`, `serialNumber`, `registering`, `available`, `purchaseDate`, `purchasePrice`, `placeNumber`, `kilometers`, `state`) VALUES
(1, 'Zoe', 'renault', 'voiture', 'citadine', 'bleu', 214568, 'FGT789TGD', 0, '2017-08-17', 3150, 4, 1000, 'Rien'),
(2, 'Zoe', 'renault', 'voiture', 'citadine', 'grise', 4531, '789CQZ456', 0, '2018-07-31', 3250, 4, 2180, 'rien'),
(3, 'I-pace', 'Jaguar', 'voiture', 'berline', 'grise', 1548957, 'XYZ789IOP', 1, '2018-04-02', 5890, 5, 5108, 'rien'),
(4, 'Tesla', 'Tesla', 'voiture', 'berline', 'noir metalisé', 789456, 'TES123LAS', 1, '2018-12-25', 8515, 5, 7541, 'Très bon état'),
(5, 'vespa', 'piaggio', 'scooter', 'aucun', 'rouge', 789645, 'VES789PAS', 0, '2019-04-09', 5740, 1, 650, 'Neuf');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
