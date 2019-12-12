package testboundaries.data.persistencia.implementacionCRUD;

import modelo.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IRepositorioConsultarCursos;
import testboundaries.data.mapeadores.CursoMapeador;
import testboundaries.data.persistencia.IConsultarCursosCRUD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ConsultarCursosRepositorioCRUDImplementacion implements IRepositorioConsultarCursos {

    @Autowired
    IConsultarCursosCRUD iConsultarCursosCRUD;

    @Override
    public Collection<Curso> findAll() {

        List<Curso> cursos = new ArrayList<>();

        this.iConsultarCursosCRUD.findAll().forEach(c -> cursos.add(CursoMapeador.mapearEntidadCore(c)));

        return cursos;

    }
}
