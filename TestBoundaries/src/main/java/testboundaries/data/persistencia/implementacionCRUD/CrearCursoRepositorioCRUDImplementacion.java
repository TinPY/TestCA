package testboundaries.data.persistencia.implementacionCRUD;

import modelo.Cuenta;
import modelo.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IRepositorioCrearCuenta;
import repositorios.IRepositorioCrearCurso;
import testboundaries.data.mapeadores.CuentaMapeador;
import testboundaries.data.mapeadores.CursoMapeador;
import testboundaries.data.persistencia.ICrearCuentaRepositorioCRUD;
import testboundaries.data.persistencia.ICrearCursoRepositorioCRUD;

@Service
public class CrearCursoRepositorioCRUDImplementacion implements IRepositorioCrearCurso {

    @Autowired
    ICrearCursoRepositorioCRUD iCrearCursoRepositorioCRUD;

    @Override
    public boolean persist(Curso curso) {
        if(this.iCrearCursoRepositorioCRUD.save(CursoMapeador.mapearCoreEntidad(curso)) != null){
            return true;
        }
        return false;
    }
}
