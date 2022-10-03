CREATE TABLE IF NOT EXISTS SUBSTANCE
(
    id   INT PRIMARY KEY,
    name VARCHAR(40)
);

CREATE TABLE IF NOT EXISTS GDK
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    id_substance    INT,
    max_gdk         DOUBLE,
    avg_gdk         DOUBLE,
    dangerous_class INT,
    FOREIGN KEY (id_substance) REFERENCES SUBSTANCE (id)
);

CREATE TABLE IF not exists OBRD
(
    id           INT PRIMARY KEY auto_increment,
    id_substance INT,
    obrd_value   DOUBLE,
    FOREIGN KEY (id_substance) REFERENCES SUBSTANCE (id)
);


CREATE TABLE if not exists OBJECTS
(
    id                             DOUBLE PRIMARY KEY,
    name                           VARCHAR(100),
    id_substance                   INT,
    value_pollution                DOUBLE,
    value_mass_pollution           DOUBLE,
    gdv                            DOUBLE,
    events_for_reduction_pollution VARCHAR(1000),
    FOREIGN KEY (id_substance)
        REFERENCES Substance (id)
);