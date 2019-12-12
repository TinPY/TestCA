package adaptadores;

import dto.CursoDTO;
import factorys.CursoFactory;
import inputs.ConsultarCursosInput;
import modelo.Curso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ConsultarCursosAdapter {

    private ConsultarCursosInput consultarCursosInput;

    public ConsultarCursosAdapter(ConsultarCursosInput consultarCursosInput) {
        this.consultarCursosInput = consultarCursosInput;
    }

    public Collection<CursoDTO> ConsultarCursos(){

        List<CursoDTO> listaCursos = new ArrayList<>();

        consultarCursosInput.ConsultarCursos().forEach(c -> listaCursos.add(CursoFactory.mapeoCoreDTO(c)));

        return listaCursos;

    }

}
