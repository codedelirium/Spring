package cn.koberb.spring.service.impl;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.dao.impl.UserDaoImpl;
import cn.koberb.spring.factory.BeanFactory;
import cn.koberb.spring.service.IUserService;

public class UserServiceImpl implements IUserService {
//    private IUserDao userDao = new UserDaoImpl();
    private IUserDao userDao = (IUserDao)BeanFactory.getOneBean("userDao");
    public void newUser() {
        System.out.println(userDao);
        userDao.addUser();
    }
}
