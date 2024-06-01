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
			Conexion conexion = new Conexion(); //inicializamos la conexión

			String sql = "INSERT INTO clientes(id_cliente, nombre_cliente, apellido_cliente, numero_DPI, fecha_nacimiento) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = conexion.connection.prepareStatement(sql);

			System.out.print("Escriba el nombre del cliente: ");
			String nombre = entrada.nextLine(); clientes.setNombreCliente(nombre);

			System.out.print("Escriba el apellido del cliente: ");
			String apellido = entrada.nextLine(); clientes.setApellidoCliente(apellido);

			System.out.print("Escriba el numero de DPI del cliente: ");
			String DPI = entrada.nextLine(); clientes.setNumeroDPI(DPI);

			System.out.print("Escriba la fecha de nacimiento del cliente en formato YYYY/MM/DD: ");
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
				System.out.println(" ");
				System.out.println("Se ha registrado el cliente: " + clientes.getNombreCliente() + " " + clientes.getApellidoCliente());
				System.out.println(" ");
			}
			else{
				System.out.println("Algo no ha ido como esperabas... ");
			}
			conexion.connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void buscarCliente(){
		try {
			Conexion conexion = new Conexion(); //inicializamos la conexión
			String sql = "SELECT * FROM clientes WHERE numero_DPI = ?";
			PreparedStatement pst = conexion.connection.prepareStatement(sql);
			System.out.println(" ");
			System.out.print("Escriba el número de DPI del cliente: ");
			String DPI = entrada.nextLine();
			System.out.println(" ");

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

	public void eliminarCliente(){
		try {
			Conexion conexion = new Conexion();
			String sql = "DELETE FROM clientes WHERE numero_DPI = ";
			System.out.print("Ingrese el DPI del cliente para eliminar: ");
			String ID = entrada.nextLine();
			System.out.println(" ");
			PreparedStatement pst = conexion.connection.prepareStatement(sql+ID);
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected == 1){
				System.out.println("Eliminado exitosamente " );
			}else{
				System.out.println("Algo no ha salido como esperabas... ");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void agregarEntrenador(){
		try {
			Conexion conexion = new Conexion(); //inicializamos la conexión

			String sql = "INSERT INTO entrenadores(id_entrenador, nombre_entrenador, apellido_entrenador, numero_telefono, email, fecha_contratacion) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = conexion.connection.prepareStatement(sql);

			System.out.print("Escriba el nombre del nuevo entrenador: ");
			String nombre = entrada.nextLine(); entrenadores.setNombreEntrenador(nombre);

			System.out.print("Escriba el apellido del nuevo entrenador: ");
			String apellido = entrada.nextLine(); entrenadores.setApellidoEntrenador(apellido);

			System.out.print("Escriba el numero de teléfono: ");
			String numero = entrada.nextLine(); entrenadores.setNumeroEntrenador(numero);

			System.out.print("Escriba el correo electrónico: ");
			String email = entrada.nextLine();	entrenadores.setEmailEntrenador(email);

			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
			LocalDate fechaActual = LocalDate.now();
			java.sql.Date sqlDate = java.sql.Date.valueOf(fechaActual);
			entrenadores.setFechaContratacion(sqlDate);

			pst.setString(1, "0");
			pst.setString(2, entrenadores.getNombreEntrenador());
			pst.setString(3, entrenadores.getApellidoEntrenador());
			pst.setString(4, entrenadores.getNumeroEntrenador());
			pst.setString(5, entrenadores.getEmailEntrenador());
			pst.setDate(6, sqlDate);

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected == 1){
				System.out.println(" ");
				System.out.println("El entrenador se ha unido al Gimnasio Siempre Fuerte " );
			}else{
				System.out.println("Algo no ha salido como esperabas... ");
			}
			conexion.connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void registrarPago(){
		try {
			Conexion conexion = new Conexion();
			String sql = "INSERT INTO pagos(id_pago, numero_DPI, fecha_pago, fecha_finalizacion, forma_pago, tiempo_pagado) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = conexion.connection.prepareStatement(sql);

			System.out.print("Escriba el número de DPI del cliente: ");
			String DPI = entrada.nextLine(); pagos.setNumeroDPI(DPI);;

			System.out.print("Escriba la fecha de pago, en formato YYYY/MM/DD: ");
			String fechaPago = entrada.nextLine();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			java.util.Date fechaPag = sdf.parse(fechaPago); pagos.setFechaDePago(fechaPag);

			System.out.print("Escriba la fecha en que finalizará el periodo, en formato YYYY/MM/DD: ");
			String fechaFin = entrada.nextLine();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");
			java.util.Date fechaFi = sdf2.parse(fechaFin); pagos.setFechaDeFinalizacion(fechaFi);

			System.out.print("Escriba forma de pago, tarjeta o efectivo: ");
			String formaPago = entrada.nextLine(); pagos.setFormaDePago(formaPago);

			System.out.print("Escriba el tiempo pagado en días, ej: 15 días. ");
			String tiempoPagado = entrada.nextLine(); pagos.setTiempoPagado(tiempoPagado);

			pst.setString(1, "0");
			pst.setString(2, pagos.getNumeroDPI());
			pst.setDate(3, new java.sql.Date(pagos.getFechaDePago().getTime()));
			pst.setDate(4, new java.sql.Date(pagos.getFechaDeFinalizacion().getTime()));
			pst.setString(5, pagos.getFormaDePago());
			pst.setString(6, pagos.getTiempoPagado());


			int rowsAffected = pst.executeUpdate();
			if (rowsAffected == 1){
				System.out.println(" ");
				System.out.println("Se ha registrado el pago exitosamente:" );
			}
			else{
				System.out.println("Algo no ha salido como esperabas... ");
			}
			conexion.connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void consultarPago(){
		try {
			Conexion conexion = new Conexion();
			String sql = "SELECT * FROM pagos WHERE numero_DPI = ?";
			PreparedStatement pst = conexion.connection.prepareStatement(sql);

			System.out.print("Escriba el número de DPI de la persona porfavor... ");
			String DPI = entrada.nextLine();
			System.out.println(" ");

			pst.setString(1, DPI);

			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				System.out.println("|Número de DPI: " +rs.getString("numero_DPI"));
				System.out.println("|Fecha de pago: " +rs.getString("fecha_pago"));
				System.out.println("|Fecha de finalización: " + rs.getString("fecha_finalizacion"));
				System.out.println("|Forma de pago: " + rs.getString("forma_pago"));
				System.out.println("|Tiempo pagado: " + rs.getString("tiempo_pagado"));
			}else{
				System.out.println("Ese pago no existe, no fue registrado o se ha eliminado");
			}
			conexion.connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void eliminarPago(){
		try {
			Conexion conexion = new Conexion();
			String sql = "DELETE FROM pagos WHERE numero_DPI = ";
			System.out.print("Ingrese el DPI: ");
			String ID = entrada.nextLine();
			System.out.println(" ");
			PreparedStatement pst = conexion.connection.prepareStatement(sql+ID);
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected == 1){
				System.out.println("Eliminado exitosamente " );
			}else{
				System.out.println("Algo no ha salido como esperabas... ");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void actualizarCliente(){
		try {
			Conexion conexion = new Conexion();
			String sql = "UPDATE clientes set nombre_cliente = ?, apellido_cliente = ?, numero_DPI = ? WHERE numero_DPI = ";
			System.out.println("Ingrese el numero de DPI del cliente que va a modificar");
			String DPI = entrada.nextLine();
			PreparedStatement pst = conexion.connection.prepareStatement(sql+DPI);

			//esto puede cambiar según lo que deseemos, es decir, podemos elegir modificar más campos, u algunas cosas...
			System.out.print("Ingrese el nuevo nombre: ");
			String nombre = entrada.nextLine(); clientes.setNombreCliente(nombre);

			System.out.print("Ingrese el nuevo apellido: ");
			String apellido = entrada.nextLine(); clientes.setApellidoCliente(apellido);

			System.out.print("Ingrese el nuevo numero de DPI: ");
			String nuevoDPI = entrada.nextLine(); clientes.setNumeroDPI(nuevoDPI);

			pst.setString(1, clientes.getNombreCliente());
			pst.setString(2, clientes.getApellidoCliente());
			pst.setString(3, clientes.getNumeroDPI());

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected == 1){
				System.out.println("");
				System.out.println("Se ha hecho la modificación exitosamente " );
			}else{
				System.out.println("Algo no ha salido como esperabas... ");
			}
			conexion.connection.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	public void buscarEntrenador(){
		try {
			Conexion conexion = new Conexion();
			String sql = "SELECT * FROM entrenadores WHERE nombre_entrenador = ?";
			PreparedStatement pst = conexion.connection.prepareStatement(sql);

			System.out.print("Escriba el solo el primer nombre del entrenador a buscar: ");
			String nombre = entrada.nextLine();
			System.out.println(" ");

			pst.setString(1, nombre);

			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				System.out.println("|Nombre Completo: "+rs.getString("nombre_entrenador")+" "+rs.getString("apellido_entrenador")+"|");
				System.out.println("|Número de telefono: " +rs.getString("numero_telefono")+"|");
				System.out.println("|Fecha de contratacion: " +rs.getString("fecha_contratacion")+"|");
			}else{
				System.out.println("Ese entrenador no aparece en la base de datos");
			}
			conexion.connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void eliminarEntrenador(){
		try {
			Conexion conexion = new Conexion();
			String sql = "DELETE FROM entrenadores WHERE numero_telefono = ";
			System.out.print("Ingrese el número de telefono del entrenador que va a eliminar: ");
			String numTel = entrada.nextLine();
			System.out.println(" ");
			PreparedStatement pst = conexion.connection.prepareStatement(sql+numTel);
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected == 1){
				System.out.println(" ");
				System.out.println("Entrenador eliminado correctamente " );
			}else{
				System.out.println("Algo no ha salido como esperabas... ");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
