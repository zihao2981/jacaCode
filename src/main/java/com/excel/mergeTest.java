package com.excel;

import java.io.File;
import java.util.ArrayList;

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
        String[]  zs = {"宝山区.xlsx","崇明区.xlsx","奉贤区.xlsx","虹口区.xlsx","嘉定区.xlsx","金山区.xlsx","静安区.xlsx","闵行区.xlsx","浦东新区.xlsx","普陀区.xlsx","青浦区.xlsx","松江区.xlsx","徐汇区.xlsx","杨浦区.xlsx","长宁区.xlsx","黄浦区.xlsx"};
        //文件夹路径
        String cpath1 = "C:\\Users\\comic\\Desktop\\归档2022-12-02\\汇总-测试_20221202\\";
        String cfile1 = "药厂上传、医院未传-测试_20221202\\";
        String cfile2 = "医院上传、药厂未传-测试_20221202\\";
        String wenti = "问题类型.xlsx";
        //测试合并
        for (int i = 0; i < ce.length; i++) {
            ArrayList<String> aaa = new ArrayList<>();
            ArrayList<String> sss = new ArrayList<>();
            File file = new File(cpath1+ce[i]);
            if(file.exists()){
                aaa.add(cpath1+ce[i]);
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
            aaa.add(cpath1+wenti);
            sss.add("问题类型");
            String path = cpath1+"合并\\";
            Utils.mergeExcel(aaa, path, ce[i],sss);
        }
        //正式
        String zpath1 = "C:\\Users\\comic\\Desktop\\归档2022-12-02\\汇总_20221202\\";
        String zfile1 = "药厂上传、医院未传_20221202\\";
        String zfile2 = "医院上传、药厂未传_20221202\\";
        //正式合并
        for (int i = 0; i < zs.length; i++) {
            ArrayList<String> aaa = new ArrayList<>();
            ArrayList<String> sss = new ArrayList<>();
            File file = new File(zpath1+zs[i]);
            if(file.exists()){
                aaa.add(zpath1+zs[i]);
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
            aaa.add(zpath1+wenti);
            sss.add("问题类型");
            String path = zpath1+"合并\\";
            Utils.mergeExcel(aaa, path, zs[i],sss);
        }
    }
    /**
     * 单个区
     */
    public  static  void oneArea(){

        String path1 = "C:\\Users\\comic\\Desktop\\归档2022-12-02\\汇总_20221202\\";
        String file1 = "药厂上传、医院未传_20221202\\";
        String file2 = "医院上传、药厂未传_20221202\\";
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
        Utils.mergeExcel(aaa, path, fileName,sss);
    }
}
