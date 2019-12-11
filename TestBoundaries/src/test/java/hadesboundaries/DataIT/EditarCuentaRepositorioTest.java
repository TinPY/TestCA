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
import testboundaries.data.persistencia.implementacionCRUD.ConsultarCuentaPorUsuarioRepositorioCRUDImplementacion;
import testboundaries.data.persistencia.implementacionCRUD.EditarCuentaRepositorioCRUDImplementacion;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
public class EditarCuentaRepositorioTest {

    @Autowired
    private EditarCuentaRepositorioCRUDImplementacion editarCuentaRepositorioCRUDImplementacion;

    @Autowired
    private ConsultarCuentaPorUsuarioRepositorioCRUDImplementacion consultarCuentaPorUsuarioRepositorioCRUDImplementacion;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/EditarCuentaAntes.sql")
    //@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/EditarCuentaDespues.sql")
    public void EditarCuenta_DatosCorrectos_EditaCorrectamente() throws CuentaFechaCreacionPosteriorHoyException, CuentaIncompletaException {

        // DATOS ANTERIORES EN SQL
        //insert into cuenta values (1,'2019-12-10 14:59:50.859','Tincho','asdasd','martinpy');
        Cuenta cuentaDatosNuevos = Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Martin PY","qweqwe");

        Assertions.assertTrue(editarCuentaRepositorioCRUDImplementacion.update(cuentaDatosNuevos));

        //
        Cuenta cuentaModificada = consultarCuentaPorUsuarioRepositorioCRUDImplementacion.findByUsuario(cuentaDatosNuevos.getUsuario());

        Assertions.assertEquals("Martin PY",cuentaModificada.getNombre());

    }
}
