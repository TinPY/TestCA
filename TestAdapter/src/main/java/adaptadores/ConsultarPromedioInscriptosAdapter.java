package adaptadores;

import inputs.ConsultarPromedioInscriptosInput;

public class ConsultarPromedioInscriptosAdapter {

    private ConsultarPromedioInscriptosInput consultarPromedioInscriptosInput;

    public ConsultarPromedioInscriptosAdapter(ConsultarPromedioInscriptosInput consultarPromedioInscriptosInput) {
        this.consultarPromedioInscriptosInput = consultarPromedioInscriptosInput;
    }

    public Float ConsultarPromedioInscriptos(){
        return this.consultarPromedioInscriptosInput.ConsultarPromedioInscriptos();
    }
}
