package principal;
import java.sql.*;
public class Conexion {
    //public static String driver = "com.mysql.jdbc.Driver";
    public String database = "gimnasio";
    public String hostname = "mysql.webcindario.com";
    //public String hostname = "localhost";
    public String port ="3306";
    public String username = "gimnasio";
    public String password ="equipoUno2024";
    public String url = "jdbc:mysql://"+hostname+":"+port+"/"+database;

    Connection connection;

    public Conexion() throws SQLException{
        try {
            //Class.forName(driver);
            connection =DriverManager.getConnection(url, username, password);
        }
        catch (SQLException e){
            e.printStackTrace();
            throw new SQLException("Error al establecer la conexion: " + e.getMessage());
        }
    }

}
