package com.uniago.service;

import spring.AutoWired;
import spring.Component;

@Component
public class UserService implements UserInterface {

    @AutoWired
    private OrderService orderService;

    public void test() {
        System.out.println(orderService);
    }

}
