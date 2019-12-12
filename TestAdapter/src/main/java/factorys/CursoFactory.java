package factorys;

import dto.CuentaDTO;
import dto.CursoDTO;
import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import modelo.Cuenta;
import modelo.Curso;

import java.util.*;

public class CursoFactory {

    public static Curso mapeoDTOCore(CursoDTO cursoDTO) {

        List<Cuenta> inscriptosCore = new ArrayList<>();

        if (cursoDTO != null) {
            try {
                cursoDTO.inscriptos.forEach( i -> inscriptosCore.add(CuentaFactory.mapeoDTOaCore(i)));
                return Curso.instancia(cursoDTO.idCurso,cursoDTO.titulo,inscriptosCore,cursoDTO.fechaLimiteInscripcion,cursoDTO.puntos);
            } catch (CursoIncompletoException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static CursoDTO mapeoCoreDTO(Curso curso) {

        List<CuentaDTO> inscriptosDTO = new ArrayList<>();

        if(curso != null){
            curso.getInscriptos().forEach(i -> inscriptosDTO.add(CuentaFactory.mapeoCoreDTO(i)));
            return new CursoDTO(curso.getIdCurso(),curso.getTitulo(),inscriptosDTO,curso.getFechaLimiteInscripcion(),curso.getPuntos());
        }
        return null;
    }
}
