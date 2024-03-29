/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.controller;

import com.chuanmei.bishe.configure.CommonResult;
import com.chuanmei.bishe.model.Uploads;
import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.service.UploadService;
import com.chuanmei.bishe.service.UserService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.chuanmei.bishe.configure.SaveFile.saveFile;
import static com.chuanmei.bishe.configure.ToolExt.suffix;

@RequestMapping(value = "/blog/uploads")
@Controller
public class UploadsController {

    @Autowired
    private UploadService uploadService;

    @GetMapping(value = "index")
    public String index(Model model,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("list",uploadService.selectList(user.getAccount()));
        return "uploads";
    }

    /**
     * 上传一个文件
     * @param file
     * @param name
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/add/uploads")
    public @ResponseBody CommonResult addUploads(MultipartFile file,String name, HttpServletRequest request) throws Exception {
        User user = (User) request.getSession().getAttribute("user");
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        if(name.equals("")){
            name = file.getOriginalFilename();
        }else {
            name = name + ext;
        }
        String filepath = ClassUtils.getDefaultClassLoader().getResource("static/uploads/").getPath() + name;
        saveFile(ClassUtils.getDefaultClassLoader().getResource("static/uploads/").getPath(), filepath, file);
        return new CommonResult(200,"成功了",uploadService.addUploads(new Uploads(user.getAccount(),name,suffix(ext),filepath)));
    }

    /**
     * 下载一个文件
     * @param request
     * @param name
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/select/uploads")
    public ResponseEntity<byte[]> selectUploads(HttpServletRequest request,String name) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Uploads uploads = uploadService.selectUploads(user.getAccount(),name);
        //创建字节输入流
        InputStream in = new FileInputStream(uploads.getRoute());
        //available():获取输入流所读取的文件的最大字节数
        byte[] body = new byte[in.available()];
        //把字节读取到数组中
        in.read(body);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment",new String(uploads.getName().getBytes("utf-8"),"iso-8859-1"));
        return new ResponseEntity<byte[]>(body,httpHeaders,200);
    }
}
