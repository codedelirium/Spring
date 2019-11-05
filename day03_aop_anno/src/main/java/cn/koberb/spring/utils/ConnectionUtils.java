package cn.koberb.spring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;

/***
 * 连接的工具类
 * 用于从数据源中获取一个连接，并实现和线程的绑定
 */
@Component
public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;
    /**
     * 获取当前线程上的连接
     */
    public Connection getThreadConnection(){
        try{
            //从ThreadLocal获取连接
            Connection conn = threadLocal.get();
            //判断连接是否存在
            if(conn == null){
                //从数据源中获取连接，并存入TreadLocal
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }
            //返回当前线程的连接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 解绑连接和线程
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}
