package com.lcy.newborn.controller;

import com.lcy.newborn.pojo.User;
import com.lcy.newborn.result.Result;
import com.lcy.newborn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import sun.plugin.dom.core.Element;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "api/login")
    public Result login(@RequestBody User requestUser, HttpSession session){
        // 对 html 标签进行转义，防止 XSS 攻击
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username,requestUser.getPassword());
        if(null == user){
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        }else {
            session.setAttribute("user", user);
            return new Result(200);
        }
    }
}
