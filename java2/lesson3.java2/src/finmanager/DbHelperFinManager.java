package finmanager;

import ex3.view.LoginDialog;

import javax.swing.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 26.05.2016.
 * Connection connection; // если будет общий - можно забыть закрыть connection
 * + если забыть закрыть, то первый поток будет перезаписан и останется неуправляемый.
 * Нужно всегда за собой закрывать поток, иначе переполнится до перезагрузки. Нужно очищать за собой ресурс
 */
//todo logger & JUnit
public class DbHelperFinManager {
    private String databaseURL = "jdbc:sqlite:finManager.db";
    private static DbHelperFinManager instance;
    private Connection currentConnection;

    public Connection getFirstConn() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(databaseURL);
            String createSQL = readResource(DbHelperFinManager.class, "create.sql");
            Statement statement = connection.createStatement();
            statement.executeQuery(createSQL);
            closeResource(statement);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: Возникла проблема при поиске jar-библиотеки.");
        } catch (SQLException e) {
            System.out.println("SQLException: Возникла проблема при попытке соединиться с базой данных.");
        } catch (IOException e) {
            System.out.println("IOException: Возникла проблема при вводе данных.");
        } catch (URISyntaxException e) {
            System.out.println("URISyntaxException: Возникла проблема в синтаксисе ссылки на базу данных.");
        } finally {
            closeResource(connection);
        }
        return connection;
    }

    public Connection getConn() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(databaseURL);
            String createSQL = readResource(DbHelperFinManager.class, "create.sql");
            Statement statement = connection.createStatement();
            if (databaseURL.equals(null)) {
                statement.executeQuery(createSQL);
                closeResource(statement);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: Возникла проблема при поиске jar-библиотеки.");
        } catch (SQLException e) {
            System.out.println("SQLException: Возникла проблема при попытке соединиться с базой данных.");
        } catch (IOException e) {
            System.out.println("IOException: Возникла проблема при вводе данных.");
        } catch (URISyntaxException e) {
            System.out.println("URISyntaxException: Возникла проблема в синтаксисе ссылки на базу данных.");
        }
        currentConnection = connection;
        return connection;
    }

    public void closeConn() {
        closeResource(currentConnection);
    }

    private DbHelperFinManager() throws URISyntaxException, IOException {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(databaseURL);
            String createSQL = readResource(DbHelperFinManager.class, "create.sql");
//            String insertSQL = readResource(DbHelperFinManager.class, "insert.sql");
            Statement statement = connection.createStatement();
            statement.executeUpdate(createSQL);
//            statement.executeUpdate(insertSQL);
            closeResource(statement); // statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ОШИБКА: Не найден класс библиотеки (jar-файл отсутствует, например org.sqlite.JDBC).");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ОШИБКА: Проблема с Базой Данных.");
        } finally {
            closeResource(connection);
        }
    }

    private String readResource(Class<DbHelperFinManager> dbHelperClass, String path) throws URISyntaxException, IOException {
        URL resource = dbHelperClass.getResource(path);
        Path resPath = Paths.get(resource.toURI());
        return new String(Files.readAllBytes(resPath), "Windows-1251");
    }

    static void closeResource(AutoCloseable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (Exception e) {
                e.printStackTrace(); // лучше использовать логирование
            }
            resource = null;
        }
    }

    //todo многопоточность
    public static DbHelperFinManager getInstance() throws IOException, URISyntaxException {
        if (instance == null) {
            instance = new DbHelperFinManager();
        }
        return instance;
    }

    public String getAllCategories(String query) {
        StringBuilder sb = new StringBuilder();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(databaseURL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                sb.append(String.format("id: %d, name: %s%n", id, name));
            }
            closeResource(resultSet); // resultSet.close();
            closeResource(statement); // statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection); // connection.close(); // понадобится обработка исключения SQL
        }
        return sb.toString();
    }

    //todo ДЗ - сделать DAO
    public List<Category> getAllCategories() { // пример метода из класса DAO Layer - Data Access Object // Hibernate похожее делает
        List<Category> categories = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(databaseURL);
            Statement statement = connection.createStatement();
            // инъекция SQL
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CATEGORIES;");
            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category();
                category.setName(name);
                category.setId(id);
                categories.add(category);
            }
            closeResource(resultSet); // resultSet.close();
            closeResource(statement); // statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection); // connection.close(); // понадобится обработка исключения SQL
        }
        return categories;
    }

    public List<Category> getAllCategoriesPreparedStatement() { // prepared statements (даём шаблоны запросов пользователю)
        List<Category> categories = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(databaseURL);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM CATEGORIES WHERE ID=?;"); // ? - wildcard проверка / вместо createStatment
            statement.setInt(1, 2); // ID=2
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category();
                category.setName(name);
                category.setId(id);
                categories.add(category);
            }
            closeResource(resultSet); // resultSet.close();
            closeResource(statement); // statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection); // connection.close(); // понадобится обработка исключения SQL
        }
        return categories;
    }

    public void addRegisteredUserPreparedStatement(User user) { // prepared statements (даём шаблоны запросов пользователю)
//        List<User> users = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(databaseURL);
//            PreparedStatement statement = connection.prepareStatement("INSERT OR REPLACE INTO USERS (NAME, PASSWORD) VALUES (?, ?);"); // ? - wildcard проверка / вместо createStatment
//            PreparedStatement statement = connection.prepareStatement("INSERT OR REPLACE INTO USERS (NAME, PASSWORD) VALUES (?,?);"); // ? - wildcard проверка / вместо createStatment
            PreparedStatement statement = connection.prepareStatement("INSERT OR REPLACE INTO USERS (NAME, PASSWORD) VALUES" + " (?,?);"); // ? - wildcard проверка / вместо createStatment
//            PreparedStatement statement = connection.prepareStatement("INSERT OR REPLACE INTO USERS (NAME, PASSWORD) VALUES (NAME=?, PASSWORD=?);"); // ? - wildcard проверка / вместо createStatment
//            PreparedStatement statement = connection.prepareStatement("INSERT OR REPLACE INTO USERS NAME=?, PASSWORD=?;"); // ? - wildcard проверка / вместо createStatment
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
//            char[] charPassword = new char[user.getPassword().length()];
//            String s = user.getPassword();
//            for (int i = 0; i < user.getPassword().length(); i++) {
//                charPassword[i] = s.charAt(i);
//            }
//            statement.setObject(2, charPassword, java.sql.Types.CHAR);
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String password = resultSet.getString("password");
//                User user1 = user;
//                user1.setName(name);
//                user1.setPassword(password);
//                users.add(user);
//            }
//            closeResource(resultSet); // resultSet.close();
            statement.executeQuery();
//            JOptionPane.showMessageDialog(LoginDialog, "Ok.");
            closeResource(statement); // statement.close();
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("SQLException: Проблемы с добавлением пользователя в Базу данных.");
        } finally {
            closeResource(connection); // connection.close(); // понадобится обработка исключения SQL
        }
    }

}
