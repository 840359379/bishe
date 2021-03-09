package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Collection;
import com.chuanmei.bishe.model.Follow;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 收藏的接口
 */
@Controller
@RequestMapping(value = "/blog/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private FollowService followService;

    @Autowired
    private GoodService goodService;

    @Autowired
    private WhimsyService whimsyService;

    @GetMapping(value = "/index")
    public String index(HttpServletRequest request, Model model){
        User user = (User) request.getSession().getAttribute("user");
        List<Collection> list = collectionService.lookCollections(user.getAccount());
        model.addAttribute("list",list);
        return "collection";
    }

    /**
     * 操作收藏的函数
     * @param number
     * @param request
     * @return
     */
    @PostMapping(value = "/operation/collection")
    public @ResponseBody CommonResult operationCollection(String number,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        if(collectionService.seletCollection(number, user.getAccount())){
            return new CommonResult(200,"收藏",collectionService.deleteCollection(number, user.getAccount()));
        }else {
            return new CommonResult(200,"取消收藏",collectionService.addCollection(number, user.getAccount()));
        }
    }


    /**
     * 获取属性填充的函数
     * @param request
     * @return
     */
    @GetMapping(value = "/obtain")
    public @ResponseBody CommonResult obtain(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Map<String,String> map = new HashMap<>();
        map.put("myCount",invitationService.lookmyinvitations(user.getAccount()).size() + "");
        map.put("yesterdayAdd",followService.yesterdayFollow(user.getAccount()) + "");
        map.put("lookTime",collectionService.selectTime(user.getAccount()));
        map.put("yesterdayGood",goodService.yesterdayGood(user.getAccount())+"");
        map.put("whimsy",whimsyService.selectList(user.getAccount()).size()+"");
        return new CommonResult(200,"操作成功",map);
    }
}
