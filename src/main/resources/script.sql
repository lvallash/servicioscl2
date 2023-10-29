create database Control2BD;

create table producto(
id int(11) NOT NULL AUTO_INCREMENT,
nombre varchar(40) NOT NULL,
descripcion varchar (60) not null,
cantidad int not NULL,
fechaVenc date,
  PRIMARY KEY (id)
);

insert into producto values (1, "leche", "leche descremada", 5, '2023-12-10 00:00:00'),
(2, "café", "café en polvo", 5, '2023-12-10 00:00:00'),
(3, "té", "té canela y clavo", 5, '2023-12-10 00:00:00'),
(4, "manzanilla", "té de manzanilla", 5, '2023-12-10 00:00:00'),
(5, "yogurt", "yogurt de fresa", 5, '2023-12-10 00:00:00');