package com.uniago.service;

import spring.AutoWired;
import spring.BeanNameAware;
import spring.Component;
import spring.InitializingBean;

@Component("userService")
public class UserService implements BeanNameAware, InitializingBean {

    @AutoWired
    private OrderService orderService;

    private String beanName;

    // 通过实现Aware接口 Spring调用回调方法 执行重写方法
    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
        System.out.println(this.beanName);
    }
    @Override
    public void afterPropertiesSet() {
        System.out.println("执行初始化..");
    }

    public void test() {
        System.out.println(orderService);
    }

}
