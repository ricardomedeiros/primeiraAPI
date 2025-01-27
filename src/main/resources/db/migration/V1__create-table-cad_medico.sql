create table cad_medico(

  id serial,
  nome varchar(100) NOT NULL,
  email varchar(100) NOT NULL UNIQUE,
  crm varchar(6) NOT NULL UNIQUE,
  especialidade varchar(100) NOT NULL,
  logradouro varchar(100) NOT NULL,
  bairro varchar(100) NOT NULL,
  cep varchar(9) NOT NULL,
  cidade varchar(100) NOT NULL,
  uf varchar(2) NOT NULL,
  numero varchar(20),
  complemento varchar(100),

  primary key(id)
);