DROP DATABASE IF EXISTS "KEA24Construction" ;
CREATE DATABASE "KEA24Construction" DEFAULT CHARACTER SET utf8 ;
USE "KEA24Construction" ;

INSERT INTO supervisors(supervisor_name) VALUES("Lars"),("Niels");

INSERT INTO students(email, name, supervisor_id) VALUES("Superkaren@mail.dk","Karen",2),("Søren@snegl.dk","Søren",1);

-- Skriptet virker ikke efter henseende.. skal indtastes manuelt..