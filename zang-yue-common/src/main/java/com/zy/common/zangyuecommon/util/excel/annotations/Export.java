package com.zy.common.zangyuecommon.util.excel.annotations;

import org.apache.poi.ss.formula.functions.T;

import java.lang.annotation.*;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/28 16:33
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.METHOD})
public @interface Export {

    /**
     * 类型
     *
     * @return
     */
    Class value();

    /**
     * 文件名
     *
     * @return
     */
    String fileName() default "";

}
