package cn.koberb.spring.dao.impl;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao2")
public class UserDaoImpl2 implements IUserDao {
    public void addUser(User user) {
        System.out.println("222222222"+user);
    }

    public void delUser(Integer id) {
        System.out.println("22222222");
    }

    public void updateUser(User user) {
        System.out.println("2222222"+user);
    }

    public User findById(Integer id) {
        return null;
    }

    public List<User> findAll() {
        return null;
    }
}
