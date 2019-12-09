package modelo;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import excepciones.CuentaIncompletaException;

public class CuentaTest {

    @Test
    public void instanciaCuenta_DatosCompletos_InstanciaCorrecto() throws CuentaIncompletaException  {

        Cuenta cuenta = Cuenta.instancia(1, "martinpy", LocalDateTime.now(), "Tincho", "asdasd");
        Assertions.assertNotNull(cuenta);
    }

    @Test
    public void instanciaCuenta_datosIncompletos_ArrojaExcepcion(){

        Assertions.assertThrows(CuentaIncompletaException.class, () -> Cuenta.instancia(1,"",LocalDateTime.now(),"",""));

    }

	
}
