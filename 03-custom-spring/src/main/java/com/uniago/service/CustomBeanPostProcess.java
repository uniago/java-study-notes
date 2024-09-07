package com.uniago.service;

import spring.BeanPostProcess;
import spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        if ("userService".equals(beanName)) {
            System.out.println("执行后置处理器...");
            Object proxyBean = Proxy.newProxyInstance(
                    // class loader
                    this.getClass().getClassLoader(),
                    // jdk动态代理需要接口
                    bean.getClass().getInterfaces(),
                    // 切面
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            // 每次调用都会执行
                            System.out.println("切面逻辑..");
                            // 由原始对象执行方法
                            return method.invoke(bean, args);
                        }
                    });
            // 返回代理对象
            return proxyBean;
        }
        return bean;
    }
}
