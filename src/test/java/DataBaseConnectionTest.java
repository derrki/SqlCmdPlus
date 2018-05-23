import org.junit.*;
import java.sql.SQLException;

public class DataBaseConnectionTest {

    private DataBaseManager dataBaseConnection;

    String HOST = "jdbc:postgresql://127.0.0.1:5432/";
    String DB_NAME = "sqlcmd";
    String USERNAME = "postgres";
    String PASSWORD = "postgres";

    @Before
    public void setup() {
        dataBaseConnection = new DataBaseManager();
        System.out.println("before");
    }

    @Test
    public void test_connection_to_db_with_all_correct_input_parameters() {
        try {
            Assert.assertTrue(dataBaseConnection.connect(HOST, DB_NAME, USERNAME, PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_connection_to_db_with_Host_null() {
        try {
            dataBaseConnection.connect(null, DB_NAME, USERNAME, PASSWORD);
            Assert.fail();
        } catch (SQLException e) {
            System.out.println("OK");
        }
    }

    @Test
    public void test_connection_to_db_with_db_null() {
        try {
            dataBaseConnection.connect(HOST, null, USERNAME, PASSWORD);
            Assert.fail();
        } catch (SQLException e) {
            System.out.println("OK");
        }
    }

    @Test
    public void test_connection_to_db_with_username_null() {
        try {
            dataBaseConnection.connect(HOST, DB_NAME, null, PASSWORD);
            Assert.fail();
        } catch (SQLException e) {
            System.out.println("OK");
        }
    }

    @Test
    public void test_connection_to_db_with_all_input_parameters_null() {
        try {
            dataBaseConnection.connect(null, null, null, null);
            Assert.fail();
        } catch (SQLException e) {
            System.out.println("OK");
        }
    }


    @After
    public void closeConnection(){
        try {
            dataBaseConnection.closeConnection();
            System.out.println("after конект закрито");
        } catch (NullPointerException e) {
            System.out.println("онект не був відкритий - " + e);
        }
    }
}
