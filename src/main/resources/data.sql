drop table if exists kunde;

create table kunde (
  id INT  AUTO_INCREMENT PRIMARY KEY,
  vorname VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  str VARCHAR(250) NOT NULL,
  plz INT(5) NOT NULL,
  stadt VARCHAR(250) NOT NULL
);

INSERT INTO Kunde values (1, 'Tom', 'Brockhaus', 'Tom Str. 23A',  44227, 'Dortmund');