package testboundaries.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import testboundaries.data.persistencia.implementacionCRUD.CrearCuentaRepositorioCRUDImplementacion;
import testboundaries.data.persistencia.implementacionCRUD.CrearCursoRepositorioCRUDImplementacion;

@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Bean
    public CrearCuentaRepositorioCRUDImplementacion crearCuentaRepositorioCRUDImplementacion() {
        return new CrearCuentaRepositorioCRUDImplementacion();
    }

    @Bean
    public CrearCursoRepositorioCRUDImplementacion crearCursoRepositorioCRUDImplementacion() {
        return new CrearCursoRepositorioCRUDImplementacion();
    }


}
