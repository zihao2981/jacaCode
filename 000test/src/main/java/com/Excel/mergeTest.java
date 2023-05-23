package com.Excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class mergeTest {
    /**
     * 在目标文件夹下建立合并文件夹
     * @param args
     */
    public static void main(String[] args) {
        moreArea();
    }
    public  static  void moreArea(){
        //区名集合
        String[] ce={"崇明区.xlsx","奉贤区.xlsx","虹口区.xlsx","青浦区.xlsx"};
        //String[]  zs = {"宝山区.xlsx","崇明区.xlsx","奉贤区.xlsx","虹口区.xlsx","嘉定区.xlsx","金山区.xlsx","静安区.xlsx","闵行区.xlsx","浦东新区.xlsx","普陀区.xlsx","青浦区.xlsx","松江区.xlsx","徐汇区.xlsx","杨浦区.xlsx","长宁区.xlsx","黄浦区.xlsx"};
        //String[] ce={"崇明区.xlsx"};
        String[]  zs = {"黄浦区.xlsx","崇明区.xlsx"};
//        //文件夹路径
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf3=new SimpleDateFormat("MMdd");
        Calendar cal   =   Calendar.getInstance();
        cal.add(Calendar.DATE,   -1);
        String date=sdf.format(cal.getTime());
        String date2=sdf2.format(cal.getTime());
        String date3=sdf3.format(cal.getTime());
        String cpath1 = "C:\\Users\\wf\\Desktop\\"+date+"\\";
        String path = "C:\\Users\\wf\\Desktop\\合并\\";
        String cfile1 = "药厂上传、医院未传-测试_"+date+"\\";
        String cfile2 = "医院上传、药厂未传-测试_"+date+"\\";
        String cfile3 = "汇总-测试_"+date+"\\";
        String wenti = "问题类型.xlsx";
        //测试合并
        for (int i = 0; i < ce.length; i++) {
            ArrayList<String> aaa = new ArrayList<>();
            ArrayList<String> sss = new ArrayList<>();
            File file = new File(cpath1+cfile3+ce[i]);
            if(file.exists()){
                aaa.add(cpath1+cfile3+ce[i]);
                sss.add("总表（测试环境）");
            }
            File filedd = new File(cpath1+cfile1+ce[i]);
            if(filedd.exists()){
                aaa.add(cpath1+cfile1+ce[i]);
                sss.add("药厂上传、医院未传（测试环境）");
            }
            File file3 = new File(cpath1+cfile2+ce[i]);
            if(file3.exists()){
                aaa.add(cpath1+cfile2+ce[i]);
                sss.add("医院上传、药厂未传（测试环境）");
            }
            aaa.add("C:\\Users\\wf\\Desktop\\"+wenti);
            sss.add("问题类型");
            if(filedd.exists()||file3.exists()){
            mergeExcel(aaa, path, date3+"测试"+ce[i],sss);
            }
        }
        //正式
        String zpath1 = "C:\\Users\\wf\\Desktop\\"+date+"\\";
        String zfile1 = "药厂上传、医院未传_"+date+"\\";
        String zfile2 = "医院上传、药厂未传_"+date+"\\";
        String zfile3="汇总_"+date+"\\";
        //正式合并
        for (int i = 0; i < zs.length; i++) {
            ArrayList<String> aaa = new ArrayList<>();
            ArrayList<String> sss = new ArrayList<>();
            File file = new File(zpath1+zfile3+zs[i]);
            if(file.exists()){
                aaa.add(zpath1+zfile3+zs[i]);
                sss.add("总表");
            }
            File filedd = new File(zpath1+zfile1+zs[i]);
            if(filedd.exists()){
                aaa.add(zpath1+zfile1+zs[i]);
                sss.add("药厂上传、医院未传");
            }
            File file3 = new File(zpath1+zfile2+zs[i]);
            if(file3.exists()){
                aaa.add(zpath1+zfile2+zs[i]);
                sss.add("医院上传、药厂未传");
            }
            aaa.add("C:\\Users\\wf\\Desktop\\"+wenti);
            sss.add("问题类型");
            if(filedd.exists()||file3.exists()) {
                mergeExcel(aaa, path, date3 + zs[i], sss);
            }
        }
    }
    /**
     * 单个区
     */
    public  static  void oneArea(){
        String Date = "20221206";
        String path1 = "C:\\Users\\wf\\Desktop\\归档2022-12-06\\汇总_20221206\\";
        String file1 = "药厂上传、医院未传_20221206\\";
        String file2 = "医院上传、药厂未传_20221206\\";
        String areaName="崇明区.xlsx";
        String wenti = "问题类型.xlsx";
        //这里是xls文件
        String[] filePaths = {path1+areaName,
                path1+file1+areaName,path1+file2+areaName,path1+wenti};

        ArrayList<String> aaa = new ArrayList<>();
        ArrayList<String> sss= new ArrayList<>();

        File file = new File(path1+areaName);
        if(file.exists()){
            aaa.add(path1+areaName);
            sss.add("总表");
        }
        File filedd = new File(path1+file1+areaName);
        if(filedd.exists()){
            aaa.add(path1+file1+areaName);
            sss.add("药厂上传、医院未传");
        }
        File file3 = new File(path1+file2+areaName);
        if(file3.exists()){
            aaa.add(path1+file2+areaName);
            sss.add("医院上传、药厂未传");
        }
        aaa.add(path1+wenti);
        sss.add("问题类型");
        String path = path1+"合并\\";
        String fileName = areaName;
        mergeExcel(aaa, path, fileName,sss);
    }
    /**
     * #合并多个excel文件
     * @param fileLists excel文件路径
     * @param path 目标文件保存目录
     * @param fileName 目标文件名称
     */
    public static void mergeExcel(List<String> fileLists, String path, String fileName, ArrayList<String> sheetName) {
        // 创建新的excel工作簿
        XSSFWorkbook newExcelWorkBook = new XSSFWorkbook();
        int a= 0;
        // 遍历需要合并的excel文件
        for (String excelName : fileLists) {
            try (InputStream in = new FileInputStream(excelName)) {
                // 创建工作簿
                XSSFWorkbook tmpWorkBook = new XSSFWorkbook(in);
                // 获取工作簿中的Sheet个数
                int len = tmpWorkBook.getNumberOfSheets();
                if (len <= 1) {
                    XSSFSheet tmpSheet = tmpWorkBook.getSheetAt(0);
                    XSSFSheet newExcelSheet = newExcelWorkBook.createSheet(sheetName.get(a));
                    // 复制sheet内容
                    copyExcelSheet(newExcelWorkBook, tmpSheet, newExcelSheet);
                } else {
                    for (int i = 0; i < len; i++) {
                        XSSFSheet tmpSheet = tmpWorkBook.getSheetAt(i);
                        XSSFSheet newExcelSheet = newExcelWorkBook.createSheet(tmpSheet.getSheetName()+i+i*5);
                        // 复制sheet内容
                        copyExcelSheet(newExcelWorkBook, tmpSheet, newExcelSheet);
                    }
                }
                a++;
                // 关闭tmpWorkBook工作簿
                tmpWorkBook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 新生成的excel文件
        if (!fileName.endsWith(".xlsx") && !fileName.endsWith(".xls")) {
            fileName += ".xlsx";
        }
        String excelFileName = path + File.separator + fileName;
        // 判断文件是否存在
        File excelFile = new File(excelFileName);
        if (excelFile.exists()) {
            // 存在则删除
            excelFile.delete();
        }
        // 使用输出流写出
        try (FileOutputStream fos = new FileOutputStream(excelFileName)) {
            newExcelWorkBook.write(fos);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                newExcelWorkBook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("excel文件合并成功，合并后文件路径：" + excelFileName);
    }

    /**
     * #复制sheet到新的excel文件中
     * @param workbook excel工作簿
     * @param tmpSheet 来源sheet
     * @param newExcelSheet 新生成的sheet
     */
    public static void copyExcelSheet(XSSFWorkbook workbook, XSSFSheet tmpSheet, XSSFSheet newExcelSheet) {
        // 合并单元格
        mergeSheetAllRegion(tmpSheet, newExcelSheet);
        // 设置单元格列宽度
        // 获取最后一个单元格位置
        int len = tmpSheet.getRow(tmpSheet.getFirstRowNum()).getLastCellNum();
        for (int i = 0; i < len; i++) {
            newExcelSheet.setColumnWidth(i, tmpSheet.getColumnWidth(i)>256*255?256*255:tmpSheet.getColumnWidth(i));
        }
        // 复制每行内容
        Iterator<Row> it = tmpSheet.iterator();
        while (it.hasNext()) {
            XSSFRow tmpRow = (XSSFRow) it.next();
            // 创建新行
            XSSFRow newExcelRow = newExcelSheet.createRow(tmpRow.getRowNum());
            // 复制行
            copyExcelRow(workbook, tmpRow, newExcelRow);
        }
    }

    /**
     * #合并单元格
     * @param tmpSheet 来源sheet
     * @param newExcelSheet 目标sheet
     */
    private static void mergeSheetAllRegion(XSSFSheet tmpSheet, XSSFSheet newExcelSheet) {
        int num = tmpSheet.getNumMergedRegions();
        CellRangeAddress cellRange = null;
        for (int i = 0; i < num; i++) {
            cellRange = tmpSheet.getMergedRegion(i);
            newExcelSheet.addMergedRegion(cellRange);
        }
    }

    /**
     * #复制excel中的行到新的sheet中
     * @param workbook 目标工作簿
     * @param tmpRow 来源excel行
     * @param newExcelRow 目标excel行
     */
    public static void copyExcelRow(XSSFWorkbook workbook, XSSFRow tmpRow, XSSFRow newExcelRow) {
        // 设置行高
        newExcelRow.setHeight(tmpRow.getHeight());
        // 获取所有列
        Iterator<Cell> it = tmpRow.cellIterator();
        while (it.hasNext()) {
            XSSFCell tmpCell = (XSSFCell) it.next();
            // 创建单元格
            XSSFCell newExcelCell = newExcelRow.createCell(tmpCell.getColumnIndex());
            // 复制单元格
            copyExcelCell(workbook, tmpCell, newExcelCell);
        }
    }

    /**
     * #复制单元格
     * @param workbook 目标工作簿
     * @param tmpCell 来源excel单元格
     * @param newExcelCell 目标excel单元格
     */
    public static void copyExcelCell(XSSFWorkbook workbook, XSSFCell tmpCell, XSSFCell newExcelCell) {
        XSSFCellStyle newExcelStyle = workbook.createCellStyle();
        // 复制单元格样式
        newExcelStyle.cloneStyleFrom(tmpCell.getCellStyle());
        // 单元格样式
        newExcelCell.setCellStyle(newExcelStyle);
        if (tmpCell.getCellComment() != null) {
            newExcelCell.setCellComment(tmpCell.getCellComment());
        }
        // 不同数据类型处理
        CellType tmpCellType = tmpCell.getCellType();

        newExcelCell.setCellType(tmpCellType);
        if (tmpCellType == CellType.NUMERIC) {
            if (DateUtil.isCellDateFormatted(tmpCell)) {
                newExcelCell.setCellValue(tmpCell.getDateCellValue());
            } else {
                newExcelCell.setCellValue(tmpCell.getNumericCellValue());
            }
        } else if (tmpCellType == CellType.STRING) {
            newExcelCell.setCellValue(tmpCell.getRichStringCellValue());
        } else if (tmpCellType == CellType.BLANK) {
        } else if (tmpCellType == CellType.BOOLEAN) {
            newExcelCell.setCellValue(tmpCell.getBooleanCellValue());
        } else if (tmpCellType == CellType.ERROR) {
            newExcelCell.setCellErrorValue(tmpCell.getErrorCellValue());
        } else if (tmpCellType == CellType.FORMULA) {
            newExcelCell.setCellFormula(tmpCell.getCellFormula());
        } else {
        }
    }
}
