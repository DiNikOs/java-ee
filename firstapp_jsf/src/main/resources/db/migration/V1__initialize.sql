DROP TABLE IF EXISTS categories;
CREATE TABLE categories (
    id                    integer,
    cat_name              VARCHAR(255) NOT NULL UNIQUE,
    description           VARCHAR(255),
    PRIMARY KEY (id)
);

INSERT INTO categories (id, cat_name, description)
VALUES
    (1, 'Category1', 'description1'),
    (2, 'Category2', 'description2'),
    (3, 'Category3', 'description3'),
    (4, 'Category4', 'description4'),
    (5, 'Category5', 'description5'),
    (6, 'Category6', 'description6'),
    (7, 'Category7', 'description7');

DROP TABLE IF EXISTS products;
CREATE TABLE products (
    id            integer PRIMARY KEY,
    prod_name     VARCHAR(255) NOT NULL UNIQUE,
    description   VARCHAR(255),
    price         numeric(8, 2),
    category_id   int,
    localDate     date,
    FOREIGN KEY (category_id)
    REFERENCES categories(id));
);

INSERT INTO products (id, prod_name, description, price, category_id, localDate)
VALUES

(1, 'Product1', 'Discription1', 150, 2, '2017-01-05'),
(2, 'Product2', 'Discription2', 200, 3, '2018-02-07'),
(3, 'Product3', 'Discription3', 320, 1, '2018-04-09'),
(4, 'Product4', 'Discription4', 150, 4, '2017-01-05'),
(5, 'Product5', 'Discription5', 200, 3, '2018-02-07'),
(6, 'Product6', 'Discription6', 320, 5, '2018-04-09'),
(7, 'Product7', 'Discription7', 150, 2, '2017-01-05'),
(8, 'Product8', 'Discription8', 200, 7, '2018-02-07'),
(9, 'Product9', 'Discription9', 320, 5, '2018-04-09');