package com.zy.common.zangyuecommon.test;

import com.zy.common.zangyuecommon.exception.ExcelExportException;
import com.zy.common.zangyuecommon.util.excel.export.AbstractExcel;
import com.zy.common.zangyuecommon.util.excel.export.template.DefaultExcelExport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/24 15:59
 */
public class Test {

    public static void main(String[] args) throws ExcelExportException, IllegalAccessException, IOException, InstantiationException, NoSuchFieldException {
        List<Demo> list = new ArrayList<>();

        Demo demo = new Demo("lhf", 9, "张家口",new Date());
        Demo demo1 = new Demo("zjs", 19, "阳原",new Date());
        Demo demo2 = new Demo("hdz", 91, "中国",new Date());

        list.add(demo);
        list.add(demo1);
        list.add(demo2);

        AbstractExcel<Demo> excelExport = new DefaultExcelExport<>();

//        excelExport.export(Demo.class, list, "测试");

//        Type superclass = excelExport.getClass().getGenericSuperclass();
//        if (superclass instanceof ParameterizedType){
//            ParameterizedType type = (ParameterizedType) superclass;
//            Type typeArgument = type.getActualTypeArguments()[0];
//            System.out.println(typeArgument);
//        }

    }
}
