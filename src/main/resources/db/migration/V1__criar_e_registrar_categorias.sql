CREATE TABLE  categoria (
	 id BIGINT(20)PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE= InnoDB DEFAULT CHARSET=utf8;

INSET INTO categoria (nome) values ('Lazer');
INSET INTO categoria (nome) values ('Alimentação');
INSET INTO categoria (nome) values ('Supermercado');
INSET INTO categoria (nome) values ('Farmácia');
INSET INTO categoria (nome) values ('Outros');