package modelo;

import java.time.LocalDateTime;

import excepciones.CuentaFechaCreacionPosteriorHoyException;
import excepciones.CuentaIncompletaException;

public class Cuenta {
	
	private Integer idCuenta;
	private String usuario;
	private LocalDateTime fechaCreacion;
	private String nombre;
	private String pass;
		
	private Cuenta(Integer idCuenta, String usuario, LocalDateTime fechaCreacion, String nombre, String pass) {
		this.idCuenta = idCuenta;
		this.usuario = usuario;
		this.fechaCreacion = fechaCreacion;
		this.nombre = nombre;
		this.pass = pass;
	}
	
	public static Cuenta instancia(Integer idCuenta, String usuario, LocalDateTime fechaCreacion, String nombre, String pass) throws CuentaIncompletaException, CuentaFechaCreacionPosteriorHoyException {
		if(usuario.isEmpty() || nombre.isEmpty() || pass.isEmpty()) {
			throw new CuentaIncompletaException();
		}
		if(fechaCreacion.isAfter(LocalDateTime.now().plusDays(1).withHour(0).withMinute(0))){
			throw new CuentaFechaCreacionPosteriorHoyException();
		}
		
		return new Cuenta(idCuenta,usuario,fechaCreacion,nombre,pass);
	}
	
	public Integer getIdCuenta() {
		return idCuenta;
	}
	public String getUsuario() {
		return usuario;
	}
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPass() {
		return pass;
	}
	
	

}
