package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.InvitationService;
import com.chuanmei.bishe.service.MessageService;
import com.chuanmei.bishe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog/visit")
public class VisitController {

    @Autowired
    private UserService userService;

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/index")
    public String index(String account, Model model){
        User user = userService.chaname(account);
        model.addAttribute("user",user);
        return "visit";
    }

    @GetMapping(value = "/invitation/{account}")
    public String invitation(@PathVariable("account") String account, Model model){
        User user = userService.chaname(account);
        model.addAttribute("user",user);
        model.addAttribute("list",invitationService.lookmyinvitations(account));
        return "invitation";
    }

    @GetMapping(value = "/leave/{account}")
    public String leave(@PathVariable("account") String account, Model model, HttpServletRequest request){
        User user = userService.chaname(account);
        User my = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        model.addAttribute("list",messageService.selectMessages(account));
        model.addAttribute("my",my);
        return "leave";
    }
}
