CREATE DATABASE Paises;  
USE Paises;

CREATE TABLE Pais (
   id 			INT		(4)      NOT NULL AUTO_INCREMENT,
   nome 		VARCHAR (100)    NOT NULL,
   populacao 	bigint           NOT NULL,
   area 		DECIMAL (15,2) 	 NOT NULL,
   PRIMARY KEY (id)
   );

DESCRIBE Pais;


