package cn.koberb.spring.service;

import cn.koberb.spring.pojo.User;

import java.util.List;

public interface IUserService {

    void newUser(User user);

    void destroy(Integer id);

    void altUser(User user);

    List<User> findAll();

    User findById(Integer id);
}
