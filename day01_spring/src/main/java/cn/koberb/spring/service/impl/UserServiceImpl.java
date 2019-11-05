package cn.koberb.spring.service.impl;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.service.IUserService;

public class UserServiceImpl implements IUserService {
    /***
     * 默认构造方法
     */
    public UserServiceImpl(){
        System.out.println("Service被创建了");
    }

    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 初始化方法
     */
    public void init(){
        System.out.println("Service初始化了");
    }

    /***
     * 销毁方法
     */
    public void destory(){
        System.out.println("Service销毁了");
    }

    public void newUser() {
//        userDao.addUser();
        System.out.println("不管dao");
    }
}
