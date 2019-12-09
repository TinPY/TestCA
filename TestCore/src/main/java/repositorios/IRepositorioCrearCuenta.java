package repositorios;

import modelo.Cuenta;

public interface IRepositorioCrearCuenta {

    boolean persist(Cuenta cuenta);

}
