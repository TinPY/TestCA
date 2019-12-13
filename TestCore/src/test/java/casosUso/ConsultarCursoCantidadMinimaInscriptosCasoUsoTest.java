package casosUso;

import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;
import excepciones.CursoIncompletoException;
import mockito.MockitoExtension;
import modelo.Cuenta;
import modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorios.IRepositorioConsultarCursos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCursoCantidadMinimaInscriptosCasoUsoTest {

    @Mock
    IRepositorioConsultarCursos iRepositorioConsultarCursos;

    @Test
    public void ConsultarCursoCantidadMinimaInscriptos_ExistenCursosConInscriptos_DevuelveCurso(){

        when(iRepositorioConsultarCursos.findAll()).thenReturn(factoryCursos());

        ConsultarCursoCantidadMinimaInscriptosCasoUso consultarCursoCantidadMinimaInscriptosCasoUso = new ConsultarCursoCantidadMinimaInscriptosCasoUso(iRepositorioConsultarCursos);

        Curso curso = consultarCursoCantidadMinimaInscriptosCasoUso.ConsultarCursoCantidadMinimaInscriptos();

        System.out.println(curso.getTitulo());

        Assertions.assertTrue(curso.getTitulo().equals("Base de Datos"));
        Assertions.assertEquals(1,curso.getInscriptos().size());

    }

    List<Curso> factoryCursos(){

        List<Curso> cursos = new ArrayList<>();
        try {
            cursos.add(Curso.instancia(1,"Algoritmos",factoryInscriptosAlgorimos(),LocalDateTime.now().plusDays(10),85));
            cursos.add(Curso.instancia(2,"Base de Datos",factoryInscriptosBaseDeDatos(),LocalDateTime.now().plusDays(3),72));
        } catch (CursoIncompletoException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursos;
    }


    List<Cuenta> factoryInscriptosAlgorimos(){

        List<Cuenta> cuentas = new ArrayList<>();
        try {
            cuentas.add(Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Martin Paez Yañez","qweqwe"));
            cuentas.add(Cuenta.instancia(1,"felipem", LocalDateTime.now(),"Felipe Medina","zxcxzc"));
        } catch (CuentaIncompletaException e) {
            e.printStackTrace();
        } catch (CuentaFechaCreacionPosteriorHoyException e) {
            e.printStackTrace();
        }

        return cuentas;

    }

    List<Cuenta> factoryInscriptosBaseDeDatos(){

        List<Cuenta> cuentas = new ArrayList<>();
        try {
            cuentas.add(Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Martin Paez Yañez","qweqwe"));
        } catch (CuentaIncompletaException e) {
            e.printStackTrace();
        } catch (CuentaFechaCreacionPosteriorHoyException e) {
            e.printStackTrace();
        }

        return cuentas;

    }

}
