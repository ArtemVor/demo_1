DROP TABLE IF EXISTS coffee ;

CREATE TABLE coffee
(
    id              SERIAL,
    brand           VARCHAR(255),
    origin          VARCHAR(255),
    characteristics VARCHAR(255)
);