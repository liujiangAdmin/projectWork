package com.ucmed.hnust.controller;

import com.ucmed.hnust.controller.enterpriseWeChat.PublicVariable;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;
import java.util.Random;

/**
 * Created by ZY-LJ-1446 on 2018/2/5.
 */
@Controller
@RequestMapping(value = "/")
public class Index {

    Logger logger = Logger.getLogger(Index.class);

    @Value("${mymy.list}")
    private String mrmyList;

    @RequestMapping(value = "/",method= RequestMethod.GET)
    public String show(HttpServletRequest request, Model model, ModelMap map, HttpServletResponse response)
    {
        //logger.info(mrmyList);
        String [] mrmyArray =  mrmyList.split("。");
        Random r = new Random();
        int randomNumber = r.nextInt(mrmyArray.length);
        String randomMrmy=mrmyArray[randomNumber];
        map.put("randomMrmy",randomMrmy);
        return "index";
    }
    @RequestMapping(value = "/fileUpload",method= RequestMethod.GET)
    public String fileUpload(HttpServletRequest request, Model model, ModelMap map, HttpServletResponse response)
    {
        logger.info(mrmyList);
        String [] mrmyArray =  mrmyList.split("。");
        Random r = new Random();
        int randomNumber = r.nextInt(mrmyArray.length);
        String randomMrmy=mrmyArray[randomNumber];
        map.put("randomMrmy",randomMrmy);
        return "chenhongDaughter1";
    }

    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String upload(HttpServletRequest request,
                         @RequestParam("description") String description,
                         @RequestParam("file") MultipartFile file) throws Exception {
        System.out.println(description);
        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String a =request.getServletContext().getRealPath("");
            String path = PublicVariable.fileuploaduri;
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            return "success";
        } else {
            return "error";
        }
    }

    public void one(String yiyuan) throws IOException {
            Properties properties = new Properties();
             InputStream input = null;
            input =  getClass().getClassLoader().getResourceAsStream("other/mrmy.properties");
            properties.load(input);
           //获取key对应的value值
            String aaa=properties.getProperty(yiyuan+".aaa");
            String bbb=properties.getProperty(yiyuan+".bbb");
            System.out.println(aaa);
            System.out.println(bbb);
    }

    public static void main(String[] args) throws IOException {
        Index index  =new Index();
        index.one("sfb");


        index.one("zjkj");
    }

}
