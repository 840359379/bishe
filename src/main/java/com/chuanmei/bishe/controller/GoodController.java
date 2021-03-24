package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Good;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/blog/good")
public class GoodController {
    @Autowired
    private GoodService goodService;

    /**
     * 操作我的点赞
     * @param good
     * @param request
     * @return
     */
    @PostMapping("/operation/good")
    public @ResponseBody CommonResult operationCollection(Good good, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        good.setAccount(user.getAccount());
        Good oldGood = goodService.selectGood(good.getNumber(), good.getAccount());
        if(oldGood==null){
            return new CommonResult(200,"添加成功",goodService.addgood(good));
        }else
            if(oldGood.getSituation() == good.getSituation()){
            good.setSituation(0);
            return new CommonResult(201,"取消",goodService.updategood(good));
        }else {
            return new CommonResult(200,"修改成功",goodService.updategood(good));
        }
    }

    @ResponseBody
    @GetMapping("/look/goodNumber")
    public CommonResult lookGoodNumber(String number,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<Good> goodList = goodService.lookgoodnr(number);
        Map<String,Integer> map = new HashMap<>();
        int situation = 0;
        for (Good good : goodList){
            if(good.getAccount().equals(user.getAccount())){
                situation = good.getSituation();
            }
        }
        map.put("count",goodList.size());
        map.put("situation",situation);
        return new CommonResult(200,"成功",map);
    }
}
