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
public class ConsultarPromedioInscriptosCasoUsoTest {

    @Mock
    IRepositorioConsultarCursos iRepositorioConsultarCursos;

    @Test
    public void ConsultarPromedioInscriptos_ExistenCursosConInscriptos_DevuelvePromedioFloat(){

        when(iRepositorioConsultarCursos.findAll()).thenReturn(factoryCursos());

        ConsultarPromedioInscriptosCasoUso consultarPromedioInscriptosCasoUso = new ConsultarPromedioInscriptosCasoUso(iRepositorioConsultarCursos);

        Float promedio = consultarPromedioInscriptosCasoUso.ConsultarPromedioInscriptos();

        System.out.println(promedio);

        Assertions.assertTrue(promedio > 0);
        Assertions.assertEquals(Float.valueOf(1.5f) ,promedio);

    }

    @Test
    public void ConsultarPromedioInscriptos_CursosConListaVacia_DevuelvePromedioFloat(){

        when(iRepositorioConsultarCursos.findAll()).thenReturn(factoryCursos2());

        ConsultarPromedioInscriptosCasoUso consultarPromedioInscriptosCasoUso = new ConsultarPromedioInscriptosCasoUso(iRepositorioConsultarCursos);

        Float promedio = consultarPromedioInscriptosCasoUso.ConsultarPromedioInscriptos();

        System.out.println(promedio);

        Assertions.assertTrue(promedio > 0);
        Assertions.assertEquals(Float.valueOf(1f) ,promedio);


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

    List<Curso> factoryCursos2(){

        List<Curso> cursos = new ArrayList<>();
        try {
            cursos.add(Curso.instancia(1,"Algoritmos",factoryInscriptosAlgorimos(),LocalDateTime.now().plusDays(10),85));
            cursos.add(Curso.instancia(2,"Base de Datos",new ArrayList<>(),LocalDateTime.now().plusDays(3),72));
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
