import java.sql.SQLException;

public interface DataBaseHelper {

    //Приєднання до бази
    boolean connect(String host, String username, String password) throws SQLException;

    //Створення таблиці
    void dBCreateTable();

    //Вставка даних в таблицю
    void dBInsert();

    //Вибірка даних з таблиці
    void dBSelect();

    //Редагування даних в таблиці
    void dBUpdate();

    //Видалення даних з таблиці
    void dBDelete();

    //закриття зєднання з базою
    void closeConnection();
}
