CREATE TABLE  pessoa (
	id BIGINT(20)PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	ativo VARCHAR(50) NOT NULL,
	logradouro VARCHAR(50),
	numero VARCHAR(50),     
	complemento VARCHAR(50),
	bairro VARCHAR(50), 
	cep VARCHAR(50),    
	cidade VARCHAR(50),     
	estado VARCHAR(50)     
	
) ENGINE = INNODB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome,ativo,cep,logradouro,numero,complemento,bairro,cidade,estado) values ('Abraão','true','02549532560', 'Casa', '96', 'Rua união', 'A.lindas', 'Belém', 'PA');
INSERT INTO pessoa (nome,ativo,cep,logradouro,numero,complemento,bairro,cidade,estado) values ('José','true','02549532560', 'Casa', '965', 'Rua união', 'A.lindas', 'Belém', 'PA');   
INSERT INTO pessoa (nome,ativo,cep,logradouro,numero,complemento,bairro,cidade,estado) values ('Maria','false','02549532560', 'Casa', '9611', 'Rua união', 'A.lindas', 'Belém', 'PA');   
INSERT INTO pessoa (nome,ativo,cep,logradouro,numero,complemento,bairro,cidade,estado) values ('Adriana','true','02549532560', 'Casa', '9151', 'Rua união', 'A.lindas', 'Belém', 'PA');   
INSERT INTO pessoa (nome,ativo,cep,logradouro,numero,complemento,bairro,cidade,estado) values ('André','true','02549532560', 'Casa', '98', 'null', 'A.lindas', 'Belém', 'PA');   
INSERT INTO pessoa (nome,ativo,cep,logradouro,numero,complemento,bairro,cidade,estado) values ('Matheus','false','02549532560', 'Casa', '99', 'null', 'A.lindas', 'Belém', 'PA');   
INSERT INTO pessoa (nome,ativo,cep,logradouro,numero,complemento,bairro,cidade,estado) values ('Victor','true','02549532560', 'Casa', '100', 'null', 'A.lindas', 'Belém', 'PA');   
INSERT INTO pessoa (nome,ativo,cep,logradouro,numero,complemento,bairro,cidade,estado) values ('Leonardo','false','02549532560', 'Casa', '101', 'null', 'A.lindas', 'Belém', 'PA');   
INSERT INTO pessoa (nome,ativo,cep,logradouro,numero,complemento,bairro,cidade,estado) values ('Amanda','true','02549532560', 'Casa', '95', 'null', 'null', 'Belém', 'PA');   
    