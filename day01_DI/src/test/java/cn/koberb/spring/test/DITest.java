package cn.koberb.spring.test;

import cn.koberb.spring.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

    /**
     * 构造函数注入。经常变化的数据不推荐使用
     * 优势：在获取bean对象是，注入数据是必须的操作，否则对象无法创建成功
     * 弊端：改变了bean对象的默认实例化方式，是我们在创建对象时，如果用不到这些数据，也必须提供。
     */
    @Test
    public void Constructor(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userService = (IUserService) applicationContext.getBean("ConService");

        userService.newUser();
    }
    /**
     * Set方法注入。更常用
     * 优势：创建对象时没有明确限制，可以直接使用默认构造函数。
     * 弊端：如果有某个成员必须由值，则无法包哦正一定注入
     */
    @Test
    public void SetInjetction(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userService = (IUserService) applicationContext.getBean("SetService");

        userService.newUser();
    }

    /***
     * 复杂类型注入
     */
    @Test
    public void Complx(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userService = (IUserService) applicationContext.getBean("CplxService");

        userService.newUser();
    }
}
