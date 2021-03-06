CREATE TABLE IF NOT EXISTS fornecedores
(
    codigo    SERIAL PRIMARY KEY ,
    cnpj      CHAR(18) CONSTRAINT cnpj_unique UNIQUE,
    descricao VARCHAR(255),
    situacao  VARCHAR(7)
);

INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('12.528.708/0001-07', 'Fornecedor 1', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('04.128.563/0001-10', 'Fornecedor 2', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('10.338.320/0001-00', 'Fornecedor 3', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('02.217.319/0001-07', 'Fornecedor 4', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('17.167.396/0001-69', 'Fornecedor 5', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('71.208.516/0001-74', 'Fornecedor 6', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('05.878.397/0001-32', 'Fornecedor 7', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('60.537.263/0001-66', 'Fornecedor 8', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('61.079.117/0001-05', 'Fornecedor 9', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('11.721.921/0001-60', 'Fornecedor 10', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('16.811.931/0001-00', 'Fornecedor 11', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('02.783.423/0001-50', 'Fornecedor 12', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('08.364.948/0001-38', 'Fornecedor 13', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('07.526.557/0001-00', 'Fornecedor 14', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('12.648.266/0001-24', 'Fornecedor 15', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('33.050.071/0001-58', 'Fornecedor 16', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('09.288.252/0001-32', 'Fornecedor 17', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('16.590.234/0001-76', 'Fornecedor 18', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('75.315.333/0001-09', 'Fornecedor 19', 'ATIVO');
INSERT INTO fornecedores(cnpj, descricao, situacao) VALUES ('04.032.433/0001-80', 'Fornecedor 20', 'ATIVO');
