/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.FollowService;
import com.chuanmei.bishe.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog/personal")
public class PersonalController {

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private FollowService followService;

    @GetMapping(value = "/index")
    public String index(Model model, HttpServletRequest request){
        model.addAttribute("user",(User) request.getSession().getAttribute("user"));
        return "personal";
    }

    @GetMapping(value = "/my/invitation")
    public String myInvitation(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model = myInformation(model, user);
        return "personal_myinvitation";
    }

    @GetMapping(value = "/invitation")
    public String invitation(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model = myInformation(model, user);
        return "personal_invitation";
    }

    @GetMapping(value = "/fans")
    public String fans(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model = myInformation(model, user);
        return "personal_fans";
    }

    @GetMapping(value = "/follow")
    public String follow(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model = myInformation(model, user);
        return "personal_follow";
    }

    private Model myInformation(Model model,User user){
        model.addAttribute("user",user);
        model.addAttribute("follow",followService.lookfollow(user.getAccount()).size());
        model.addAttribute("coverfollow",followService.coverlookfollow(user.getAccount()).size());
        model.addAttribute("myinvitation",invitationService.lookmyinvitations(user.getAccount()));
        return model;
    }
}
