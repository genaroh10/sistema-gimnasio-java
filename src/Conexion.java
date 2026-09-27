import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection conectar() {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gimnasio",
                    "root",
                    "password"
            );

            return con;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
