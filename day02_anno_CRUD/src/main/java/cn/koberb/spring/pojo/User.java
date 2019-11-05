package cn.koberb.spring.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

@Repository
public class User implements Serializable {
    private  Integer id = null;
    private Integer age = null;
    private String name =null;
    private Date birthday =null;

    @Value("18")
    public void setAge(Integer age) {
        this.age = age;
    }
    @Value("test")
    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
