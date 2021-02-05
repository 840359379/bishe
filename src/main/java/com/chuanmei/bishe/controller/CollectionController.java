package com.chuanmei.bishe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog/collection")
public class CollectionController {
    @GetMapping(value = "/index")
    public String index(HttpServletRequest request, Model model){
        return "collection";
    }
}
