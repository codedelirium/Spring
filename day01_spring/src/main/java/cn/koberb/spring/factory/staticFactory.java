package cn.koberb.spring.factory;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.dao.impl.UserDaoImpl;
import cn.koberb.spring.service.IUserService;
import cn.koberb.spring.service.impl.UserServiceImpl;

/**
 * 静态工厂
 */
public class staticFactory {
    public static IUserService getUserService(){
        return new UserServiceImpl();
    }

//    public static IUserDao getUserDao(){
//        return new UserDaoImpl();
//    }
}
