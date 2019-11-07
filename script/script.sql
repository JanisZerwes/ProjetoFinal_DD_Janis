DROP DATABASE IF EXISTS projetofinaljanis; 
CREATE DATABASE projetofinaljanis;

USE projetofinaljanis;

CREATE TABLE CLIENTE (
IDCLIENTE INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
NOME VARCHAR(255), 
SOBRENOME VARCHAR(255),
ENDERECO VARCHAR (255),
SEXO CHAR (1),
CPF CHAR(11), 
TELEFONE CHAR(14), 
EMAIL VARCHAR(255), 
ADIMPLENTE boolean
);
commit;

CREATE TABLE VETERINARIO (
IDVETERINARIO INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
NOME VARCHAR(255), 
SOBRENOME VARCHAR(255),
ENDERECO VARCHAR (255),
SEXO CHAR (1),
CPF CHAR(11), 
TELEFONE CHAR(14), 
EMAIL VARCHAR(255), 
CERTIFICADO VARCHAR(255), 
CRMV VARCHAR (255)
);
commit;

CREATE TABLE PET (
IDPET INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
IDCLIENTE INT,
NOME VARCHAR (255),
DTNASCIMENTO date,
PESO DOUBLE,
PORTE VARCHAR (255),
ESPECIE VARCHAR (255),
RACA VARCHAR (255),
SEXO CHAR(1),
FOREIGN KEY ( IDCLIENTE) REFERENCES CLIENTE (IDCLIENTE));
commit;


CREATE TABLE TIPO(
IDTIPO INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
DESCRICAO VARCHAR(255));
commit;

CREATE TABLE PROCEDIMENTO(
IDPROCEDIMENTO  INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
IDPET INT,
IDVETERINARIO INT,
IDTIPO INT,
TITULO VARCHAR (255),
DESCRICAO VARCHAR (255),
DTENTRADA DATE,
DTSAIDA DATE, 
VALOR DOUBLE, 
FORMAPAGAMENTO VARCHAR (255),
FOREIGN KEY (IDPET) REFERENCES PET (IDPET),
FOREIGN KEY(IDVETERINARIO) REFERENCES VETERINARIO (IDVETERINARIO),
FOREIGN KEY (IDTIPO) REFERENCES TIPO (IDTIPO));
commit;



INSERT INTO CLIENTE (nome, sobrenome, endereco, sexo, cpf, telefone, email, adimplente) 
VALUES ('Clovis', 'Pirez', 'Avenida Brasil ','M','11111111111', '44444-4444', 'Clovis@clovis', true);
commit;

INSERT INTO VETERINARIO (nome, sobrenome, endereco, sexo, cpf, telefone, email, certificado, crmv) 
VALUES ('Joana', 'Sonza', ' Rua Brasil ','F','11111111111', '44444-4444', 'Joana@sonza', ' ', ' ');
commit;

INSERT INTO PET (idcliente, nome, dtnascimento, peso, porte, especie, raca, sexo) 
VALUES (1,'Fera', '2017-03-20', 9, 'médio', 'Cão','vira-lata', 'M');
commit;

INSERT INTO PROCEDIMENTO (idveterinario, idpet, titulo, descricao, valor, dtentrada, dtsaida, formapagamento) 
VALUES (1, 1, ' castração ', ' já era ', 400, '2019-10-14', '2019-11-10', 'cartão');

commit;

INSERT INTO PROCEDIMENTO (idveterinario, idpet, titulo, descricao, valor, dtentrada, dtsaida, formapagamento) 
VALUES (1, 1, ' Tosa ', 'Higienica', 30, '2019-11-05', '2019-11-05', 'cartão');

commit;

INSERT INTO TIPO (idtipo, descricao) 
VALUES (1, ' ');
commit;

select * from cliente;
select * from veterinario; 
select * from pet;
select * from procedimento;
SELECT p.idPet, p.nome, p.porte, p.peso, p.raca, p.especie, p.dtnascimento, p.sexo, c.nome as dono,  count(proc.idprocedimento) as contagem, sum(proc.valor) as total FROM Pet as p inner join cliente as c on p.idcliente = c.idcliente inner join procedimento as proc on proc.idpet = p.idpet;
