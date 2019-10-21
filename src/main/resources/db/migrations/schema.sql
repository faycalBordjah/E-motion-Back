
DROP TABLE IF EXISTS `roles`;
CREATE TABLE roles
(
    id   int(20)  NOT NULL AUTO_INCREMENT,
    name varchar(60) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_roles_name (name)
)
-- ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------
-- ----------------------------------------------------------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location`
(
    id                                        NOT NULL AUTO_INCREMENT,
    start_date  date                                  NOT NULL,
    end_date    date                                  NOT NULL,
    start_time  time                                  NOT NULL,
    end_time    time                                  NOT NULL,
    user_id    bigint                                 NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (user_id) REFERENCES users (id)
)

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


---
--
--
--
-- create table roles
(
    id          bigint auto_increment
        primary key,
    description varchar(255) not null,
    role_name   varchar(255) not null,
    constraint UK_nb4h0p6txrmfc0xbrd1kglp9t
        unique (role_name)
);

create table users
(
    id                bigint auto_increment
        primary key,
    city              varchar(255) null,
    country           varchar(255) null,
    number            int          null,
    state             varchar(255) null,
    street            varchar(255) null,
    zip               varchar(255) null,
    birth_day         datetime(6)  not null,
    creation_date     datetime(6)  null,
    first_name        varchar(255) not null,
    last_name         varchar(255) not null,
    mail              varchar(255) not null,
    modification_date datetime(6)  null,
    password          varchar(255) not null,
    permit_num        int          not null,
    phone             varchar(255) not null,
    constraint UKjhck7kjdogc7yia7qamc89ypv
        unique (mail)
);



create table user_roles
(
    user_id bigint not null,
    role_id bigint not null,
    constraint FKh8ciramu9cc9q3qcqiv4ue8a6
        foreign key (role_id) references roles (id),
    constraint FKhfh9dx7w3ubf1co1vdev94g3f
        foreign key (user_id) references users (id)
);

create table vehicles
(
    id             bigint auto_increment
        primary key,
    available      bit          not null,
    brand          varchar(255) not null,
    category       varchar(255) not null,
    color          varchar(255) not null,
    kilometers     int          not null,
    model          varchar(255) not null,
    place_number   int          not null,
    purchase_date  datetime(6)  not null,
    purchase_price double       not null,
    registering    varchar(255) not null,
    serial_number  int          not null,
    state          varchar(255) not null,
    type           varchar(255) not null
);

