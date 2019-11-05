package cn.koberb.spring.test;

import cn.koberb.spring.pojo.User;
import cn.koberb.spring.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/***
 * 整合junit
 */
@RunWith(SpringJUnit4ClassRunner.class)//替换原有y运行期
@ContextConfiguration(locations = {"classpath:bean.xml"})//指定配置文件
public class xmlTest {
    @Autowired
    private IUserService userService;
    @Autowired
    private User user;

    @Test
    public void findAll(){

        List<User> userList = userService.findAll();

        for (User u :
                userList) {
            System.out.println(u);
        }
    }

    @Test
    public void add(){
        userService.newUser(user);

        findAll();
    }

}
