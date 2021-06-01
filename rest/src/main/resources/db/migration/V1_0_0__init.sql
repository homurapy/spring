CREATE TABLE categories (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO categories (name) VALUES
('мясные продукты'),
('замороженные продукты'),
('консервация'),
('фрукты'),
('молочные продукты'),
('овощи'),
('напитки');
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), version INTEGER, price INTEGER, category_id bigint REFERENCES categories(id));
INSERT INTO products (title, price, version, category_id) VALUES
('сметана Снежок 310 гр', 75, 1, 5),
('Яблоки Симиренко', 99, 1, 4),
('Бананы', 68, 1, 4),
('чай краснодарский 200г', 150, 1, 7),
('кофе растворимый', 250, 1, 7),
('молоко валуйки', 80, 1, 5),
('шпрот в масле', 73, 1, 3),
('Яблоки сезонные', 70, 1, 4),
('помидоры розовые', 199, 1, 6),
('картофель ранний', 70, 1, 6),
('картофель эконом', 25, 1, 6),
('молоко валуйки', 76, 1, 5),
('авакадо', 32, 1, 4),
('лук белый ', 54, 1, 6),
('зеленый лук', 199, 1, 6),
('пельмени богатырские 500 г', 123, 1, 2);
