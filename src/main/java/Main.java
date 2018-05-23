import java.sql.SQLException;

/**
 * 1. Make it work. 2. Make it right. 3. Make it fast
 */
public class Main {


    public static void main(String[] args){

        String HOST = "jdbc:postgresql://127.0.0.1:5432/";
        String DB_NAME = "sqlcmd";
        String USERNAME = "postgres";
        String PASSWORD = null;

       DataBaseManager dataBaseManager = new DataBaseManager();
        try {
            dataBaseManager.connect(HOST,DB_NAME, USERNAME, PASSWORD);
            dataBaseManager.closeConnection();
        } catch (SQLException e) {
            System.err.println("Приєднання до бази не відбулось, по причині - " +e);
        }
    }
}
