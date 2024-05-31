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

    public String getNombreCliente() {
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
}
