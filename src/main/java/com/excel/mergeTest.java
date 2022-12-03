package com.excel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class mergeTest {
    public static void main(String[] args) {
        //区名集合
        String[] aa={"崇明区.xlsx","奉贤区.xlsx","虹口区.xlsx","青浦区.xlsx"};
        String[]  bb = {"宝山区.xlsx","崇明区.xlsx","奉贤区.xlsx","虹口区.xlsx","嘉定区.xlsx","金山区.xlsx","静安区.xlsx","闵行区.xlsx","浦东新区.xlsx","普陀区.xlsx","青浦区.xlsx","松江区.xlsx","徐汇区.xlsx","杨浦区.xlsx","长宁区.xlsx","黄浦区.xlsx"};
        //四个路径
        String path1 = "C:\\Users\\comic\\Desktop\\归档2022-12-02\\汇总-测试_20221202\\";
        String file1 = "药厂上传、医院未传-测试_20221202\\";
        String file2 = "医院上传、药厂未传-测试_20221202\\";
        //正式
        String tpath1 = "C:\\Users\\comic\\Desktop\\归档2022-12-02\\汇总_20221202\\";
        String tfile1 = "药厂上传、医院未传_20221202\\";
        String tfile2 = "医院上传、药厂未传_20221202\\";
        String wenti = "问题类型.xlsx";
        List<ArrayList<String>> areee = new ArrayList<>();
        List<ArrayList<String>> sharea = new ArrayList<>();
        for (int i = 0; i < aa.length; i++) {
            ArrayList<String> aaa = new ArrayList<>();
            ArrayList<String> sss = new ArrayList<>();
            File file = new File(path1+aa[i]);
            if(file.exists()){
                aaa.add(path1+aa[i]);
                sss.add("总表（测试环境）");
            }
            File filedd = new File(path1+file1+aa[i]);
            if(filedd.exists()){
                aaa.add(path1+file1+aa[i]);
                sss.add("药厂上传、医院未传（测试环境）");
            }
            File file3 = new File(path1+file2+aa[i]);
            if(file3.exists()){
                aaa.add(path1+file2+aa[i]);
                sss.add("医院上传、药厂未传（测试环境）");
            }
            aaa.add(path1+wenti);
            sss.add("问题类型");
            String path = path1+"合并\\";
            Utils.mergeExcel(aaa, path, aa[i],sss);
        }
//        String areaName="崇明区.xlsx";
//        //这里是xls文件
//        String[] filePaths = {path1+areaName,
//                path1+file1+areaName,path1+file2+areaName,path1+wenti};
//
//        ArrayList<String> list = new ArrayList<>();
//
//        for (String path : filePaths) {
//            list.add(path);
//        }
//        String[] sheetName={"总表","药厂上传、医院未传","医院上传、药厂未传","问题类型"};
//        String path = path1+"合并\\";
//        String fileName = areaName;
//        Utils.mergeExcel(list, path, fileName,sheetName);

    }

}
