package modelo;

import excepciones.CuentaIncompletaException;
import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CursoTest {

    @Test
    public void instanciaCurso_DatosCompletos_InstanciaCorrecto() throws CursoIncompletoException, CursoFechaLimiteAnteriorException {

        Curso curso = Curso.instancia(1,"Informatica",new HashSet<>(),LocalDateTime.now(),95);
        Assertions.assertNotNull(curso);
    }

    @Test
    public void instanciaCurso_DatosIncompletos_ArrojaExcepcionCursoIncompleto(){
        Assertions.assertThrows(CursoIncompletoException.class, () -> Curso.instancia(1,"",new HashSet<>(),LocalDateTime.now(),95));
    }

    @Test
    public void instanciaCurso_ColeccionNula_ArrojaExcepcionCursoIncompleto(){
        Assertions.assertThrows(CursoIncompletoException.class, () -> Curso.instancia(1,"Geografia",null,LocalDateTime.now(),95));
    }

    @Test
    public void instanciaCurso_ColeccionInscriptosConElementos_ColeccionVaciada() throws CursoFechaLimiteAnteriorException, CursoIncompletoException {
        Curso curso = Curso.instancia(1,"Algoritmos", factoryInscriptos(),LocalDateTime.now(),95);
        Assertions.assertNotNull(curso.getInscriptos());
        Assertions.assertEquals(0,curso.getInscriptos().size());
    }

    @Test
    public void instanciaCurso_fechaLimiteInferiorActual(){
        Assertions.assertThrows(CursoFechaLimiteAnteriorException.class,
                () -> Curso.instancia(1,"Historia",new HashSet<>(),LocalDateTime.now().minusDays(1),95)
        );
    }


    private Collection<Cuenta> factoryInscriptos(){
        Set<Cuenta> cuentas = new HashSet<>();
        try {
            cuentas.add(Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Tincho","asdasd"));
            cuentas.add(Cuenta.instancia(1,"felipem", LocalDateTime.now(),"Felipe Medina","qweqwe"));
        } catch (CuentaIncompletaException e) {
            e.printStackTrace();
        }
        return cuentas;

    }
}
