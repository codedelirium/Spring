package cn.koberb.spring.service.impl;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.pojo.User;
import cn.koberb.spring.service.IUserService;
import cn.koberb.spring.tran.TransectionManager;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

/**
 * 用户的业务层实现类
 *
 */
public class UserServiceImpl implements IUserService {
    private IUserDao userDao = null;//@Autowired如果找到的类型不唯一，那么匹配属性名和bean id
    //注入
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     *一个事务多条sql语句
     * @param sourceId
     * @param targetId
     * @param age
     */
    public void transfer(Integer sourceId, Integer targetId, Integer age) {

            User source = userDao.findById(sourceId);//获取一个连接
            User target = userDao.findById(targetId);//获取一个连接

            source.setAge(source.getAge()-age);
            target.setAge(target.getAge()+age);

            userDao.updateUser(source);//获取一个连接
            userDao.updateUser(target);//获取一个连接
    }

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
}

