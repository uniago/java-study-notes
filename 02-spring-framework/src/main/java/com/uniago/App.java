package com.uniago;

import com.uniago.controller.HelloController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    private final Log log = LogFactory.getLog(getClass());
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloController controller = (HelloController) context.getBean("helloController");
        System.out.println(controller.getHelloMessage());
        new App().test();
    }
    private void test() {
        System.out.println("log = " + log);
        log.debug("this debug");
        log.info("this info");
        log.warn("this warn");
        log.error("this error");
    }
}
