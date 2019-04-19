package com.ucmed.hnust.controller.enterpriseWeChat.addressBookManagement;

import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvWriter;
import com.ucmed.hnust.controller.enterpriseWeChat.PublicVariable;
import com.ucmed.hnust.controller.enterpriseWeChat.TokenUtil;
import com.ucmed.hnust.pojo.Dept;
import com.ucmed.hnust.service.DeptService;
import com.ucmed.hnust.util.HttpRequestGet;
import com.ucmed.hnust.util.HttpRequestPost;
import com.ucmed.hnust.util.QywxUploadPost;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ZY-LJ-1446 on 2018/4/20.
 * 通讯录异步批量接口
 */
@Controller
@RequestMapping(value = "/asynchronousBatch")
public class AsynchronousBatch {
    private static final Logger logger = Logger.getLogger(AsynchronousBatch.class);
    @Autowired
    private DeptService deptService;
    @Autowired
    private TokenUtil tokenUtil;

    /**全量覆盖部门*/
    @ResponseBody
    @RequestMapping(value = "/fullCoverageDepartment", method = RequestMethod.GET)
    public String fullCoverageDepartment() throws IOException {
        List<Dept> list = deptService.selectDept();
        logger.info(JSONObject.toJSONString(list));

        //生成csv文件
        File file = new File(PublicVariable.fileuploaduri+"dept.csv");
        if (file.exists())
        {
            if(file.delete())
            {
                file.createNewFile();
            }else{
                logger.info("");
                return "error";
            }
        }else{
            file.createNewFile();
        }
        CsvWriter csvWriter = new CsvWriter(file.getCanonicalPath(),',', Charset.forName("UTF-8"));
        long start= System.currentTimeMillis();
        String[] headers = {"部门名称","部门ID","父部门ID","排序"};
        csvWriter.writeRecord(headers);
        for (Dept dept : list)
        {
            csvWriter.write(dept.getDeptName());
            csvWriter.write(dept.getDeptId().toString());
            csvWriter.write(dept.getParentDeptId().toString());
            csvWriter.write(dept.getSortBy().toString());
            csvWriter.endRecord();
        }
        csvWriter.close();
        long end=System.currentTimeMillis();
        logger.info("时间戳:"+(end-start));

        //进行素材上传
        String url= PublicVariable.uploadrui+ tokenUtil.gettxlTokenImpl()+"&type=file";
        String filePath = file.getPath();
        String result= QywxUploadPost.send(url,filePath);
        logger.info("素材上传:"+result);
        //全量覆盖部门
        JSONObject jsonObject = JSONObject.parseObject(result);
        String mediaId=jsonObject.getString("media_id");
        JSONObject deptInput = new JSONObject();
        deptInput.put("media_id",mediaId);
        String res= HttpRequestPost.HttpRequest(PublicVariable.deptall+tokenUtil.gettxlTokenImpl(),"POST",deptInput.toString());
        logger.info(res);
        //获取异步任务结果
        JSONObject jsonObject1 = JSONObject.parseObject(res);
        String jobId=jsonObject1.getString("jobid");
        Map<String, Object> map = new HashMap<>();
        map.put("access_token",tokenUtil.gettxlTokenImpl());
        map.put("jobid",jobId);
        JSONObject res1 =  HttpRequestGet.sendGet(PublicVariable.hqybrwjg,map,"utf-8");
        logger.info(res1);
        logger.info(res1);
        logger.info(res1);
        return res1.toString();
    }
}
