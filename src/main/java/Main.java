/**
 * 1. Make it work. 2. Make it right. 3. Make it fast
 */
public class Main {
    public static void main(String[] args) {

        String DRIVER =  "org.postgresql.Driver";
        String HOST = "jdbc:postgresql://127.0.0.1:5432/";
        String DB_NAME = "sqlcm";
        String USERNAME = "postgres";
        String PASSWORD = "postgres";

        JDBCHelper.registerDriver(DRIVER);
    }
}
