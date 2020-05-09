SET GLOBAL TIME_ZONE = '-06:00';

USE treat_tracker_test;

DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS incident;
DROP TABLE IF EXISTS resolution;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS user;


create table user
(
    id         int auto_increment primary key,
    first_name varchar(25) not null,
    last_name  varchar(25) not null,
    user_name  varchar(25) not null,
    email      varchar(50) not null,
    password   varchar(50) not null,
    constraint user_email_uindex unique (email),
    constraint user_user_name_uindex unique (user_name)
);

create table role
(
    id        int auto_increment
        primary key,
    user_name varchar(20) not null,
    role      varchar(20) not null,
    constraint role_user_name_uindex
        unique (user_name),
    constraint role_user_user_name_fk
        foreign key (user_name) references user (user_name)
            on update cascade on delete cascade
);

create table resolution
(
    id              int auto_increment primary key,
    user_id         int          not null,
    resolution_date datetime     not null,
    description     varchar(255) not null,
    constraint resolution_user_id_fk foreign key (user_id) references user (id) on update cascade on delete cascade
);

create table incident
(
    id            int auto_increment primary key,
    user_id       int          not null,
    incident_date datetime     not null,
    description   varchar(255) not null,
    resolution_id int,
    constraint incident_resolution_id_fk foreign key (resolution_id) references resolution (id) on update cascade on delete cascade,
    constraint incident_user_id_fk foreign key (user_id) references user (id) on update cascade on delete cascade
);


INSERT INTO treat_tracker_test.user (id, first_name, last_name, user_name, email, password) VALUES (1, 'Layla', 'Mcmanus', 'lmcmanus', 'lmcmanus@treattracker.com', 'password1');
INSERT INTO treat_tracker_test.user (id, first_name, last_name, user_name, email, password) VALUES (2, 'Faye', 'Odling', 'fodling', 'folding@treattracker.com', 'password2');
INSERT INTO treat_tracker_test.user (id, first_name, last_name, user_name, email, password) VALUES (3, 'Kerys', 'Yates', 'kyates', 'kyates@treattracker.com', 'password3');
INSERT INTO treat_tracker_test.user (id, first_name, last_name, user_name, email, password) VALUES (4, 'Jeanne', 'Bate', 'jbate', 'jbate@treattracker.com', 'password4');
INSERT INTO treat_tracker_test.user (id, first_name, last_name, user_name, email, password) VALUES (5, 'Abid', 'Duggan', 'aduggan', 'aduggan@treattracker.com', 'a');
INSERT INTO treat_tracker_test.user (id, first_name, last_name, user_name, email, password) VALUES (6, 'Abraham', 'Warren', 'awarren', 'awarren@treattracker.com', 'password6');

INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (1, 'lmcmanus', 'basic');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (2, 'fodling', 'admin');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (3, 'kyates', 'basic');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (4, 'jbate', 'basic');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (5, 'aduggan', 'admin');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (6, 'awarren', 'basic');

INSERT INTO treat_tracker_test.resolution (id, user_id, resolution_date, description) VALUES (1, 4, '2019-11-15 12:50:56', 'treats in break room');
INSERT INTO treat_tracker_test.resolution (id, user_id, resolution_date, description) VALUES (2, 5, '2020-01-11 12:51:13', 'donuts at my desk');

INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (1, 1, '2019-10-15 12:45:15', 'treats for all', null);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (2, 4, '2019-10-19 12:47:18', 'yummy treats soon', 1);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (3, 5, '2019-12-27 12:47:32', 'appreciate you all...treats', 2);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (4, 4, '2020-02-04 12:47:46', 'treats treats treats', null);














