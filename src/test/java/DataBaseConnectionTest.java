import org.junit.*;
import java.sql.SQLException;

public class DataBaseConnectionTest {

    private DataBaseManager dataBaseConnection;

    String HOST_MYSQL = "jdbc:mysql://localhost:3306/sqlcmd"+
            "?verifyServerCertificate=false"+
            "&useSSL=false"+
            "&requireSSL=false"+
            "&useLegacyDatetimeCode=false"+
            "&amp"+
            "&serverTimezone=UTC";
    String USERNAME_MYSQL = "root";
    String PASSWORD_MYSQL = "root";

    @Before
    public void setup() {
        dataBaseConnection = new DataBaseManager();
        System.out.println("before");
    }

    @After
    public void closeConnection(){
        try {
            dataBaseConnection.closeConnection();
            System.out.println("конект закрито");

        } catch (NullPointerException e) {
            System.out.println("конект не був відкритий - " + e);
        }
    }

    @Test
    public void test_connection_to_db_with_all_correct_input_parameters() {
        try {
            Assert.assertTrue(dataBaseConnection.connect(HOST_MYSQL, USERNAME_MYSQL, PASSWORD_MYSQL));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_connection_to_db_with_Host_null() {
        try {
            dataBaseConnection.connect(null, USERNAME_MYSQL, PASSWORD_MYSQL);
            Assert.fail();
        } catch (SQLException e) {
            System.out.println("OK");
        }
    }

    @Test
    public void test_connection_to_db_with_username_null() {
        try {
            dataBaseConnection.connect(HOST_MYSQL, null, PASSWORD_MYSQL);
            Assert.fail();
        } catch (SQLException e) {
            System.out.println("OK");
        }
    }

    @Test
    public void test_connection_to_db_with_password_null() {
        try {
            dataBaseConnection.connect(HOST_MYSQL, USERNAME_MYSQL, null);
            Assert.fail();
        } catch (SQLException e) {
            System.out.println("OK");
        }
    }

    @Test
    public void test_connection_to_db_with_all_input_parameters_null() {
        try {
            dataBaseConnection.connect(null, null, null);
            Assert.fail();
        } catch (SQLException e) {
            System.out.println("OK");
        }
    }
}
