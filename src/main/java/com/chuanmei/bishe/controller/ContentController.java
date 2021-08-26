/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Content;
import com.chuanmei.bishe.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/blog/content")
public class ContentController {

    @Autowired
    public ContentService contentService;

    /**
     * 删除一个评论
     * @param id
     * @return
     */
    @PostMapping(value = "/delete/content")
    public @ResponseBody CommonResult deleteContent(int id){
        boolean data = contentService.deleteContent(id);
        return new CommonResult(200,"成功了",data);
    }

    /**
     * 添加一个评论
     * @param content
     * @return
     */
    @PostMapping(value = "/add/content")
    public @ResponseBody CommonResult addContent(Content content){
        return new CommonResult(200,"成功了",contentService.addContent(content));
    }
}
