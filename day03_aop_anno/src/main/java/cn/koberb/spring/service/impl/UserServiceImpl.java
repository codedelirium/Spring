package cn.koberb.spring.service.impl;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.pojo.User;
import cn.koberb.spring.service.IUserService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户的业务层实现类
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao = null;//@Autowired如果找到的类型不唯一，那么匹配属性名和bean id

    public void transfer(Integer sourceId, Integer targetId, Integer age) {

            User source = userDao.findById(sourceId);//获取一个连接
            User target = userDao.findById(targetId);//获取一个连接

            source.setAge(source.getAge()-age);
            target.setAge(target.getAge()+age);

            userDao.updateUser(source);//获取一个连接
            userDao.updateUser(target);//获取一个连接
    }

    public void newUser(User user) {
        userDao.addUser(user);
    }

    public void destroy(Integer id) {
        userDao.delUser(id);
    }

    public void altUser(User user) {
        userDao.updateUser(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findById(Integer id) {
        return userDao.findById(id);
    }
}

