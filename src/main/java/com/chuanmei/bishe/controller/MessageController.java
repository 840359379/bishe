package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Message;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "/blog/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/index")
    public String index(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("user");
        List<Message> list = messageService.selectMessages(user.getAccount());
        model.addAttribute("list",list);
        return "message";
    }

    /**
     * 删除一个留言
     * @param id
     * @return
     */
    @PostMapping(value = "/delete/message")
    public @ResponseBody CommonResult deleteMessage(int id){
        return new CommonResult(200,"已删除",messageService.deleteMessage(id));
    }

    /**
     * 添加一个留言
     * @param request
     * @param message
     * @return
     */
    @PostMapping(value = "/add/message")
    public @ResponseBody CommonResult addMessage(HttpServletRequest request,Message message){
        User user = (User) request.getSession().getAttribute("user");
        message.setAccount(user.getAccount());
        return new CommonResult(200,"成功了",messageService.addMessage(message));
    }

    @GetMapping(value = "/socket")
    public String socket(){
        return "socket";
    }
}
