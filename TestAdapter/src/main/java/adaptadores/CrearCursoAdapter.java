package adaptadores;

import dto.CursoDTO;
import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import factorys.CuentaFactory;
import factorys.CursoFactory;
import inputs.CrearCursoInput;

public class CrearCursoAdapter {

    private CrearCursoInput crearCursoInput;

    public CrearCursoAdapter(CrearCursoInput crearCursoInput) {
        this.crearCursoInput = crearCursoInput;
    }

    public boolean CrearCurso(CursoDTO cursoDTO) throws CursoFechaLimiteAnteriorException, CursoIncompletoException {
        return this.crearCursoInput.CrearCurso(CursoFactory.mapeoDTOaCore(cursoDTO));
    }
}
