CREATE TABLE IF NOT EXISTS SUBSTANCE
(
    id   INT PRIMARY KEY,
    name VARCHAR(40) not null
);

CREATE TABLE IF NOT EXISTS GDK
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    id_substance    INT,
    max_gdk         DOUBLE,
    avg_gdk         DOUBLE,
    dangerous_class INT,
    FOREIGN KEY (id_substance) REFERENCES SUBSTANCE (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF not exists OBRD
(
    id           INT PRIMARY KEY auto_increment,
    id_substance INT,
    obrd_value   DOUBLE,
    FOREIGN KEY (id_substance) REFERENCES SUBSTANCE (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS OBJECTS
(
    id   INT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE if not exists OBJECTS_LAB1
(
    id                             INT AUTO_INCREMENT primary key,
    id_object                      int,
    id_substance                   INT,
    value_pollution                DOUBLE,
    factorError                    INT DEFAULT 0,
    events_for_reduction_pollution VARCHAR(1000),
    year                           INT DEFAULT 2020,
    FOREIGN KEY (id_substance)
        REFERENCES Substance (id),
    foreign key (id_object)
        REFERENCES OBJECTS (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS OBJECTS_LAB2
(
    id                      INT AUTO_INCREMENT PRIMARY KEY,
    id_object               INT,
    id_substance            INT,
    amount_of_emissions     DOUBLE,
    tax_rates_for_emissions DOUBLE,
    tax_amount              DOUBLE default 0,
    year                    INT    DEFAULT 2020,
    FOREIGN KEY (id_substance)
        REFERENCES Substance (id),
    foreign key (id_object)
        REFERENCES OBJECTS (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS SFI
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    id_substance INT,
    sfi          DOUBLE,
    FOREIGN KEY (id_substance) REFERENCES SUBSTANCE (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS RFC
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    id_substance INT,
    rfc          DOUBLE,
    FOREIGN KEY (id_substance) REFERENCES SUBSTANCE (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS OBJECTS_KONCEROGEN
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    id_object     INT,
    id_substance  INT,
    concentration DOUBLE,
    PCR           DOUBLE DEFAULT 0,
    Risk          DOUBLE DEFAULT 0,
    year          INT    DEFAULT 2020,
    FOREIGN KEY (id_substance)
        REFERENCES SUBSTANCE (id),
    FOREIGN KEY (id_object)
        REFERENCES OBJECTS (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS OBJ_NOT_KONCEROGEN
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    id_object     INT,
    id_substance  INT,
    concentration DOUBLE,
    HQ            DOUBLE DEFAULT 0,
    Risk          DOUBLE DEFAULT 0,
    year          INT    DEFAULT 2020,
    FOREIGN KEY (id_substance)
        REFERENCES SUBSTANCE (id),
    FOREIGN KEY (id_object)
        REFERENCES OBJECTS (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS OBJECTS_POLLUTION
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    id_object           INT,
    id_substance        INT,
    amount_of_emissions DOUBLE,
    concentration       DOUBLE,
    loss                DOUBLE DEFAULT 0,
    year                INT    DEFAULT 2020,
    FOREIGN KEY (id_substance)
        REFERENCES SUBSTANCE (id),
    FOREIGN KEY (id_object)
        REFERENCES OBJECTS (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);



