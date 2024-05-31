package principal;

import java.util.Date;

public class Pagos {
	private String numeroDPI = null;
	private Date fechaDePago = null;
	private Date fechaDeFinalizacion = null;
	private String formaDePago = null;
	private String tiempoPagado = null;

	public Date getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(Date fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public Date getFechaDeFinalizacion() {
		return fechaDeFinalizacion;
	}

	public void setFechaDeFinalizacion(Date fechaDeFinalizacion) {
		this.fechaDeFinalizacion = fechaDeFinalizacion;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public String getTiempoPagado() {
		return tiempoPagado;
	}

	public void setTiempoPagado(String tiempoPagado) {
		this.tiempoPagado = tiempoPagado;
	}

	public String getNumeroDPI() {
		return numeroDPI;
	}

	public void setNumeroDPI(String numeroDPI) {
		this.numeroDPI = numeroDPI;
	}
}
