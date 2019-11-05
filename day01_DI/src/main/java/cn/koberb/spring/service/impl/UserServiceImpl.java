package cn.koberb.spring.service.impl;

import cn.koberb.spring.service.IUserService;

import java.util.Date;

public class UserServiceImpl implements IUserService {
    private String name;
    private Integer age;
    private Date birthday;
    /**
     * 构造函数
     * @param name
     * @param age
     * @param btd
     */
    public UserServiceImpl(String name,Integer age,Date btd){
        this.age = age;
        this.name = name;
        this.birthday = btd;
    }
    public void newUser() {
        System.out.println(name+","+age+","+birthday);
    }
}
