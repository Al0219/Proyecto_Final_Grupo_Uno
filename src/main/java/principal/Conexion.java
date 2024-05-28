package principal;
import java.sql.*;
public class Conexion {
    Connection conex;

    public Conexion() throws SQLException{
        try {
            conex = DriverManager.getConnection("jdbc:mysql://localhost/gimnasio", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al establecer la conexión: " + e.getMessage());
        }
    }

    public Connection getConex(){
        return conex;
    }

}
