package ferdianjulianto.jwork.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class DatabaseConnection connects database with projects
 *
 * @author Ferdian Julianto
 * @version 10.06.2021
 */
public class DatabaseConnection {
    public static Connection connection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jwork", "postgres", "");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
    }
}
