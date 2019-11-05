package cn.koberb.spring.dao.impl;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {
    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public void addUser(User user) {
        try{
            jt.update("insert into user(id,name,age,birthday)values(?,?,?,?)"
                    ,user.getId(),user.getName(),user.getAge(),user.getBirthday());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void delUser(Integer id) {
        try{
            jt.update("delete from user where id = ?",id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void updateUser(User user) {
        try{
            jt.update("update user set name=?,age=?,birthday=? where id = ?"
                    ,user.getName(),user.getAge(),user.getBirthday(),user.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }


    public User findById(Integer id) {
        try{
            List<User> userList= jt.query("select * from user where id = ?"
                    ,new BeanPropertyRowMapper<User>(User.class),id);
            return userList.isEmpty()?null:(userList.size()>1?null:userList.get(0));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public List<User> findAll() {
        try{
            List<User> userList= jt.query("select * from user"
                ,new BeanPropertyRowMapper<User>(User.class));
            return userList.isEmpty()?null:userList;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
