package testboundaries.configuracion;

import adaptadores.CrearCuentaAdapter;
import adaptadores.CrearCursoAdapter;
import inputs.CrearCuentaInput;
import inputs.CrearCursoInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    @Autowired
    private CrearCuentaInput crearCuentaInput;

    @Autowired
    private CrearCursoInput crearCursoInput;

    @Bean
    public CrearCuentaAdapter crearCuentaAdapter() {
        return new CrearCuentaAdapter(crearCuentaInput);
    }

    @Bean
    public CrearCursoAdapter crearCursoAdapter() {return new CrearCursoAdapter(crearCursoInput);}



}
