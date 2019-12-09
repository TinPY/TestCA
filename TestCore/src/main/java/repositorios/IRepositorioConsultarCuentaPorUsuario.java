package repositorios;

import modelo.Cuenta;

public interface IRepositorioConsultarCuentaPorUsuario {

    Cuenta findByUsuario(String usuario);

}
