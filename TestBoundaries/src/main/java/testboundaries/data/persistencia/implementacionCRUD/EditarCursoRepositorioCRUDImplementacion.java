package testboundaries.data.persistencia.implementacionCRUD;

import modelo.Cuenta;
import modelo.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.IRepositorioEditarCuenta;
import repositorios.IRepositorioEditarCurso;
import testboundaries.data.mapeadores.CuentaMapeador;
import testboundaries.data.mapeadores.CursoMapeador;
import testboundaries.data.persistencia.IEditarCuentaRepositorioCRUD;
import testboundaries.data.persistencia.IEditarCursoRepositorioCRUD;

@Service
public class EditarCursoRepositorioCRUDImplementacion implements IRepositorioEditarCurso {

    @Autowired
    IEditarCursoRepositorioCRUD iEditarCursoRepositorioCRUD;

    @Override
    public boolean update(Curso curso) {
        if(this.iEditarCursoRepositorioCRUD.save(CursoMapeador.mapearCoreEntidad(curso)) != null){
            return true;
        }
        return false;
    }
}
