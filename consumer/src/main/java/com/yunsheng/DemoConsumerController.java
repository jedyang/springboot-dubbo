package com.yunsheng;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DemoConsumerController {

    @Autowired
    private HelloService helloService;

    // 演示通过代码获得配置中心的值
    @Value("#{dubboGroup['dubbo.registry.address.690']}")
    private String zk;

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        String sayHello = helloService.sayHello(name);

        return sayHello + "from " + zk;
    }
}