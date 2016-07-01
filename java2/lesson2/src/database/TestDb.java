package database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Steve on 26.05.2016.
 */
public class TestDb {
    private final static Logger logger = LoggerFactory.getLogger(TestDb.class);

    public static void main(String[] args) throws IOException, URISyntaxException {
//        System.out.println(DbHelper.getInstance().getAllCategories("SELECT * FROM CATEGORIES;"));
        System.out.println(DbHelper.getInstance().getAllCategoriesPreparedStatement());

        String i = "s";
        String i2 = "sd";
        logger.info("new info: {} test: {}", i, i2);

    }
}
