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


        String HOST2 = "jdbc:mysql://127.0.0.1:3306/";
        String DB_NAME2 = "sqlcmd";
        String USERNAME2 = "root";
        String PASSWORD2 = "root";

       DataBaseManager dataBaseManager = new DataBaseManager();
        try {
            dataBaseManager.connect(HOST,DB_NAME, USERNAME, PASSWORD);
            System.out.println("Приєднано до postgresql");
            dataBaseManager.closeConnection();
        } catch (SQLException e) {
            System.err.println("Приєднання до бази не відбулось, по причині - " + e);
        }

        try {
            dataBaseManager.connectToMySQL();
            System.out.println("Приєднано до mysql");
            dataBaseManager.closeConnection();
        } catch (SQLException e) {
            System.err.println("Приєднання до бази не відбулось, по причині - " + e);
        }
    }
}
