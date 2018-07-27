package com.yunsheng.service;


import com.yunsheng.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {

        return "Hello from xml:" + name + "!";
    }
}