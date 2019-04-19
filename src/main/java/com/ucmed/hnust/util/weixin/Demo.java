package com.ucmed.hnust.util.weixin;

import com.alibaba.fastjson.JSONObject;
import com.ucmed.hnust.util.HttpPostKeyValue;
import com.ucmed.hnust.util.HttpRequestPost;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZY-LJ-1446 on 2018/5/3.
 */
public class Demo {

    public static void main(String[] args) {
        Demo d = new Demo();
        d.show();
    }

    public void show()
    {
       /* String url="http://test.wxmedpay.ucmed.cn/weixinmedpay/getmedinfo";
        String outString="<xml>\n" +
                "<sub_openid>oweNkuJxtizSuvQxxR1gK-G1P8ws</sub_openid>\n" +
                "<name>鲍佳珍</name>\n" +
                "<idcard_md5>1abe31ad5ef369edb0342be6ec6419f3</idcard_md5>\n" +
                "<nonce_str>68264bdb65b97eeae6788aa3348e553c</nonce_str>\n" +
                "<sign>88BF8D3199F94B4A2D299158D7FB71C7</sign>\n" +
                "<biz_id>Xls5eb6O</biz_id>\n" +
                "</xml>";
       String res = HttpRequestPost.HttpRequest(url,"POST",outString);
       System.out.print("res:"+res);

       */

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("app_code", "12ced41c-92d4-47cd-bf55-a272e865eb20");
        param.put("phone", "17682311759");
        // 请求用户中心数据
        JSONObject res = HttpPostKeyValue.sendPost(
                "http://ylxz.zwjk.com/ThirdPartyUserCenter/SecretLogin",
                param, "utf-8");
        System.out.print(res);


    }
}
