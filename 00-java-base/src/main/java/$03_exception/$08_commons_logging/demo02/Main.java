package $03_exception.$08_commons_logging.demo02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// 在静态方法中引用Log:
public class Main {
    static final Log log = LogFactory.getLog(Main.class);

    static void foo() {
        log.info("foo");
    }
}