package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Content;
import com.chuanmei.bishe.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/blog/content")
public class ContentController {

    @Autowired
    public ContentService contentService;

    @PostMapping(value = "/delete/content")
    public @ResponseBody CommonResult deleteContent(int id){
        boolean data = contentService.deleteContent(id);
        return new CommonResult(200,"成功了",data);
    }

    @PostMapping(value = "/add/content")
    public @ResponseBody CommonResult addContent(Content content){
        return new CommonResult(200,"成功了",contentService.addContent(content));
    }
}
