package inputs;

import excepciones.InscripcionACursoExistenteException;
import excepciones.InscripcionACursoFechaLimiteVencidaException;
import excepciones.PassIncorrectaException;
import excepciones.UpdateCursoException;
import modelo.Cuenta;
import modelo.Curso;

public interface InscribirEnCursoInput {

    boolean InscribirEnCurso(Curso curso, Cuenta cuenta, String pass) throws
            InscripcionACursoExistenteException,
            InscripcionACursoFechaLimiteVencidaException,
            PassIncorrectaException,
            UpdateCursoException;

}
