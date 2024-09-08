package com.uniago;

import com.uniago.mapper.OrderMapper;
import com.uniago.mapper.UserMapper;
import com.uniago.service.UserService;
import mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);



        UserService userService = ac.getBean("userService", UserService.class);
        userService.test();

        // 需要将mapper接口对象变成bean,并添加到spring容器中
        // FactoryBean中的getObject()返回的对象
        // 因此想要获取mapper bean直接从getObject方法返回代理对象即可
        // System.out.println(ac.getBean("sqlSessionFactoryBean"));
        // FactoryBean对象
        // System.out.println(ac.getBean("&sqlSessionFactoryBean"));
    }
}