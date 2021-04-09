package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Content;
import com.chuanmei.bishe.model.Uploads;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.model.Whimsy;
import com.chuanmei.bishe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/blog/backstage")
public class BackstageController {

    @Autowired
    private WhimsyService whimsyService;

    @Autowired
    private UserService userService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ContentService contentService;

    @Autowired
    private InvitationService invitationService;

    @GetMapping(value = "/index")
    public String index(){
        return "backstage";
    }

    @GetMapping(value = "/look/whimsy")
    @ResponseBody
    public CommonResult lookWhimsyList(){
        List<Whimsy> whimsyList = whimsyService.selectList(null);
        return new CommonResult(0,"",whimsyList.size(),whimsyList);
    }

    @GetMapping(value = "/look/users")
    @ResponseBody
    public CommonResult lookUsers(){
        List<User> userList = userService.chaname(null);
        return new CommonResult(0,"",userList.size(),userList);
    }

    @GetMapping(value = "/look/upload")
    @ResponseBody
    public CommonResult lookUpload(){
        List<Uploads> uploadsList = uploadService.selectList(null);
        return new CommonResult(0,"",uploadsList.size(),uploadsList);
    }

    @GetMapping(value = "/look/content")
    @ResponseBody
    public CommonResult lookContent(){
        List<Content> contentList = contentService.selectList(-1);
        return new CommonResult(0,"",contentList.size(),contentList);
    }

    @PostMapping(value = "/delete/data")
    @ResponseBody
    public CommonResult deleteDate(String surface,int event){
        boolean situation;
        switch (event){
            case 1:
                situation = invitationService.deleteinvitation(Integer.parseInt(surface));
                break;
            case 2:
                situation = whimsyService.deleteWhimsy(Integer.parseInt(surface));
                break;
            case 3:
                situation = contentService.deleteContent(Integer.parseInt(surface));
                break;
            case 4:
                situation = uploadService.deleteUploads(surface);
                break;
            default:
                situation = true;
        }
        return new CommonResult(200,"成功",situation);
    }
}
