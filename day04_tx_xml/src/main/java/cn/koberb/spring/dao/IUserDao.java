package cn.koberb.spring.dao;

import cn.koberb.spring.pojo.User;

import java.util.List;

public interface IUserDao {

    User findById(Integer id);

    List<User> findAll();

    void updateUser(User user);
}
