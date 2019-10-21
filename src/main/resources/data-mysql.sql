
INSERT INTO roles(role_name, description)
VALUES ('ADMIN_ROLE', 'Administration');

INSERT INTO roles(role_name, description)
VALUES ('USER_ROLE', 'Custom user');

INSERT INTO address(city,
                    country,
                    number,
                    state,
                    street,
                    zip)
VALUES ('paris', 'france', 12, 'ile de france', 'claude tilliers', 75012);

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

-- Initialize the admin user role

INSERT INTO user_roles (user_id, role_id)
VALUES (1, 1);