------- CREATE ROLES
DROP TABLE IF EXISTS roles;
CREATE TABLE roles
(
    id   bigint  NOT NULL AUTO_INCREMENT,
    role_name varchar(60) NOT NULL,
    description varchar (255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY uk_roles_name (role_name)
);

DROP TABLE IF EXISTS address;
create table address
(
    id      bigint auto_increment
        primary key,
    city    varchar(255) not null,
    country varchar(255) not null,
    number  int          not null,
    state   varchar(255) not null,
    street  varchar(255) not null,
    zip     varchar(255) not null
);

------ CREATE USERS
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
    address_id        bigint not null,
    UNIQUE key uk_mail (mail),
    CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES address (id)
);


------ CREATE JOINT TABLE ROLES AND USERS

DROP TABLE IF EXISTS user_roles;
create table user_roles
(
    user_id bigint not null,
    role_id bigint not null,
    CONSTRAINT fk_user_roles_role_id    foreign key (role_id) references roles (id),
    CONSTRAINT fk_user_roles_user_id   foreign key (user_id) references users (id)
);
---- CREATE TABLE vehicles

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

--- CREATE TABLE Location

DROP TABLE IF EXISTS location;
CREATE TABLE location
  (  id         bigint auto_increment
        primary key,
    end_date   date   not null,
    end_time   time   not null,
    star_date  date   not null,
    start_time time   not null,
    status     varchar(255) not null,
    user_id    bigint not null,
    vehicle_id bigint not null,
    CONSTRAINT fk_user_id foreign key (user_id) references users (id),
    CONSTRAINT fk_vehicle_id foreign key (vehicle_id) references vehicles (id)
);


