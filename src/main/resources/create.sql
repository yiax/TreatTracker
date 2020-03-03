CREATE TABLE user (
                      id int(10) AUTO_INCREMENT PRIMARY KEY ,
                      firstName varchar(25) NOT NULL,
                      lastName varchar(25) NOT NULL,
                      email varchar(50) NOT NULL,
                      userName varchar(30) NOT NULL,
                      password varchar(255) NOT NULL,
                      UNIQUE KEY userName_UNIQUE (userName)
);

CREATE TABLE incident (
                          id int(10) AUTO_INCREMENT PRIMARY KEY,
                          incidentDate varchar(10) NOT NULL,
                          userID int(10) NOT NULL,
                          description varchar(255) NOT NULL,
                          resolutionID int(10) DEFAULT NULL,
                          CONSTRAINT incident_userID_fk FOREIGN KEY (userID) REFERENCES user (id)
);

CREATE TABLE resolution (
                            id int(10) AUTO_INCREMENT PRIMARY KEY,
                            resolutionDate varchar(10) NOT NULL,
                            incidentID int(10) NOT NULL,
                            description varchar(255) NOT NULL,
                            CONSTRAINT resolution_incidentID_fk FOREIGN KEY (incidentID) REFERENCES incident (id)
);