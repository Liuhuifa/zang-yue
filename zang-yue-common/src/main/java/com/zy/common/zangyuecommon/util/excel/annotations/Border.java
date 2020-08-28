package com.zy.common.zangyuecommon.util.excel.annotations;

import org.apache.poi.ss.usermodel.BorderStyle;

import java.lang.annotation.*;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/28 11:06
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target({ElementType.ANNOTATION_TYPE})
public @interface Border {

    BorderStyle left() default BorderStyle.NONE;
    BorderStyle top() default BorderStyle.NONE;
    BorderStyle right() default BorderStyle.NONE;
    BorderStyle bottom() default BorderStyle.NONE;

}
