package cn.koberb.spring.factory;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.dao.impl.UserDaoImpl;
import cn.koberb.spring.service.IUserService;
import cn.koberb.spring.service.impl.UserServiceImpl;

/**
 * 实例工厂
 */
public class instanceFactory {
    public IUserService getUserService(){
        return new UserServiceImpl();
    }
//
//    public IUserDao getUserDao(){
//        return new UserDaoImpl();
//    }
}
