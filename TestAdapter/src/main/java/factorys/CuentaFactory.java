package factorys;

import dto.CuentaDTO;
import excepciones.CuentaIncompletaException;
import modelo.Cuenta;

public class CuentaFactory {

    public static Cuenta mapeoDTOaCore(CuentaDTO cuentaDTO) {

        if (cuentaDTO != null) {
            try {
                return Cuenta.instancia(cuentaDTO.getIdCuenta(),cuentaDTO.getUsuario(),cuentaDTO.getFechaCreacion(),cuentaDTO.getNombre(),cuentaDTO.getPass());
            } catch (CuentaIncompletaException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
