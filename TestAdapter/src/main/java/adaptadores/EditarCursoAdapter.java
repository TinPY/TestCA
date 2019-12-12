package adaptadores;

import dto.CursoDTO;
import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.UpdateCursoException;
import excepciones.UpdateCursoFechaLimiteAnteriorException;
import factorys.CursoFactory;
import inputs.EditarCursoInput;
import modelo.Curso;

public class EditarCursoAdapter {

    private EditarCursoInput editarCursoInput;

    public EditarCursoAdapter(EditarCursoInput editarCursoInput) {
        this.editarCursoInput = editarCursoInput;
    }

    public CursoDTO EditarCurso(CursoDTO cursoDTO) throws UpdateCursoException, CursoFechaLimiteAnteriorException, UpdateCursoFechaLimiteAnteriorException {
        Curso curso = this.editarCursoInput.EditarCurso(CursoFactory.mapeoDTOCore(cursoDTO));
        return CursoFactory.mapeoCoreDTO(curso);
    }
}
