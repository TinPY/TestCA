delete from inscripciones;
delete from curso;
delete from cuenta;

ALTER SEQUENCE curso_idcurso_seq RESTART WITH 1;
ALTER SEQUENCE cuenta_idcuenta_seq RESTART WITH 1;

insert into curso values (1, '2019-12-19 20:00:00.000', 250, 'Desarrollo Software');
insert into curso values (2, '2019-12-15 17:00:00.000', 105, 'Biologia II');