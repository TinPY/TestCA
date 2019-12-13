package hadesboundaries.DataIT;

import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;
import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import modelo.Cuenta;
import modelo.Curso;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import testboundaries.TestBoundariesApplication;
import testboundaries.data.entidades.CursoEntidad;
import testboundaries.data.persistencia.implementacionCRUD.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
public class ConsultarInscripcionesPorIdCuentaRepositorioTest {

    @Autowired
    private CrearCuentaRepositorioCRUDImplementacion crearCuentaRepositorioCRUDImplementacion;

    @Autowired
    private CrearCursoRepositorioCRUDImplementacion crearCursoRepositorioCRUDImplementacion;

    @Autowired
    private ConsultarInscripcionesPorIdCuentaRepositorioCRUDImplementacion consultarInscripcionesPorIdCuentaRepositorioCRUDImplementacion;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarInscripcionesPorIdCuentaAntes.sql")
    //@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarInscripcionesPorIdCuentaDespues.sql")
    public void ConsultarInscripcionesPorIdCuenta_IdCuentaExisteYTieneCursosInscriptos_DevuelveLista() throws CuentaFechaCreacionPosteriorHoyException, CuentaIncompletaException, CursoIncompletoException {

        // Crear Cuenta
        crearCuentaRepositorioCRUDImplementacion.persist(Cuenta.instancia(1,"martinpy",LocalDateTime.now().minusDays(3),"Martin PY","asdasd"));
        crearCuentaRepositorioCRUDImplementacion.persist(Cuenta.instancia(2,"felipem",LocalDateTime.now().minusDays(5),"Felipe Medina","qweqwe"));
        crearCuentaRepositorioCRUDImplementacion.persist(Cuenta.instancia(3,"sofiao",LocalDateTime.now().minusDays(5),"Sofia Ortiz","zxczxc"));

        // Crear Curso
        crearCursoRepositorioCRUDImplementacion.persist(Curso.instancia(1,"Algoritmos",factoryCuentasCursoAlgoritmos(),LocalDateTime.now().plusDays(10),80));
        crearCursoRepositorioCRUDImplementacion.persist(Curso.instancia(2,"Base de Datos",factoryCuentasCursoBaseDeDatos(),LocalDateTime.now().plusDays(25),125));

        // Consultar Inscripciones por IdCuenta
        List<Curso> listaCursos = (List<Curso>) consultarInscripcionesPorIdCuentaRepositorioCRUDImplementacion.findByInscriptos_IdCuenta(1);
//        List<Curso> listaCursos = (List<Curso>) consultarInscripcionesPorIdCuentaRepositorioCRUDImplementacion.findByInscriptos_IdCuenta(2);
//        List<Curso> listaCursos = (List<Curso>) consultarInscripcionesPorIdCuentaRepositorioCRUDImplementacion.findByInscriptos_IdCuenta(3);

        Assertions.assertEquals(2,listaCursos.size());
//        Assertions.assertEquals(2,listaCursos.size());
//        Assertions.assertEquals(1,listaCursos.size());

    }


    private List<Cuenta> factoryCuentasCursoAlgoritmos(){
        List<Cuenta> listaCuentas = new ArrayList<>();
        try {
            listaCuentas.add(Cuenta.instancia(1,"martinpy",LocalDateTime.now().minusDays(3),"Martin PY","asdasd"));
            listaCuentas.add(Cuenta.instancia(2,"felipem",LocalDateTime.now().minusDays(5),"Felipe Medina","qweqwe"));
            listaCuentas.add(Cuenta.instancia(3,"sofiao",LocalDateTime.now().minusDays(5),"Sofia Ortiz","zxczxc"));
        } catch (CuentaIncompletaException e) {
            e.printStackTrace();
        } catch (CuentaFechaCreacionPosteriorHoyException e) {
            e.printStackTrace();
        }
        return listaCuentas;
    }

    private List<Cuenta> factoryCuentasCursoBaseDeDatos(){
        List<Cuenta> listaCuentas = new ArrayList<>();
        try {
            listaCuentas.add(Cuenta.instancia(1,"martinpy",LocalDateTime.now().minusDays(3),"Martin PY","asdasd"));
            listaCuentas.add(Cuenta.instancia(2,"felipem",LocalDateTime.now().minusDays(5),"Felipe Medina","qweqwe"));
        } catch (CuentaIncompletaException e) {
            e.printStackTrace();
        } catch (CuentaFechaCreacionPosteriorHoyException e) {
            e.printStackTrace();
        }
        return listaCuentas;
    }


}
