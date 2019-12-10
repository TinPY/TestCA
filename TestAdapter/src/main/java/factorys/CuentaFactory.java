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

    public static CuentaDTO mapeoCoreDTO(Cuenta cuenta){
        if(cuenta != null){
            CuentaDTO cuentaDTO = new CuentaDTO(cuenta.getIdCuenta(),cuenta.getUsuario(),cuenta.getFechaCreacion(),cuenta.getNombre(),cuenta.getPass());
            return cuentaDTO;
        }
        return null;
    }


}
