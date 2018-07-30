package com.yunsheng.service.impl;

import com.yunsheng.model.User;
import com.yunsheng.service.ServiceApplicationTests;
import com.yunsheng.service.UserService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.Assert.*;

public class UserServiceImplTest extends ServiceApplicationTests{

    @Value("${config.datasource.url}")
    private String url;


    @Autowired
    private UserService userService;


    @Test
    public void testVal(){
        System.out.println(url);
    }

    @Test
    public void addUserRollBack() throws Exception {
        User a = new User();
        a.setUserId(100);
        a.setPassword("123");
        a.setPhone("2345");
        a.setUserName("rb");
        userService.addUserRollBack(a);
    }

    @Test
    public void addUser() throws Exception {
        User a = new User();
        java.util.Random r=new java.util.Random();
        a.setUserId(r.nextInt(1000));
        a.setPassword("123");
        a.setPhone("2345");
        a.setUserName("addOne");
        userService.addUser(a);
    }

}