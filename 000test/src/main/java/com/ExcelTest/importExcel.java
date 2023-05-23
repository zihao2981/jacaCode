package com.ExcelTest;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;

public class importExcel {

    public static void main(String[] args) throws Exception {

        ExcelUtil excelUtil = new ExcelUtil();
        File file=new File("C:/Users/wf/Desktop/test.xlsx");
        Workbook sheets = excelUtil.readExcel(file);
//        List<Person> a = excelUtil.convertWB(sheets);
        System.out.println("hello");
//        System.out.println(a.toString());
    }

}

