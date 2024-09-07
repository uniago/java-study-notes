package com.uniago.service;

import spring.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 创建Spring容器
        ApplicationContext ac = new ApplicationContext(AppConfig.class);
        // 尝试获取bean
        UserService userService = (UserService)ac.getBean("userService");
        // 调用方法
        userService.test();

    }
}
