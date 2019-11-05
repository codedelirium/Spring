package cn.koberb.spring.test;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.jdbc.JdbcSupport;
import cn.koberb.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.PublicKey;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
@PropertySource("classpath:jdbc.properties")
public class JdbcTemplateTest {
    //
    @Value("$jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("$jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * jdbctemplate 基础用法
     */
    @Test
    public void Test01(){
        //spring内置数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        //
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);

        System.out.println(jt.query("select * from user"
                ,new BeanPropertyRowMapper<User>(User.class)));
    }

    @Autowired
    private JdbcTemplate jt;

    /**
     * jdbctemplate 解耦用法
     */
    @Test
    public void Test02(){
        jt.execute("insert into user(id,name,age) values(22,'jdbc01',22)");

        System.out.println(jt.query("select * from user where id = 22"
                ,new BeanPropertyRowMapper<User>(User.class)));
    }

    @Autowired
    private IUserDao userDao;

    /**
     * jdbctemplate在dao层使用
     */
    @Test
    public void TestCRUD(){

        User user = userDao.findById(22);
        System.out.println(user);
        user.setName("改改改");
        userDao.updateUser(user);
        System.out.println(userDao.findById(22));
    }


}
