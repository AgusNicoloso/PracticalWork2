create database ahorcado;
use ahorcado;

create table palabras(
    id_palabra int auto_increment,
    palabra varchar(50),
    constraint pk_id_palabra primary key (id_palabra),
    constraint unq_palabra unique (palabra)
);

create table ganadores(
    id_ganadores int auto_increment,
    fecha date,
    nombre varchar(50),
    palabraganadora varchar(50),
    constraint pk_id_ganadores primary key (id_ganadores)
);

INSERT INTO palabras (palabra) values ('jbdc') , ('builder') , ('factory') , ('hilos') , ('maven') , ('java') , ('strategy');
