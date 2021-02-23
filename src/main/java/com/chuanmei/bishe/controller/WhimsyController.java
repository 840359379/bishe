package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.WhimsyService;
import com.sun.deploy.net.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog/whimsy")
public class WhimsyController {

    @Autowired
    private WhimsyService whimsyService;

    @GetMapping(value = "/index")
    public String index(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        return "whimsy";
    }

    @GetMapping(value = "/list/whimsy")
    public String listWhimsy(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        model.addAttribute("list",whimsyService.selectList(null));
        return "listWhimsy";
    }

    @GetMapping(value = "/add/whimsy")
    public String addWhimsy(){
        return "addWhimsy";
    }
}
