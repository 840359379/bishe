/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Administrators;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.AdministratorsService;
import com.chuanmei.bishe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog/landing")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdministratorsService administratorsService;

    @GetMapping(value = "index")
    public String landing(){
        return "landing";
    }

    /**
     * 登录
     * @param id
     * @param pw
     * @param request
     * @return
     */
    @PostMapping(value = "/enroll")
    public @ResponseBody CommonResult enroll(String id, String pw, HttpServletRequest request){
        User user = userService.record(id,pw);
        if(user == null){
            return new CommonResult(404,"登录失败", null);
        }else {
            request.getSession().setAttribute("user", user);
        }
        user.setPassword("******");
        return new CommonResult(200,"登录成功", user);
    }

    /**
     * 管理员登录
     * @param account
     * @param password
     * @param request
     * @return
     */
    @PostMapping(value = "/Administrators")
    public @ResponseBody CommonResult Administrators(String account, String password, HttpServletRequest request){
        Administrators administrators = administratorsService.selectAdministrators(account,password);
        if(administrators == null){
            return new CommonResult(404,"登录失败", null);
        }else {
            request.getSession().setAttribute("user", administrators);
        }
        return new CommonResult(200,"登录成功", administrators);
    }

    /**
     * 更改用户信息
     * @param user
     * @param request
     * @return
     */
    @PostMapping(value = "updateuser")
    public @ResponseBody CommonResult updateuser(User user,HttpServletRequest request){
        User old = (User) request.getSession().getAttribute("user");
        user.setAccount(old.getAccount());
        boolean post = userService.modify(user);
        if(!post){
            return new CommonResult(404,"修改失败",post);
        }
        User newUser= userService.chaname(user.getAccount()).get(0);
        newUser.setPassword("******");
        request.getSession().setAttribute("user", newUser);
        return new CommonResult(200,"修改成功",post);
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public CommonResult register(User user){
        if(userService.record(user.getAccount(),user.getPassword()) == null){
            return new CommonResult(200,"成功",userService.register(user));
        }else {
            return new CommonResult(404,"失败",false);
        }
    }
}
