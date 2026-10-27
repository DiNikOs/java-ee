use db;
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