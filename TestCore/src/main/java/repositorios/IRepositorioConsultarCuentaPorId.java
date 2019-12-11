package repositorios;

import modelo.Cuenta;

public interface IRepositorioConsultarCuentaPorId {

    Cuenta findByIdCuenta(Integer idCuenta);
}
