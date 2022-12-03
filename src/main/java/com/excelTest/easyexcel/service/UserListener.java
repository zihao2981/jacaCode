package com.excelTest.easyexcel.service;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.excelTest.easyexcel.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
public class UserListener extends AnalysisEventListener<User> {
    @Autowired
    private IUserService userService;

    public UserListener(IUserService userService) {
        this.userService = userService;
    }


    //  一行行读取excel内容，然后用MybatisPlus的方法进行导入
    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        System.out.println("invoke");
        userService.insert(user);
    }

    //  读取表头内容，导出可用到
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头：" + headMap);
    }

    //  读取完成之后进行的操作
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("doafteallanalysed");
    }
}
