package com.tan.dao;

import com.pan.poji.User;
import com.pan.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {
    @Test
    public void test(){
        ApplicationContext ac= new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ac.getBean("userService");
        int register = userService.register(new User(2, "username", "password", "123", "465"));
        System.out.println("register = " + register);
    }

}
