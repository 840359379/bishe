package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.configure.RedisTool;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog/task")
public class TaskController {

    @Autowired
    private UserService userService;

    /**
     * 获取任务的状态
     * @param model
     * @param request
     * @return
     */
    @GetMapping(value = "/index")
    public String index(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("signIn", RedisTool.testing(user.getAccount(),"signIn"));
        model.addAttribute("good",RedisTool.testing(user.getAccount(), "good"));
        model.addAttribute("whimsy",RedisTool.testing(user.getAccount(), "whimsy"));
        model.addAttribute("content",RedisTool.testing(user.getAccount(), "content"));
        return "task";
    }

    /**
     * 更改任务的状态
     * @param request
     * @param task
     * @param status
     * @return
     */
    @PostMapping(value = "/update/task")
    public @ResponseBody CommonResult updateTask(HttpServletRequest request,String task,int status){
        User user = (User) request.getSession().getAttribute("user");
        RedisTool.addStatus(user.getAccount(),task,status);
        if(userService.addCoin()){
            user.setCoin(user.getCoin()+2);
            request.getSession().setAttribute("user",user);
        }
        return new CommonResult(200,"成功",true);
    }

    @PostMapping(value = "/signIn")
    public @ResponseBody CommonResult signIn(HttpServletRequest request,int status){
        User user = (User) request.getSession().getAttribute("user");
        RedisTool.addStatus(user.getAccount(),"signIn",status);
        return new CommonResult(200,"成功",true);
    }
}
