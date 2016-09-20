package com.freemvc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by yangliangbin on 2016/9/21.
 * 全局配置
 */
@Component
public class GlobalConfig {

    /**
     * 是否开启拦截请求日志
     */
    @Value("#{setting['global.config.isOpenLog']}")
    private boolean _isOpenLog;
    public static boolean isOpenLog;

    /**
     * 是否开启拦截请求日志
     */
    @Value("#{setting['global.config.myTest']}")
    private String _myTest;
    public static String myTest;

    public boolean isOpenLog() {
        return _isOpenLog;
    }
    public void setOpenLog(boolean _isOpenLog) {
        System.out.print(_isOpenLog);
        _isOpenLog = _isOpenLog;
    }

    public String isMyTest() {
        return _myTest;
    }
    public void setMyTest(String _myTest) {
        System.out.print(_myTest);
        this._myTest = _myTest;
    }

    /**
     *   被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。
     *   PostConstruct在Servle构造函数之后执行,init()方法之前执行。PreDestroy（）方法在destroy()方法执行执行之后执行
     */
    @PostConstruct
    public void initConfig() {
        isOpenLog = _isOpenLog;
        myTest = _myTest;
    }
}
