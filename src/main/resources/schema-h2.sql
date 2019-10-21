DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    id   bigint  NOT NULL AUTO_INCREMENT,
    role_name varchar(60) NOT NULL,
    description varchar (255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_roles_name (role_name)
);

DROP TABLE IF EXISTS users;
CREATE TABLE users
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
    UNIQUE key uk_mail (mail),
);

DROP TABLE IF EXISTS user_roles;
create table user_roles
(
    user_id bigint not null,
    role_id bigint not null,
    CONSTRAINT fk_user_roles_role_id    foreign key (role_id) references roles (id),
    CONSTRAINT fk_user_roles_user_id   foreign key (user_id) references users (id)
);

DROP TABLE IF EXISTS vehicles;
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