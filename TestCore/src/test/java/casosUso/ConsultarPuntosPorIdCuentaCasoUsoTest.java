package casosUso;

import excepciones.CursoIncompletoException;
import mockito.MockitoExtension;
import modelo.Curso;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorios.IRepositorioConsultarCursos;
import repositorios.IRepositorioConsultarInscripcionesPorIdCuenta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarPuntosPorIdCuentaCasoUsoTest {

    @Mock
    IRepositorioConsultarInscripcionesPorIdCuenta iRepositorioConsultarInscripcionesPorIdCuenta;

    @Test
    public void ConsultarPuntosPorIdCuenta_ExistenInscripciones_DevuelvePuntos(){

        when(iRepositorioConsultarInscripcionesPorIdCuenta.findByInscriptos_IdCuenta(1)).thenReturn(factoryCursos());

        ConsultarPuntosPorIdCuentaCasoUso consultarPuntosPorIdCuentaCasoUso = new ConsultarPuntosPorIdCuentaCasoUso(iRepositorioConsultarInscripcionesPorIdCuenta);

        Assertions.assertEquals(155,consultarPuntosPorIdCuentaCasoUso.ConsultarPuntosPorIdCuenta(1).intValue());

    }

    @Test
    public void ConsultarPuntosPorIdCuenta_NoHayInscripciones_DevuelveCero(){
        when(iRepositorioConsultarInscripcionesPorIdCuenta.findByInscriptos_IdCuenta(1)).thenReturn(new ArrayList<>());

        ConsultarPuntosPorIdCuentaCasoUso consultarPuntosPorIdCuentaCasoUso = new ConsultarPuntosPorIdCuentaCasoUso(iRepositorioConsultarInscripcionesPorIdCuenta);

        Assertions.assertEquals(0,consultarPuntosPorIdCuentaCasoUso.ConsultarPuntosPorIdCuenta(1).intValue());
    }

    List<Curso> factoryCursos(){

        List<Curso> cursos = new ArrayList<>();
        try {
            cursos.add(Curso.instancia(1,"Algoritmos",new ArrayList<>(),LocalDateTime.now().plusDays(10),85));
            cursos.add(Curso.instancia(2,"Base de Datos",new ArrayList<>(),LocalDateTime.now().plusDays(3),70));
        } catch (CursoIncompletoException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursos;



    }

}
