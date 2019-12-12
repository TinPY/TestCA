package inputs;

import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.UpdateCursoException;
import excepciones.UpdateCursoFechaLimiteAnteriorException;
import modelo.Curso;

public interface EditarCursoInput {

    Curso EditarCurso(Curso cursoDatosNuevos) throws UpdateCursoException, CursoFechaLimiteAnteriorException, UpdateCursoFechaLimiteAnteriorException;
}
