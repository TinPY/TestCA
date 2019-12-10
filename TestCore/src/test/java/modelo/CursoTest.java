package modelo;

import excepciones.CuentaIncompletaException;
import excepciones.CursoIncompletoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CursoTest {

    @Test
    public void instanciaCurso_DatosCompletos_InstanciaCorrecto() throws CursoIncompletoException {

        Curso curso = Curso.instancia(1,"Informatica",factoryCuentas(),LocalDateTime.now(),95);
        Assertions.assertNotNull(curso);
    }

    @Test
    public void instanciaCurso_DatosIncompletos_ArrojaExcepcionCursoIncompleto(){
        Assertions.assertThrows(CursoIncompletoException.class, () -> Curso.instancia(1,"",factoryCuentas(),LocalDateTime.now(),95));
    }

    @Test
    public void instanciaCurso_ColeccionNula_ArrojaExcepcionCursoIncompleto(){
        Assertions.assertThrows(CursoIncompletoException.class, () -> Curso.instancia(1,"",null,LocalDateTime.now(),95));
    }


    private Collection<Cuenta> factoryCuentas(){
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
