package principal;

import java.util.Date;

public class Clientes {
    private String nombreCliente = null;
    private String apellidoCliente = null;
    private String numeroDPI = null;
    private Date fechaNacimiento = null;

    public String getNumeroDPI() {
        return numeroDPI;
    }

    public void setNumeroDPI(String numeroDPI) {
        this.numeroDPI = numeroDPI;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombreCompletoCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombresCliente) {
        this.nombreCliente = nombresCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidosCliente) {
        this.apellidoCliente = apellidosCliente;
    }

    public void setNombreCompletoCliente(String nombre) {
    }

    public void setFechaDePago(String fechaDePago) {
    }

    public void setFechaDeFinalizacion(String fechaDeFinalizacion) {
    }

    public void setFormaDePago(String formaDePago) {
    }

    public void setTiempoPagado(String tiempoPagado) {
    }

    public void setActivo(boolean activo) {
    }


    public String getFechaDePago() {
        String FechaDePago = null;
        return FechaDePago;
    }

    public String getFechaDeFinalizacion() {
        String FechaDeFinalizacion = null;
        return FechaDeFinalizacion;
    }

    public String getFormaDePago() {
        String FormaDePago = null;
        return FormaDePago;

    }

    public String getTiempoPagado() {
        String TiempoPagado = null;
        return TiempoPagado;
    }

    public boolean getActivo() {
        boolean Activo = Boolean.parseBoolean(null);
        return Activo;
    }

    public String getNombreCliente() {
        String NombreCliente = null;
        return NombreCliente;
    }
}
