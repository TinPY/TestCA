delete from inscripciones;
delete from curso;
delete from cuenta;

ALTER SEQUENCE curso_idcurso_seq RESTART WITH 1;
ALTER SEQUENCE cuenta_idcuenta_seq RESTART WITH 1;

insert into cuenta values (1,'2019-12-1 17:19:00.219','Felipe Medina','asdasd','felipem');
insert into cuenta values (2,'2019-12-10 14:59:50.859','Tincho','qweqwe','martinpy');
insert into cuenta values (3,'2019-12-10 14:59:50.859','Javier','zxczxc','jruitti');
insert into cuenta values (4,'2019-12-10 14:59:50.859','Romina','poipoi','rvega');
insert into cuenta values (5,'2019-12-10 14:59:50.859','Rodrigo','lkjlkj','rabazan');
insert into cuenta values (6,'2019-12-10 14:59:50.859','German','mbnmnb','gtorres');

insert into curso values (1, '2019-12-19 20:00:00.000', 125, 'Algoritmos I');
insert into curso values (2, '2019-12-15 17:00:00.000', 75, 'Biologia II');

insert into inscripciones (idcuenta,idcurso) values (1,1);
insert into inscripciones (idcuenta,idcurso) values (2,1);
insert into inscripciones (idcuenta,idcurso) values (3,1);
insert into inscripciones (idcuenta,idcurso) values (4,1);
insert into inscripciones (idcuenta,idcurso) values (5,1);
insert into inscripciones (idcuenta,idcurso) values (6,1);

insert into inscripciones (idcuenta,idcurso) values (1,2);
insert into inscripciones (idcuenta,idcurso) values (4,2);
insert into inscripciones (idcuenta,idcurso) values (6,2);