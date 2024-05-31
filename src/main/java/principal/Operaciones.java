package principal;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
public class Operaciones {

	Scanner entrada = new Scanner(System.in); //instancia para escáner
	Clientes clientes = new Clientes(); //creación de objeto clientes
	Pagos pagos = new Pagos(); //creación de objeto pagos
	Entrenadores entrenadores = new Entrenadores(); //creación de objeto entrenadores

	public void registrarCliente(){
		try {
			Conexion conexion = new Conexion();

			String sql = "INSERT INTO clientes(id_cliente, nombre_cliente, apellido_cliente, numero_DPI, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = conexion.connection.prepareStatement(sql);

			System.out.print("Escriba el nombre del cliente: ");
			String nombre = entrada.nextLine(); clientes.setNombreCliente(nombre);

			System.out.print("Escriba el apellido del cliente: ");
			String apellido = entrada.nextLine(); clientes.setApellidoCliente(apellido);

			System.out.print("Escriba el numero de DPI del cliente: ");
			String DPI = entrada.nextLine(); clientes.setNumeroDPI(DPI);

			System.out.println("Escriba la fecha de nacimiento del cliente: formato: YYYY/MM/DD");
			String fechaNacimiento = entrada.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.util.Date fechaInicio = sdf.parse(fechaNacimiento); clientes.setFechaNacimiento(fechaInicio);

			pst.setString(1, "0");
			pst.setString(2, clientes.getNombreCliente());
			pst.setString(3, clientes.getApellidoCliente());
			pst.setString(4, clientes.getNumeroDPI());
			pst.setDate(5, new java.sql.Date(clientes.getFechaNacimiento().getTime()));

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected == 1){
				System.out.println("Se ha registrado el cliente: " + clientes.getNombreCliente() + " " + clientes.getApellidoCliente());
			}
			else{
				System.out.println("Algo no ha ido como esperabas...");
			}
			conexion.connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void buscarCliente(){
		try {
			Conexion conexion = new Conexion();
			String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
			PreparedStatement pst = conexion.connection.prepareStatement(sql);

			System.out.print("Escriba el ID del Cliente a buscar: ");
			System.out.println(" ");
			String DPI = entrada.nextLine();

			pst.setString(1, DPI);

			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				System.out.println("|Nombre Completo: "+rs.getString("nombre_cliente")+" "+rs.getString("apellido_cliente")+"|");
				System.out.println("|Número de DPI: " +rs.getString("numero_DPI")+"|");
				System.out.println("|Fecha de nacimiento: " +rs.getString("fecha_nacimiento")+"|");
			}else{
				System.out.println("Cliente no se encuentra en la base de datos");
			}
			conexion.connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
