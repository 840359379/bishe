package com.chuanmei.bishe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/blog/uploads")
@Controller
public class UploadsController {

    @GetMapping(value = "index")
    public String index(Model model){
        return "uploads";
    }
}
