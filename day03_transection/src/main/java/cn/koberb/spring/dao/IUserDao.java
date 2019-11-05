package cn.koberb.spring.dao;

import cn.koberb.spring.pojo.User;

import java.util.List;

public interface IUserDao {
    void addUser(User user);

    void delUser(Integer id);

    void updateUser(User user);

    User findById(Integer id);

    List<User> findAll();
}
