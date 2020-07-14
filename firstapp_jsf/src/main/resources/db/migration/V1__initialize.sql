DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
    id                    BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    cat_name              VARCHAR(255) NOT NULL UNIQUE,
    description           VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO categories (cat_name, description)
VALUES
    ('Category1', 'description1'),
    ('Category2', 'description2'),
    ('Category3', 'description3'),
    ('Category4', 'description4'),
    ('Category5', 'description5'),
    ('Category6', 'description6'),
    ('Category7', 'description7');

DROP TABLE IF EXISTS products;
CREATE TABLE products (
    id            BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
    prod_name     VARCHAR(255) NOT NULL UNIQUE,
    description   VARCHAR(255),
    price         numeric(8, 2),
    category_id   BIGINT,
    localDate     DATE,
    FOREIGN KEY (category_id)
    REFERENCES categories(id));
);

INSERT INTO products (prod_name, description, price, category_id, localDate)
VALUES

('Product1', 'Discription1', 150, 2, '2017-01-05'),
('Product2', 'Discription2', 200, 3, '2018-02-07'),
('Product3', 'Discription3', 320, 1, '2018-04-09'),
('Product4', 'Discription4', 150, 4, '2017-01-05'),
('Product5', 'Discription5', 200, 3, '2018-02-07'),
('Product6', 'Discription6', 320, 5, '2018-04-09'),
('Product7', 'Discription7', 150, 2, '2017-01-05'),
('Product8', 'Discription8', 200, 7, '2018-02-07'),
('Product9', 'Discription9', 320, 5, '2018-04-09');

-- DROP TABLE IF EXISTS roles;
-- CREATE TABLE roles (
--   id                    BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
--   name                  VARCHAR(50) NOT NULL,
--   PRIMARY KEY (id)
-- );
--
-- INSERT INTO roles (name)
-- VALUES
-- ('ROLE_ADMIN'), ('ROLE_USER');

-- DROP TABLE IF EXISTS users;
-- CREATE TABLE users (
--   id                    BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
--   login                 varchar (50) NOT NULL UNIQUE,
--   password              VARCHAR(80) NOT NULL,
--   PRIMARY KEY (id)
-- );
--
-- INSERT INTO users (login, password)
-- VALUES
-- ('admin','123'),
-- -- password=123
-- ('user','111');
-- -- password=111

-- DROP TABLE IF EXISTS users_roles;
-- CREATE TABLE users_roles (
--   user_id               bigint NOT NULL,
--   role_id               bigint NOT NULL,
--   PRIMARY KEY (user_id, role_id),
--   FOREIGN KEY (user_id)
--   REFERENCES users (id),
--   FOREIGN KEY (role_id)
--   REFERENCES roles (id)
-- );
--
-- INSERT INTO users_roles (user_id, role_id)
-- VALUES
-- (1, 1),
-- (1, 2);