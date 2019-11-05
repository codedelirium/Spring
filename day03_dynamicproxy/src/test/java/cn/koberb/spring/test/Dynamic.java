package cn.koberb.spring.test;

import cn.koberb.proxy.ProxyFactory;
import cn.koberb.spring.pojo.User;
import cn.koberb.spring.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class Dynamic {
    @Autowired
    @Qualifier("proxyService")//指定事务管理
    private IUserService userService;

    @Autowired
    @Qualifier("cglibService")
    private IUserService userService1;
    @Test
    public void Dynamic_Proxy(){


        List<User> userList = userService.findAll();
        for (User u :
                userList) {
            System.out.println(u);
        }
        System.out.println("----------");
        userService.transfer(2,3,2);
        userList = userService.findAll();
        for (User u :
                userList) {
            System.out.println(u);
        }
    }
    @Test
    public void Dynamic_CGLib(){
        List<User> userList = userService1.findAll();
        for (User u :
                userList) {
            System.out.println(u);
        }
        System.out.println("----------");
        userService1.transfer(2,3,2);
        userList = userService1.findAll();
        for (User u :
                userList) {
            System.out.println(u);
        }
    }
}
