package com.ExcelTest.easyexcel.service;

import com.ExcelTest.easyexcel.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    public void insert(User user) {
        System.out.println("insert");
        System.out.println(user.getAge());
        System.out.println("insert完成");
    }
}
