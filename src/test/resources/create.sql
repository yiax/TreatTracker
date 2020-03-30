SET GLOBAL TIME_ZONE = '-6:00';

DROP DATABASE IF EXISTS treat_tracker_test;

CREATE DATABASE treat_tracker_test;

USE treat_tracker_test;


CREATE TABLE role (
    id int(11) NOT NULL,
    role varchar(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY role_role_uindex (role)
);

CREATE TABLE user (
    id int(11) NOT NULL AUTO_INCREMENT,
    firstName varchar(25) NOT NULL,
    lastName varchar(25) NOT NULL,
    email varchar(50) NOT NULL,
    userName varchar(25) NOT NULL,
    password varchar(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY user_email_uindex (email),
    UNIQUE KEY user_userName_uindex (userName)
);

CREATE TABLE user_role (
    id int(11) NOT NULL,
    createDate datetime NOT NULL,
    userName varchar(50) NOT NULL,
    role varchar(50) NOT NULL,
    updateDate datetime NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY user_role_userName_uindex (userName),
    KEY user_role_role_role_fk (role),
    CONSTRAINT user_role_role_role_fk FOREIGN KEY (role) REFERENCES role (role),
    CONSTRAINT user_role_user_userName_fk FOREIGN KEY (userName) REFERENCES user (userName)
);

CREATE TABLE resolution (
    id int(11) NOT NULL,
    resolutionDate datetime NOT NULL,
    description varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE incident (
  id int(11) NOT NULL,
  incidentDate datetime NOT NULL,
  user int(11) NOT NULL,
  description varchar(255) NOT NULL,
  resolution int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  KEY incident_resolution_id_fk (resolution),
  KEY incident_user_id_fk (user),
  CONSTRAINT incident_resolution_id_fk FOREIGN KEY (resolution) REFERENCES resolution (id),
  CONSTRAINT incident_user_id_fk FOREIGN KEY (user) REFERENCES user (id)
);


INSERT INTO role VALUES (2,'admin'),(1,'basic');
INSERT INTO user VALUES (1,'Layla','Mcmanus','lmcmanus@treattracker.com','lmcmanus','password1'),(2,'Faye','Odling','fodling@treattracker.com','folding','password2'),(3,'Kerys','Yates','kyates@treattracker.com','kyates','password3'),(4,'Jeanne','Bate','jbate@treattracker.com','jbate','password4'),(5,'Abid','Duggan','aduggan@treattracker.com','aduggan','password5'),(6,'Abraham','Warren','awarren@treattracker.com','awarren','password6');
INSERT INTO user_role VALUES (1,'2018-01-27 05:42:19','lmcmanus','basic','2018-01-27 05:42:19'),(2,'2018-09-26 08:37:36','folding','basic','2018-09-26 08:37:36'),(3,'2019-05-16 09:32:56','kyates','admin','2019-05-16 09:32:56'),(4,'2017-07-15 10:56:15','jbate','basic','2017-07-15 10:56:15'),(5,'2018-09-29 15:34:48','aduggan','admin','2018-09-29 15:34:48'),(6,'2017-10-31 03:06:10','awarren','basic','2017-10-31 03:06:10');
INSERT INTO resolution VALUES (1,'2020-01-29 01:29:27','treats in break room');
INSERT INTO incident VALUES (1,'2019-10-12 15:35:47',2,'will bring treats',1),(2,'2019-10-27 20:31:12',4,'treats for all',NULL);













