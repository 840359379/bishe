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
import java.util.Date;
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
    public String index(Model model, HttpServletRequest request,String account) {
        User user = (User) request.getSession().getAttribute("user");
        List<Socket> list = socketService.selectUnreadList(user.getAccount());
        if(account != null){
            int situation = 0;
            for (Socket socket : list){
                if(account.equals(socket.getAccount()) || account.equals(socket.getCover())) {
                    situation = 1;
                }else break;
            }
            if(situation == 0){
                User freshUser = userService.chaname(account).get(0);
                list.add(new Socket(0,MyTool.combination(account,user.getAccount()),freshUser.getName(),user.getAccount(),freshUser.getAccount(),freshUser.getName(),
                        0,null,0,null));
            }
        }
        model.addAttribute("user",user);
        model.addAttribute("list",list);
        return "socket";
    }

    @PostMapping(value = "/look/socket")
    @ResponseBody
    public CommonResult lookSocket(HttpServletRequest request,String cover){
        User user = (User) request.getSession().getAttribute("user");
        String combination = MyTool.combination(cover,user.getAccount());
        String coverName = userService.chaname(cover).get(0).getName();
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
        Socket socket2 = new Socket(0,socket.getCombination(), null,socket.getAccount(),socket.getCover(),
                null,1,null,0,socket.getContent());
        return new CommonResult(200,"成功",socketService.addSocket(socket));
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message, toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }

    @PostMapping(value = "off/line")
    @ResponseBody
    public CommonResult offLine(Socket socket){
        socketService.updateIdSocket(socket.getId(),1);
        return new CommonResult(200,"成功",true);
    }
}
