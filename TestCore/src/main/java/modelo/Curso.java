package modelo;

import java.time.LocalDateTime;
import java.util.Collection;

import excepciones.CursoFechaLimiteAnteriorException;
import excepciones.CursoIncompletoException;

public class Curso {

	private Integer idCurso;
	private String titulo;
	private Collection<Cuenta> inscriptos;
	private LocalDateTime fechaLimiteInscripcion;
	private Integer puntos;
	
	private Curso(Integer idCurso, String titulo, Collection<Cuenta> inscriptos, LocalDateTime fechaLimiteInscripcion, Integer puntos) {
		super();
		this.idCurso = idCurso;
		this.titulo = titulo;
		this.inscriptos = inscriptos;
		this.fechaLimiteInscripcion = fechaLimiteInscripcion;
		this.puntos = puntos;
	}
	
	public static Curso instancia(Integer idCurso, String titulo, Collection<Cuenta> inscriptos, LocalDateTime fechaLimiteInscripcion,Integer puntos)
			throws CursoIncompletoException, CursoFechaLimiteAnteriorException {
		if(titulo.isEmpty() || inscriptos == null || fechaLimiteInscripcion == null || puntos == null ) {
			throw new CursoIncompletoException();
		}

		if(fechaLimiteInscripcion.isBefore(LocalDateTime.now().withHour(0).withMinute(0))){
			throw new CursoFechaLimiteAnteriorException();
		}

		// cantidad de inscriptos > 0
		if(inscriptos != null){
			inscriptos.clear();
		}
		
		return new Curso(idCurso,titulo,inscriptos,fechaLimiteInscripcion,puntos);
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public String getTitulo() {
		return titulo;
	}

	public Collection<Cuenta> getInscriptos() {
		return inscriptos;
	}

	public LocalDateTime getFechaLimiteInscripcion() {
		return fechaLimiteInscripcion;
	}

	public Integer getPuntos() {
		return puntos;
	}

	public void modificarDatos(Curso cursoDatosNuevos) {
		this.idCurso = cursoDatosNuevos.getIdCurso();
		this.fechaLimiteInscripcion = cursoDatosNuevos.getFechaLimiteInscripcion();
		this.titulo = cursoDatosNuevos.getTitulo();
		this.inscriptos = cursoDatosNuevos.getInscriptos();
		this.puntos = cursoDatosNuevos.getPuntos();
	}
}
