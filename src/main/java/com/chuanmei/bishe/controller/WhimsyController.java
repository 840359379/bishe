package com.chuanmei.bishe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/blog/whimsy")
public class WhimsyController {

    @GetMapping(value = "/index")
    public String index(Model model){
        model.addAttribute("yes","yes");
        return "whimsy";
    }
}
