package com.myspringmvc.contract;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangliangbin on 2016/9/13.
 */
public class MC {
    /**
     * msgCode提示语数据
     */
    private static Map map;

    /**
     *静态构造器
     */
    static {
        map = new HashMap();
        map.put("99999", "接口异常,操作失败！");
        map.put("10000", "操作成功！");
        map.put("10001", "用户名不存在！");
        map.put("10002", "密码不正确！");
        map.put("10003", "！");
        map.put("10004", "！");
        map.put("10005", "！");
        map.put("10006", "！");
        map.put("10007", "！");
    }

    /**
     * 获取对应MsgCode的提示语
     *
     * @param msgCode
     * @return
     */
    public static String GetMsgContent(String msgCode) {
        if (map.containsKey(msgCode))
            return map.get(msgCode).toString();
        return "";
    }
}
