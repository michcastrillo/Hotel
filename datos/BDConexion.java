package datos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author yasni
 */
public class BDConexion {

    private Connection connection = null;

    public Connection Conexion() {
        String url = "jdbc:postgresql://localhost:5432/hotel";
        String password = "123";
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, "postgres", password);//Hace la conexion
            if (connection != null) {
                System.out.println("Conectándo a la base de datos...");
            }
        } catch (Exception e) {
            System.out.println("Problema conectándose a la base de datos.");
        }
        return connection;
    }
}
