import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DataBaseManager {

    String HOST = "jdbc:postgresql://127.0.0.1:5432/";
    String DB_NAME = "sqlcmd";
    String USERNAME = "postgres";
    String PASSWORD = "postgres";
    private Connection connection;

    boolean connect(String host, String dbName, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(HOST + DB_NAME, USERNAME, PASSWORD);
        return !connection.isClosed();
    }

    boolean closeConnection() throws SQLException {
        if(!connection.isClosed()){
            connection.close();
            return true;
        } else {
            return false;
        }

    }
}
