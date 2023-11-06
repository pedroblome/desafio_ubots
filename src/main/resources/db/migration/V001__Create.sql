-- Criação das tabelas
CREATE TABLE Time (
    id INT PRIMARY KEY,
    area VARCHAR(20)
);

CREATE TABLE Atendente (
    id INT PRIMARY KEY,
    nome VARCHAR(50),
    idTime INT,
    FOREIGN KEY (idTime) REFERENCES Time(id)
);

CREATE TABLE FilaSolicitacao (
    id INT PRIMARY KEY,
    idTime INT,
    FOREIGN KEY (idTime) REFERENCES Time(id)
);

CREATE TABLE Solicitacao (
    id INT PRIMARY KEY,
    assunto VARCHAR(255),
    idAtendente INT,
    idFilaSolicitacao INT,
    FOREIGN KEY (idAtendente) REFERENCES Atendente(id),
    FOREIGN KEY (idFilaSolicitacao) REFERENCES FilaSolicitacao(id)
);

-- População das tabelas
-- Populando a tabela Time
INSERT INTO Time (id, area) VALUES (1, 'CARTAO');
INSERT INTO Time (id, area) VALUES (2, 'EMPRESTIMO');
INSERT INTO Time (id, area) VALUES (3, 'OUTROS');

-- Populando a tabela Atendente
INSERT INTO Atendente (id, nome, idTime) VALUES (1, 'Atendente Cartoes', 1);
INSERT INTO Atendente (id, nome, idTime) VALUES (2, 'Atendente Emprestimo', 2);
INSERT INTO Atendente (id, nome, idTime) VALUES (3, 'Atendente Outros', 3);

-- Populando a tabela FilaSolicitacao
INSERT INTO FilaSolicitacao (id, idTime) VALUES (1, 1);
INSERT INTO FilaSolicitacao (id, idTime) VALUES (2, 2);
INSERT INTO FilaSolicitacao (id, idTime) VALUES (3, 3);

-- Populando a tabela Solicitacao com o campo "assunto"
-- Certifique-se de que as referências de chaves estrangeiras estejam corretas ao popular esta tabela.
INSERT INTO Solicitacao (id, assunto, idAtendente, idFilaSolicitacao) VALUES (1, 'Problemas com cartão', 1, 1);
INSERT INTO Solicitacao (id, assunto, idAtendente, idFilaSolicitacao) VALUES (2, 'Contratação de empréstimo', 2, 2);
INSERT INTO Solicitacao (id, assunto, idAtendente, idFilaSolicitacao) VALUES (3, 'Outros Assuntos', 3, 3);
