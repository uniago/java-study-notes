package com.uniago.service;

import spring.BeanPostProcess;
import spring.Component;

/**
 * 自定义bean处理器
 */
@Component
public class CustomBeanPostProcess implements BeanPostProcess {
    @Override
    public Object postProcessBeforeInitialization(String beanName, Object bean) {
        if ("userService".equals(beanName)) {
            System.out.println("执行前置处理器...");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(String beanName, Object bean) {
        System.out.println("执行前置处理器...");
        return bean;
    }
}
