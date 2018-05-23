import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;

public class DataBaseConnectionTest {

    private DataBaseManager  dataBaseConnection;


    String HOST = "jdbc:postgresql://127.0.0.1:5432/";
    String DB_NAME = "sqlcmd";
    String USERNAME = "postgres";
    String PASSWORD = "postgres";

    @Before
    public void setup(){
        dataBaseConnection = new DataBaseManager();
    }

    @Test
    public void test_connection_to_db_with_all_correct_input_parameters(){
        try {

            Assert.assertTrue(dataBaseConnection.connect(HOST,DB_NAME, USERNAME,PASSWORD));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
