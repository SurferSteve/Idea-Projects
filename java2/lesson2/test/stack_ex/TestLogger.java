package stack_ex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Steve on 24.05.2016.
 */
public class TestLogger {
    static Logger logger = LoggerFactory.getLogger(TestLogger.class);

    void test() {
        logger.warn("Warn message");
    }
}
