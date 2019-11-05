package cn.koberb.spring.tran;

import cn.koberb.spring.utils.ConnectionUtils;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 事务控制类
 * 控制事物的提交和回滚
 */
@Component("tManager")
@Aspect//声明切面类
public class TransectionManager {
    @Autowired
    private ConnectionUtils conn;//事务连接

    @Before("execution(* cn.koberb.spring.service.impl.*.*(..))")
    public void begin(){
        try{
            conn.getThreadConnection().setAutoCommit(false);
            System.out.println("------manager");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @After("execution(* cn.koberb.spring.service.impl.*.*(..))")
    public void commit(){
        try{
            conn.getThreadConnection().commit();
            System.out.println("-----commit");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @AfterThrowing(pointcut = "execution(* cn.koberb.spring.service.impl.*.*(..))")
    public void rollback(){
        try{
            conn.getThreadConnection().rollback();
            System.out.println("-------rollback");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @AfterReturning(pointcut = "execution(* cn.koberb.spring.service.impl.*.*(..))")
    public void release(){
        try{
            conn.getThreadConnection().close();//还给连接池，连接存在但关闭
            conn.removeConnection();//解绑
            System.out.println("------release");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
