package com.zy.common.zangyuecommon.util.excel.export;

import com.zy.common.zangyuecommon.util.excel.annotations.Border;
import com.zy.common.zangyuecommon.util.excel.annotations.Excel;
import com.zy.common.zangyuecommon.util.excel.annotations.ExcelColumns;
import com.zy.common.zangyuecommon.util.excel.export.utils.ExcelStyle;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/25 16:12
 */
public abstract class AbstractExcel<T> {

    protected Workbook work = null;
    protected Sheet sheet;

    /**
     * 表名
     */
    protected String excelName = null;
    /**
     * 表头
     */
    protected String[] headers = null;

    /**
     * 合并
     */
    protected CellRangeAddress[] addresses;

    /**
     * 单元格样式
     */
    protected BorderStyle[] borderStyles = new BorderStyle[4];

    /**
     * @param tClass
     * @param list
     * @param fileName
     * @throws IllegalAccessException
     * @throws IOException
     * @throws NoSuchFieldException
     */
    public void export(Class<T> tClass, List<T> list, String fileName, HttpServletResponse response) throws IllegalAccessException, IOException {

        //初始化
        this.init(tClass);

        //创建工作簿
        work = this.createWorkbook();

        //创建表
        this.addSheet();

        //添加表头
        this.head(list, tClass);

        //添加数据
        this.setRowValue(list.size(), (sheet.getLastRowNum() + 1), sheet, list, tClass);

        //添加表尾部
        this.foot();

        //输出到文件
        if (response == null) {
            this.output(fileName);
        } else {
            this.output(fileName, response);
        }

    }

    /**
     * 初始化表
     *
     * @param tClass
     */
    protected void init(Class<T> tClass) {

        if (!tClass.isAnnotationPresent(Excel.class)) {
            throw new IllegalArgumentException("传入类型不是excel实体,请添加@Excel注解");
        }
        Excel annotation = tClass.getAnnotation(Excel.class);

        //地址
        String[] addresses = Arrays.stream(annotation.addresses()).filter(StringUtils::isNotBlank).toArray(String[]::new);
        this.addresses = new CellRangeAddress[addresses.length];
        for (int i = 0; i < addresses.length; i++) {
            String[] str = addresses[i].split(",");
            if (str.length != 4) {
                throw new IllegalArgumentException("合并单元格参数有误!!!!");
            }
            this.addresses[i] = new CellRangeAddress(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]));
        }


        //边框
        Border border = annotation.border();
        borderStyles[0] = border.left();
        borderStyles[1] = border.top();
        borderStyles[2] = border.right();
        borderStyles[3] = border.bottom();

        //表名
        excelName = this.excelName(tClass);
        //表头
        headers = this.headers(tClass);
    }


    /**
     * 创建表
     *
     * @param list
     * @param tClass
     * @throws IllegalAccessException
     */
    protected abstract void head(List<T> list, Class<T> tClass) throws IllegalAccessException;

    /**
     * 表尾
     *
     * @throws IllegalAccessException
     */
    protected abstract void foot() throws IllegalAccessException;

    /**
     * 创建工作簿
     *
     * @return
     */
    protected abstract Workbook createWorkbook();


    /**
     * 创建表
     *
     * @param workbook
     * @param sheetName
     * @return
     */
    protected Sheet addSheet(Workbook workbook, String sheetName) {
        return workbook.createSheet(sheetName);
    }

    /**
     * 创建表
     *
     * @return
     */
    protected void addSheet() {
        sheet = this.work.createSheet();
        this.initSheet();
    }

    /**
     * 初始化表
     */
    private void initSheet() {
        //合并
        for (CellRangeAddress address : addresses) {
            sheet.addMergedRegion(address);
        }
    }

    /**
     * 获取excel的名字
     *
     * @param tClass
     * @return
     */
    private String excelName(Class<T> tClass) {
        Excel excel = tClass.getAnnotation(Excel.class);
        String excelName = excel.value();
        if (StringUtils.isBlank(excelName)) {
            excelName = excel.name();
        }
        return excelName;
    }


    /**
     * 表头
     *
     * @param tClass
     * @return
     */
    private String[] headers(Class<T> tClass) {

        return Arrays.stream(this.sort(tClass)).map(item -> {
            ExcelColumns annotation = item.getAnnotation(ExcelColumns.class);
            String value = annotation.value();
            if (StringUtils.isBlank(value)) {
                value = annotation.column();
            }
            return value;
        }).toArray(String[]::new);

    }

    /**
     * 设置行的值
     *
     * @param cell
     * @param field
     * @param o
     * @return
     * @throws IllegalAccessException
     */
    protected void getCellValue(Cell cell, Field field, Object o) throws IllegalAccessException {
        setCellValue(cell, field, o);
    }

    protected void setCellValue(Cell cell, Field field, Object o) throws IllegalAccessException {
        field.setAccessible(true);
        Object o1 = field.get(o);

        if (o1 instanceof String) {
            cell.setCellValue((String) o1);
        } else if (o1 instanceof Boolean) {
            cell.setCellValue((Boolean) o1);
        } else if (o1 instanceof Double) {
            cell.setCellValue((Double) o1);
        } else if (o1 instanceof Date) {
            SimpleDateFormat format = new SimpleDateFormat(this.format(field));
            cell.setCellValue(format.format((Date) o1));
        } else if (o1 instanceof LocalDateTime) {
            cell.setCellValue((LocalDateTime) o1);
        } else if (o1 instanceof Calendar) {
            cell.setCellValue((Calendar) o1);
        } else if (o1 instanceof RichTextString) {
            cell.setCellValue((RichTextString) o1);
        } else if (o1 instanceof LocalDate) {
            cell.setCellValue((LocalDate) o1);
        } else if (o1 instanceof Integer) {
            cell.setCellValue((Integer) o1);
        } else {
            cell.setCellValue((String) o1);
        }
        //设置样式
        this.setCellStyle(cell, field);
    }

    /**
     * 日期格式
     *
     * @param field
     * @return
     */
    protected String format(Field field) {
        ExcelColumns annotation = field.getAnnotation(ExcelColumns.class);
        String format = annotation.dataFormat();
        if (StringUtils.isBlank(format)) {
            format = "yyyy/MM/dd HH:mm:ss";
        }
        return format;
    }

    /**
     * 设置列样式
     *
     * @param cell  列
     * @param field Field 对应字段
     */
    private void setCellStyle(Cell cell, Field field) {
        ExcelColumns annotation = field.getAnnotation(ExcelColumns.class);
        boolean bold = annotation.isBold();
        short color = annotation.color();
        boolean italic = annotation.isItalic();
        boolean strikeout = annotation.isStrikeout();
        HorizontalAlignment alignment = annotation.alignment();
        VerticalAlignment verticalAlignment = annotation.verticalAlignment();
        String dataFormat = annotation.dataFormat();

        CellStyle build = ExcelStyle.builder(work).border(this.borderStyles).font().bold(bold).color(color).italic(italic).strikeout(strikeout).and().alignment(alignment, verticalAlignment).build();

        if (StringUtils.isBlank(dataFormat)) {
            DataFormat format = work.createDataFormat();
            build.setDataFormat(format.getFormat(dataFormat));
        }

        cell.setCellStyle(build);
    }

    /**
     * 设置列样式
     *
     * @param cell
     * @param style
     */
    protected void setCellStyle(Cell cell, CellStyle style) {
        cell.setCellStyle(style);
    }

    /**
     * 合并
     *
     * @param sheet
     * @param merge
     */
    protected void sheetMerge(Sheet sheet, CellRangeAddress... merge) {
        for (CellRangeAddress address : merge) {
            sheet.addMergedRegion(address);
        }
    }

    /**
     * 添加所有行数据
     *
     * @param rowNum 行数
     * @param v      行偏移量
     * @param sheet  当前表
     * @param list   数据
     * @param tClass 类型
     * @throws IllegalAccessException
     */
    protected void setRowValue(int rowNum, final int v, Sheet sheet, List<T> list, Class<T> tClass) throws IllegalAccessException {
        //获取排好序的字段名
        Field[] fields = this.sort(tClass);
        for (int i = v; i < rowNum + v; i++) {
            Row row = sheet.createRow(i);
            T o = list.get((i - v));
            for (int j = 0; j < fields.length; j++) {
                //列
                Cell cell1 = row.createCell(j);

                this.getCellValue(cell1, fields[j], o);

            }
        }
    }

    /**
     * 排序，并且获取字段
     *
     * @param tClass
     * @return
     */
    protected Field[] sort(Class<T> tClass) {
        return Arrays.stream(tClass.getDeclaredFields()).filter(item -> item.isAnnotationPresent(ExcelColumns.class)).sorted((s1, s2) -> {
            int val1 = s1.getAnnotation(ExcelColumns.class).sort();
            int val2 = s2.getAnnotation(ExcelColumns.class).sort();
            return val1 - val2;
        }).toArray(Field[]::new);
    }

    /**
     * 输出到文件
     *
     * @param fileName 文件名
     * @throws IOException
     */
    protected void output(String fileName) throws IOException {
        //写入到文件
        File file = new File("D:\\" + fileName + ".xlsx");
        FileOutputStream stream = new FileOutputStream(file);
        this.work.write(stream);
        stream.flush();
        stream.close();
        work.close();
    }

    /**
     * 输出到响应体
     *
     * @param fileName 文件名
     * @throws IOException
     */
    protected void output(String fileName, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xlsx");
        OutputStream out = response.getOutputStream();

        this.work.write(out);
        out.flush();
        out.close();
        work.close();
    }
}
