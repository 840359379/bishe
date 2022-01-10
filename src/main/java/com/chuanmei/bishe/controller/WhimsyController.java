/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.configure.MyTool;
import com.chuanmei.bishe.configure.RedisTool;
import com.chuanmei.bishe.configure.ToolExt;
import com.chuanmei.bishe.model.Uploads;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.model.Whimsy;
import com.chuanmei.bishe.service.UploadService;
import com.chuanmei.bishe.service.UserService;
import com.chuanmei.bishe.service.WhimsyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.chuanmei.bishe.configure.SaveFile.saveFile;

@Controller
@RequestMapping(value = "/blog/whimsy")
public class WhimsyController {

    @Autowired
    private WhimsyService whimsyService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/index")
    public String index(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
//        model.addAttribute("signIn", 0);
        model.addAttribute("signIn", RedisTool.testing(user.getAccount(),"signIn"));
        return "whimsy";
    }

    /**
     * 转到随想
     * @param model
     * @param request
     * @return
     */
    @GetMapping(value = "/list/whimsy")
    public String listWhimsy(Model model, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("user",user);
        model.addAttribute("list",whimsyService.selectList(null));
        return "listWhimsy";
    }

    /**
     * 转到添加随想
     * @return
     */
    @GetMapping(value = "/add/whimsy")
    public String addWhimsy(){
        return "addWhimsy";
    }

    /**
     * 发表一篇随想
     * @param file
     * @param whimsy
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/increase/whimsy")
    public @ResponseBody CommonResult increaseWhimsy(MultipartFile[] file, Whimsy whimsy, HttpServletRequest request) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        whimsy.setAccount(user.getAccount());
        whimsyService.addWhimsy(whimsy);
        String behind = null;
        if(file != null){
            for (int count = 0;count < file.length ;count++){
                String ext = file[count].getOriginalFilename().substring(file[count].getOriginalFilename().lastIndexOf("."));
                String name = MyTool.uuid() + ext;
                if(count == 0){
                    behind = "/static/uploads/"+name;
                }
                String filepath = ClassUtils.getDefaultClassLoader().getResource("static/uploads/").getPath() + name;
                saveFile(ClassUtils.getDefaultClassLoader().getResource("static/uploads/").getPath(), filepath, file[count]);
                uploadService.addUploads(new Uploads(0,user.getAccount(),name, ToolExt.suffix(ext),"/static/uploads/"+name,null,whimsy.getId()));
            }
        }
        whimsy.setBehind(behind);
        if (whimsy.getSeries() == 0){
            whimsy.setSeries(whimsy.getId());
        }
        whimsyService.updateWhimsy(whimsy);
        return new CommonResult(200,"成功了",true);
    };

    /**
     * 转到看随想的页面
     * @param model
     * @param whimsy
     * @return
     */
    @GetMapping(value = "/look/whimsy")
    public String lookWhimsy(Model model,Whimsy whimsy){
        List<Whimsy> list = whimsyService.seriesWhimsy(whimsy.getSeries());
        for(Whimsy x : list){
            x.setList(uploadService.selectGeared(x.getId()));
        }
        User user = userService.chaname(whimsy.getAccount()).get(0);
        user.setPassword("******");
        model.addAttribute("list",list);
        model.addAttribute("user",user);
        return "lookWhimsy";
    }

    @PostMapping(value = "/add/coin")
    @ResponseBody
    public CommonResult addCoin(int count,String coverAccount,int number,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(user.getCoin() < count){
            return new CommonResult(404,"硬币不足",false);
        }else {
            userService.operatedCoin(user.getAccount(),coverAccount,count,number);
            user.setCoin(user.getCoin()-count);
            request.getSession().setAttribute("user",user);
            return new CommonResult(200,"成功",true);
        }
    }

    @GetMapping(value = "test")
    @ResponseBody
    public Integer test(int id){
        int count = whimsyService.test(id);
        return count;
    }
}
