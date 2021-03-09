package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.configure.MyTool;
import com.chuanmei.bishe.model.Socket;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.SocketService;
import com.chuanmei.bishe.service.UserService;
import com.chuanmei.bishe.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping(value = "/blog/chat")
public class WebSocketController {

    @Autowired
    private WebSocketService WebSocketServer;

    @Autowired
    private SocketService socketService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Socket> list = socketService.selectUnreadList(user.getAccount());
        model.addAttribute("user",user);
        model.addAttribute("list",list);
        return "socket";
    }

    @PostMapping(value = "/look/socket")
    @ResponseBody
    public CommonResult lookSocket(HttpServletRequest request,String cover){
        User user = (User) request.getSession().getAttribute("user");
        String combination = MyTool.combination(cover,user.getAccount());
        String coverName = userService.chaname(cover).getName();
        List<Socket> list = socketService.selectChatList(combination);
        for(Socket socket : list){
            if(socket.getAccount().equals(user.getAccount())){
                socket.setName(user.getName());
                socket.setCoverName(coverName);
            }else {
                socket.setName(coverName);
                socket.setCoverName(user.getName());
            }
        }
        socketService.updateSocket(combination,user.getAccount(),0);
        return new CommonResult(200,"成功",list);
    }

    @GetMapping(value = "/add/socket")
    @ResponseBody
    public CommonResult addSocket(Socket socket){
        Socket socket2 = new Socket(socket.getCombination(), null,socket.getAccount(),socket.getCover(),
                null,1,null,0,socket.getContent());
        return new CommonResult(200,"成功",socketService.addSocket(socket));
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message, toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
}
