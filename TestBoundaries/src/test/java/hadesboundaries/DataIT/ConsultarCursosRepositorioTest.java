package hadesboundaries.DataIT;


import modelo.Curso;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import testboundaries.TestBoundariesApplication;
import testboundaries.data.persistencia.implementacionCRUD.ConsultarCursosRepositorioCRUDImplementacion;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
public class ConsultarCursosRepositorioTest {

    @Autowired
    ConsultarCursosRepositorioCRUDImplementacion consultarCursosRepositorioCRUDImplementacion;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/ConsultarCursosAntes.sql")
    public void ConsultarCursos_ExistenCursos_DevuelveColeccion(){

        List<Curso> listaCursos = (List<Curso>) consultarCursosRepositorioCRUDImplementacion.findAll();

        Assertions.assertEquals(2,listaCursos.size());

    }

}
