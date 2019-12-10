package hadesboundaries.DataIT;

import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;
import modelo.Curso;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import testboundaries.TestBoundariesApplication;
import testboundaries.data.persistencia.implementacionCRUD.CrearCursoRepositorioCRUDImplementacion;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
public class CrearCursoRepositorioTest {

    @Autowired
    private CrearCursoRepositorioCRUDImplementacion crearCursoRepositorioCRUDImplementacion;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/CrearCursoDespues.sql")
    public void CrearCurso_DatosCorrectos_CreaCorrectamente() throws CursoFechaLimiteAnteriorException, CursoIncompletoException {

        Curso Curso = modelo.Curso.instancia(1,"Informatica",new ArrayList<>(),LocalDateTime.now(),50);
        Assertions.assertTrue(crearCursoRepositorioCRUDImplementacion.persist(Curso));
    }
}
