package com.yunsheng.service.impl;

import com.yunsheng.model.User;
import com.yunsheng.service.ServiceApplicationTests;
import com.yunsheng.service.UserService;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class UserServiceImplTest extends ServiceApplicationTests{

    @Autowired
    private UserService userService;

    @Test
    public void addUserRollBack() throws Exception {
        User a = new User();
        a.setUserId(100);
        a.setPassword("123");
        a.setPhone("2345");
        a.setUserName("rb");
        userService.addUserRollBack(a);
    }

}