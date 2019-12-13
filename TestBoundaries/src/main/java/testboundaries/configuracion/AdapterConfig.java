package testboundaries.configuracion;

import adaptadores.*;
import inputs.*;
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

    @Autowired
    private ConsultarCursosInput consultarCursosInput;

    @Autowired
    private EditarCursoInput editarCursoInput;

    @Autowired
    private InscribirEnCursoInput inscribirEnCursoInput;

    @Autowired
    private ConsultarPuntosPorIdCuentaInput consultarPuntosPorIdCuentaInput;

    @Autowired
    private ConsultarPromedioInscriptosInput consultarPromedioInscriptosInput;

    @Autowired
    private ConsultarCursoCantidadMaximaInscriptosInput consultarCursoCantidadMaximaInscriptosInput;

    @Autowired
    private ConsultarCursoCantidadMinimaInscriptosInput consultarCursoCantidadMinimaInscriptosInput;

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

    @Bean
    public ConsultarCursosAdapter consultarCursosAdapter() {return new ConsultarCursosAdapter(consultarCursosInput);}

    @Bean
    public EditarCursoAdapter editarCursoAdapter() {return new EditarCursoAdapter(editarCursoInput);}

    @Bean
    public InscribirEnCursoAdapter inscribirEnCursoAdapter() {return new InscribirEnCursoAdapter(inscribirEnCursoInput);}

    @Bean
    public ConsultarPuntosPorIdCuentaAdapter consultarPuntosPorIdCuentaAdapter() {return new ConsultarPuntosPorIdCuentaAdapter(consultarPuntosPorIdCuentaInput);}

    @Bean
    public ConsultarPromedioInscriptosAdapter consultarPromedioInscriptosAdapter() {return new ConsultarPromedioInscriptosAdapter(consultarPromedioInscriptosInput);}

    @Bean
    public ConsultarCursoCantidadMaximaInscriptosAdapter consultarCursoCantidadMaximaInscriptosAdapter() {return new ConsultarCursoCantidadMaximaInscriptosAdapter(consultarCursoCantidadMaximaInscriptosInput);}

    @Bean
    public ConsultarCursoCantidadMinimaInscriptosAdapter consultarCursoCantidadMinimaInscriptosAdapter() {return new ConsultarCursoCantidadMinimaInscriptosAdapter(consultarCursoCantidadMinimaInscriptosInput);}

}
