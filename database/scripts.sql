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
    platform_id INTEGER FOREIGN KEY REFERENCES platforms(id) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIME NOT NULL
  );

  CREATE TABLE platforms (
    id INTEGER PRIMARY KEY NOT NULL,
    name VARCHAR(255) NOT NULL
  );


  -- INSERTS
  INSERT INTO users ('nome', 'email', 'client_id') VALUES ('Evelin Steiger', 'evelinsteiger1@gmail.com', 'zu9lflw6vehnews02st1s8np1jqqw1');

  INSERT INTO platform ('id', 'nome') VALUES ('1', 'Não informado');
  INSERT INTO platform ('id', 'nome') VALUES ('6', 'PC Windows');
  INSERT INTO platform ('id', 'nome') VALUES ('7', 'PS1');
  INSERT INTO platform ('id', 'nome') VALUES ('8', 'PS2');
  INSERT INTO platform ('id', 'nome') VALUES ('9', 'PS3');
  INSERT INTO platform ('id', 'nome') VALUES ('11', 'XBOX');
  INSERT INTO platform ('id', 'nome') VALUES ('12', 'XBOX 360');
  INSERT INTO platform ('id', 'nome') VALUES ('48', 'PS4');
  INSERT INTO platform ('id', 'nome') VALUES ('49', 'XBOX One');
  INSERT INTO platform ('id', 'nome') VALUES ('167', 'PS5');
  INSERT INTO platform ('id', 'nome') VALUES ('169', 'XBOX Series X|S');