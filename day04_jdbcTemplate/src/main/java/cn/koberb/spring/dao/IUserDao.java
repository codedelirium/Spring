package cn.koberb.spring.dao;

import cn.koberb.spring.pojo.User;

public interface IUserDao {

    User findById(Integer id);

    void updateUser(User u);

    void deleUser(Integer id);

    void addUser(User user);
}
