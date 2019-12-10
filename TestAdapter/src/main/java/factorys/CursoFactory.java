package factorys;

import dto.CursoDTO;
import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import modelo.Cuenta;
import modelo.Curso;

import java.util.*;

public class CursoFactory {

    public static Curso mapeoDTOaCore(CursoDTO cursoDTO) {

        List<Cuenta> inscriptosCore = new ArrayList<>();
        cursoDTO.inscriptos.forEach( i -> inscriptosCore.add(CuentaFactory.mapeoDTOaCore(i)));

        if (cursoDTO != null) {
            try {
                return Curso.instancia(cursoDTO.idCurso,cursoDTO.titulo,inscriptosCore,cursoDTO.fechaLimiteInscripcion,cursoDTO.puntos);
            } catch (CursoIncompletoException e) {
                e.printStackTrace();
            } catch (CursoFechaLimiteAnteriorException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
