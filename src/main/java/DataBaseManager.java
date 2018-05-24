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
        try {
            stmt = connection.createStatement();
            String sql = "CREATE TABLE CONTACT " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " SALARY         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();

            System.out.println("Таблиця створена");
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void dBInsert() {
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            String sql = "INSERT INTO CONTACT "
                    + "VALUES (1, 'Paul', 32, 'California', 20000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CONTACT (ID,NAME,AGE,ADDRESS,SALARY) "
                    + "VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CONTACT (ADDRESS,ID,NAME, AGE) "
                    + "VALUES ('Norway', 3, 'Teddy', 3 );";
            stmt.executeUpdate(sql);

            sql = "INSERT INTO CONTACT (ID,NAME, AGE, ADDRESS,SALARY) "
                    + "VALUES (4, 'Mark', 28, 'Rich-Mond ', 65000.00 );";
            stmt.executeUpdate(sql);

            stmt.close();
            connection.commit();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
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
