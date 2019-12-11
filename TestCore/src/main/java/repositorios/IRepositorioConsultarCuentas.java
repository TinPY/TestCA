package repositorios;

import modelo.Cuenta;

import java.util.Collection;

public interface IRepositorioConsultarCuentas {

    Collection<Cuenta> findAll();

}
