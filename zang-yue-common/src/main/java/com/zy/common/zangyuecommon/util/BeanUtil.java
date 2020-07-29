package com.zy.common.zangyuecommon.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * <p>
 * bean 对象获取工具类
 * </p>
 *
 * @author lhf
 * @since 2020/7/29 9:43
 */
@Component
public class BeanUtil implements ApplicationContextAware {

    private static ApplicationContext context;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return context.getBean(name, clazz);
    }

    public static <T> T getBean(Class<T> clazz) {
        return context.getBean(clazz);
    }
}
