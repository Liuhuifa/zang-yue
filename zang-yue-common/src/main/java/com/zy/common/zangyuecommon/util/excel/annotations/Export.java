package com.zy.common.zangyuecommon.util.excel.annotations;

import com.zy.common.zangyuecommon.util.excel.export.template.DefaultExcelExport;
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
    Class<?> value();

    Class<?> template() default DefaultExcelExport.class;

    /**
     * 文件名
     *
     * @return
     */
    String fileName() default "";

}
