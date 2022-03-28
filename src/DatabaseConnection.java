import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/student_management";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Connected to database successfully");
            } catch (ClassNotFoundException | SQLException e) {
                ((Throwable) e).printStackTrace();
            }
        }
        return connection;
    }
}