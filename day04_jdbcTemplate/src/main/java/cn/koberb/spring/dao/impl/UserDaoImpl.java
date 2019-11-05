package cn.koberb.spring.dao.impl;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.jdbc.JdbcSupport;
import cn.koberb.spring.pojo.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class UserDaoImpl extends JdbcDaoSupport implements IUserDao {

    public User findById(Integer id) {
        List<User> userList= super.getJdbcTemplate().query("select * from user where id = ?"
                ,new BeanPropertyRowMapper<User>(User.class),id);
        return userList.isEmpty()?null:(userList.size()>1?null:userList.get(0));
    }

    public void updateUser(User u) {
        super.getJdbcTemplate().update("update user set name=?,age=?,birthday=? where id =?"
                ,u.getName(),u.getAge(),u.getBirthday(),u.getId());
    }

    public void deleUser(Integer id) {
        super.getJdbcTemplate().update("delete from user where id = ?",id);
    }

    public void addUser(User user) {
        super.getJdbcTemplate().update("insert into user(id,name,age) values(?,?,?)"
                ,user.getId(),user.getName(),user.getAge());
    }
}
