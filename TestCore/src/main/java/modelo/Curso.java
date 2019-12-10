package modelo;

import java.time.LocalDateTime;
import java.util.Collection;

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
	
	public static Curso instancia(Integer idCurso, String titulo, Collection<Cuenta> inscriptos, LocalDateTime fechaLimiteInscripcion,Integer puntos) throws CursoIncompletoException {
		if(titulo.isEmpty() || inscriptos == null || fechaLimiteInscripcion == null ) {
			throw new CursoIncompletoException();
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
}
