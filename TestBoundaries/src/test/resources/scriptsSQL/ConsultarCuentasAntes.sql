delete from cuenta;
ALTER SEQUENCE cuenta_idcuenta_seq RESTART WITH 1;
insert into cuenta values (nextval('cuenta_idcuenta_seq'),'2019-12-1 17:19:00.219','Felipe Medina','asdasd','felipem');
insert into cuenta values (nextval('cuenta_idcuenta_seq'),'2019-12-10 14:59:50.859','Tincho','qweqwe','martinpy');