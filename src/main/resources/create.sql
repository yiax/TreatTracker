CREATE TABLE resolution (
                            id int(10) AUTO_INCREMENT PRIMARY KEY,
                            userID int(10) NOT NULL,
                            resolutionDate varchar(10) NOT NULL,
                            description varchar(255) NOT NULL
);

CREATE TABLE incident (
                          id int(10) AUTO_INCREMENT PRIMARY KEY,
                          incidentDate varchar(10) NOT NULL,
                          email varchar(50) NOT NULL,
                          description varchar(255) NOT NULL,
                          resolutionID int(10) DEFAULT NULL,
                          CONSTRAINT incident_resolutionID_id_fk FOREIGN KEY (resolutionID) REFERENCES resolution (id)
);

CREATE TABLE user (
                      id int(10) AUTO_INCREMENT PRIMARY KEY ,
                      firstName varchar(25) NOT NULL,
                      lastName varchar(25) NOT NULL,
                      email varchar(50) NOT NULL,
                      userName varchar(30) NOT NULL,
                      password varchar(255) NOT NULL,
                      incidents int(10) DEFAULT NULL,
                      CONSTRAINT user_incidents_id_fk FOREIGN KEY (incidents) REFERENCES incident (id),
                      UNIQUE KEY userName_UNIQUE (userName)
);