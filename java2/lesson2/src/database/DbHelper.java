package database;

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
 */
//todo logger & JUnit
public class DbHelper {
    private String databaseURL = "jdbc:sqlite:test1.db";
    private static DbHelper instance;
//    Connection connection; // если будет общий - можно забыть закрыть connection
    // + если забыть закрыть, то первый поток будет перезаписан и останется неуправляемый
    // нужно всегда за собой закрывать поток
    // иначе переполнится до перезагрузки
    // нужно очищать за собой ресурс

    private DbHelper() throws URISyntaxException, IOException {
//        DriverManager.registerDriver(new org.sqlite.JDBC());
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(databaseURL);
            String createSQL = readResource(DbHelper.class, "database/create.sql");
            String insertSQL = readResource(DbHelper.class, "database/insert.sql");
//            System.out.println(createSQL);
//            System.out.println(insertSQL);

            Statement statement = connection.createStatement();
            statement.executeUpdate(createSQL);
            statement.executeUpdate(insertSQL);
            closeResource(statement); // statement.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection);
        }
    }

    private String readResource(Class<DbHelper> dbHelperClass, String path) throws URISyntaxException, IOException {
        URL resource = dbHelperClass.getResource(path);
        Path resPath = Paths.get(resource.toURI());
        return new String(Files.readAllBytes(resPath), "UTF8");
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
    public static DbHelper getInstance() throws IOException, URISyntaxException {
        if (instance == null) {
            instance = new DbHelper();
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

}
