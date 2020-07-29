package com.zy.common.zangyuecommon.annotations;

import java.lang.annotation.*;

/**
 * <p>
 * 标识不需要转换的字段
 * </p>
 *
 * @author lhf
 * @since 2020/7/29 16:55
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Ignore {
}
