package adaptadores;

import excepciones.InscripcionACursoExistenteException;
import excepciones.InscripcionACursoFechaLimiteVencidaException;
import excepciones.PassIncorrectaException;
import excepciones.UpdateCursoException;
import inputs.InscribirEnCursoInput;

public class InscribirEnCursoAdapter {

    private InscribirEnCursoInput inscribirEnCursoInput;

    public InscribirEnCursoAdapter(InscribirEnCursoInput inscribirEnCursoInput) {
        this.inscribirEnCursoInput = inscribirEnCursoInput;
    }

    public boolean InscribirEnCurso(Integer idCurso, Integer idCuenta, String pass) throws InscripcionACursoFechaLimiteVencidaException, InscripcionACursoExistenteException, UpdateCursoException, PassIncorrectaException {
        return this.inscribirEnCursoInput.InscribirEnCurso(idCurso,idCuenta,pass);
    }
}
