package testboundaries.data.mapeadores;

import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import modelo.Cuenta;
import modelo.Curso;
import testboundaries.data.entidades.CuentaEntidad;
import testboundaries.data.entidades.CursoEntidad;

import java.util.ArrayList;
import java.util.List;

public class CursoMapeador {

    public static CursoEntidad mapearCoreEntidad(Curso curso){

        List<CuentaEntidad> inscriptosEntidades = new ArrayList<>();
        curso.getInscriptos().forEach( i -> inscriptosEntidades.add(CuentaMapeador.mapearCoreEntidad(i)));

        CursoEntidad CursoEntidad = new CursoEntidad(curso.getIdCurso(),curso.getTitulo(),inscriptosEntidades,curso.getFechaLimiteInscripcion(),curso.getPuntos());
        return CursoEntidad;

    }

    public static Curso mapearEntidadCore(CursoEntidad cursoEntidad) {

        List<Cuenta> inscriptosCore = new ArrayList<>();
        cursoEntidad.getInscriptos().forEach(i-> inscriptosCore.add(CuentaMapeador.mapearEntidadCore(i)));

        try {
            return Curso.instancia(cursoEntidad.getIdCurso(),cursoEntidad.getTitulo(),inscriptosCore,cursoEntidad.getFechaLimiteInscripcion(),cursoEntidad.getPuntos());
        } catch (CursoIncompletoException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}
