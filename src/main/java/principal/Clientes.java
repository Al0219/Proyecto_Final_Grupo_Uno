package principal;

public class Clientes {
    private String nombreCompletoCliente = null;
    private String numeroDPI = null;
    private String fechaDePago = null;
    private String fechaDeFinalizacion = null;
    private String formaDePago = null;
    private String tiempoPagado = null;
    private Boolean activo = false;

    public String getNombreCompletoCliente() {
        return nombreCompletoCliente;
    }

    public void setNombreCompletoCliente(String nombreCompletoCliente) {
        this.nombreCompletoCliente = nombreCompletoCliente;
    }

    public String getNumeroDPI() {
        return numeroDPI;
    }

    public void setNumeroDPI(String numeroDPI) {
        this.numeroDPI = numeroDPI;
    }

    public String getFechaDePago() {
        return fechaDePago;
    }

    public void setFechaDePago(String fechaDePago) {
        this.fechaDePago = fechaDePago;
    }

    public String getFechaDeFinalizacion() {
        return fechaDeFinalizacion;
    }

    public void setFechaDeFinalizacion(String fechaDeFinalizacion) {
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
