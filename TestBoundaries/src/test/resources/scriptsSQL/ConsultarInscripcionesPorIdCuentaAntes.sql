delete from inscripciones;
delete from cuenta;
delete from curso;

ALTER SEQUENCE cuenta_idcuenta_seq RESTART WITH 1;
ALTER SEQUENCE curso_idcurso_seq RESTART WITH 1;