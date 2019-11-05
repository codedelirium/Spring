package cn.koberb.spring.test;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void defaultBean(){
        //1.使用ApplicationContext接口，获取spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据bean的id获取对象
        IUserService userService = (IUserService) applicationContext.getBean("defaultService");
        userService.newUser();
        //3.关闭容器
        applicationContext.close();

    }

    @Test
    public void instanceFactory(){
        //1.使用ApplicationContext接口，获取spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据bean的id获取对象
        IUserService userService = (IUserService) applicationContext.getBean("staticService");
        userService.newUser();
        //3.关闭容器
        applicationContext.close();

    }

    @Test
    public void staticFactory(){
        //1.使用ApplicationContext接口，获取spring容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据bean的id获取对象
        IUserService userService = (IUserService) applicationContext.getBean("instanceService");
        userService.newUser();
        //3.关闭容器
        applicationContext.close();
    }
}
