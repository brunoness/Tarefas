create table cliente (
    id serial primary key,
    nome varchar(100) not null,
    idade integer not null,
    cpf varchar(11) unique not null);

insert into cliente (nome, idade, cpf) values
('ana clara', 28, '12345678901'),
('bruno lima', 35, '23456789012'),
('eduardo silva', 40, '56789012345'),
('daniela moura', 30, '45678901234'),
('carlos souza', 22, '34567890123');

select * from cliente;

create table produto (
    id serial primary key,
    nome varchar(100) not null,
    preco numeric(10, 2) not null);

create table venda (
    id serial primary key,
    cliente_id integer not null,
    data_venda date not null default current_date,
    foreign key (cliente_id) references cliente(id));

create table venda_produto (
    venda_id integer not null,
    produto_id integer not null,
    quantidade integer not null default 1,
    primary key (venda_id, produto_id),
    foreign key (venda_id) references venda(id),
    foreign key (produto_id) references produto(id));

insert into produto (nome, preco) values 
('notebook', 3500.00),
('mouse', 50.00),
('teclado', 120.00),
('monitor', 899.90),
('cadeira gamer', 1499.00);

select * from produto;

insert into venda (cliente_id) values 
(1), -- venda 1
(2), -- venda 2
(3), -- venda 3
(5); -- venda 4

select * from venda;

-- venda 1: notebook e mouse
insert into venda_produto (venda_id, produto_id, quantidade) values 
(1, 1, 1), -- notebook
(1, 2, 1); -- mouse

-- venda 2: teclado e monitor
insert into venda_produto (venda_id, produto_id, quantidade) values 
(2, 3, 2), -- teclado 
(2, 4, 1); -- monitor

-- venda 3:
insert into venda_produto (venda_id, produto_id, quantidade) values (3, 5, 1);

--venda 4: todos os produtos
insert into venda_produto (venda_id, produto_id, quantidade) values
(4,1,3),
(4,2,1),
(4,3,1),
(4,4,2),
(4,5,6);

select * from venda_produto;

-- com JOIN
SELECT 
    v.id AS venda_id,
    c.nome AS cliente,
    pr.nome AS produto,
    vp.quantidade,
    pr.preco,
    (vp.quantidade * pr.preco) AS total_item
FROM venda v
JOIN cliente c ON v.cliente_id = c.id
JOIN venda_produto vp ON v.id = vp.venda_id
JOIN produto pr ON vp.produto_id = pr.id;

--com WHERE
SELECT 
    v.id AS venda_id,
    c.nome AS cliente,
    pr.nome AS produto,
    vp.quantidade,
    pr.preco,
    (vp.quantidade * pr.preco) AS total_item
FROM venda v, cliente c, venda_produto vp, produto pr
WHERE v.cliente_id = c.id
  AND v.id = vp.venda_id
  AND pr.id = vp.produto_id;