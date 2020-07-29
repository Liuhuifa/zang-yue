package com.zy.common.zangyuecommon.util;

import com.zy.common.zangyuecommon.annotations.Ignore;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <p>
 * 实体类之间的转换
 * </p>
 *
 * @author lhf
 * @since 2020/7/29 11:39
 */
public class EntityUtil<T, E> {


    /**
     * 实体类之间的转换
     *
     * @param t     当前实体类
     * @param clazz 目标实体类
     * @return 返回转换后的对象
     */
    public static <T, E> E transformation(T t, Class<E> clazz) {
        E e = null;
        try {
            e = clazz.newInstance();
            Field[] fields = t.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!field.isAnnotationPresent(Ignore.class)) {
                    field.setAccessible(true);
                    Field declaredField = clazz.getDeclaredField(field.getName());
                    declaredField.setAccessible(true);
                    declaredField.set(e, field.get(t));
                }
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchFieldException instantiationException) {
            instantiationException.printStackTrace();
        }


        return e;
    }

}
