BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

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
    claimed BOOLEAN default false,
    CONSTRAINT fk_production_run FOREIGN KEY(production_run) REFERENCES production_run (id)
);

CREATE TABLE user_instance (
    user_id SERIAL REFERENCES users (user_id),
    instance_serial VARCHAR(6) REFERENCES instance (serial)
);

CREATE TABLE instance_history (
    instance_serial VARCHAR(6) REFERENCES instance (serial),
    user_id SERIAL REFERENCES users (user_id),
    claimed BOOLEAN NOT NULL,
    change_date DATE DEFAULT CURRENT_DATE
);

COMMIT TRANSACTION;
