package com.freemvc.common;

import java.lang.annotation.*;

/**
 * Created by yangliangbin on 2016/9/9.
 * 数据表注解（用于声明Model与数据库表的映射关系）
 */
@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target(ElementType.TYPE)
public @interface TableMapping {

    /*数据表名,不区分大小写*/
    String tableName();

    /*数据表主键，默认为ID,不区分大小写*/
    String primaryKey() default "ID";
}
