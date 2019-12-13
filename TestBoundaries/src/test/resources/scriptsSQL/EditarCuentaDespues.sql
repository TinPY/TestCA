delete from inscripciones;
delete from curso;
delete from cuenta;

ALTER SEQUENCE curso_idcurso_seq RESTART WITH 1;
ALTER SEQUENCE cuenta_idcuenta_seq RESTART WITH 1;

--ALTER SEQUENCE cuenta_idcuenta_seq RESTART WITH 1;