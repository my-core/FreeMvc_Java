package com.myspringmvc.common;

import com.myspringmvc.controller.HomeController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Created by yangliangbin on 2016/9/12.
 * log4j帮助类(commons-logging)
 */
public class Log4jHelper {
    /**
     * 日志记录器对象
     */
    //private static Logger log;
    private static Log log;

    /**
     * 静态构造函数
     */
    static {
        //BasicConfigurator.configure();
        //log = Logger.getLogger(Log4jHelper.class);
        log = LogFactory.getLog(Log4jHelper.class);
    }

    /**
     * debug
     * @param module
     * @param method
     * @param message
     */
    public static void debug(String module ,String method,String message) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\n module:" + module);
        sb.append("\n\n method:" + method);
        sb.append("\n\n messge:" + message);
        log.debug(sb.toString());
    }

    /**
     * info
     * @param module
     * @param method
     * @param message
     */
    public static void info(String module ,String method,String message) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\n module:" + module);
        sb.append("\n\n method:" + method);
        sb.append("\n\n messge:" + message);
        log.info(sb.toString());
    }

    /**
     * warn
     * @param module
     * @param method
     * @param message
     */
    public static void warn(String module ,String method,String message) {
        StringBuffer sb = new StringBuffer();
        sb.append("module:" + module);
        sb.append("\r\n method:" + method);
        sb.append("\r\n messge:" + message);
        log.warn(sb.toString());
    }

    /**
     * error
     * @param module
     * @param method
     * @param message
     * @param ex
     */
    public static void error(String module ,String method,String message,Exception ex) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\n module:" + module);
        sb.append("\n\n method:" + method);
        sb.append("\n\n messge:" + message);
        if (ex != null) {
            sb.append("\nexception:" + ex.getMessage());
        }
        log.error(sb.toString());
    }

    /**
     * fatal
     * @param module
     * @param method
     * @param message
     * @param ex
     */
    public static void fatal(String module ,String method,String message,Exception ex) {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\n module:" + module);
        sb.append("\n\n method:" + method);
        sb.append("\n\n messge:" + message);
        if (ex != null) {
            sb.append("\nexception:" + ex.getMessage());
        }
        log.fatal(sb);
    }
}
