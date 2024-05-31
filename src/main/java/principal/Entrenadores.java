package principal;

import java.util.Date;

public class Entrenadores {
	private String nombreEntrenador = null;
	private String apellidoEntrenador = null;
	private String numeroEntrenador = null;
	private String emailEntrenador = null;
	private Date fechaContratacion = null;

	public String getNombreEntrenador() {
		return nombreEntrenador;
	}

	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}

	public String getApellidoEntrenador() {
		return apellidoEntrenador;
	}

	public void setApellidoEntrenador(String apellidoEntrenador) {
		this.apellidoEntrenador = apellidoEntrenador;
	}

	public String getNumeroEntrenador() {
		return numeroEntrenador;
	}

	public void setNumeroEntrenador(String numeroEntrenador) {
		this.numeroEntrenador = numeroEntrenador;
	}

	public String getEmailEntrenador() {
		return emailEntrenador;
	}

	public void setEmailEntrenador(String emailEntrenador) {
		this.emailEntrenador = emailEntrenador;
	}

	public Date getFechaContratacion() {
		return fechaContratacion;
	}

	public void setFechaContratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
}
