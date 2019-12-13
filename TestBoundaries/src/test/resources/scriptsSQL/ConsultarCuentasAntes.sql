delete from inscripciones;
delete from curso;
delete from cuenta;

ALTER SEQUENCE curso_idcurso_seq RESTART WITH 1;
ALTER SEQUENCE cuenta_idcuenta_seq RESTART WITH 1;

insert into cuenta values (nextval('cuenta_idcuenta_seq'),'2019-12-1 17:19:00.219','Felipe Medina','asdasd','felipem');
insert into cuenta values (nextval('cuenta_idcuenta_seq'),'2019-12-10 14:59:50.859','Tincho','qweqwe','martinpy');