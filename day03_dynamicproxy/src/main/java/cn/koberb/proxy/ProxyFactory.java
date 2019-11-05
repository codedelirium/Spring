package cn.koberb.proxy;

import cn.koberb.spring.dao.IUserDao;
import cn.koberb.spring.pojo.User;
import cn.koberb.spring.service.IUserService;
import cn.koberb.spring.tran.TransectionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建Service的代理对象工厂
 */
public class ProxyFactory{
    private IUserService userService;
    private TransectionManager txcm;
    public void setTxcm(TransectionManager txcm) {
        this.txcm = txcm;
    }
    //注入的userService作为被代理对象定义成final类
    public final void setUserService(IUserService userService){
        this.userService = userService;
    }
    /**
     * 获取Service代理对象
     *
     */
    public IUserService getUserService(){
         return (IUserService)Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),//被代理类的字节码
                userService.getClass().getInterfaces(),//被代理类的接口
                 new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object res = null;
                        try{
                            txcm.begin();
                            res = method.invoke(userService,args);//核心
                            txcm.commit();
                            return res;
                        }catch (Exception e){
                            txcm.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            txcm.release();
                        }
                    }
                });

    }
}
