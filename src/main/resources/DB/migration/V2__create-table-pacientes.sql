create table pacientes (

    id bigint auto_increment primary key,
    guia int not null,
    registro varchar(30) not null unique,
    categoria varchar(2) not null,
    solicitacao varchar(50) not null,
    data_cadastro varchar(10) not null,
    data_nascimento varchar(10) not null,
    nome varchar(100) not null,
    sexo varchar(10) not null,
    cpf varchar(14) not null unique,
    nome_mae varchar(100) not null,
    nome_pai varchar(100) not null,
    telefone varchar(20) not null
);