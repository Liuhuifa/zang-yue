package com.zy.common.zangyuecommon.util.excel.export.template;

import com.zy.common.zangyuecommon.util.excel.export.AbstractExcel;
import com.zy.common.zangyuecommon.util.excel.export.utils.ExcelStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/24 15:42
 */
public class DefaultExcelExport<T> extends AbstractExcel<T> {


    /**
     * 创建工作簿
     *
     * @return
     */
    @Override
    protected HSSFWorkbook createWorkbook() {
        return new HSSFWorkbook();
    }



    /**
     * 创建表
     *
     * @param list
     * @param tClass
     */
    @Override
    public void head(List<T> list, Class<T> tClass) throws IllegalAccessException {

        //第一行，表名
        Row nameRow = sheet.createRow(0);

        Cell cell = nameRow.createCell(0);
        cell.setCellValue(excelName);

        // 设置居中
        super.setCellStyle(cell, ExcelStyle.builder(work).border(super.borderStyles).alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER).build());

        //表头
        Row headRow = sheet.createRow(1);
        for (int i = 0; i < headers.length; i++) {
            Cell headRowCell = headRow.createCell(i);
            headRowCell.setCellValue(headers[i]);
            //设置样式
            super.setCellStyle(headRowCell, ExcelStyle.builder(work).border(super.borderStyles).alignment(HorizontalAlignment.CENTER, VerticalAlignment.CENTER).font().bold(true).and().build());
        }



    }

    /**
     * 表尾
     *
     * @throws IllegalAccessException
     */
    @Override
    public void foot() throws IllegalAccessException {
        //不添加

    }

}
