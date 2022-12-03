package com.excelTest;



import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import com.excelTest.dto.Person;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;

import java.lang.reflect.InvocationTargetException;

import java.lang.reflect.Method;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

    /**

     * 功能: [POI实现把Excel数据导入到数据库]

     * 作者: JML

     * 版本: 1.0

     */

    public class dyni{
        public static void main(String[] args) throws Exception {
            Person person=new Person();
            ExcelUtil excelUtil = new ExcelUtil();
            File file=new File("C:/Users/wf/Desktop/test.xlsx");
            Workbook sheets = excelUtil.readExcel(file);
            List<Row> rows = excelUtil.convertWB(sheets);
            List objectList=returnObjectList(rows,person.getClass());
            System.out.println(objectList);
        }
//正则表达式 用于匹配属性的第一个字母
        private static final String REGEX = "[a-zA-Z]";
        private static String getCellValue(Cell cell) {
            Object result = "";
            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                        result = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        result = cell.getNumericCellValue();
                        break;
                    case BOOLEAN:
                        result = cell.getBooleanCellValue();
                        break;
                    case FORMULA:
                        result = cell.getCellFormula();
                        break;
                    case ERROR:
                        result = cell.getErrorCellValue();
                        break;
                    case BLANK:
                        break;
                    default:
                        break;
                }
            }
            return result.toString();
        }

        private static List returnObjectList(List<Row> rowList, Class clazz) {
            List objectList=null;
            Object obj=null;
            String attribute=null;
            String value=null;
            int j=0;
            try {
                objectList=new ArrayList();
                Field[] declaredFields = clazz.getDeclaredFields();
                for (Row row : rowList) {
                    j=0;
                    obj = clazz.newInstance();
                    for (Field field : declaredFields) {
                        attribute=field.getName().toString();
                        value = getCellValue(row.getCell(j));
                        if(value!="") {
                            setAttrributeValue(obj, attribute, value);
                        }
                        j++;
                    }
                    objectList.add(obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return objectList;
        }

        /**

         * 功能:给指定对象的指定属性赋值

         */

        private static void setAttrributeValue(Object obj,String attribute,String value) throws NoSuchFieldException {
//得到该属性的set方法名
            String method_name = convertToMethodName(attribute,obj.getClass(),true);
            Method[] methods = obj.getClass().getMethods();
            for (Method method : methods) {
/**
 * 因为这里只是调用bean中属性的set方法，属性名称不能重复
 * 所以set方法也不会重复，所以就直接用方法名称去锁定一个方法
 * (注：在java中，锁定一个方法的条件是方法名及参数)
 */
                if(method.getName().equals(method_name))
                {
                    Class[] parameterC = method.getParameterTypes();
                    try {
/**如果是(整型,浮点型,布尔型,字节型,时间类型),
 * 按照各自的规则把value值转换成各自的类型
 * 否则一律按类型强制转换(比如:String类型)
 */
                        if(parameterC[0] == int.class || parameterC[0]==java.lang.Integer.class)
                        {
                            method.invoke(obj,Integer.valueOf(value));
                            break;
                        }else if(parameterC[0] == float.class || parameterC[0]==java.lang.Float.class){
                            method.invoke(obj, Float.valueOf(value));
                            break;
                        }else if(parameterC[0] == double.class || parameterC[0]==java.lang.Double.class)
                        {
                            method.invoke(obj, Double.valueOf(value));
                            break;
                        }else if(parameterC[0] == byte.class || parameterC[0]==java.lang.Byte.class)
                        {
                            method.invoke(obj, Byte.valueOf(value));
                            break;
                        }else if(parameterC[0] == boolean.class|| parameterC[0]==java.lang.Boolean.class)
                        {
                            method.invoke(obj, Boolean.valueOf(value));
                            break;
                        }else if(parameterC[0] == java.util.Date.class)
                        {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date=null;
                            try {
                                date=sdf.parse(value);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            method.invoke(obj,date);
                            break;
                        }else if(parameterC[0] == BigDecimal.class)
                        {
                            method.invoke(obj,new BigDecimal(value));
                            break;
                        }
                        else
                        {
                            method.invoke(obj,parameterC[0].cast(value));
                            break;
                        }
                    } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                }
            }
        }}
        /**
         * 功能:根据属性生成对应的set/get方法
         */
        private static String convertToMethodName(String attribute,Class objClass,boolean isSetElseGet) throws NoSuchFieldException {
            /** 通过正则表达式来匹配第一个字符 **/
            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(attribute);
            StringBuilder sb = new StringBuilder();
            /** 如果是set方法名称 **/
            if(isSetElseGet) {
                sb.append("set");
            }else{
                /** get方法名称 **/
                Field attributeField = objClass.getDeclaredField(attribute);
                /** 如果类型为boolean **/
                if(attributeField.getType() == boolean.class||attributeField.getType() == Boolean.class) {
                    sb.append("is");
                }else {
                    sb.append("get");}
            }
            /** 针对以下划线开头的属性 **/
            if(attribute.charAt(0)!='_' && m.find()) {
                sb.append(m.replaceFirst(m.group().toUpperCase()));
            }else{
                sb.append(attribute);
            }
            return sb.toString();
        }
    }