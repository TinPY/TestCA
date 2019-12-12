package inputs;

import excepciones.UpdateCursoException;
import modelo.Curso;

public interface EditarCursoInput {

    Curso EditarCurso(Curso cursoDatosNuevos) throws UpdateCursoException;
}
