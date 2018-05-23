import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DataBaseManager {

    private Connection connection;

    String url = "jdbc:mysql://localhost:3306/sqlcmd"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";

    boolean connect(String host, String dbName, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(host + dbName, username, password);
        return !connection.isClosed();
    }

    boolean connectToMySQL() throws SQLException {
        connection = DriverManager.getConnection(url,
                "root", "root");
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
