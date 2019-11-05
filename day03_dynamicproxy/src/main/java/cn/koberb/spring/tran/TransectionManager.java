package cn.koberb.spring.tran;

import cn.koberb.spring.utils.ConnectionUtils;


/**
 * 事务控制类
 * 控制事物的提交和回滚
 */
public class TransectionManager {
    private ConnectionUtils conn;//事务连接
    //xml注入
    public void setConn(ConnectionUtils conn) {
        this.conn = conn;
    }
    /**
     * 开启事务
     */
    public void begin(){
        try{
            conn.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 事物提交
     */
    public void commit(){
        try{
            conn.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 事物回滚
     */
    public void rollback(){
        try{
            conn.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
    public void release(){
        try{
            conn.getThreadConnection().close();//还给连接池，连接存在但关闭
            conn.removeConnection();//解绑
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
