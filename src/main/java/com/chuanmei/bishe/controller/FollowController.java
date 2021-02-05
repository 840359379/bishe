package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Follow;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "/blog/follow")
@Controller
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping(value = "/look/follow")
    public @ResponseBody CommonResult lookFollow(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<Follow> list= followService.lookfollow(user.getAccount());
        return new CommonResult(200,"读取成功",list);
    }

    @GetMapping(value = "look/cover")
    public @ResponseBody CommonResult lookCover(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<Follow> list =  followService.coverlookfollow(user.getAccount());
        return new CommonResult(200,"读取成功",list);
    }

    @PostMapping(value = "/delete/follow")
    public @ResponseBody CommonResult deleteFollow(HttpServletRequest request,String account,String coveraccount){
        boolean result = followService.deletefollow(account, coveraccount);
        return new CommonResult(200,"成功了",result);
    }

    @PostMapping(value = "/add/follow")
    public @ResponseBody CommonResult addFollow(Follow follow){
        boolean existence = followService.selectFollow(follow);
        if(existence){
            return new CommonResult(200,"你已关注此用户",false);
        }
        boolean result = followService.addfollow(follow);
        return new CommonResult(200,"成功了",result);
    }
}
