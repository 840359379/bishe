package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Uploads;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.UploadService;
import com.chuanmei.bishe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

import static com.chuanmei.bishe.configure.SaveFile.saveFile;
import static com.chuanmei.bishe.configure.ToolExt.suffix;

@RequestMapping(value = "/blog/uploads")
@Controller
public class UploadsController {

    @Autowired
    private UploadService uploadService;

    @GetMapping(value = "index")
    public String index(Model model,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        model.addAttribute("list",uploadService.selectList(user.getAccount()));
        return "uploads";
    }

    @PostMapping(value = "/add/uploads")
    public @ResponseBody CommonResult addUploads(MultipartFile file,String name, HttpServletRequest request) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String filepath = ClassUtils.getDefaultClassLoader().getResource("static/txt/").getPath() + name + ext;
        saveFile(ClassUtils.getDefaultClassLoader().getResource("static/txt/").getPath(), filepath, file);
        return new CommonResult(200,"成功了",uploadService.addUploads(new Uploads(user.getAccount(),name,suffix(ext),filepath)));
    }
}
