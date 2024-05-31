package principal;
import javax.swing.*;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;
import java.awt.Component;
import java.io.PrintStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class Acciones {


    private Random leer;
    int opcion = leer.nextInt();
if (opcion == 1) {


        try {
            Conexion conexion = new Conexion();
            String sql = "INSERT INTO Clientes (nombre_Clientes, observaciones) VALUES (?, ?)";

            PreparedStatement preparedStatement = conexion.conex.prepareStatement(sql);

            Clientes clientes = new Clientes();
            String nombre = JOptionPane.showInputDialog("Escribe el nombre completo del Cliente: ");
            String dpi = JOptionPane.showInputDialog("Escribe el numero de dpi: ");
            String fechaDePago = JOptionPane.showInputDialog("Escribe la fecha de pago: ");
            String fechaDeFinalizacion = JOptionPane.showInputDialog("Escribe la fecha de finalizacion: ");
            String formaDePago = JOptionPane.showInputDialog("Escribe la forma de pago: ");
            String tiempoPagado = JOptionPane.showInputDialog("Escribe el tipo de pago: ");
            boolean activo = JOptionPane.showInputDialog("Escribe si el cliente esta activo o no: ").isEmpty();

            clientes.setNombreCompletoCliente(nombre);
            clientes.setNumeroDPI(dpi);
            clientes.setFechaDePago(fechaDePago);
            clientes.setFechaDeFinalizacion(fechaDeFinalizacion);
            clientes.setFormaDePago(formaDePago);
            clientes.setTiempoPagado(tiempoPagado);
            clientes.setActivo(activo);

            preparedStatement.setString(1, clientes.getNombreCompletoCliente());
            preparedStatement.setString(2, clientes.getNumeroDPI());
            preparedStatement.setString(3, clientes.getFechaDePago());
            preparedStatement.setString(4, clientes.getFechaDeFinalizacion());
            preparedStatement.setString(5, clientes.getFormaDePago());
            preparedStatement.setString(6, clientes.getTiempoPagado());
            preparedStatement.setBoolean(7, clientes.getActivo());


            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("rows " + rowsAffected);

            if (rowsAffected == 1) {
                JOptionPane.showConfirmDialog(null, "Insertado con exito");
            }
            conexion.conex.close();
        } catch (Exception e) {


        }
    }

}

