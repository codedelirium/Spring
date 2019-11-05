package cn.koberb.spring.service.impl;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.pojo.User;
import cn.koberb.spring.service.IUserService;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户的业务层实现类
 */
@Service("userService")//默认userServiceImpl
//@Scope("prototype")
public class UserServiceImpl implements IUserService {

//    @Autowired//自动按照类型注入
//    @Qualifier("userDao2")//指定bean
    @Resource(name = "userDao1")
    private IUserDao userDao = null;//@Autowired如果找到的类型不唯一，那么匹配属性名和bean id

    /***
     * 新增用户
     * @param user
     */
    public void newUser(User user) {
        userDao.addUser(user);
    }

    /**
     * 删除用户
     * @param id
     */
    public void destroy(Integer id) {
        userDao.delUser(id);
    }

    /**
     * 修改用户
     * @param user
     */
    public void altUser(User user) {
        userDao.updateUser(user);
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 通过id查找用户
     * @param id
     * @return
     */
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @PostConstruct
    public void init(){
        System.out.println("初始化");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁");
    }
}

