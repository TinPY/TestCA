package casosUso;

import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;
import mockito.MockitoExtension;
import modelo.Cuenta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import repositorios.IRepositorioConsultarCuentas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarCuentasCasoUsoTest {

    @Mock
    IRepositorioConsultarCuentas iRepositorioConsultarCuentas;

    @Test
    public void ConsultarCuentas_ExistenCuentas_DevuelveLista(){

        when(iRepositorioConsultarCuentas.findAll()).thenReturn(factoryCuentas());
        ConsultarCuentasCasoUso consultarCuentasCasoUso = new ConsultarCuentasCasoUso(iRepositorioConsultarCuentas);

        List<Cuenta> cuentasConsultadas = (List<Cuenta>) consultarCuentasCasoUso.ConsultarCuentas();
        Assertions.assertEquals(2,cuentasConsultadas.size());

    }

    List<Cuenta> factoryCuentas(){

        List<Cuenta> cuentas = new ArrayList<>();
        try {
            cuentas.add(Cuenta.instancia(1,"martinpy", LocalDateTime.now(),"Martin Paez Yañez","asdasd"));
            cuentas.add(Cuenta.instancia(1,"felipem", LocalDateTime.now(),"Felipe Medina","qweqwe"));
        } catch (CuentaIncompletaException e) {
            e.printStackTrace();
        } catch (CuentaFechaCreacionPosteriorHoyException e) {
            e.printStackTrace();
        }

        return cuentas;



    }

}
