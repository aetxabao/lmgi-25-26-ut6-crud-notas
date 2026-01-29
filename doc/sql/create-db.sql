
CREATE USER 'proy'@'localhost' IDENTIFIED BY 'password';

CREATE DATABASE crud_db;

GRANT ALL PRIVILEGES ON crud_db.* TO 'proy'@'localhost';

USE crud_db;


