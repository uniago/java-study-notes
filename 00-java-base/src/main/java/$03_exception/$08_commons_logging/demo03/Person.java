package $03_exception.$08_commons_logging.demo03;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

// 在实例方法中引用Log:
public class Person {
    protected final Log log = LogFactory.getLog(getClass());

    void foo() {
        log.info("foo");
    }
}