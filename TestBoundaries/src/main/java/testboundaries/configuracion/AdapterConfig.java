package testboundaries.configuracion;

import adaptadores.ConsultarCuentasAdapter;
import adaptadores.CrearCuentaAdapter;
import adaptadores.CrearCursoAdapter;
import adaptadores.EditarCuentaAdapter;
import inputs.ConsultarCuentasInput;
import inputs.CrearCuentaInput;
import inputs.CrearCursoInput;
import inputs.EditarCuentaInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdapterConfig {

    @Autowired
    private CrearCuentaInput crearCuentaInput;

    @Autowired
    private CrearCursoInput crearCursoInput;

    @Autowired
    private EditarCuentaInput editarCuentaInput;

    @Autowired
    private ConsultarCuentasInput consultarCuentasInput;

    @Bean
    public CrearCuentaAdapter crearCuentaAdapter() {
        return new CrearCuentaAdapter(crearCuentaInput);
    }

    @Bean
    public CrearCursoAdapter crearCursoAdapter() {return new CrearCursoAdapter(crearCursoInput);}

    @Bean
    public EditarCuentaAdapter editarCuentaAdapter() {return new EditarCuentaAdapter(editarCuentaInput);}

    @Bean
    public ConsultarCuentasAdapter consultarCuentasAdapter(){return new ConsultarCuentasAdapter(consultarCuentasInput);}

}
