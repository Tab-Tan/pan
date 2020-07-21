package com.pan.controller;

import com.google.gson.Gson;
import com.pan.poji.PanFile;
import com.pan.poji.User;
import com.pan.service.PanFileService;
import com.pan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/panFile")
public class PanFileController {

    @Autowired
    Gson gson;
    @Autowired
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    PanFileService panFileService;

    public PanFileService getPanFileService() {
        return panFileService;
    }

    public void setPanFileService(PanFileService panFileService) {
        this.panFileService = panFileService;
    }

    String msg;

    @RequestMapping(value = "/upload/{colid}",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String upload(@PathVariable("colid") int colid ,@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req) throws IOException {

        //给每个文件生成uuid文件夹，确保安全
        String uuid = UUID.randomUUID().toString();
        String path = req.getServletContext().getRealPath("upload/");
        File realPath = new File(path+uuid);
        if(!realPath.exists()){
            realPath.mkdirs();
        }

        file.transferTo(new File(realPath+"/"+file.getOriginalFilename()));


        String username = (String) req.getSession().getAttribute("user");

        User user = userService.queryByUsername(username);

        String url = uuid+"/"+file.getOriginalFilename();
        String fname = file.getOriginalFilename().substring(0,file.getOriginalFilename().lastIndexOf("."));
        Date date = new Date();
        PanFile panFile = new PanFile(0,new Byte("1"),url,fname,user.getId(),date,colid,0);

        panFileService.upload(panFile);

        msg="1";
        return msg;
    }

    @RequestMapping(value = "/download/{id}",produces = "application/json;charset=utf-8")
    public String download(@PathVariable("id") int id, HttpServletResponse resp, HttpServletRequest req) throws IOException {

        PanFile panFile = panFileService.download(id);

        String path = req.getServletContext().getRealPath("/upload/");
        path+=panFile.getUrl();

        String fileName = panFile.getUrl().substring(panFile.getUrl().lastIndexOf("/")+1);

        resp.reset();//设置页面不缓存，清空buffer
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("multipart/from-data");

        resp.setHeader("Content-Disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));
        File file = new File(path);
        OutputStream out = resp.getOutputStream();
        System.out.println(file);
        InputStream input = new FileInputStream(file);
        byte[] buff = new byte[1024];
        int index=0;
        while ((index=input.read(buff))!=-1){
            out.write(buff,0,index);
            out.flush();
        }
        out.close();
        input.close();

        return "forward:?WEB-INF/view/logininfo.html";
    }

    //查询
    @RequestMapping(value = "/queryfile",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryurl(HttpServletRequest req){

        String username = (String) req.getSession().getAttribute("user");

        int uid = userService.queryByUsername(username).getId();

        List<PanFile> panFiles = panFileService.queryByUid(uid);

        return gson.toJson(panFiles);
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/deleteFile/{ids}",produces = "application/json;charset=utf-8")
    public String delFile(@PathVariable("ids") String ids,HttpServletRequest req){

        String[] values = ids.split(",");

        List<String> list = Arrays.asList(values);

        List<PanFile> panFiles = panFileService.queryInIds(list);

        for (PanFile file:panFiles) {
            String url = file.getUrl();
            String path = req.getServletContext().getRealPath("/upload/");
            String fileItem = path+url;
            String folder = path+url.substring(0,url.lastIndexOf("/"));
            //删除文件
            File del = new File(fileItem);
            del.delete();
            //删除文件夹
            File delFolder = new File(folder);
            delFolder.delete();
        }

        int i = panFileService.delInIds(list);

        msg=String.valueOf(i);

        return msg;
    }

}
