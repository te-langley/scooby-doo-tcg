BEGIN TRANSACTION;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	created DATE DEFAULT CURRENT_DATE,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    species VARCHAR(50),
    occupation VARCHAR(100),
    catchphrase VARCHAR(200),
    image VARCHAR(200)
);

CREATE TABLE production_run (
    id SERIAL PRIMARY KEY,
    product_code INTEGER REFERENCES product (id),
    production_date DATE NOT NULL,
    quantity INTEGER,
    status VARCHAR(20),
    notes TEXT
);

CREATE TABLE instance (
    serial VARCHAR(6) PRIMARY KEY,
    product_code INTEGER REFERENCES product (id),
    production_run INTEGER,
    sequence INTEGER,
    locked BOOLEAN default true,
    CONSTRAINT fk_production_run FOREIGN KEY(production_run) REFERENCES production_run (id)
);

CREATE TABLE instance_history (
    event_id SERIAL PRIMARY KEY,
    instance_serial VARCHAR(6) REFERENCES instance (serial),
    user_id SERIAL REFERENCES users (user_id),
    claimed BOOLEAN NOT NULL,
    change_date DATE DEFAULT CURRENT_DATE
);

CREATE VIEW last_update AS
    SELECT max(change_date) AS last_updated, instance_serial
    FROM instance_history
    GROUP BY instance_serial;

CREATE VIEW currently_claimed AS
    SELECT ih.instance_serial, claimed, change_date
    FROM last_update AS lu
    JOIN instance_history AS ih
    ON ih.instance_serial=lu.instance_serial AND ih.change_date=last_updated
    WHERE claimed=true
    ORDER BY instance_serial, change_date DESC;

COMMIT TRANSACTION;
