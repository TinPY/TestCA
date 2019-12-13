package casosUso;

import inputs.ConsultarPuntosPorIdCuentaInput;
import modelo.Curso;
import repositorios.IRepositorioConsultarInscripcionesPorIdCuenta;

import java.util.List;

public class ConsultarPuntosPorIdCuentaCasoUso implements ConsultarPuntosPorIdCuentaInput {

    private IRepositorioConsultarInscripcionesPorIdCuenta iRepositorioConsultarInscripcionesPorIdCuenta;

    public ConsultarPuntosPorIdCuentaCasoUso(
            IRepositorioConsultarInscripcionesPorIdCuenta iRepositorioConsultarInscripcionesPorIdCuenta) {
        this.iRepositorioConsultarInscripcionesPorIdCuenta = iRepositorioConsultarInscripcionesPorIdCuenta;
    }


    @Override
    public Integer ConsultarPuntosPorIdCuenta(Integer idCuenta) {

        List<Curso> listaCursos = (List<Curso>) this.iRepositorioConsultarInscripcionesPorIdCuenta.findByInscriptos_IdCuenta(idCuenta);

        int puntos = 0;

        for (Curso curso : listaCursos) {
            puntos += curso.getPuntos();
        }

        return puntos;

    }
}
