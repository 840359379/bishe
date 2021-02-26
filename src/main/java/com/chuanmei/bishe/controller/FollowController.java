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

    /**
     * 查看我关注的人列表
     * @param request
     * @return
     */
    @GetMapping(value = "/look/follow")
    public @ResponseBody CommonResult lookFollow(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<Follow> list= followService.lookfollow(user.getAccount());
        return new CommonResult(200,"读取成功",list);
    }

    /**
     * 查看我粉丝的列表
     * @param request
     * @return
     */
    @GetMapping(value = "look/cover")
    public @ResponseBody CommonResult lookCover(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<Follow> list =  followService.coverlookfollow(user.getAccount());
        return new CommonResult(200,"读取成功",list);
    }

    /**
     * 删除一个粉丝
     * @param follow
     * @param request
     * @return
     */
    @PostMapping(value = "/delete/follow")
    public @ResponseBody CommonResult deleteFollow(Follow follow,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        boolean result = followService.deletefollow(user.getAccount(), follow.getCoveraccount());
        return new CommonResult(200,"成功了",result);
    }

    /**
     * 关注别人
     * @param request
     * @param follow
     * @return
     */
    @PostMapping(value = "/add/follow")
    public @ResponseBody CommonResult addFollow(HttpServletRequest request,Follow follow){
        User user = (User) request.getSession().getAttribute("user");
        follow.setAccount(user.getAccount());
        follow.setName(user.getName());
        boolean existence = followService.selectFollow(follow);
        if(existence){
            return new CommonResult(200,"你已关注此用户",false);
        }
        boolean result = followService.addfollow(follow);
        return new CommonResult(200,"成功了",result);
    }

    @GetMapping(value = "/existence")
    public @ResponseBody CommonResult existence(HttpServletRequest request,Follow follow){
        User user = (User) request.getSession().getAttribute("user");
        follow.setAccount(user.getAccount());
        return new CommonResult(200,"成功了",followService.selectFollow(follow));
    }
}
