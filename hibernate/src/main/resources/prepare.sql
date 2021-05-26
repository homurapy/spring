BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price INTEGER);
INSERT INTO products (title, price) VALUES
('говядина', 800),
('свинина', 400),
('курица', 250),
('треска', 600),
('бычки в томате', 100),
('Шаверма от Шера', 210),
('Яблоки Симиренко', 99),
('Бананы', 68);

DROP TABLE IF EXISTS buyers CASCADE;
CREATE TABLE buyers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO buyers (name) VALUES
('Alexander'),
('Bob');

DROP TABLE IF EXISTS orders CASCADE;
CREATE TABLE orders (id_buyer bigint, id_product bigint, FOREIGN KEY (id_product) REFERENCES products (id), FOREIGN KEY (id_buyer) REFERENCES buyers (id));
INSERT INTO orders (id_product, id_buyer) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 1),
(6, 1),
(7, 2),
(8, 2);

COMMIT;