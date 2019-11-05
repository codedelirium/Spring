package cn.koberb.spring.test;

import cn.koberb.spring.factory.BeanFactory;
import cn.koberb.spring.service.IUserService;
import cn.koberb.spring.service.impl.UserServiceImpl;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void BeanFactoryTest(){
        for (int i = 0; i < 5; i++) {
//            IUserService userService = new UserServiceImpl();//原始
//            IUserService userService = (IUserService) BeanFactory.getMultBean("userService");//使用工厂
            IUserService userService = (IUserService)BeanFactory.getOneBean("userService");//使用单例工厂
            System.out.println(userService);
            userService.newUser();
        }
    }
}
