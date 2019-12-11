package hadesboundaries.DataIT;

import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;
import modelo.Cuenta;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import testboundaries.TestBoundariesApplication;
import testboundaries.data.persistencia.implementacionCRUD.CrearCuentaRepositorioCRUDImplementacion;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
public class CrearCuentaRepositorioTest {

    @Autowired
    private CrearCuentaRepositorioCRUDImplementacion crearCuentaRepositorioCRUDImplementacion;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/CrearCuentaDespues.sql")
    public void CrearCuenta_DatosCorrectos_CreaCorrectamente() throws CuentaIncompletaException, CuentaFechaCreacionPosteriorHoyException {

        Cuenta cuenta = Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Tincho","asdasd");
        Assertions.assertTrue(crearCuentaRepositorioCRUDImplementacion.persist(cuenta));
    }
}
