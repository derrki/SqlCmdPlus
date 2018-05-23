import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * 1. Make it work. 2. Make it right. 3. Make it fast
 */
public class Main {


    public static void main(String[] args) throws SQLException {

        String HOST = "jdbc:postgresql://127.0.0.1:5432/";
        String DB_NAME = "sqlcmd";
        String USERNAME = "postgres";
        String PASSWORD = "postgres";

       DataBaseManager dataBaseManager = new DataBaseManager();
       dataBaseManager.connect(HOST,DB_NAME, USERNAME,PASSWORD);
       dataBaseManager.closeConnection();
    }
}
