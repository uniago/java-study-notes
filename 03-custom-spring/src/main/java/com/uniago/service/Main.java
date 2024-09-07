package com.uniago.service;

import spring.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 创建Spring容器
        ApplicationContext ac = new ApplicationContext(AppConfig.class);
        // 尝试获取bean
        UserService userService = (UserService)ac.getBean("userService");
        // 打印bean
        System.out.println(userService);
        // 调用方法
        userService.test();

        // 测试单例多例
        System.out.println(ac.getBean("userService"));
        System.out.println(ac.getBean("userService"));
        System.out.println(ac.getBean("userService"));
        System.out.println(ac.getBean("userService"));
    }
}
