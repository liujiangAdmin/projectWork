package com.ucmed.hnust.util;

import com.ucmed.hnust.util.weixin.AesException;
import com.ucmed.hnust.util.weixin.WXBizMsgCrypt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by ZY-LJ-1446 on 2018/2/5.
 */
public class UnicodeUtilTest {
    public  static void main(String [] args) throws UnsupportedEncodingException, AesException {

      /* String mrmyList = UnicodeUtil.gbEncoding("对于科学，有比才智更加重要的，那就是真诚希望发现真理而不管它是何种真理。不能驾驭外界，我就驾驭自己，如果外界不适应我，那么我就去适应它们。\\\n" +
               "  一个人如果从不满意自己，那么别人要讨他欢喜也是枉然。有的人一天是你爸爸，那永远是你爸爸");
       String decodeUnicode="\\u9519\\u8bef\\uff08\\u53ef\\u80fd\\u5df2\\u7ecf\\u8d85\\u65f6\\u5931\\u6548\\uff09\\uff0c\\u8bf7\\u91cd\\u65b0\\u8bbf\\u95ee\\u5f00\\u59cb\\u95ee\\u8bca";
       decodeUnicode=UnicodeUtil.decodeUnicode(decodeUnicode);
       System.out.print(decodeUnicode);*/


       /*String s="http://test.lj.ucmed.cn:80/jssjfwq/yzurl?msg_signature=45adc2ef1cccb092e3ac570dfa705bef4f3ab608&timestamp=1524121277&nonce=1524170168&echostr=7koSO66qJVqVuPgsMn4U%2BWh1StOtcx4Gq0O34O%2BGDFLVVhTZf7ODR73ctT8kXe%2F5y04y%2F%2BF3n793MzY17pKHeA%3D%3D";
       String s1=URLDecoder.decode(s,"utf-8");
        System.out.print(s1);
        String msg_signature ="45adc2ef1cccb092e3ac570dfa705bef4f3ab608";
        String timestamp="1524121277";
        String nonce="1524170168";
        String echostr="7koSO66qJVqVuPgsMn4U+Wh1StOtcx4Gq0O34O+GDFLVVhTZf7ODR73ctT8kXe/5y04y/+F3n793MzY17pKHeA==";
        WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt("lBEMDTUtuAgiTA","Qrf65Fn4YjowLyHMPmYwPkDKc7ODxU8AjFNKf7SUZfs","wwe1a4da7b2beb9def");
        String res= wxBizMsgCrypt.VerifyURL(msg_signature,timestamp,nonce,echostr);
        System.out.print(res);*/

       /* String h ="P9nAzCzyDtyTWESHep1vC5X9xho%2FqYX3Zpb4yKa9SKld1DsH3Iyt3tP3zNdtp%2B4RPcs8TgAE7OaBO%2BFZXvnaqQ%3D%3D";
        String l=URLDecoder.decode(h,"utf-8");*/
       //JAVA十三位时间戳和PHP十位时间戳转换
        String  java=String.valueOf(System.currentTimeMillis());
        System.out.println(java);
        java=java.substring(0,10);
        System.out.println(java);







    }
}
