import java.sql.SQLException;
/**
 * 1. Make it work. 2. Make it right. 3. Make it fast
 */
public class Main {

    public static void main(String[] args){

        String HOST_POSTGRE = "jdbc:postgresql://127.0.0.1:5432/sqlcmd";
        String USERNAME_POSTGRE = "postgres";
        String PASSWORD_POSTGRE = null;

        String HOST_MYSQL = "jdbc:mysql://localhost:3306/sqlcmd"+
                "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";
        String USERNAME_MYSQL = "root";
        String PASSWORD_MYSQL = "root";

       DataBaseManager dataBaseManager = new DataBaseManager();
        try {
            dataBaseManager.connect(HOST_POSTGRE, USERNAME_POSTGRE, PASSWORD_POSTGRE);
            System.out.println("Приєднано до postgresql");
            //dataBaseManager.dBCreateTable();
            dataBaseManager.dBInsert();
            dataBaseManager.closeConnection();
        } catch (SQLException e) {
            System.err.println("Приєднання до бази не відбулось, по причині - " + e);
        }

        try {
            dataBaseManager.connect(HOST_MYSQL, USERNAME_MYSQL, PASSWORD_MYSQL);
            System.out.println("Приєднано до mysql");
            dataBaseManager.closeConnection();
        } catch (SQLException e) {
            System.err.println("Приєднання до бази не відбулось, по причині - " + e);
        }
    }
}
