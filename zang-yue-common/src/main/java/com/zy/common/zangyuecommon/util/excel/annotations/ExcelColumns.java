package com.zy.common.zangyuecommon.util.excel.annotations;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/24 15:07
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelColumns {

    /**
     * 表头，默认为实体类字段名
     *
     * @return
     */
    String value() default "";

    /**
     * 表头
     *
     * @return
     */
    @AliasFor("value")
    String column() default "";

    /**
     * 排序
     *
     * @return
     */
    int sort() default 0;


    /**
     * 水平排列方式
     *
     * @return
     * @see HorizontalAlignment#GENERAL
     * @see HorizontalAlignment#LEFT
     * @see HorizontalAlignment#CENTER
     * @see HorizontalAlignment#RIGHT
     * @see HorizontalAlignment#FILL
     * @see HorizontalAlignment#JUSTIFY
     * @see HorizontalAlignment#CENTER_SELECTION
     * @see HorizontalAlignment#DISTRIBUTED
     */
    HorizontalAlignment alignment() default HorizontalAlignment.LEFT;

    /**
     * 垂直排列方式
     *
     * @return
     * @see VerticalAlignment#TOP
     * @see VerticalAlignment#CENTER
     * @see VerticalAlignment#BOTTOM
     * @see VerticalAlignment#JUSTIFY
     * @see VerticalAlignment#DISTRIBUTED
     */
    VerticalAlignment verticalAlignment() default VerticalAlignment.TOP;


    /**
     * 是否加粗
     *
     * @return
     */
    boolean isBold() default false;

    /**
     * 是否使用斜体
     *
     * @return
     */
    boolean isItalic() default false;


    /**
     * 是否使用删除线，水平线
     *
     * @return
     */
    boolean isStrikeout() default false;

    /**
     * 字体颜色
     *
     * @see Font#COLOR_NORMAL
     * @see Font#COLOR_RED
     * @see org.apache.poi.hssf.usermodel.HSSFPalette#getColor(short)
     */
    short color() default Font.COLOR_NORMAL;

    /**
     * @return
     * @see Font#U_NONE
     * @see Font#U_SINGLE
     * @see Font#U_DOUBLE
     * @see Font#U_SINGLE_ACCOUNTING
     * @see Font#U_DOUBLE_ACCOUNTING
     */
    byte underline() default Font.U_NONE;


    /**
     * 日期格式化
     *
     * @return
     */
    String dataFormat() default "";
}
