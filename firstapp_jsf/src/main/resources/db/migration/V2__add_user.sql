use db;

DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
  id            BIGINT PRIMARY KEY AUTO_INCREMENT,
  name     VARCHAR (255) NOT NULL
  );

INSERT INTO roles (name)
VALUES
('ADMIN'),
('USER');

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id                    BIGINT PRIMARY KEY AUTO_INCREMENT,
  login                 varchar (50) NOT NULL UNIQUE,
  password              VARCHAR(80) NOT NULL
);

INSERT INTO users (login, password)
VALUES
('admin','123'),
('user','111');

DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles (
  user_id               bigint NOT NULL,
  role_id               bigint NOT NULL,
  PRIMARY KEY (user_id, role_id),
  FOREIGN KEY (user_id)
  REFERENCES users (id),
  FOREIGN KEY (role_id)
  REFERENCES roles (id)
);
INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1),
(1, 2);