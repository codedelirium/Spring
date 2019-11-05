package cn.koberb.spring.test;

import cn.koberb.spring.pojo.User;
import cn.koberb.spring.service.IUserService;
import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.aop.support.annotation.AnnotationClassFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class annoTest {

    @Test
    public void findAll(){
        //
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        IUserService userService = applicationContext.getBean("userService",IUserService.class);

        List<User> userList = userService.findAll();

        for (User u :
                userList) {
            System.out.println(u);
        }

    }

    @Test
    public void QueryRunner(){
        //根据配置类获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        QueryRunner runner = applicationContext.getBean("runner",QueryRunner.class);
        QueryRunner runner1 = applicationContext.getBean("runner",QueryRunner.class);

        System.out.println(runner==runner1);

    }

}
