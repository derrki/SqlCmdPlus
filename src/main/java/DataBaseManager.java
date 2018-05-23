import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DataBaseManager {

    private Connection connection;

    boolean connect(String host, String dbName, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(host + dbName, username, password);
        return !connection.isClosed();
    }

    void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
