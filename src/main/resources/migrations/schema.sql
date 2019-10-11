
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles`
(
    `id`   int(20)  NOT NULL AUTO_INCREMENT,
    `name` varchar(60) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_roles_name` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8;
-- ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location`
(
    `id`         int(11)                               NOT NULL AUTO_INCREMENT,
    `start_date`  date                                  NOT NULL,
    `end_date`    date                                  NOT NULL,
    `start_hour`  time                                  NOT NULL,
    `end_hour`    time                                  NOT NULL,
    `user_id`    int(11)                               NOT NULL,
    `vehicle_id` int(11)                               NOT NULL,
    `state`      varchar(10) COLLATE latin1_general_ci NOT NULL,
    PRIMARY KEY (`id`),
    KEY `user` (`user_id`),
    KEY `id_vehicle` (`vehicle_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users`
(
    `id`         int(11)                               NOT NULL AUTO_INCREMENT,
    `last_name`  varchar(30) COLLATE latin1_general_ci NOT NULL,
    `first_name` varchar(30) COLLATE latin1_general_ci NOT NULL,
    `birth`     date                                   NOT NULL,
    `num`        int(11)                               NOT NULL,
    `street`     varchar(50) COLLATE latin1_general_ci NOT NULL,
    `town`       varchar(50) COLLATE latin1_general_ci NOT NULL,
    `zipCode`    int(11)                               NOT NULL,
    `phone`      varchar(10) COLLATE latin1_general_ci NOT NULL,
    `mail`       varchar(50) COLLATE latin1_general_ci NOT NULL,
    `password`   varchar(15) COLLATE latin1_general_ci NOT NULL,
    `role`       varchar(10) COLLATE latin1_general_ci NOT NULL,
    `permit`     varchar(35) COLLATE latin1_general_ci NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `vehicle`
--

DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE IF NOT EXISTS `vehicles`
(
    `id`             int(11)                               NOT NULL AUTO_INCREMENT,
    `model`          varchar(25) COLLATE latin1_general_ci NOT NULL,
    `brand`          varchar(20) COLLATE latin1_general_ci NOT NULL,
    `type`           varchar(10) COLLATE latin1_general_ci NOT NULL,
    `category`       varchar(15) COLLATE latin1_general_ci NOT NULL,
    `color`          varchar(20) COLLATE latin1_general_ci NOT NULL,
    `serial_number`  int(11)                               NOT NULL,
    `registering`    varchar(10) COLLATE latin1_general_ci NOT NULL COMMENT 'immatriculation',
    `available`      tinyint(1)                            NOT NULL,
    `purchase_date`  date                                  NOT NULL,
    `purchase_price` int(11)                               NOT NULL,
    `place_number`   int(11)                               NOT NULL,
    `kilometers`     int(11)                               NOT NULL,
    `state`          text COLLATE latin1_general_ci        NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1
  COLLATE = latin1_general_ci;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `facture`
--
--  ALTER TABLE `facture`
--  ADD CONSTRAINT `facture_ibfk_1` FOREIGN KEY (`idLocation`) REFERENCES `location` (`id`);

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
    ADD CONSTRAINT `location_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
    ADD CONSTRAINT `location_ibfk_2` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`);
COMMIT;

CREATE TABLE `user_roles`
(
    `user_id` int(20) NOT NULL,
    `role_id` int(20) NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    KEY `fk_user_roles_role_id` (`role_id`),
    CONSTRAINT `fk_user_roles_role_id` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
    CONSTRAINT `fk_user_roles_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
