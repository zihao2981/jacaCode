package com.excelTest.easyexcel.service;

import com.excelTest.easyexcel.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    public void insert(User user) {
        System.out.println("insert");
        System.out.println(user.getAge());
        System.out.println("insert完成");
    }
}
