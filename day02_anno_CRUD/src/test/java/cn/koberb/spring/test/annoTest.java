package cn.koberb.spring.test;

import cn.koberb.spring.pojo.User;
import cn.koberb.spring.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class annoTest {

    @Test
    public void anno(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userService = applicationContext.getBean("userService",IUserService.class);
        User user = applicationContext.getBean("user",User.class);
//        user.setName("zhangs");
//        user.setAge(15);
        userService.newUser(user);

        applicationContext.close();

    }

    @Test
    public void findAll(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        IUserService userService = applicationContext.getBean("userService",IUserService.class);

        List<User> userList = userService.findAll();

        for (User u :
                userList) {
            System.out.println(u);
        }

        applicationContext.close();
    }


}
