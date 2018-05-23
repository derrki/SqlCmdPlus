class JDBCHelper {

    static void registerDriver(String driver){
        try {
            Class.forName(driver);
            System.out.println("Драйвер postgresql знайдено!!!");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер відсутній! Перевірте налаштування проекту" + e);
        }
    }
}
