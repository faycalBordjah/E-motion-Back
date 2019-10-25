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

INSERT INTO users (
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
VALUES ( 'emotion_admin', 'local', 'admin@local.com', '2019-10-08',
        '2019-10-08 21:37:00.996000000',
        '$2a$10$98wmQ9r7xEMl2y.fiDKleeQmMA3xThH1q64GTytcH14xDf.gO4VsW', 309090909, 0768686868,
        '2019-10-08 21:37:00.996000000', 1);

INSERT INTO users (
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
VALUES ( 'User', 'User', 'user@local.com', '2019-10-21',
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
VALUES (1, false, 'tesla', 'moto', 'bleu', 3434, 'teslaX1', 5, '2019-10-08 21:37:00.996000000', 345, '', 2323, 'raillure et accident en avant ', 'SCOOTER');

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
VALUES (2, true, 'renault', 'citadine', 'bleu', 3434, 'Zoe', 5, '2019-10-20 21:37:00.996000000', 400, '', 4242, 'tout neuf', 'CAR');

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
VALUES (3, true, 'mercedes', 'berline', 'gris', 5252, 'EQ', 5, '2019-10-20 21:37:00.996000000', 450, 'CQ12390', 6666, 'tout neuf', 'SCOOTER');

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
VALUES (4, true, 'Lexus', 'SUV', 'beige', 7575, 'UX300', 5, '2019-10-20 21:37:00.996000000', 700, 'WQ12390', 7575, 'ancien avec petites taches', 'CAR');

-- Initialize locations

INSERT INTO location(
                     start_date,
                     end_date,
                     start_time,
                     end_time,
                     status,
                     user_id,
                     vehicle_id)
VALUES ('2019-10-20','2019-10-20','21:37:00.996000000','21:37:00.996000000','IN_PROGRESS',2,1);

INSERT INTO location(
                     start_date,
                     end_date,
                     start_time,
                     end_time,
                     status,
                     user_id,
                     vehicle_id)
VALUES ('2019-10-20','2019-10-20','21:37:00.996000000','21:37:00.996000000','CANCELED',2,2);

INSERT INTO location(
                     start_date,
                     end_date,
                     start_time,
                     end_time,
                     status,
                     user_id,
                     vehicle_id)
VALUES ('2019-10-20','2019-10-30','21:37:00.996000000','21:37:00.996000000','DONE',2,3);

INSERT INTO location(
                     start_date,
                     end_date,
                     start_time,
                     end_time,
                     status,
                     user_id,
                     vehicle_id)
VALUES ('2019-11-05','2019-11-20','21:37:00.996000000','21:37:00.996000000','IN_PROGRESS',2,4);

