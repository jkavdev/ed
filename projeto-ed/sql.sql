    alter table grupo 
        drop 
        foreign key FKgq7i272i6560ee1xd7ni8qfpy
    
    alter table grupo_integrante 
        drop 
        foreign key FK9kr7iurbfdihqyxhm04cb1j3f
    
    alter table grupo_integrante 
        drop 
        foreign key FKll5l17672k69q3nd3drcniyv7
    
    alter table integrante 
        drop 
        foreign key FKkdfaived8rug20tdyhecwyo5s
    
    alter table integrante 
        drop 
        foreign key FKowxdmgti1y4ds91211fragf41
    
    drop table if exists complemento_integrante
    
    drop table if exists endereco
    
    drop table if exists grupo
    
    drop table if exists grupo_integrante
    
    drop table if exists integrante
    
    drop table if exists status_grupo
    
    create table complemento_integrante (
        id bigint not null auto_increment,
        celular_mae varchar(255),
        celular_pai varchar(255),
        nome_mae varchar(255),
        nome_pai varchar(255),
        observacao varchar(255),
        alergia varchar(255),
        medicamento_utilizado varchar(255),
        primary key (id)
    )
    
    create table endereco (
        id bigint not null auto_increment,
        cep varchar(255),
        cidade varchar(255),
        complemento varchar(255),
        logradouro varchar(255),
        numero varchar(255),
        uf varchar(255),
        primary key (id)
    )
    
    create table grupo (
        id bigint not null auto_increment,
        nome varchar(255),
        status_grupo_id bigint,
        primary key (id)
    )
    
    create table grupo_integrante (
        grupo_id bigint not null,
        integrante_id bigint not null,
        data_inclusao date,
        primary key (grupo_id, integrante_id)
    )
    
    create table integrante (
        id bigint not null auto_increment,
        celular varchar(255),
        email varchar(255),
        idade integer,
        nome varchar(255),
        complemento_id bigint,
        endereco_id bigint,
        primary key (id)
    )
    
    create table status_grupo (
        id bigint not null auto_increment,
        nome varchar(255),
        primary key (id)
    )
    
    alter table integrante 
        add constraint UK_bvanel3eccay23f5x3aj5201y unique (email)
    
    alter table grupo 
        add constraint FKgq7i272i6560ee1xd7ni8qfpy 
        foreign key (status_grupo_id) 
        references status_grupo (id)
    
    alter table grupo_integrante 
        add constraint FK9kr7iurbfdihqyxhm04cb1j3f 
        foreign key (grupo_id) 
        references grupo (id)
    
    alter table grupo_integrante 
        add constraint FKll5l17672k69q3nd3drcniyv7 
        foreign key (integrante_id) 
        references integrante (id)
    
    alter table integrante 
        add constraint FKkdfaived8rug20tdyhecwyo5s 
        foreign key (complemento_id) 
        references complemento_integrante (id)
    
    alter table integrante 
        add constraint FKowxdmgti1y4ds91211fragf41 
        foreign key (endereco_id) 
        references endereco (id)