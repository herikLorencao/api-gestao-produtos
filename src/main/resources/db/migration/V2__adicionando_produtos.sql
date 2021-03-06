CREATE TABLE IF NOT EXISTS produtos
(
    codigo            SERIAL PRIMARY KEY,
    data_fabricacao   DATE,
    data_validade     DATE,
    descricao         VARCHAR(255) NOT NULL,
    situacao          VARCHAR(7),
    fornecedor_codigo BIGINT CONSTRAINT fk_fornecedor REFERENCES fornecedores
);

INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 1', 'ATIVO', 1);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 2', 'ATIVO', 2);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 3', 'ATIVO', 3);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 4', 'ATIVO', 4);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 5', 'ATIVO', 5);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 6', 'ATIVO', 6);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 7', 'ATIVO', 7);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 8', 'ATIVO', 8);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 9', 'ATIVO', 9);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 10', 'ATIVO', 10);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 11', 'ATIVO', 11);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 12', 'ATIVO', 12);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 13', 'ATIVO', 13);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 14', 'ATIVO', 14);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 15', 'ATIVO', 15);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 16', 'ATIVO', 16);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 17', 'ATIVO', 17);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 18', 'ATIVO', 18);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 19', 'ATIVO', 19);
INSERT INTO produtos(data_fabricacao, data_validade, descricao, situacao, fornecedor_codigo) VALUES('2021-12-08', '2029-12-08', 'Produto 20', 'ATIVO', 20);
