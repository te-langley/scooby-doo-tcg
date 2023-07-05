BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO product (name, species, occupation, catchphrase)
VALUES
('Scooby Doo', 'Great Dane', 'Mystery Solver', 'Scooby-Dooby-Doo!'),
('Shaggy Rogers', 'Human', 'Mystery Solver', 'Zoinks!'),
('Velma Dinkley', 'Human', 'Mystery Solver', 'Jinkies!'),
('Fred Jones', 'Human', 'Mystery Solver', 'Let''s split up, gang!'),
('Daphne Blake', 'Human', 'Mystery Solver', 'Jeepers!'),
('Scrappy Doo', 'Great Dane', 'Mystery Solver', 'Scrappy Power!');

INSERT INTO production_run (product_code, production_date, quantity, status, notes)
VALUES
(1, '2023-04-20', 100, 'Completed', ''),
(2, '2023-04-20', 100, 'Completed', ''),
(3, '2023-04-20', 100, 'Completed', ''),
(4, '2023-04-20', 100, 'Completed', ''),
(5, '2023-04-20', 100, 'Completed', ''),
(6, '2023-04-20', 100, 'Canceled', 'Nobody likes Scrappy Doo'),
(1, '2023-09-13', 25, 'In Progress', 'Special Release (Wave 1)'),
(2, '2023-09-13', 25, 'In Progress', 'Special Release (Wave 1)'),
(3, '2023-09-13', 25, 'In Progress', 'Special Release (Wave 1)'),
(4, '2024-01-01', 25, 'Pending', 'Special Release (Wave 2)'),
(5, '2023-01-01', 25, 'Pending', 'Special Release (Wave 2)');

COMMIT TRANSACTION;
