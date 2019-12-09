package testboundaries.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import testboundaries.data.persistencia.implementacionCRUD.CrearCuentaRepositorioCRUDImplementacion;

@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Bean
    public CrearCuentaRepositorioCRUDImplementacion crearCuentaRepositorioCRUDImplementacion() {
        return new CrearCuentaRepositorioCRUDImplementacion();
    }



}
