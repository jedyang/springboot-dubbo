package com.yunsheng;


import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Value;

@Service(version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class HelloServiceImpl implements HelloService {

    static int i = 0;
    @Override
    public String sayHello(String name) {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException("ex");
        }
        return "Hello " + name + "!";
    }
}