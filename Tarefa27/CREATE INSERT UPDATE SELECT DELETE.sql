CREATE DATABASE bruno;

CREATE TABLE pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(30),
    idade INTEGER,
    cpf VARCHAR(11)
);

INSERT INTO pessoa (nome, idade, cpf) VALUES 	('Ana Clara', 28, '12345678901'),
												('Bruno Lima', 35, '23456789012'),
												('Carlos Souza', 22, '34567890123'),
												('Daniela Moura', 30, '45678901234'),
												('Eduardo Silva', 40, '56789012345');

select * from pessoa;

UPDATE pessoa SET nome = 'João Gomes' WHERE id = 5;

DELETE FROM pessoa WHERE id = 3;