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
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (5,'2020-06-08 10:15:01+03',2241.23,'TRANSFERENCIA', 'Beltrano',1);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (6,'2021-04-01 12:12:04+03',25173.09,'TRANSFERENCIA', 'Ronnyscley',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (7,'2020-01-08 10:15:01+03',100.00,'DEPOSITO', null,3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (8,'2017-03-28 10:15:01+03',-1000.00,'SAQUE', null,4);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (9,'2015-05-01 10:15:01+03',670.00,'TRANSFERENCIA', 'Alan',5);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (10,'2022-05-11 10:15:01+03',3241.65,'TRANSFERENCIA', 'Marcos',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (11, '2021-01-27 10:15:01+03',-3000.87,'SAQUE', null,5);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (12,'2022-09-13 10:15:01+03',876.47,'TRANSFERENCIA', 'Tatiana',2);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (13,'2020-01-08 10:15:01+03',654.84,'DEPOSITO', null,4);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (14,'2020-01-08 10:15:01+03',654.84,'TRANSFERENCIA', 'Leandro',4);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (15,'2020-01-08 10:15:01+03',654.84,'TRANSFERENCIA', 'Marcos',3);
INSERT INTO transferencia (id,data_transferencia, valor, tipo, nome_operador_transacao, conta_id) VALUES (16,'2020-01-08 10:15:01+03',654.84,'DEPOSITO', null,3);




