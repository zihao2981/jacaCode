package com.excelTest;


import com.excelTest.dto.Person;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {
    //读取excel函数：
    public Workbook readExcel(File file) throws Exception {      //读取excel函数
        //获取文件名字
        String fileName = file.getName();
        //获取文件类型
        String fileType = fileName.substring(fileName.lastIndexOf(".") + 1);
        //获取输入流
        InputStream stream = new FileInputStream(file);
        //获取工作薄
        Workbook xssfWorkbook = null;
        if (fileType.equals("xls")) {
            xssfWorkbook = new HSSFWorkbook(stream);
        } else if (fileType.equals("xlsx")) {
            xssfWorkbook = new XSSFWorkbook(stream);
        } else {
            throw  new RuntimeException("您输入的excel格式不正确");
        }
        return xssfWorkbook;
    }
    public  List<Row> convertWB(Workbook workbook){
        //     TranTaskDao a = null;
        List<Row> aList = new ArrayList();
        // Read the Sheet
        Sheet Sheet = workbook.getSheetAt(0);
        // Read the Row 从0开始
        for (int rowNum = 0; rowNum <= Sheet.getLastRowNum(); rowNum++) {
            Row row = Sheet.getRow(rowNum);
            if (row != null) {
                //判断这行记录是否存在
                if (row.getLastCellNum() < 1 || "".equals(row.getCell(0))||rowNum==0) {
                    continue;
                }
                aList.add(row);
            }
        }
        return aList;
    }
    public  List<Row> convertWB(Workbook workbook ,String region){
        //     TranTaskDao a = null;
        List<Row> aList = new ArrayList();
        // Read the Sheet
        Sheet Sheet = workbook.getSheetAt(0);
        // Read the Row 从0开始
        for (int rowNum = 0; rowNum <= Sheet.getLastRowNum(); rowNum++) {
            Row row = Sheet.getRow(rowNum);
            if (row != null) {
                //判断这行记录是否存在
                if (row.getLastCellNum() < 1 || "".equals(row.getCell(0))||rowNum==0) {
                    continue;
                }
                if(region.equals(row.getFirstCellNum())){
                    aList.add(row);
                }
            }
        }
        return aList;
    }
    public  List<Person> convertWB2(Workbook workbook){
        List<Person>  personList= new ArrayList<>();
        Sheet Sheet = workbook.getSheetAt(0);
        for (int rowNum = 0; rowNum <=Sheet.getLastRowNum(); rowNum++) {
            Row Row = Sheet.getRow(rowNum);
            if (Row != null) {
                //判断这行记录是否存在
                if (Row.getLastCellNum() < 1 || "".equals(Row.getCell(0))) {
                    continue;
                }
                //获取每一行封装成对象
                Person person =new Person();
                if(Row.getCell(0)!=null){
                    person.setName(Row.getCell(0).toString());
                }
                if(Row.getCell(1)!=null){
                    person.setSex(Row.getCell(1).toString());
                }
                if(Row.getCell(2)!=null){
                    person.setAge(Row.getCell(2).toString());
                }
                personList.add(person);
            }
        }
        return personList;
    }
    public static Object getCellFormatValue(Cell cell) throws Exception{
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            cellValue = sdf.format(cell.getDateCellValue());// 日期
                        } catch (Exception e) {
                            throw new Exception("exception on get date data !".concat(e.toString()));
                        }finally{
                            sdf = null;
                        }
                    } else {
                        BigDecimal bd = new BigDecimal(cell.getNumericCellValue());
                        cellValue = bd.toPlainString();// 数值 这种用BigDecimal包装再获取plainString，可以防止获取到科学计数值
                    }
                case FORMULA:
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;

                case STRING:
                    cellValue = cell.getRichStringCellValue().getString();
                    break;

                case BLANK:
                    cellValue = "";
                    break;
                case BOOLEAN:
                    cellValue = String.valueOf(cell.getBooleanCellValue());

                case ERROR: // 故障
                    cellValue = "ERROR";

                default:
                    cellValue = "N/A";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }
}
