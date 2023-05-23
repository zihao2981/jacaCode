package com.Excel;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tzh
 * @date 2023/1/9
 */
public class ypsycf {
    public static void main(String[] args) {
        merge();
        System.out.println("chenggong");
    }

    public static void merge() {
        String fileName = "C:\\Users\\wf\\Desktop\\新建文件夹\\处方状态明细详情_20230106_20230106 (1).xlsx";
        try {


            //获取excel文件
            InputStream in = new FileInputStream(fileName);
            // 创建工作簿
            XSSFWorkbook tmpWorkBook = new XSSFWorkbook(in);
            // 获取工作簿中的Sheet个数
            int len = tmpWorkBook.getNumberOfSheets();
            if (len >= 1) {
                XSSFSheet tmpSheet = tmpWorkBook.getSheetAt(0);
                //导入excel转入列表
                List<syItem> syItems = importExcel(tmpSheet);
                //解析列表对象转成新的list
                List<syDetail> syDetails = convertList(syItems);
                ////统计明细信息
                //List<syDetail> statis = statisDetail(syDetails,syItems);
                ////导出统计信息
                //exportstatis(statis);
                //把新的list写入excel
                exportExce(syDetails);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //private static void exportstatis(List<syDetail> statis) {
    //}
    //
    //private static List<syDetail> statisDetail(List<syDetail> syDetails, List<syItem> syItems) {
    //    //获取医院和药厂对应
    //    List<String> yqList = new ArrayList<>();
    //    Map<String,List<String>> yyDetail = new HashMap<>();
    //    for (syItem s : syItems) {
    //        yqList.add(s.getYqmc());
    //        List<String> yy = new ArrayList<>();
    //
    //    }
    //    return syDetails;
    //}

    private static void exportExce(List<syDetail> syDetails) {
        String fileName="C:\\Users\\wf\\Desktop\\新建文件夹\\1.xlsx";
        File excelFile = new File(fileName);
        if (excelFile.exists()) {
            // 存在则删除
            excelFile.delete();
        }
        //创建新的excel
        XSSFWorkbook newExcelWorkBook = new XSSFWorkbook();
        XSSFSheet newExcelSheet = newExcelWorkBook.createSheet("明细");
        Font font = newExcelWorkBook.createFont();
        font.setFontName("微软雅黑");
        font.setFontHeightInPoints((short) 18);
        // 字体加粗
        font.setBold(true);
        List<String> headlist = new ArrayList<>();
        headlist.add("处方日期");
        headlist.add("代煎企业代码");
        headlist.add("代煎企业名称");
        headlist.add("医疗机构代码");
        headlist.add("医疗机构名称");
        headlist.add("院内处方编号");
        headlist.add("状态编码");
        headlist.add("明细数");
        headlist.add("异常数");
        headlist.add("企业药品溯源编码");
        headlist.add("供货企业编码");
        headlist.add("错误信息");
        headlist.add("批次号");
        headlist.add("药品医保代码");
        headlist.add("协会溯源码");

        //定义excel列头
        int commonColSize=headlist.size();
        int headRowNum=0;//表头
        int dataRowNum=1;//数据
        Row headRow = newExcelSheet.createRow(headRowNum);
        headRow.setHeight((short)500);
        for (int i=0;i<commonColSize;i++){
            Cell cell = headRow.createCell(i);
            cell.setCellType(CellType.STRING);
            cell.setCellValue(headlist.get(i));
        }
        font.setBold(false);
        //写入excel数据
        for (int i=0;i<syDetails.size();i++){
            Row dataRow=newExcelSheet.createRow(dataRowNum++);
            //每个数据
            Cell dataCell1 = dataRow.createCell(0);
            dataCell1.setCellType(CellType.STRING);
            dataCell1.setCellValue(syDetails.get(i).getCfrq());
            //每个数据
            Cell dataCell2 = dataRow.createCell(1);
            dataCell2.setCellType(CellType.STRING);
            dataCell2.setCellValue(syDetails.get(i).getYqdm());
            //每个数据
            Cell dataCell3 = dataRow.createCell(2);
            dataCell3.setCellType(CellType.STRING);
            dataCell3.setCellValue(syDetails.get(i).getYqmc());
            //每个数据
            Cell dataCell4 = dataRow.createCell(3);
            dataCell4.setCellType(CellType.STRING);
            dataCell4.setCellValue(syDetails.get(i).getYljgbm());
            //每个数据
            Cell dataCell5 = dataRow.createCell(4);
            dataCell5.setCellType(CellType.STRING);
            dataCell5.setCellValue(syDetails.get(i).getYljgmc());
            //每个数据
            Cell dataCell6 = dataRow.createCell(5);
            dataCell6.setCellType(CellType.STRING);
            dataCell6.setCellValue(syDetails.get(i).getYncfbm());
            //每个数据
            Cell dataCell7 = dataRow.createCell(6);
            dataCell7.setCellType(CellType.STRING);
            dataCell7.setCellValue(syDetails.get(i).getState());
            //每个数据
            Cell dataCell8 = dataRow.createCell(7);
            dataCell8.setCellType(CellType.STRING);
            dataCell8.setCellValue(syDetails.get(i).getDetailCount());
            //每个数据
            Cell dataCell9 = dataRow.createCell(8);
            dataCell9.setCellType(CellType.STRING);
            dataCell9.setCellValue(syDetails.get(i).getErrorCount());
            //每个数据
            Cell dataCella = dataRow.createCell(9);
            dataCella.setCellType(CellType.STRING);
            dataCella.setCellValue(syDetails.get(i).getQYYPSYBM());
            //每个数据
            Cell dataCellq = dataRow.createCell(10);
            dataCellq.setCellType(CellType.STRING);
            dataCellq.setCellValue(syDetails.get(i).getGHQYBM());
            //每个数据
            Cell dataCellw = dataRow.createCell(11);
            dataCellw.setCellType(CellType.STRING);
            dataCellw.setCellValue(syDetails.get(i).getErrMassager());
            //每个数据
            Cell dataCelle = dataRow.createCell(12);
            dataCelle.setCellType(CellType.STRING);
            dataCelle.setCellValue(syDetails.get(i).getPCH());
            //每个数据
            Cell dataCellt = dataRow.createCell(13);
            dataCellt.setCellType(CellType.STRING);
            dataCellt.setCellValue(syDetails.get(i).getYPYBDM());
            //每个数据
            Cell dataCelly = dataRow.createCell(14);
            dataCelly.setCellType(CellType.STRING);
            dataCelly.setCellValue(syDetails.get(i).getYPSYBM());
            ////每个数据
            //Cell dataCellu = dataRow.createCell(16);
            //dataCellu.setCellType(CellType.STRING);
            //dataCellu.setCellValue(syDetails.get(i));
            ////每个数据
            //Cell dataCelli = dataRow.createCell(17);
            //dataCelli.setCellType(CellType.STRING);
            //dataCelli.setCellValue(syDetails.get(i));
            ////每个数据
            //Cell dataCello = dataRow.createCell(18);
            //dataCello.setCellType(CellType.STRING);
            //dataCello.setCellValue(syDetails.get(i));
            ////每个数据
            //Cell dataCells = dataRow.createCell(19);
            //dataCells.setCellType(CellType.STRING);
            //dataCells.setCellValue(syDetails.get(i));

        }
        //流写入文件
        try{
        FileOutputStream fos = new FileOutputStream(fileName);
        newExcelWorkBook.write(fos);
        fos.flush();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                newExcelWorkBook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static List<syDetail> convertList(List<syItem> syItems) {


        List<syDetail> syDetails = new ArrayList<>();
        for (int i = 1;i < syItems.size(); i++) {

            syItem s = syItems.get(i);
            //获取明细信息
            String detail = s.getDetail();
            JSONArray jsonDetailS = JSONArray.parseArray(detail);
            int count = jsonDetailS.size();
            //获取异常信息
            String error = s.getRemark();
            JSONArray jsonErrorS = JSONArray.parseArray(error);
            jsonErrorS.forEach(obj->{
                syDetail syDetail = new syDetail();
                BeanUtils.copyProperties(s,syDetail);;
                syDetail.setDetailCount(count);
                syDetail.setQYYPSYBM(((JSONObject)obj).getString("QYYPSYBM")==null?((JSONObject)obj).getString("qyypsybm"):((JSONObject)obj).getString("QYYPSYBM"));
                syDetail.setGHQYBM(((JSONObject)obj).getString("GHQYBM")==null?((JSONObject)obj).getString("ghqybm"):((JSONObject)obj).getString("GHQYBM"));
                syDetail.setErrMassager(((JSONObject)obj).getString("errorMessage"));
                syDetail.setPCH(((JSONObject)obj).getString("PCH")==null?((JSONObject)obj).getString("pch"):((JSONObject)obj).getString("PCH"));
                syDetail.setYPYBDM(((JSONObject)obj).getString("YPYBDM")==null?((JSONObject)obj).getString("ypybdm"):((JSONObject)obj).getString("YPYBDM"));
                syDetail.setYPSYBM(((JSONObject)obj).getString("YPSYBM")==null?((JSONObject)obj).getString("ypsybm"):((JSONObject)obj).getString("YPSYBM"));

                syDetails.add(syDetail);
            });
        }

        return syDetails;

    }

    public static List<syItem> importExcel(XSSFSheet sheet) {
        List<syItem>  sy= new ArrayList<>();
        for (int rowNum = 0; rowNum <=sheet.getLastRowNum(); rowNum++) {
            Row Row = sheet.getRow(rowNum);
            if (Row != null) {
                //判断这行记录是否存在
                if (Row.getLastCellNum() < 1 || "".equals(Row.getCell(0))) {
                    continue;
                }
                //获取每一行封装成对象
                syItem object =new syItem();
                if(Row.getCell(0)!=null){
                    object.setCfrq(Row.getCell(0).toString());
                }
                if(Row.getCell(1)!=null){
                    object.setYqdm(Row.getCell(1).toString());
                }
                if(Row.getCell(2)!=null){
                    object.setYqmc(Row.getCell(2).toString());
                }
                if(Row.getCell(3)!=null){
                    object.setYljgbm(Row.getCell(3).toString());
                }
                if(Row.getCell(4)!=null){
                    object.setYljgmc(Row.getCell(4).toString());
                }
                if(Row.getCell(5)!=null){
                    object.setYncfbm(Row.getCell(5).toString());
                }
                if(Row.getCell(6)!=null){
                    object.setState(Row.getCell(6).toString());
                }
                if(Row.getCell(7)!=null){
                    object.setDetail(Row.getCell(7).toString());
                }
                if(Row.getCell(8)!=null){
                    object.setErrorCount(Row.getCell(8).toString());
                }
                if(Row.getCell(9)!=null){
                    object.setRemark(Row.getCell(9).toString());
                }

                sy.add(object);
            }
        }
        return sy;
    }
}
