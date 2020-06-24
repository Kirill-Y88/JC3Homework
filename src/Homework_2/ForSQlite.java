package Homework_2;

import java.sql.*;

public class ForSQlite {
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    // ПОДКЛЮЧЕНИЕ К БАЗЕ
    public static void connect()
    {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:PasswordBase0.s3db");
            statement = connection.createStatement();
            System.out.println("База Подключена!");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Создание таблицы
    public static void createDB()
    {
        try {
            statement.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' STRING, 'login' STRING, 'password' STRING);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Таблица создана или уже существует.");
    }

    // Добавление данных в таблицу
    public static void writeDB(String name, String login, String password)
    {
        String query =  String.format("INSERT INTO 'users' ('name', 'login', 'password')" +
                " VALUES ('%s', '%s', '%s'); ",name, login, password);
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Таблица заполнена");
    }

    // Вывод таблицы
    public static void readDB() //throws ClassNotFoundException, SQLException
    {
        try{
        resultSet = statement.executeQuery("SELECT * FROM users");
        while(resultSet.next())
        {
            int id = resultSet.getInt("id");
            String  name = resultSet.getString("name");
            String  login = resultSet.getString("login");
            String  password = resultSet.getString("password");
            System.out.println( "ID = " + id );
            System.out.println( "name = " + name );
            System.out.println( "login = " + login );
            System.out.println( "password = " + password );
            System.out.println();
        }}catch (SQLException e){
            e.printStackTrace();
        }

        System.out.println("Таблица выведена");
    }

    // Аутентификация
    public static String auth (String login, String password)  {
        String query = String.format("select name from users where login='%s' and password='%s'", login, password);
        try (ResultSet set = statement.executeQuery(query)) {
            if (set.next())
                System.out.println("Аутентификация пройдена" );
            return set.getString(1);
        } catch (SQLException e) {
            System.out.println("Логин или пароль неверны");
            //throw new RuntimeException(e);
        }
        return  null;
    }

    // Изменение ника
    public static void updateName (String login, String password, String newName){
        String query = String.format("UPDATE  users SET name = '%s' WHERE login='%s' and password='%s'",newName, login, password);
        try {
            statement.execute(query);
            System.out.println("Смена ника прошла успешно");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Неверен логин или пароль");
        }
    }



    // Закрытие
    public static void closeDB()
    {
        try {
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Соединения закрыты");
    }

}
