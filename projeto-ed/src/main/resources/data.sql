drop database if exists eddb;
create database if not exists eddb;
use eddb;

insert into status_grupo(nome) values('Pastorais'); 
insert into status_grupo(nome) values('Grupos'); 
insert into status_grupo(nome) values('Movimentos');
	
insert into grupo(nome, status_grupo_id) values('Pastoral da criança',  1);
insert into grupo(nome, status_grupo_id) values('Pastoral da saúde',  1);
insert into grupo(nome, status_grupo_id) values('Pastoral da educação',  1);
insert into grupo(nome, status_grupo_id) values('Pastoral da juventude',  1);
insert into grupo(nome, status_grupo_id) values('Pastoral da comunicação',  1);
insert into grupo(nome, status_grupo_id) values('Pastoral da sobriedade',  1);
insert into grupo(nome, status_grupo_id) values('Pastoral do menor',  1);
insert into grupo(nome, status_grupo_id) values('Pastoral da liturgia',  1);
insert into grupo(nome, status_grupo_id) values('Pastoral da catequese',  1);
insert into grupo(nome, status_grupo_id) values('Pastoral da familiar',  1);
insert into grupo(nome, status_grupo_id) values('Pastoral da carcerária',  1);

insert into grupo(nome, status_grupo_id) values('Encontro de Casais com Cristo',  2);
insert into grupo(nome, status_grupo_id) values('Apostolado da Oração',  2);
insert into grupo(nome, status_grupo_id) values('Renovação Carismática Católica',  2);
insert into grupo(nome, status_grupo_id) values('Mãe Rainha',  2);
insert into grupo(nome, status_grupo_id) values('Terço dos Homens',  2);

insert into grupo(nome, status_grupo_id) values('Comunidade Canção Nova',  3);
insert into grupo(nome, status_grupo_id) values('Oração Paroquiais',  3);
	
insert into endereco(logradouro, numero, cidade, uf, cep, complemento) values 
	('Qr 12 Casa 3', '3', 'Brasília', 'DF', '12345678', 'Casa Própria'),
	('Qr 12 Casa 1', '9', 'Lago Sul', 'DF', '12345618', 'Pousada'),
	('Qr 12 Casa 5', '5', 'Santa Maria', 'DF', '12345658', 'Casa Alugada'),
	('Qr 12 Casa 6', '6', 'Ceilândia', 'DF', '12345668', 'Apartamento Próprio');
	
insert into complemento_integrante(nome_Mae, celular_Mae, nome_Pai, celular_Pai, observacao, medicamento_utilizado, alergia) values
	('Maria', '12345678', 'Marcelo', '12345678', 'Nenhuma', 'Nenhum', 'Nenhum'),
	('Sivirina', '12345678', 'Cezar', '12345678', 'Vida que segue', 'Nenhum', 'Nenhum'),
	('Não conheçe', '12345678', 'Luiz', '12345678', 'Sou mais forte ainda', 'Pilulas para resfriado', 'Espiro Forte'),
	('Marcia', '12345678', 'Não conheçe', '12345678', 'Sou forte', 'Creme esfoliante', 'Coçeria de Pele');
	
insert into integrante(celular, email, idade, nome, endereco_id, complemento_id) values
	('12345678', 'Jhonatan@gmail.com', 15, 'Jhonatan', 1, 1),
	('12345678', 'Paulo@gmail.com', 13, 'Paulo', 2, 2),
	('12345678', 'Douglas@gmail.com', 16, 'Douglas', 3, 3),
	('12345678', 'Lucas@gmail.com', 32, 'Lucas', 4, 4);