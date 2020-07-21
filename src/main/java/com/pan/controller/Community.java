package com.pan.controller;

import com.google.gson.Gson;
import com.pan.poji.PanFile;
import com.pan.service.PanFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/share")
public class Community {

    @Autowired
    PanFileService panFileService;

    @Autowired
    Gson gson;

    @ResponseBody
    @RequestMapping("/download/{id}")
    public String downloadShare(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PanFile panFile = panFileService.download(id);

        String url = panFile.getUrl();
        String path = req.getServletContext().getRealPath("/upload/");

        File downFile = new File(path+url);
        //流操作
        InputStream in = new FileInputStream(downFile);
        ServletOutputStream out = resp.getOutputStream();

        byte[] buffer = new byte[1024*1024];
        int len = 0;

        while ((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }

        return "1";
    }

    @ResponseBody
    @RequestMapping(value = "/queryopen",produces = "applicationn/json;charset=utf-8")
    public String queryOpen(){
        Byte b = 1;

        List<PanFile> panFiles = panFileService.queryOpen(b);

        return gson.toJson(panFiles);
    }

}
