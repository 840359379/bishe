package com.chuanmei.bishe.controller;


import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Invitation;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.ContentService;
import com.chuanmei.bishe.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.StandardCharsets;


@Controller
@RequestMapping(value = "/blog/invitation")
public class InvitationController {

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private ContentService contentService;

    /**
     *  发一个帖子
     * @param invitation
     * @param request
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/addInvitation")
    public @ResponseBody CommonResult addInvitation(Invitation invitation, HttpServletRequest request) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        invitation.setAccount(user.getAccount());
        invitation.setName(user.getName());
        String text = invitation.getText();
        invitation.setText(null);
        invitationService.publishinvitation(invitation);
//        String basePath = ResourceUtils.getURL("classpath:").getPath() + "static/upload/";
        String filepath = ClassUtils.getDefaultClassLoader().getResource("static/txt/").getPath() + invitation.getNumber() + ".txt";
        File file = new File(filepath);
        FileWriter fw = new FileWriter(file);
        fw.write(text);
        fw.close();
        invitationService.updataText(filepath,invitation.getNumber());
        return new CommonResult(200,"成功",invitation.getNumber());
    }

    /**
     * 查看一个文章
     * @param request
     * @param model
     * @param number
     * @return
     * @throws IOException
     */
    @GetMapping(value = "look/invitation")
    public String lookInvitation(HttpServletRequest request, Model model, int number) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Invitation invitation = invitationService.lookinvitation(number);
        //读出文章
        FileInputStream fileInputStream = new FileInputStream(invitation.getText());
        InputStreamReader reader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        String count = "";
        while((strTmp = buffReader.readLine()) != null){
            count  += strTmp;
        }
        buffReader.close();
        fileInputStream.close();
        //返回值
        invitation.setText(count);
        model.addAttribute("user",user);
        model.addAttribute("invitation",invitation);
        model.addAttribute("content",contentService.selectList(invitation.getNumber()));
        return "article";
    }
}
