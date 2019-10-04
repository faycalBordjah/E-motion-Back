-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 19 sep. 2019 à 09:58
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

-- SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
-- SET AUTOCOMMIT = 0;
-- START TRANSACTION;
-- SET time_zone = "+00:00";


-- /*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
-- /*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
-- /*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
-- /*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `e-motion`
--

--
-- Déchargement des données de la table `facture`
--

-- INSERT INTO `facture` (`id`, `idLocation`, `price`, `duration`, `startKilometer`, `endKilometer`) VALUES
-- (1, 1, 200, 48, 1000, 1042);

--
-- Déchargement des données de la table `location`
--

-- INSERT INTO `location` (`id`, `startDate`, `endDate`, `startHour`, `endHour`, `idUser`, `idVehicule`, `state`) VALUES
-- (1, '2019-09-02', '2019-09-04', '12:00:00', '17:00:00', 4, 4, ''),
-- (2, '2019-09-22', '2019-09-27', '10:00:00', '18:00:00', 5, 3, '');

--
-- Déchargement des données de la table `user`
--

-- INSERT INTO user (id, city, country,number,state,street,zip, birth_day, creation_date, first_name, last_name,mail,modification_date,password,permit_num,phone) VALUES
-- (1,'paris', 'france', 1, 15, 'boulevard dAngular', 'develoville', '2016-08-25 01:23:46.0', '2016-08-25 01:23:46.0', 'Alves.Kevin@gmail.com', 'kevin.alves', 'admin@local.com',
--  '2016-08-25 01:23:46.0','dddd',333,"75000");
-- INSERT IGNORE INTO roles(name) VALUES('ROLE_USER');
-- INSERT IGNORE INTO roles(name) VALUES('ROLE_ADMIN');
--
-- Déchargement des données de la table `vehicle`
--

-- INSERT INTO `vehicle` (`id`, `model`, `brand`, `type`, `category`, `color`, `serial_number`, `registering`, `available`, `purchase_date`, `purchase_price`, `place_number`, `kilometers`, `state`) VALUES
-- (1, 'Zoe', 'renault', 'voiture', 'citadine', 'bleu', 214568, 'FGT789TGD', 0, '2017-08-17', 3150, 4, 1000, 'Rien'),
-- (2, 'Zoe', 'renault', 'voiture', 'citadine', 'grise', 4531, '789CQZ456', 0, '2018-07-31', 3250, 4, 2180, 'Rien'),
-- (3, 'I-pace', 'Jaguar', 'voiture', 'berline', 'grise', 1548957, 'XYZ789IOP', 1, '2018-04-02', 5890, 5, 5108, 'Rien'),
-- (4, 'Tesla', 'Tesla', 'voiture', 'berline', 'noir metalisé', 789456, 'TES123LAS', 1, '2018-12-25', 8515, 5, 7541, 'Très bon état'),
-- (5, 'vespa', 'piaggio', 'scooter', 'aucun', 'rouge', 789645, 'VES789PAS', 0, '2019-04-09', 5740, 1, 650, 'Neuf'),
-- (6, 'vespa2', 'piaggio2', 'scooter2', 'aucun', 'rouge', 789645, 'VES789PAS', 0, '2019-04-09', 5740, 1, 650, 'Bris , Rayures , bosses');
-- COMMIT;


-- /*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
--  /*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
-- /*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
