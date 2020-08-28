package com.zy.common.zangyuecommon.util.excel.export.proxy;

import com.zy.common.zangyuecommon.util.excel.annotations.Export;
import com.zy.common.zangyuecommon.util.excel.export.AbstractExcel;
import com.zy.common.zangyuecommon.util.excel.export.template.DefaultExcelExport;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/28 16:27
 */
@Aspect
@Component
public class ExcelAop {

    @Pointcut(value = "@annotation(com.zy.common.zangyuecommon.util.excel.annotations.Export)")
    public void pointcut() {
    }


    @AfterReturning(value = "pointcut()", returning = "obj")
    public void around(JoinPoint point, Object obj) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        Export annotation = method.getAnnotation(Export.class);
        Class clazz = annotation.value();
        String fileName = annotation.fileName();

        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        AbstractExcel excel = new DefaultExcelExport<>();
        excel.export(clazz, (List) obj, fileName,null);
    }
}
