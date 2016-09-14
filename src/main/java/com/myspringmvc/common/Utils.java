package com.myspringmvc.common;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by yangliangbin on 2016/9/8.
 */
public class Utils {

    /**
     * 转换时间字符串
     *
     * @param date
     * @return
     */
    public static String DateToString(Date date) {
        return DateToString(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String DateToString(Date obj, String format) {
        Date date = new Date();
        SimpleDateFormat dateFromat = new SimpleDateFormat(format);
        return dateFromat.format(date);
    }

    /**
     * 生成32位UUID 并去掉"-"
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * MD5加密
     *
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String md5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}