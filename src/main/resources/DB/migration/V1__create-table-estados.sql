CREATE TABLE estados (
	id INT PRIMARY KEY,
	nome VARCHAR(50),
	sigla CHAR(2),
	INDEX idx_estados_sigla (sigla)
);

INSERT INTO estados (id, nome, sigla) VALUES (11, 'Rondônia', 'RO');
INSERT INTO estados (id, nome, sigla) VALUES (12, 'Acre', 'AC');
INSERT INTO estados (id, nome, sigla) VALUES (13, 'Amazonas', 'AM');
INSERT INTO estados (id, nome, sigla) VALUES (14, 'Roraima', 'RR');
INSERT INTO estados (id, nome, sigla) VALUES (15, 'Pará', 'PA');
INSERT INTO estados (id, nome, sigla) VALUES (16, 'Amapá', 'AP');
INSERT INTO estados (id, nome, sigla) VALUES (17, 'Tocantins', 'TO');
INSERT INTO estados (id, nome, sigla) VALUES (21, 'Maranhão', 'MA');
INSERT INTO estados (id, nome, sigla) VALUES (22, 'Piauí', 'PI');
INSERT INTO estados (id, nome, sigla) VALUES (23, 'Ceará', 'CE');
INSERT INTO estados (id, nome, sigla) VALUES (24, 'Rio Grande do Norte', 'RN');
INSERT INTO estados (id, nome, sigla) VALUES (25, 'Paraíba', 'PB');
INSERT INTO estados (id, nome, sigla) VALUES (26, 'Pernambuco', 'PE');
INSERT INTO estados (id, nome, sigla) VALUES (27, 'Alagoas', 'AL');
INSERT INTO estados (id, nome, sigla) VALUES (28, 'Sergipe', 'SE');
INSERT INTO estados (id, nome, sigla) VALUES (29, 'Bahia', 'BA');
INSERT INTO estados (id, nome, sigla) VALUES (31, 'Minas Gerais', 'MG');
INSERT INTO estados (id, nome, sigla) VALUES (32, 'Espírito Santo', 'ES');
INSERT INTO estados (id, nome, sigla) VALUES (33, 'Rio de Janeiro', 'RJ');
INSERT INTO estados (id, nome, sigla) VALUES (35, 'São Paulo', 'SP');
INSERT INTO estados (id, nome, sigla) VALUES (41, 'Paraná', 'PR');
INSERT INTO estados (id, nome, sigla) VALUES (42, 'Santa Catarina', 'SC');
INSERT INTO estados (id, nome, sigla) VALUES (43, 'Rio Grande do Sul', 'RS');
INSERT INTO estados (id, nome, sigla) VALUES (50, 'Mato Grosso do Sul', 'MS');
INSERT INTO estados (id, nome, sigla) VALUES (51, 'Mato Grosso', 'MT');
INSERT INTO estados (id, nome, sigla) VALUES (52, 'Goiás', 'GO');
INSERT INTO estados (id, nome, sigla) VALUES (53, 'Distrito Federal', 'DF');