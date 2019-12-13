package adaptadores;

import inputs.ConsultarCursoCantidadMinimaInscriptosInput;
import modelo.Curso;

public class ConsultarCursoCantidadMinimaInscriptosAdapter {

    private ConsultarCursoCantidadMinimaInscriptosInput consultarCursoCantidadMinimaInscriptosInput;

    public ConsultarCursoCantidadMinimaInscriptosAdapter(ConsultarCursoCantidadMinimaInscriptosInput consultarCursoCantidadMinimaInscriptosInput) {
        this.consultarCursoCantidadMinimaInscriptosInput = consultarCursoCantidadMinimaInscriptosInput;
    }

    public Curso ConsultarCursoCantidadMinimaInscriptos(){
        return this.consultarCursoCantidadMinimaInscriptosInput.ConsultarCursoCantidadMinimaInscriptos();
    }
}
