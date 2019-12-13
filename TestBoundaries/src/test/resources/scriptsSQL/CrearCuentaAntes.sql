delete from inscripciones;
delete from curso;
delete from cuenta;

ALTER SEQUENCE curso_idcurso_seq RESTART WITH 1;
ALTER SEQUENCE cuenta_idcuenta_seq RESTART WITH 1;
--insert into cuenta values (1,'2019-12-10 14:59:50.859','Tincho','asdasd','martinpy');