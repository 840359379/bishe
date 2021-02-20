package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Good;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/blog/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @PostMapping("/operation/good")
    public @ResponseBody CommonResult operationCollection(Good good, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        good.setAccount(user.getAccount());
        Good oldGood = goodService.selectGood(good.getNumber(), good.getAccount());
        if(oldGood==null){
            return new CommonResult(200,"添加成功",goodService.addgood(good));
        }else if(oldGood.getSituation() == good.getSituation()){
            good.setSituation(0);
            return new CommonResult(201,"取消",goodService.updategood(good));
        }else {
            return new CommonResult(200,"修改成功",goodService.updategood(good));
        }
    }
}
