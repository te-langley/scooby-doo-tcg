BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO product (name, species, occupation, catchphrase, image)
VALUES 
('Scooby Doo', 'Great Dane', 'Mystery Solver', 'Scooby-Dooby-Doo!', 'scooby-doo.png'),
('Shaggy Rogers', 'Human', 'Mystery Solver', 'Zoinks!', 'shaggy-rogers.png'),
('Velma Dinkley', 'Human', 'Mystery Solver', 'Jinkies!', 'velma-dinkley.png'),
('Fred Jones', 'Human', 'Mystery Solver', 'Let''s split up, gang!', 'fred-jones.png'),
('Daphne Blake', 'Human', 'Mystery Solver', 'Jeepers!', 'daphne-blake.png'),
('Scrappy Doo', 'Great Dane', 'Mystery Solver', 'Scrappy Power!', 'scrappy-doo.png');

INSERT INTO production_run (product_code, production_date, quantity, status, notes)
VALUES
(1, '2023-04-20', 100, 'Completed', ''),
(2, '2023-04-20', 100, 'Completed', ''),
(3, '2023-04-20', 100, 'Completed', ''),
(4, '2023-04-20', 100, 'Completed', ''),
(5, '2023-04-20', 100, 'Completed', ''),
(6, '2023-04-20', 100, 'Canceled', 'Nobody likes Scrappy Doo'),
(1, '2023-09-13', 25, 'In Progress', 'Special Release'),
(2, '2023-09-13', 25, 'In Progress', 'Special Release'),
(3, '2023-09-13', 25, 'In Progress', 'Special Release');

COMMIT TRANSACTION;
