package casosUso;

import excepciones.*;
import mockito.MockitoExtension;
import modelo.Cuenta;
import modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorios.IRepositorioConsultarCuentaPorId;
import repositorios.IRepositorioConsultarCursoPorId;
import repositorios.IRepositorioConsultarInscripcionesPorIdCuenta;
import repositorios.IRepositorioEditarCurso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InscribirseCursoCasoUsoTest  {

    @Mock
    IRepositorioConsultarCursoPorId iRepositorioConsultarCursoPorId;

    @Mock
    IRepositorioConsultarCuentaPorId iRepositorioConsultarCuentaPorId;

    @Mock
    IRepositorioConsultarInscripcionesPorIdCuenta iRepositorioConsultarInscripcionesPorIdCuenta;

    @Mock
    IRepositorioEditarCurso iRepositorioEditarCurso;

    @Test
    public void inscribirEnCurso_TodoCorrectoNoEstaInscriptoFechaDisponiblePassCorrecta_DevuelveVerdadero() throws CursoIncompletoException, CuentaFechaCreacionPosteriorHoyException, CuentaIncompletaException, InscripcionACursoFechaLimiteVencidaException, InscripcionACursoExistenteException, UpdateCursoException, PassIncorrectaException {

        Curso cursoAInscribir = Curso.instancia(100,"Algoritmos",new ArrayList<>(), LocalDateTime.now(),100);
        Cuenta cuentaAInscribir = Cuenta.instancia(1,"martinpy",LocalDateTime.now(),"Martin PY","asdasd");

        when(iRepositorioConsultarCursoPorId.findByIdCurso(100)).thenReturn(cursoAInscribir);
        when(iRepositorioConsultarCuentaPorId.findByIdCuenta(1)).thenReturn(cuentaAInscribir);
        when(iRepositorioConsultarInscripcionesPorIdCuenta.findByInscriptos_IdCuenta(1)).thenReturn(factoryCursosInscriptos());
        when(iRepositorioEditarCurso.update(cursoAInscribir)).thenReturn(true);

        InscribirEnCursoCasoUso inscribirEnCursoCasoUso = new InscribirEnCursoCasoUso(
                iRepositorioConsultarCursoPorId,
                iRepositorioConsultarCuentaPorId,
                iRepositorioConsultarInscripcionesPorIdCuenta,
                iRepositorioEditarCurso);

        inscribirEnCursoCasoUso.InscribirEnCurso(100,1,"asdasd");

    }

    @Test
    public void inscribirEnCurso_YaEstaInscriptoFechaDisponiblePassCorrecta_ArrojaYaEstaInscriptoException() throws CursoIncompletoException, CuentaFechaCreacionPosteriorHoyException, CuentaIncompletaException, InscripcionACursoFechaLimiteVencidaException, InscripcionACursoExistenteException, UpdateCursoException, PassIncorrectaException {
        Curso cursoAInscribir = Curso.instancia(1,"Base de Datos",new ArrayList<>(),LocalDateTime.now().plusDays(10),125);
        Cuenta cuentaAInscribir = Cuenta.instancia(1,"martinpy",LocalDateTime.now(),"Martin PY","asdasd");

        when(iRepositorioConsultarCursoPorId.findByIdCurso(1)).thenReturn(cursoAInscribir);
        when(iRepositorioConsultarCuentaPorId.findByIdCuenta(1)).thenReturn(cuentaAInscribir);
        when(iRepositorioConsultarInscripcionesPorIdCuenta.findByInscriptos_IdCuenta(1)).thenReturn(factoryCursosInscriptos());
        when(iRepositorioEditarCurso.update(cursoAInscribir)).thenReturn(true);

        InscribirEnCursoCasoUso inscribirEnCursoCasoUso = new InscribirEnCursoCasoUso(
                iRepositorioConsultarCursoPorId,
                iRepositorioConsultarCuentaPorId,
                iRepositorioConsultarInscripcionesPorIdCuenta,
                iRepositorioEditarCurso);

        //inscribirEnCursoCasoUso.InscribirEnCurso(cursoAInscribir,cuentaAInscribir,"asdasd");

        Assertions.assertThrows(InscripcionACursoExistenteException.class, () -> inscribirEnCursoCasoUso.InscribirEnCurso(1,1,"asdasd"));
    }

    @Test
    public void inscribirEnCurso_NoEstaInscriptoFechaVencidaPassCorrecta_DevuelveFalso() throws CursoIncompletoException, CuentaFechaCreacionPosteriorHoyException, CuentaIncompletaException, InscripcionACursoFechaLimiteVencidaException, InscripcionACursoExistenteException, UpdateCursoException, PassIncorrectaException {
        Curso cursoAInscribir = Curso.instancia(100,"Algoritmos",new ArrayList<>(), LocalDateTime.now().minusDays(20),100);
        Cuenta cuentaAInscribir = Cuenta.instancia(1,"martinpy",LocalDateTime.now(),"Martin PY","asdasd");

        when(iRepositorioConsultarCursoPorId.findByIdCurso(100)).thenReturn(cursoAInscribir);
        when(iRepositorioConsultarCuentaPorId.findByIdCuenta(1)).thenReturn(cuentaAInscribir);
        when(iRepositorioConsultarInscripcionesPorIdCuenta.findByInscriptos_IdCuenta(1)).thenReturn(factoryCursosInscriptos());
        when(iRepositorioEditarCurso.update(cursoAInscribir)).thenReturn(true);

        InscribirEnCursoCasoUso inscribirEnCursoCasoUso = new InscribirEnCursoCasoUso(
                iRepositorioConsultarCursoPorId,
                iRepositorioConsultarCuentaPorId,
                iRepositorioConsultarInscripcionesPorIdCuenta,
                iRepositorioEditarCurso);

        //inscribirEnCursoCasoUso.InscribirEnCurso(cursoAInscribir,cuentaAInscribir,"asdasd");

        Assertions.assertThrows(InscripcionACursoFechaLimiteVencidaException.class, () -> inscribirEnCursoCasoUso.InscribirEnCurso(100,1,"asdasd"));
    }


    @Test
    public void inscribirEnCurso_NoEstaInscriptoFechaDisponiblePassIncorrecta_ArrojaPassIncorrectaException() throws CursoIncompletoException, CuentaFechaCreacionPosteriorHoyException, CuentaIncompletaException {

        Curso cursoAInscribir = Curso.instancia(100,"Algoritmos",new ArrayList<>(), LocalDateTime.now(),100);
        Cuenta cuentaAInscribir = Cuenta.instancia(1,"martinpy",LocalDateTime.now(),"Martin PY","asdasd");

        when(iRepositorioConsultarCursoPorId.findByIdCurso(100)).thenReturn(cursoAInscribir);
        when(iRepositorioConsultarCuentaPorId.findByIdCuenta(1)).thenReturn(cuentaAInscribir);
        when(iRepositorioConsultarInscripcionesPorIdCuenta.findByInscriptos_IdCuenta(1)).thenReturn(factoryCursosInscriptos());
        when(iRepositorioEditarCurso.update(cursoAInscribir)).thenReturn(true);

        InscribirEnCursoCasoUso inscribirEnCursoCasoUso = new InscribirEnCursoCasoUso(
                iRepositorioConsultarCursoPorId,
                iRepositorioConsultarCuentaPorId,
                iRepositorioConsultarInscripcionesPorIdCuenta,
                iRepositorioEditarCurso);

        Assertions.assertThrows(PassIncorrectaException.class, () -> inscribirEnCursoCasoUso.InscribirEnCurso(100,1,"QWEQWE"));

    }

    public Collection<Curso> factoryCursosInscriptos(){

        List<Curso> listaCursos = new ArrayList<>();
        try {
            listaCursos.add(Curso.instancia(1,"Base de Datos",new ArrayList<>(),LocalDateTime.now().plusDays(10),125));
            listaCursos.add(Curso.instancia(2,"Informatica Aplicada",new ArrayList<>(),LocalDateTime.now().plusDays(15),85));
            listaCursos.add(Curso.instancia(3,"Ingenieria de Software",new ArrayList<>(),LocalDateTime.now().plusDays(20),90));
        } catch (CursoIncompletoException e) {
            e.printStackTrace();
        }

        return listaCursos;

    }

}
