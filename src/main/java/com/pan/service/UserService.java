package com.pan.service;

import com.pan.poji.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    int register(User user);

    int login(String username,String password);

    int update(String password,String nikename,String signature,String username);

    User queryByUsername(String username);


}
