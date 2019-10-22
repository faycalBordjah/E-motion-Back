-- Initialize the admin/user role
INSERT INTO roles(role_name, description)
VALUES ('ADMIN_ROLE', 'Administration');

INSERT INTO roles(role_name, description)
VALUES ('USER_ROLE', 'Custom user');

-- Initialize the User's Address

INSERT INTO address(city,
                    country,
                    number,
                    state,
                    street,
                    zip)
VALUES ('paris', 'france', 12, 'ile de france', 'claude tilliers', 75012);
INSERT INTO address(city,
                    country,
                    number,
                    state,
                    street,
                    zip)
VALUES ('paris', 'france', 5, 'ile de france', ' Marel Dupont', 75012);

-- Initialize the user

INSERT INTO users (id,
                   first_name,
                   last_name,
                   mail,
                   creation_date,
                   modification_date,
                   password,
                   permit_num,
                   phone,
                   birth_day,
                   address_id)
VALUES (1, 'emotion_admin', 'local', 'admin@local.com', '2019-10-08 21:37:00.996000000',
        '2019-10-08 21:37:00.996000000',
        '$2a$10$98wmQ9r7xEMl2y.fiDKleeQmMA3xThH1q64GTytcH14xDf.gO4VsW', 309090909, 0768686868,
        '2019-10-08 21:37:00.996000000', 1);

INSERT INTO users (id,
                   first_name,
                   last_name,
                   mail,
                   creation_date,
                   modification_date,
                   password,
                   permit_num,
                   phone,
                   birth_day,
                   address_id)
VALUES (1, 'User', 'User', 'user@local.com', '2019-10-21 21:37:00.996000000',
        '2019-10-21 21:37:00.996000000',
        '$2a$10$98wmQ9r7xEMl2y.fiDKleeQmMA3xThH1q64GTytcH14xDf.gO4VsW', 309090909, 0668686869,
        '2019-10-08 21:37:00.996000000', 2);

-- Give the admin/user role

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id)
VALUES (2, 2);

-- Initialize the vehicle

INSERT INTO vehicles(id, available,
                     brand,
                     category,
                     color,
                     kilometers,
                     model,
                     place_number,
                     purchase_date,
                     purchase_price,
                     registering,
                     serial_number,
                     state,
                     type)
VALUES (1, false, 'tesla', 'moto', 'bleu', 3434, 'teslaX1', 5, '2019-10-08 21:37:00.996000000', 345, '', 2323, '', '');

INSERT INTO vehicles(id, available,
                     brand,
                     category,
                     color,
                     kilometers,
                     model,
                     place_number,
                     purchase_date,
                     purchase_price,
                     registering,
                     serial_number,
                     state,
                     type)
VALUES (2, true, 'renault', 'citadine', 'bleu', 3434, 'Zoe', 5, '2019-10-20 21:37:00.996000000', 400, '', 4242, 'Paris', '');

INSERT INTO vehicles(id, available,
                     brand,
                     category,
                     color,
                     kilometers,
                     model,
                     place_number,
                     purchase_date,
                     purchase_price,
                     registering,
                     serial_number,
                     state,
                     type)
VALUES (3, true, 'mercedes', 'berline', 'gris', 5252, 'EQ', 5, '2019-10-20 21:37:00.996000000', 450, '', 6666, 'Lyon', '');

INSERT INTO vehicles(id, available,
                     brand,
                     category,
                     color,
                     kilometers,
                     model,
                     place_number,
                     purchase_date,
                     purchase_price,
                     registering,
                     serial_number,
                     state,
                     type)
VALUES (4, true, 'Lexus', 'SUV', 'beige', 7575, 'UX300', 5, '2019-10-20 21:37:00.996000000', 700, '', 7575, 'Paris', '');

-- Initialize locations

INSERT INTO Location(id,
                     starDate,
                     endDate,
                     startTime,
                     endTime,
                     user,
                     vehicle)
VALUES (1,'2019-10-20','2019-10-20','21:37:00.996000000','21:37:00.996000000',2,3);

INSERT INTO Location(id,
                     starDate,
                     endDate,
                     startTime,
                     endTime,
                     user,
                     vehicle)
VALUES (1,'2019-10-20','2019-10-20','21:37:00.996000000','21:37:00.996000000',2,3);

INSERT INTO Location(id,
                     starDate,
                     endDate,
                     startTime,
                     endTime,
                     user,
                     vehicle)
VALUES (2,'2019-10-20','2019-10-30','21:37:00.996000000','21:37:00.996000000',3,4);

INSERT INTO Location(id,
                     starDate,
                     endDate,
                     startTime,
                     endTime,
                     user,
                     vehicle)
VALUES (3,'2019-11-05','2019-11-20','21:37:00.996000000','21:37:00.996000000',3,1);

INSERT INTO Location(id,
                     starDate,
                     endDate,
                     startTime,
                     endTime,
                     user,
                     vehicle)
VALUES (1,'2019-11-25','2019-11-30','21:37:00.996000000','21:37:00.996000000',2,3);
