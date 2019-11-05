package cn.koberb.spring.dao.impl;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.pojo.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("userDao1")
public class UserDaoImpl implements IUserDao {
    @Autowired
    private QueryRunner runner;


    public void addUser(User user) {
        try{
            runner.update("insert into user(name,age,birthday)values(?,?,?)"
                    ,user.getName(),user.getAge(),user.getBirthday());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void delUser(Integer id) {
        try{
            runner.update("delete from user where id = ?",id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateUser(User user) {
        try{
            runner.update("update user set name=?,age=?,birthday=? where id = ?"
                    ,user.getName(),user.getAge(),user.getBirthday(),user.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public User findById(Integer id) {
        try{
            return runner.query("select*from user where id = ?",new BeanHandler<User>(User.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<User> findAll() {
        try{
            return runner.query("select*from user",new BeanListHandler<User>(User.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
