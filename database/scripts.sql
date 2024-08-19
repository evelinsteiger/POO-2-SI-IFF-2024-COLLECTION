-- TABELAS
  CREATE TABLE users (
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    client_id VARCHAR(255) NOT NULL,
    grant_type VARCHAR(80) DEFAULT 'client_credentials' NOT NULL
  );

  CREATE TABLE games (
    id INTEGER PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    gender VARCHAR(80) NOT NULL,
    rating NUMERIC(5,2) DEFAULT 0 NOT NULL,
    release_dates DATETIME,
    favorite BOOLEAN DEFAULT 0 NOT NULL,
    status ENUM('PENDING', 'PLAYING_NOW', 'FINISHED', 'NOT_INTERESTED') DEFAULT 'PENDING',
	platform_id INTEGER NOT NULL,
    FOREIGN KEY (platform_id) REFERENCES platforms(id),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
  );

  ALTER TABLE games ADD description TEXT;

  ALTER TABLE games ADD image TEXT;

  CREATE TABLE platforms (
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
  );


  -- INSERTS
  INSERT INTO users (name,email,client_id) VALUES ('Evelin Steiger','evelinsteiger1@gmail.com','zu9lflw6vehnews02st1s8np1jqqw1');

  INSERT INTO platforms (id,name) VALUES ('1', 'Não informado');
  INSERT INTO platforms (id,name) VALUES ('6', 'PC Windows');
  INSERT INTO platforms (id,name) VALUES ('7', 'PS1');
  INSERT INTO platforms (id,name) VALUES ('8', 'PS2');
  INSERT INTO platforms (id,name) VALUES ('9', 'PS3');
  INSERT INTO platforms (id,name) VALUES ('11', 'XBOX');
  INSERT INTO platforms (id,name) VALUES ('12', 'XBOX 360');
  INSERT INTO platforms (id,name) VALUES ('48', 'PS4');
  INSERT INTO platforms (id,name) VALUES ('49', 'XBOX One');
  INSERT INTO platforms (id,name) VALUES ('167', 'PS5');
  INSERT INTO platforms (id,name) VALUES ('169', 'XBOX Series X|S');