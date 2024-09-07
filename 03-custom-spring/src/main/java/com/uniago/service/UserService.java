package com.uniago.service;

import spring.AutoWired;
import spring.Component;

@Component("userService")
public class UserService {

    @AutoWired
    private OrderService orderService;

    public void test() {
        System.out.println(orderService);
    }
}
