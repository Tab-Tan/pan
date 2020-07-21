package com.pan.service;

import com.pan.dao.UserMapper;
import com.pan.poji.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public int register(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int login(String username, String password) {
        Map map = new HashMap<String,String>();

        map.put("username",username);
        map.put("password",password);
        User user = userMapper.queryByUsernameAndPassword(map);
        if (user==null){
            return 0;
        }
        return 1;
    }

    @Override
    public int update(String password, String nikename, String signature, String username) {

        Map map = new HashMap<String,String>();
        map.put("username",username);
        map.put("password",password);
        map.put("nikename",nikename);
        map.put("signature",signature);
        return userMapper.updateUserByUsername(map);
    }


    @Override
    public User queryByUsername(String username) {
        return userMapper.queryByUsername(username);
    }
}
