package cn.koberb.spring.dao.impl;

import cn.koberb.spring.dao.IUserDao;

public class UserDaoImpl implements IUserDao {
    public void addUser() {
        System.out.println("新增了用户");
    }
}
