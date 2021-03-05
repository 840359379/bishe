package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.model.Socket;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.SocketService;
import com.chuanmei.bishe.service.WebSocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/index")
    public String index(Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Socket> list = socketService.selectUnreadList(user.getAccount());
        model.addAttribute("user",user);
        model.addAttribute("list",list);
        return "socket";
    }

    @RequestMapping("/push/{toUserId}")
    public ResponseEntity<String> pushToWeb(String message, @PathVariable String toUserId) throws IOException {
        WebSocketServer.sendInfo(message, toUserId);
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
}
