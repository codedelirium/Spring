package cn.koberb.spring.service;

import cn.koberb.spring.pojo.User;

import java.util.List;

public interface IUserService {

    void transfer(Integer sourceId,Integer targetId,Integer age);

    List<User> findAll();

    User findById(Integer id);
}
