package com.ucmed.hnust.util;



import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.UUID;

/**
 * Created by ZY-LJ-1446 on 2018/5/4.
 * Java常用工具类
 */
public class Tool {


    /**
     * byte to String
     *
     * @param hash
     * @return
     */
    public static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    /**
     * 生成签名的时间戳
     *
     * @return
     */
    public static String getTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    /**
     * 生成签名的随机串
     *
     * @return
     */
    public static String getNoncestr() {
        return UUID.randomUUID().toString();
    }
    /**
     * 对字符串作sha1加密
     *
     * @param str
     * @return
     */
    public static String getSha1(String str) {
        String signature = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(str.getBytes("UTF-8"));
            signature = Tool.byteToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {

        } catch (UnsupportedEncodingException e) {

        }
        return signature;
    }
}
