package hadesboundaries.DataIT;


import modelo.Cuenta;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import testboundaries.TestBoundariesApplication;
import testboundaries.data.persistencia.implementacionCRUD.ConsultarCuentasRepositorioCRUDImplementacion;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
public class ConsultarCuentasRepositorioTest {

    @Autowired
    ConsultarCuentasRepositorioCRUDImplementacion consultarCuentasRepositorioCRUDImplementacion;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCuentasAntes.sql")
    public void ConsultarCuentas_ExistenCuentas_DevuelveColeccion(){

        List<Cuenta> listaCuentas = (List<Cuenta>) consultarCuentasRepositorioCRUDImplementacion.findAll();

//        insert into cuenta values (nextval('cuenta_idcuenta_seq'),'2019-12-1 17:19:00.219','Felipe Medina','asdasd','felipem');
//        insert into cuenta values (nextval('cuenta_idcuenta_seq'),'2019-12-10 14:59:50.859','Tincho','qweqwe','martinpy');

        Assertions.assertEquals(2,listaCuentas.size());

    }

}
