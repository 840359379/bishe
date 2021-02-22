package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = "/blog/uploads")
@Controller
public class UploadsController {

    @GetMapping(value = "index")
    public String index(Model model){
        return "uploads";
    }

    @PostMapping(value = "/add/uploads")
    public @ResponseBody CommonResult addUploads(MultipartFile file,String name, HttpServletRequest request){
//        String filepath = ClassUtils.getDefaultClassLoader().getResource("static/txt/").getPath() + name + ".txt";
        String y = file.getOriginalFilename();
        String x =  file.getContentType();
        return new CommonResult();
    }
}
