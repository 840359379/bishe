package com.chuanmei.bishe.controller;


import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Invitation;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.FollowService;

import com.chuanmei.bishe.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping(value = "blog/homepage")
@Controller
public class HomepageController {

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private FollowService followService;

    @GetMapping(value = "/index")
    public String index(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        followService.coverlookfollow(user.getAccount());
        model.addAttribute("user",user);
        model.addAttribute("follow",followService.lookfollow(user.getAccount()).size());
        model.addAttribute("coverfollow",followService.coverlookfollow(user.getAccount()).size());
        model.addAttribute("myinvitation",invitationService.lookmyinvitations(user.getAccount()));
        return "homepage";
    }

    @PostMapping(value = "/invitations")
    public @ResponseBody CommonResult invitations(HttpServletRequest request){
        List<Invitation> lists = invitationService.lookinvitations();
        return new CommonResult(200,"成功拿到了",lists);
    }
}
