import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DataBaseManager implements DataBaseHelper {

    private Connection connection;
    private Statement stmt;

    @Override
    public boolean connect(String host, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(host, username, password);
        return !connection.isClosed();
    }

    @Override
    public void dBCreateTable() {
        //TODO
    }

    @Override
    public void dBInsert() {
        //TODO
    }

    @Override
    public void dBSelect() {
        //TODO
    }

    @Override
    public void dBUpdate() {
        //TODO
    }

    @Override
    public void dBDelete() {
        //TODO
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
