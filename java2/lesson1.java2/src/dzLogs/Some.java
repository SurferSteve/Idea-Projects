package dzLogs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Steve on 23.05.2016.
 */

public class Some {
    static Logger logger = LoggerFactory.getLogger(Some.class);

    void test() {
        logger.warn("Warn message");
    }
}
