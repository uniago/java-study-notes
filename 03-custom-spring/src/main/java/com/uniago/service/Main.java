package com.uniago.service;

import spring.ApplicationContext;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        // 创建Spring容器
        ApplicationContext ac = new ApplicationContext(AppConfig.class);
        // 尝试获取bean
        UserInterface userService = (UserInterface) ac.getBean("userService");
        // 查看是否为代理对象 不会走切面逻辑
        System.out.println(userService instanceof Proxy);
        // 这相当于调用toString()方法 因此也会走切面逻辑
        System.out.println(userService);
        // 调用方法
        userService.test();

    }
}
