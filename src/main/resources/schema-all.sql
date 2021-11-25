DROP ALL OBJECTS;
-- Versione 1.0

-- 1. Sequence
CREATE SEQUENCE NXTNBR START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;

-- 2. Tabella dei messaggi
CREATE TABLE MESSAGE (
    ID NUMBER(19) NOT NULL,
    USERNAME VARCHAR2(500 CHAR) NOT NULL,
    MESSAGE VARCHAR2(4000) NOT NULL,
    DT_TIME TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL,
    CONSTRAINT MESSAGE PRIMARY KEY (ID)
);

CREATE TABLE FOLLOWER (
    ID NUMBER(19) NOT NULL,
    USERNAME VARCHAR2(500 CHAR) NOT NULL,
    FOLLOWER VARCHAR2(500 CHAR) NOT NULL,
    CONSTRAINT MESSAGE PRIMARY KEY (ID),
    CONSTRAINT MESSAGE UNIQUE ( USERNAME, FOLLOWER )
);