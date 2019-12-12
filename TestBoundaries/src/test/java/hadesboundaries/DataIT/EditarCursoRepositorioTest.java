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
import testboundaries.data.persistencia.implementacionCRUD.ConsultarCursoPorIdRepositorioCRUDImplementacion;
import testboundaries.data.persistencia.implementacionCRUD.CrearCursoRepositorioCRUDImplementacion;
import testboundaries.data.persistencia.implementacionCRUD.EditarCursoRepositorioCRUDImplementacion;

import java.time.LocalDateTime;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={TestBoundariesApplication.class})
public class EditarCursoRepositorioTest {

    @Autowired
    private EditarCursoRepositorioCRUDImplementacion editarCursoRepositorioCRUDImplementacion;

    @Autowired
    private ConsultarCursoPorIdRepositorioCRUDImplementacion consultarCursoPorIdRepositorioCRUDImplementacion;

    @Autowired
    private CrearCursoRepositorioCRUDImplementacion crearCursoRepositorioCRUDImplementacion;

    @Test
    @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:scriptsSQL/EditarCursoAntes.sql")
    //@Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:scriptsSQL/EditarCursoDespues.sql")
    public void EditarCurso_DatosCorrectos_EditaCorrectamente() throws CursoFechaLimiteAnteriorException, CursoIncompletoException {

        // Crear Dato
        crearCursoRepositorioCRUDImplementacion.persist(Curso.instancia(1,"Programacion I",new ArrayList<>(),LocalDateTime.now().plusDays(10),80));

        // Modificacion
        Curso CursoDatosNuevos = Curso.instancia(1,"Desarrollo Software",new ArrayList<>(),LocalDateTime.now(),225);

        Assertions.assertTrue(editarCursoRepositorioCRUDImplementacion.update(CursoDatosNuevos));

        // Verificacion
        Curso cursoModificado = consultarCursoPorIdRepositorioCRUDImplementacion.findByIdCurso(CursoDatosNuevos.getIdCurso());

        Assertions.assertEquals(225,cursoModificado.getPuntos().intValue());

    }
}
