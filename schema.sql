-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 18 sep. 2019 à 09:45
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
  `prix` int(11) NOT NULL,
  `duree` int(11) NOT NULL,
  `kilometreDebut` int(11) NOT NULL,
  `kilometrageFin` int(11) NOT NULL,
  `numFacture` int(11) NOT NULL,
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
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `heureDebut` time NOT NULL,
  `heureFin` time NOT NULL,
  `idUser` int(11) NOT NULL,
  `idVehicule` int(11) NOT NULL,
  `etat` enum('En cours','EN ATTENTE','TERMINER','ANNULER') COLLATE latin1_general_ci NOT NULL,
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
  `nom` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `prenom` varchar(30) COLLATE latin1_general_ci NOT NULL,
  `dateNaissance` date NOT NULL,
  `numRue` int(11) NOT NULL,
  `nomRue` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `ville` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `codePosta` int(11) NOT NULL,
  `telephone` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `mail` varchar(50) COLLATE latin1_general_ci NOT NULL,
  `password` varchar(15) COLLATE latin1_general_ci NOT NULL,
  `numPermis` varchar(35) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;


-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

DROP TABLE IF EXISTS `vehicule`;
CREATE TABLE IF NOT EXISTS `vehicule` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `modele` varchar(25) COLLATE latin1_general_ci NOT NULL,
  `marque` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `type` enum('voiture','scooter') COLLATE latin1_general_ci NOT NULL,
  `couleur` varchar(20) COLLATE latin1_general_ci NOT NULL,
  `numSerie` int(11) NOT NULL,
  `immatriculation` varchar(10) COLLATE latin1_general_ci NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  `dateAchat` date NOT NULL,
  `nbPlace` int(11) NOT NULL,
  `prixAchat` int(11) NOT NULL,
  `kilometrage` int(11) NOT NULL,
  `etat` text COLLATE latin1_general_ci NOT NULL,
  `categorie` enum('AUCUN','BERLINE','CROSSOVER','COUPE','UTILITAIRE','FAMILIALE') COLLATE latin1_general_ci NOT NULL,
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
  ADD CONSTRAINT `location_ibfk_2` FOREIGN KEY (`idVehicule`) REFERENCES `vehicule` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
