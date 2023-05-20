create table medicos (

    id bigint not null auto_increment primary key,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(20) not null,
    crm varchar(6) not null unique,
    especialidade varchar(100) not null,
    ativo tinyint default 1 not null
);