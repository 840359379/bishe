package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Follow;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/blog/follow")
@Controller
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping(value = "/look/follow")
    public @ResponseBody CommonResult lookFollow(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        return new CommonResult(200,"读取成功",followService.lookfollow(user.getAccount()));
    }

    @GetMapping(value = "look/cover")
    public @ResponseBody CommonResult lookCover(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        return new CommonResult(200,"读取成功",followService.coverlookfollow(user.getAccount()));
    }
}
