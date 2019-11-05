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
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void transfer(Integer sourceId, Integer targetId, Integer age)
    {

        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        User source = userDao.findById(sourceId);
        //2.2根据名称查询转入账户
        User target = userDao.findById(targetId);
        //2.3转出账户减钱
        source.setAge(source.getAge()-age);
        //2.4转入账户加钱
        target.setAge(target.getAge()+age);
        //2.5更新转出账户
        userDao.updateUser(source);
        int i=1/0;
        //2.6更新转入账户
        userDao.updateUser(target);
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

