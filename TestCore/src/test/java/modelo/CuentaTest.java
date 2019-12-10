package modelo;

import java.time.LocalDateTime;

import excepciones.CuentaFechaCreacionPosteriorHoyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import excepciones.CuentaIncompletaException;

public class CuentaTest {

    @Test
    public void instanciaCuenta_DatosCompletos_InstanciaCorrecto() throws CuentaIncompletaException, CuentaFechaCreacionPosteriorHoyException {

        Cuenta cuenta = Cuenta.instancia(1, "martinpy", LocalDateTime.now(), "Tincho", "asdasd");
        Assertions.assertNotNull(cuenta);
    }

    @Test
    public void instanciaCuenta_datosIncompletos_ArrojaExcepcion(){

        Assertions.assertThrows(CuentaIncompletaException.class, () -> Cuenta.instancia(1,"",LocalDateTime.now(),"",""));

    }

    @Test
    public void instanciaCuenta_fechaCreacionPosteriorAHoy_ArrojaExcepcion(){

        //Assertions.assertThrows(CuentaFechaCreacionPosteriorHoyException.class, () -> Cuenta.instancia(1,"felipem",LocalDateTime.now().withHour(23),"Felipito","asdasd"));
        Assertions.assertThrows(CuentaFechaCreacionPosteriorHoyException.class, () -> Cuenta.instancia(1,"felipem",LocalDateTime.now().plusDays(1),"Felipito","asdasd"));


    }

	
}
