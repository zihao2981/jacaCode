package com.excelTest;

import com.excelTest.dto.Person;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

