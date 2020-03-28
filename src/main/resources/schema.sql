DROP TABLE IF EXISTS city;

CREATE TABLE city (
    id          CHAR(36)     NOT NULL,
	name        VARCHAR(225) NOT NULL,
	description VARCHAR(2000) NOT NULL,
	CONSTRAINT pk_city PRIMARY KEY (id),
	CONSTRAINT uk_city_name UNIQUE (name)
);
