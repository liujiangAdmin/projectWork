package com.ucmed.hnust.demo;

import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.controller.CookieController;
import org.apache.commons.io.output.WriterOutputStream;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by ZY-LJ-1446 on 2018/7/13.
 */
public class FileDemo {

    private static final Logger logger = Logger.getLogger(FileDemo.class);

    /**
     * 创建文件
     */
    public static boolean createNewFile(String filePath) {
        boolean isTrue = false;
        try {
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            isTrue = file.createNewFile();
        } catch (Exception e) {
            logger.error("创建文件出错", e);
        }
        return isTrue;
    }

    /**
     * 删除文件
     */

    public static boolean deleteFile(String filePath) {
        boolean isTrue = false;
        try {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                isTrue = file.delete();
            }
        } catch (Exception e) {
            logger.error("删除文件出错", e);
        }
        return isTrue;
    }


    public static void main(String[] args) throws IOException {
//        boolean isTrue = FileDemo.createNewFile("D:/liujiang.txt");
//        System.out.print(isTrue);
//
//        Writer write = new FileWriter("D:/liujiang.txt");
//        write.write("liujiang");
//        write.close();
//
//        String demo = "chenhong";
//        byte[] bytes = demo.getBytes();
//        OutputStream out = new FileOutputStream("D:/liujiang.txt", true);
//        out.write(bytes);
//        out.close();
        File file = new File("D:/FileDemo/liujiang.txt");
        logger.info(file.getPath());
        logger.info(file.getName());
        ObjectOutputStream objectOutputStream=null;
    }
}
