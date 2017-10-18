create table despesa(
	cod_despesa int not null primary key auto_increment,
    descricao varchar(50) not null,
    valor double not null,
    cod_responsavel int not null,
    tipo varchar(1) not null,
    FOREIGN KEY (cod_responsavel) REFERENCES usuario(nome_usuario)
)