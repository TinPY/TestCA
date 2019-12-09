package modelo;

import java.time.LocalDateTime;
import java.util.Collection;

import excepciones.CursoIncompletoException;

public class Curso {

	private Integer idCurso;
	private String titulo;
	private Collection<Cuenta> inscriptos;
	private LocalDateTime fechaLimiteInscripcion;
	
	private Curso(Integer idCurso, String titulo, Collection<Cuenta> inscriptos, LocalDateTime fechaLimiteInscripcion) {
		super();
		this.idCurso = idCurso;
		this.titulo = titulo;
		this.inscriptos = inscriptos;
		this.fechaLimiteInscripcion = fechaLimiteInscripcion;
	}
	
	public static Curso instancia(Integer idCurso, String titulo, Collection<Cuenta> inscriptos, LocalDateTime fechaLimiteInscripcion) throws CursoIncompletoException {
		if(titulo.isEmpty() || inscriptos == null || fechaLimiteInscripcion == null ) {
			throw new CursoIncompletoException();
		}
		
		return new Curso(idCurso,titulo,inscriptos,fechaLimiteInscripcion);
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
	

	
	
	
	
}
