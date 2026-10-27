use db;
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




