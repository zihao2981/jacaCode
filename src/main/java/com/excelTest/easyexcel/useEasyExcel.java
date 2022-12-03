package com.excelTest.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.excelTest.easyexcel.model.User;
import com.excelTest.easyexcel.service.IUserService;
import com.excelTest.easyexcel.service.UserListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;


public class useEasyExcel {
    @Autowired
    static
    IUserService userService;
    public static  String upload(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        EasyExcel.read(fileInputStream, User.class,new UserListener(userService)).sheet().doRead();
        return "success";
    }

    public static void main(String[] args) throws IOException {
        String paths="C:\\Users\\wf\\Desktop\\test.xlsx";
        String result=upload(paths);
        System.out.println(result);

    }

}

