package com.zy.common.zangyuecommon.util.excel.annotations;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/24 15:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Excel {

    String value() default "";

    /**
     * 导出表名
     *
     * @return
     */
    @AliasFor("value")
    String name() default "";


    /**
     * 要合并的列，按照左上右下的顺序，用逗号分隔
     * 比如合并第一行的第一列和第二列  0,0,0,1  分别对应开始行，结束行，开始列，结束列
     *
     * @return
     */
    String[] addresses() default {""};


    /**
     * 边框
     *
     * @return
     */
    Border border() default @Border;


}
