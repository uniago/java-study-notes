package com.uniago.controller;


import com.uniago.service.HelloService;

public class HelloController {
    private HelloService helloService;

    public String getHelloMessage() {
        return helloService.getHelloMessage();
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }
}
