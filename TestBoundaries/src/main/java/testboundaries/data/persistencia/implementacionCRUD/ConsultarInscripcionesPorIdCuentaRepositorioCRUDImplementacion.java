package testboundaries.data.persistencia.implementacionCRUD;

import modelo.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IRepositorioConsultarInscripcionesPorIdCuenta;
import testboundaries.data.mapeadores.CursoMapeador;
import testboundaries.data.persistencia.IConsultarInscripcionesPorIdCuentaRepositorioCRUD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ConsultarInscripcionesPorIdCuentaRepositorioCRUDImplementacion implements IRepositorioConsultarInscripcionesPorIdCuenta {

    @Autowired
    private IConsultarInscripcionesPorIdCuentaRepositorioCRUD iConsultarInscripcionesPorIdCuentaRepositorioCRUD;

    @Override
    public Collection<Curso> findByInscriptos_IdCuenta(Integer idCuenta) {

        List<Curso> listaCurso = new ArrayList<>();

        iConsultarInscripcionesPorIdCuentaRepositorioCRUD.findByInscriptos_idCuenta(idCuenta).forEach( c -> listaCurso.add(CursoMapeador.mapearEntidadCore(c)));

        return listaCurso;

    }
}
