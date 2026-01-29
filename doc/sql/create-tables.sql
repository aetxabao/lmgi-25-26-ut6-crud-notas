CREATE TABLE crud_db.notas (
                             id  bigint(20) NOT NULL AUTO_INCREMENT,
                             titulo varchar(255) DEFAULT '',
                             contenido varchar(4095) DEFAULT '',
                             creado varchar(4095) DEFAULT '',
                             modificado varchar(4095) DEFAULT '',
                             PRIMARY KEY (id)
);
