package com.zy.common.zangyuecommon.util.excel.export.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/25 17:23
 */
public class ExcelStyle {


    /**
     * 合并列
     *
     * @param firstRow
     * @param lastRow
     * @param firstCell
     * @param lastCell
     * @return
     */
    public static CellRangeAddress merge(int firstRow, int lastRow, int firstCell, int lastCell) {
        return new CellRangeAddress(firstRow, lastRow, firstCell, lastCell);
    }


    /**
     * 获取字体
     *
     * @param workbook
     * @return
     */
    public static Font getFont(Workbook workbook) {
        return workbook.createFont();
    }

    /**
     * 获取列样式
     *
     * @param workbook
     * @return
     */
    public static CellStyle getCellStyle(Workbook workbook) {
        return workbook.createCellStyle();
    }


    public static CellStyles builder(Workbook workbook) {
        return new CellStyles(workbook);
    }


    public static class CellStyles {
        private final CellStyle cellStyle;
        private final Workbook workbook;

        public CellStyles(Workbook workbook) {
            this.workbook = workbook;
            this.cellStyle = workbook.createCellStyle();
        }

        /**
         * 文本排列方式
         *
         * @param ha
         * @param va
         * @return
         */
        public CellStyles alignment(HorizontalAlignment ha, VerticalAlignment va) {
            cellStyle.setAlignment(ha);
            cellStyle.setVerticalAlignment(va);
            return CellStyles.this;
        }

        /**
         * 设置背景
         *
         * @param colors 颜色
         * @param type   填充类型
         * @return
         */
        public CellStyles backgroundColor(IndexedColors colors, FillPatternType type) {
            cellStyle.setFillForegroundColor(colors.getIndex());
            cellStyle.setFillPattern(type);
            return CellStyles.this;
        }

        /**
         * 边框样式
         *
         * @return
         * @see BorderStyle
         */

        public CellStyles border() {
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setBorderTop(BorderStyle.THIN);
            cellStyle.setBorderRight(BorderStyle.THIN);
            cellStyle.setBorderBottom(BorderStyle.THIN);
            return CellStyles.this;
        }

        /**
         * 边框样式
         * 顺序为左上右下
         *
         * @return
         * @see BorderStyle
         */
        public CellStyles border(BorderStyle... styles) {
            int max = 4;
            if (styles.length != max) {
                throw new IllegalArgumentException("边框样式最多添加四个");
            }
            cellStyle.setBorderLeft(styles[0]);
            cellStyle.setBorderTop(styles[1]);
            cellStyle.setBorderRight(styles[2]);
            cellStyle.setBorderBottom(styles[3]);
            return CellStyles.this;
        }

        public CellStyles apply(Font font) {
            this.cellStyle.setFont(font);
            return CellStyles.this;
        }

        public Fonts font() {
            return new Fonts(workbook);
        }

        /**
         * 字体设置
         */
        public class Fonts {
            private final Font font;

            public Fonts(Workbook workbook) {
                this.font = workbook.createFont();
            }

            /**
             * 设置行高
             *
             * @param rowHeight 高度
             * @return
             */
            public Fonts setRowHeight(short rowHeight) {
                font.setFontHeightInPoints(rowHeight);

                return this;
            }

            /**
             * 字体颜色
             *
             * @see Font#COLOR_NORMAL
             * @see Font#COLOR_RED
             * @see org.apache.poi.hssf.usermodel.HSSFPalette#getColor(short)
             */
            public Fonts color(short color) {
                font.setColor(color);
                return this;
            }

            /**
             * 是否加粗
             *
             * @return
             */
            public Fonts bold(boolean b) {
                font.setBold(b);
                return this;
            }

            /**
             * 是否使用斜体
             *
             * @return
             */
            public Fonts italic(boolean b) {
                font.setItalic(b);
                return this;
            }

            /**
             * 是否使用删除线，水平线
             *
             * @return
             */
            public Fonts strikeout(boolean b) {
                font.setStrikeout(b);
                return this;
            }

            /**
             * @param b
             * @return
             * @see Font#U_NONE
             * @see Font#U_SINGLE
             * @see Font#U_DOUBLE
             * @see Font#U_SINGLE_ACCOUNTING
             * @see Font#U_DOUBLE_ACCOUNTING
             */
            public Fonts underline(byte b) {
                font.setUnderline(b);
                return this;
            }

            public CellStyles and() {
                return apply(this.font);
            }

        }


        /**
         * 构建
         *
         * @return
         */
        public CellStyle build() {
            return this.cellStyle;
        }

    }


}
