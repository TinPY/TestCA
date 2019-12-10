package inputs;

import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import modelo.Curso;

public interface CrearCursoInput {

    boolean CrearCurso(Curso curso) throws CursoIncompletoException, CursoFechaLimiteAnteriorException;
}
