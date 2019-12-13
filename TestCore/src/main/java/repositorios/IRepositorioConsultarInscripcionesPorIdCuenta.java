package repositorios;

import modelo.Curso;

import java.util.Collection;

public interface IRepositorioConsultarInscripcionesPorIdCuenta {

    Collection<Curso> findByInscriptos_IdCuenta(Integer idCuenta);
}
