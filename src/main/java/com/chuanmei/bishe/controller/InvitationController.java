package com.chuanmei.bishe.controller;


import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Invitation;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Controller
@RequestMapping(value = "/blog/invitation")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @PostMapping(value = "/addInvitation")
    public @ResponseBody CommonResult addInvitation(Invitation invitation, HttpServletRequest request) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        invitation.setAccount(user.getAccount());
        invitation.setName(user.getName());
        String text = invitation.getText();
        invitation.setText(null);
        invitationService.publishinvitation(invitation);
//        String fileDirPath = new String("src/main/resources/" + 111);
//        File fileDir = new File(fileDirPath);
//        String absolutePath = fileDir.getAbsolutePath();
        String filepath = ClassUtils.getDefaultClassLoader().getResource("static/txt/").getPath() + invitation.getNumber() + ".txt";
        File file = new File(filepath);
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
        invitationService.updataText(filepath,invitation.getNumber());
        return new CommonResult(200,"成功",true);
    }

    @GetMapping(value = "look/invitation")
    public String lookInvitation(HttpServletRequest request, Model model, int number){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        model.addAttribute("invitation",invitationService.lookinvitation(number));
        return "article";
    }
}
