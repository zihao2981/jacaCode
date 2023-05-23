package com.ExcelTest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.BeanUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MergeAXDExcel {
    public static void main(String[] args) throws Exception {
        ExcelUtil excelUtil = new ExcelUtil();
        List<String> regions=new ArrayList<>();
        regions.add("崇明区");
        regions.add("黄浦区");
        for (String region : regions) {
            Calendar cal   =   Calendar.getInstance();
            cal.add(Calendar.DATE,   -1);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String date=sdf.format(cal.getTime());
            String fileName= "/"+region+".xlsx";
            String sourcePath="C:/Users/wf/Desktop/汇总_20221120";
            String sourcePathyc=sourcePath+"/药厂上传、医院未传_20221120";
            String sourcePathyy=sourcePath+"/医院上传、药厂未传_20221120";
            //创建表格
            Workbook wb=new HSSFWorkbook();
            Sheet zbsh=wb.createSheet("总表");
            Sheet ycsh=wb.createSheet("药厂上传、医院未传");
            Sheet yysh=wb.createSheet("医院上传、药厂未传");
            //总表
            File zongbiao = new File(sourcePath+fileName);
            if(zongbiao.exists()){
                Workbook zongbiaowb = excelUtil.readExcel(zongbiao);
                Sheet zbsheet = zongbiaowb.getSheetAt(0);
                zbsh=zongbiaowb.cloneSheet(0);
            }
            //药厂
            File yc = new File(sourcePathyc+fileName);
            if(yc.exists()){
                Workbook ycwb = excelUtil.readExcel(yc);
                Sheet ycsheet = ycwb.getSheetAt(0);
                BeanUtils.copyProperties(ycsheet,ycsh);
            }
            //医院
            File yy = new File(sourcePathyy+fileName);
            if(yy.exists()){
                Workbook yywb = excelUtil.readExcel(yy);
                Sheet yysheet = yywb.getSheetAt(0);
                BeanUtils.copyProperties(yysheet,yysh);
            }
            String path = sourcePath + "/合并/"+region+".xls";
            File fileTmp = new File(sourcePath+"/合并/");
            if (!fileTmp.exists() && !fileTmp.isDirectory()) {
                //当文件夹不存在或者不是文件夹时创建文件夹
                fileTmp.mkdir();
            }
            FileOutputStream fos = new FileOutputStream(path);
            wb.write(fos);
            fos.flush();
            fos.close();
        }
        System.out.println("完成拆分");
    }
}
