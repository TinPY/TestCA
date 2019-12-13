package adaptadores;

import inputs.ConsultarCursoCantidadMaximaInscriptosInput;
import modelo.Curso;

public class ConsultarCursoCantidadMaximaInscriptosAdapter {

    private ConsultarCursoCantidadMaximaInscriptosInput consultarCursoCantidadMaximaInscriptosInput;

    public ConsultarCursoCantidadMaximaInscriptosAdapter(ConsultarCursoCantidadMaximaInscriptosInput consultarCursoCantidadMaximaInscriptosInput) {
        this.consultarCursoCantidadMaximaInscriptosInput = consultarCursoCantidadMaximaInscriptosInput;
    }

    public Curso ConsultarCursoCantidadMaximaInscriptos(){
        return this.consultarCursoCantidadMaximaInscriptosInput.ConsultarCursoCantidadMaximaInscriptos();
    }
}
