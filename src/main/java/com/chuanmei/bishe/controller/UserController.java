package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog/core")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "landing")
    public String landing(){
        return "landing";
    }

    @PostMapping
    public @ResponseBody boolean enroll(String id, String pw, HttpServletRequest request){
        User user = userService.record(id,pw);

        return true;
    }
}
