package cn.koberb.spring.service.impl;

import cn.koberb.spring.service.IUserService;

import java.util.Date;

public class UserServiceImpl2 implements IUserService {
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public void newUser() {
        System.out.println(name+","+age+","+birthday);
    }

}
