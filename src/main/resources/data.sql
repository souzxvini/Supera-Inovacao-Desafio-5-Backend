CREATE TABLE conta
(
    id_conta IDENTITY NOT NULL PRIMARY KEY,
    nome_responsavel VARCHAR(50) NOT NULL
);


CREATE TABLE transferencia
(
    id IDENTITY NOT NULL PRIMARY KEY,
    data_transferencia TIMESTAMP WITH TIME ZONE NOT NULL,
    valor NUMERIC (20,2) NOT NULL,
    tipo VARCHAR(15) NOT NULL,
    nome_operador_transacao VARCHAR (50),
    conta_id INT NOT NULL,

        CONSTRAINT FK_CONTA
        FOREIGN KEY (conta_id)
        REFERENCES conta(id_conta)
);

INSERT INTO conta (id_conta, nome_responsavel) VALUES (1,'Fulano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (2,'Sicrano');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (3,'Vinicius');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (4,'Vitor');
INSERT INTO conta (id_conta, nome_responsavel) VALUES (5,'Alex');

INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (1,'2019-01-01 12:00:00+03',30895.46,'DEPOSITO', null, 1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (2,'2019-02-03 09:53:27+03',12.24,'DEPOSITO', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (3,'2019-05-04 08:12:45+03',-500.50,'SAQUE', null,1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (4,'2019-08-07 08:12:45+03',-530.50,'SAQUE', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-06-08 10:15:01+03',2241.23,'TRANSFERENCIA', 'Beltrano da Silva',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley Moreira Santos',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7,'2020-01-08 10:15:45+03',100.00,'DEPOSITO', null,3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8,'2017-03-28 10:15:01+03',-1000.00,'SAQUE', null,4);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9,'2015-05-01 10:15:58+03',670.00,'TRANSFERENCIA', 'Alan Oliveira Neto',5);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10,'2022-05-11 09:58:26+03',3241.65,'TRANSFERENCIA', 'Marcos Silva',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (11, '2021-01-27 10:15:01+03',-3000.87,'SAQUE', null,5);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (12,'2022-09-13 18:22:11+03',876.47,'TRANSFERENCIA', 'Tatiana Foster',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (13,'2010-01-22 10:15:01+03',654.84,'DEPOSITO', null,4);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (14,'2012-01-18 15:12:25+03',-333.99,'TRANSFERENCIA', 'Leandro de Almeida',4);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (15,'2016-07-16 10:15:01+03',654.84,'TRANSFERENCIA', 'Marcos Silva',3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (16,'2020-06-12 22:59:23+03',-2155.00,'DEPOSITO', null,3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (17,'2021-10-01 10:55:48+03',768.90,'TRANSFERENCIA', 'Leandro de Almeida',3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (18,'2020-12-06 01:15:01+03',10750.00,'DEPOSITO', null,4);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (19,'2018-01-26 03:21:01+03',12500.00,'TRANSFERENCIA', 'Beltrano da Silva',3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (20,'2019-07-29 20:27:01+03',-28000.00,'DEPOSITO', null,5);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (21,'2017-04-22 23:49:01+03',3000.00,'SAQUE', null,3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (22,'2020-05-08 19:15:01+03',-204.00,'TRANSFERENCIA', 'Beltrano da Silva',3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (23,'2020-03-25 11:25:01+03',654.84,'DEPOSITO', null,1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (24,'2022-11-08 12:00:41+03',99.00,'TRANSFERENCIA', 'Leandro de Almeida',3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (25,'2021-12-13 18:50:01+03',-220.98,'SAQUE', null,1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (26,'2020-09-22 19:15:51+03',560.89,'DEPOSITO', null,2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (27,'2022-06-21 17:47:01+03',120.00,'SAQUE', null,3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (28,'2021-07-08 04:01:01+03',-1500.90,'TRANSFERENCIA', 'Alan Oliveira Neto',3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (29,'2020-01-15 09:15:23+03',-750.87,'DEPOSITO', null,5);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (30,'2019-04-03 14:04:09+03',999.90,'TRANSFERENCIA', 'Tatiana Foster',3);




