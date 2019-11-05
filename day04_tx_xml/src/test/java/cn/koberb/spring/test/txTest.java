package cn.koberb.spring.test;

import cn.koberb.spring.pojo.User;
import cn.koberb.spring.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class txTest {

    @Autowired
    private IUserService userService;
    @Test
    public void AAA(){
        userService.transfer(2,3,2);

    }

    @Test
    public void BBB(){
        List<User> userList = userService.findAll();
        for (User u :
                userList) {
            System.out.println(u);
        }
    }
}
