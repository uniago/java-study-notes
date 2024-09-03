package $03_exception.$10_slf4j_logback.demo01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(Main.class);
        log.info("start...");
        log.info("Set score {} for Person {} ok.", 99, "Uniago");
        log.warn("end.");
    }
}