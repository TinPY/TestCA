package casosUso;

import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import mockito.MockitoExtension;
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
public class ConsultarCursosCasoUsoTest {

    @Mock
    IRepositorioConsultarCursos iRepositorioConsultarCursos;

    @Test
    public void ConsultarCursos_ExistenCursos_DevuelveLista(){

        when(iRepositorioConsultarCursos.findAll()).thenReturn(factoryCursos());
        ConsultarCursosCasoUso consultarCursosCasoUso = new ConsultarCursosCasoUso(iRepositorioConsultarCursos);

        List<Curso> cursosConsultados = (List<Curso>) consultarCursosCasoUso.ConsultarCursos();
        Assertions.assertEquals(2,cursosConsultados.size());

    }

    List<Curso> factoryCursos(){

        List<Curso> cursos = new ArrayList<>();
        try {
            cursos.add(Curso.instancia(1,"Algoritmos",new ArrayList<>(),LocalDateTime.now().plusDays(10),85));
            cursos.add(Curso.instancia(2,"Arquitectura",new ArrayList<>(),LocalDateTime.now().plusDays(3),72));
        } catch (CursoIncompletoException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursos;



    }

}
