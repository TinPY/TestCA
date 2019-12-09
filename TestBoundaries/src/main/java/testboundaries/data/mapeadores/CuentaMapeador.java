package testboundaries.data.mapeadores;

import excepciones.CuentaIncompletaException;
import testboundaries.data.entidades.CuentaEntidad;
import modelo.Cuenta;

public class CuentaMapeador {

    public static CuentaEntidad mapearCoreEntidad(Cuenta cuenta){

        CuentaEntidad cuentaEntidad = new CuentaEntidad(cuenta.getIdCuenta(),cuenta.getUsuario(),cuenta.getFechaCreacion(),cuenta.getNombre(),cuenta.getPass());
        return cuentaEntidad;

    }

    public static Cuenta mapeoDataCore(CuentaEntidad cuentaEntidad) {

        try {
            return Cuenta.instancia(cuentaEntidad.getIdCuenta(),cuentaEntidad.getUsuario(),cuentaEntidad.getFechaCreacion(),cuentaEntidad.getNombre(),cuentaEntidad.getPass());
        } catch (CuentaIncompletaException e) {
            e.printStackTrace();
            return null;
        }


    }
}
