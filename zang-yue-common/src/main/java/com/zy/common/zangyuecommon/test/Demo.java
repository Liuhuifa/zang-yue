package com.zy.common.zangyuecommon.test;

import com.zy.common.zangyuecommon.util.excel.annotations.Border;
import com.zy.common.zangyuecommon.util.excel.annotations.Excel;
import com.zy.common.zangyuecommon.util.excel.annotations.ExcelColumns;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.util.Date;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/24 15:55
 */
@Excel(value = "测试表",
        border = @Border(left = BorderStyle.THIN, top = BorderStyle.THIN, right = BorderStyle.THIN, bottom = BorderStyle.THIN),
        addresses = "0,0,0,3")
public class Demo {

    @ExcelColumns(value = "姓名", sort = 3, alignment = HorizontalAlignment.CENTER, verticalAlignment = VerticalAlignment.CENTER)
    private String name;
    @ExcelColumns(value = "年龄", sort = 1)
    private int age;
    @ExcelColumns(value = "地址", sort = 2)
    private String address;
    @ExcelColumns(value = "生日", dataFormat = "yyyy/MM/dd")
    private Date birth;


    public Demo() {
    }

    public Demo(String name, int age, String address, Date birth) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
