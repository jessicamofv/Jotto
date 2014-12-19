CREATE TABLE JUSER
(
ID INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
FIRSTNAME VARCHAR(255) NOT NULL,
LASTNAME VARCHAR(255) NOT NULL,
PASSWORD VARCHAR(255) NOT NULL,
SINCE TIMESTAMP,
USERNAME VARCHAR(255) NOT NULL,
PRIMARY KEY (ID)
);

CREATE TABLE JSTATS 
(
ID INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
FASTESTWINJGAMEID INTEGER NOT NULL,
FEWESTGUESSESJGAMEID INTEGER NOT NULL,
GAMESPLAYED INTEGER NOT NULL,
LOSSES INTEGER NOT NULL,
WINS INTEGER NOT NULL,
JUSERID INTEGER NOT NULL,
PRIMARY KEY (ID)
);

CREATE TABLE JGUESS
(
ID INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
GUESS VARCHAR(255) NOT NULL,
JGAMEID INTEGER NOT NULL,
PRIMARY KEY (ID)
);

CREATE TABLE JGAME
(
ID INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL,
GAMETIME BIGINT NOT NULL,
NUMGUESSES INTEGER NOT NULL,
SECRETWORD VARCHAR(255) NOT NULL,
JUSERID INTEGER NOT NULL,
PRIMARY KEY (ID)
);

ALTER TABLE JSTATS
ADD CONSTRAINT FK_JSTATS_JUSERID
FOREIGN KEY (JUSERID) REFERENCES JUSER (ID);

ALTER TABLE JGUESS
ADD CONSTRAINT FK_JGUESS_JGAMEID
FOREIGN KEY (JGAMEID) REFERENCES JGAME (ID);

ALTER TABLE JGAME
ADD CONSTRAINT FK_JGAME_JUSERID
FOREIGN KEY (JUSERID) REFERENCES JUSER (ID);
