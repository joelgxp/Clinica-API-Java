create table ficha_medica (
    id bigint not null auto_increment primary key,
    id_paciente bigint not null,
    ladoesquerdo varchar(3) not null,
    ladodireito varchar(3) not null,
    correcao varchar(15) not null,
    examevalidade varchar(10) not null,
    complemento longtext,
    campo_visual_direito varchar(3) not null,
    campo_visual_esquerdo varchar(3) not null,
    conclusao varchar(10) not null
);