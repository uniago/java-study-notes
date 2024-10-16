package $03_exception.$07_jdk_logging.demo02;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("Start process...");
        try {
            "".getBytes("invalidCharsetName");
        } catch (UnsupportedEncodingException e) {
            // TODO: 使用logger.severe()打印异常
            logger.severe("Use invalid charset name:" + e.getMessage());
        }
        logger.info("Process end.");
    }
}