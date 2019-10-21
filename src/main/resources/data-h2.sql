INSERT  INTO roles(role_name, description) VALUES('ADMIN_ROLE','Administration');
INSERT  INTO roles(role_name,description) VALUES('USER_ROLE','Custom user');


INSERT INTO users (id, first_name, last_name, mail,  creation_date,modification_date,password,permit_num,phone,birth_day,
                   city,country,number,state,street,zip) VALUES
(1,  'emotion_admin', 'local','admin@local.com','2019-10-08 21:37:00.996000000','2019-10-08 21:37:00.996000000',
 '$2a$10$98wmQ9r7xEMl2y.fiDKleeQmMA3xThH1q64GTytcH14xDf.gO4VsW',309090909,0768686868,'2019-10-08 21:37:00.996000000','paris','france',12,
 'paris', 'rue claude til', 75012);

-- Initialize the admin user role

INSERT INTO user_roles (user_id, role_id) VALUES (1,1);

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
type) VALUES (1,false,'tesla','moto','bleu',3434,'teslaX1',5,'2019-10-08 21:37:00.996000000',345,'',2323,'','');
