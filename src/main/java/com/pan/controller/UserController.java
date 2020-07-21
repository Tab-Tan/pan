package com.pan.controller;

import com.google.gson.Gson;
import com.pan.poji.User;
import com.pan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
public class UserController {

    @Autowired
    Gson gson;

    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    //登录
    @RequestMapping(value = "/login",produces = "application/json;charset=utf-8")
    public String login(String username, String password, HttpServletRequest req){

        String msg;

        int flag = userService.login(username, password);

        if (flag==0){
            System.out.println("账号密码错误！");
            return "redirect:/index.html";
        }

        req.getSession().setAttribute("user",username);

        return "logininfo";
    }

    //注册
    @RequestMapping("/register")
    public String register(String username,String password){

        try {
            int flag = userService.register(new User(null, username, password, "", ""));

            if (flag==1){
                System.out.println("注册成功");
            }
        }catch (Exception e){
            System.out.println("注册失败");
        }

        return "redirect:/index.html";
    }

    //更改信息
    @RequestMapping("/update")
    @ResponseBody
    public String update(String data) throws UnsupportedEncodingException {

        String decode = URLDecoder.decode(data, "UTF-8");
        String[] values = decode.split(",");

        int flag = userService.update(values[1], values[2], values[3], values[0]);

        return String.valueOf(flag);
    }

    //查询自己
    @RequestMapping(value = "/query",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String query(HttpServletRequest req) throws UnsupportedEncodingException {

        req.setCharacterEncoding("utf-8");

        String username = (String) req.getSession().getAttribute("user");

        User user = userService.queryByUsername(username);

        return gson.toJson(user);
    }

    //转发回首页
    @RequestMapping("/goback")
    public String goBack(HttpServletRequest req){

        System.out.println(req.getSession().getAttribute("user").toString());

        return "forward:/index.html";
    }



}
