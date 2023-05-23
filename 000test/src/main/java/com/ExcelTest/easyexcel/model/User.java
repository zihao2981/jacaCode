package com.ExcelTest.easyexcel.model;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * value对应name
 * 或者使用index对应列标
 */
public class User {
    @ExcelProperty(value = "编号")
    private String id; //id
    @ExcelProperty(value = "姓名")
    private String name;  //姓名
    @ExcelProperty(value = "年龄")
    private String age;  //年龄
    @ExcelProperty(value = "性别")
    private String sex;  //性别

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
