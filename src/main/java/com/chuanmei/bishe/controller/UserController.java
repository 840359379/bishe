package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
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
@RequestMapping(value = "/blog/landing")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "index")
    public String landing(){
        return "landing";
    }

    @PostMapping(value = "/enroll")
    public @ResponseBody CommonResult enroll(String id, String pw, HttpServletRequest request){
        User user = userService.record(id,pw);
        if(user == null){
            return new CommonResult(404,"登录失败", null);
        }else {
            request.getSession().setAttribute("user", user);
        }
        user.setPassword("******");
        return new CommonResult(200,"登录成功", user);
    }

    @PostMapping(value = "updateuser")
    public @ResponseBody CommonResult updateuser(User user,HttpServletRequest request){
        User old = (User) request.getSession().getAttribute("user");
        user.setAccount(old.getAccount());
        boolean post = userService.modify(user);
        if(!post){
            return new CommonResult(404,"修改失败",post);
        }
        User newUser= userService.chaname(user.getAccount());
        newUser.setPassword("******");
        request.getSession().setAttribute("user", newUser);
        return new CommonResult(200,"修改成功",post);
    }
}
