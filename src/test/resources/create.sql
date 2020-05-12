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
INSERT INTO treat_tracker_test.user (id, first_name, last_name, user_name, email, password) VALUES (5, 'Abid', 'Duggan', 'aduggan', 'aduggan@treattracker.com', 'password5');
INSERT INTO treat_tracker_test.user (id, first_name, last_name, user_name, email, password) VALUES (6, 'Abraham', 'Warren', 'awarren', 'awarren@treattracker.com', 'password6');
INSERT INTO treat_tracker_test.user (id, first_name, last_name, user_name, email, password) VALUES (7, 'Yia', 'Xiong', 'yxiong', 'yiax86@gmail.com', 'r00t');


INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (1, 'lmcmanus', 'basic');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (2, 'fodling', 'admin');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (3, 'kyates', 'basic');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (4, 'jbate', 'basic');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (5, 'aduggan', 'admin');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (6, 'awarren', 'basic');
INSERT INTO treat_tracker_test.role (id, user_name, role) VALUES (7, 'yxiong', 'admin');

INSERT INTO treat_tracker_test.resolution (id, user_id, resolution_date, description) VALUES (1, 4, '2019-11-15 12:50:56', 'treats in break room');
INSERT INTO treat_tracker_test.resolution (id, user_id, resolution_date, description) VALUES (2, 5, '2020-01-11 12:51:13', 'donuts at my desk');
INSERT INTO treat_tracker_test.resolution (id, user_id, resolution_date, description) VALUES (3, 6, '2020-02-15 06:15:20', 'resolution3');
INSERT INTO treat_tracker_test.resolution (id, user_id, resolution_date, description) VALUES (4, 2, '2020-02-19 09:31:41', 'resolution4');
INSERT INTO treat_tracker_test.resolution (id, user_id, resolution_date, description) VALUES (5, 1, '2020-03-20 10:40:25', 'resolution5');
INSERT INTO treat_tracker_test.resolution (id, user_id, resolution_date, description) VALUES (6, 7, '2020-04-30 01:06:07', 'resolution6');

INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (1, 1, '2019-10-15 12:45:15', 'treats for all', null);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (2, 4, '2019-10-19 12:47:18', 'yummy treats soon', 1);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (3, 5, '2019-12-27 12:47:32', 'appreciate you all...treats', 2);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (4, 4, '2020-02-04 12:47:46', 'treats treats treats', null);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (5, 6, '2020-02-05 01:12:11', 'incident5', 3);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (6, 2, '2020-02-17 06:30:51', 'incident6', 4);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (7, 1, '2020-03-03 06:18:35', 'incident7', 5);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (8, 7, '2020-03-06 11:15:24', 'incident8', 6);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (9, 2, '2020-03-10 03:42:14', 'incident9', null);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (10, 1, '2020-04-09 05:51:18', 'incident10', null);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (11, 6, '2020-04-15 06:41:52', 'incident11', null);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (12, 7, '2020-04-16 12:35:41', 'incident12', null);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (13, 4, '2020-04-22 09:20:34', 'incident13', null);
INSERT INTO treat_tracker_test.incident (id, user_id, incident_date, description, resolution_id) VALUES (14, 4, '2020-05-04 10:51:05', 'incident14', null);


/*
INSERT INTO treattracker.user (id, first_name, last_name, user_name, email, password) VALUES (1, 'Layla', 'Mcmanus', 'lmcmanus', 'lmcmanus@treattracker.com', 'password1');
INSERT INTO treattracker.user (id, first_name, last_name, user_name, email, password) VALUES (2, 'Faye', 'Odling', 'fodling', 'folding@treattracker.com', 'password2');
INSERT INTO treattracker.user (id, first_name, last_name, user_name, email, password) VALUES (3, 'Kerys', 'Yates', 'kyates', 'kyates@treattracker.com', 'password3');
INSERT INTO treattracker.user (id, first_name, last_name, user_name, email, password) VALUES (4, 'Jeanne', 'Bate', 'jbate', 'jbate@treattracker.com', 'password4');
INSERT INTO treattracker.user (id, first_name, last_name, user_name, email, password) VALUES (5, 'Abid', 'Duggan', 'aduggan', 'aduggan@treattracker.com', 'password5');
INSERT INTO treattracker.user (id, first_name, last_name, user_name, email, password) VALUES (6, 'Abraham', 'Warren', 'awarren', 'awarren@treattracker.com', 'password6');


INSERT INTO treattracker.role (id, user_name, role) VALUES (1, 'lmcmanus', 'basic');
INSERT INTO treattracker.role (id, user_name, role) VALUES (2, 'fodling', 'admin');
INSERT INTO treattracker.role (id, user_name, role) VALUES (3, 'kyates', 'basic');
INSERT INTO treattracker.role (id, user_name, role) VALUES (4, 'jbate', 'basic');
INSERT INTO treattracker.role (id, user_name, role) VALUES (5, 'aduggan', 'admin');
INSERT INTO treattracker.role (id, user_name, role) VALUES (6, 'awarren', 'basic');

INSERT INTO treattracker.resolution (id, user_id, resolution_date, description) VALUES (1, 4, '2019-11-15 12:50:56', 'treats in break room');
INSERT INTO treattracker.resolution (id, user_id, resolution_date, description) VALUES (2, 5, '2020-01-11 12:51:13', 'donuts at my desk');
INSERT INTO treattracker.resolution (id, user_id, resolution_date, description) VALUES (3, 6, '2020-02-15 06:15:20', 'resolution3');
INSERT INTO treattracker.resolution (id, user_id, resolution_date, description) VALUES (4, 2, '2020-02-19 09:31:41', 'resolution4');
INSERT INTO treattracker.resolution (id, user_id, resolution_date, description) VALUES (5, 1, '2020-03-20 10:40:25', 'resolution5');


INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (1, 1, '2019-10-15 12:45:15', 'treats for all', null);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (2, 4, '2019-10-19 12:47:18', 'yummy treats soon', 1);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (3, 5, '2019-12-27 12:47:32', 'appreciate you all...treats', 2);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (4, 4, '2020-02-04 12:47:46', 'treats treats treats', null);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (5, 6, '2020-02-05 01:12:11', 'incident5', 3);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (6, 2, '2020-02-17 06:30:51', 'incident6', 4);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (7, 1, '2020-03-03 06:18:35', 'incident7', 5);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (8, 2, '2020-03-10 03:42:14', 'incident9', null);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (9, 1, '2020-04-09 05:51:18', 'incident10', null);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (10, 6, '2020-04-15 06:41:52', 'incident11', null);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (11, 4, '2020-04-22 09:20:34', 'incident13', null);
INSERT INTO treattracker.incident (id, user_id, incident_date, description, resolution_id) VALUES (12, 4, '2020-05-04 10:51:05', 'incident14', null);
*/











