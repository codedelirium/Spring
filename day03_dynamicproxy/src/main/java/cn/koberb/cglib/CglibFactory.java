package cn.koberb.cglib;

import cn.koberb.spring.service.IUserService;
import cn.koberb.spring.tran.TransectionManager;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

public class CglibFactory{
    private IUserService userService;
    private TransectionManager txcm;
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    public void setTxcm(TransectionManager txcm) {
        this.txcm = txcm;
    }
    public IUserService getUserService() {
        return (IUserService) Enhancer.create(userService.getClass(),
                new MethodInterceptor() {
                    /**
                     *
                     * @param o
                     * @param method
                     * @param objects
                     *      以上与基于接口的动态代理中的invoke方法的参数一样
                     * @param methodProxy 当前执行方法的代理对象
                     * @return
                     * @throws Throwable
                     */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object res = null;
                //可得到方法参数
                String name = method.getName();
                ///代理指定方法
                if("transfer".equals(name)){
                    try{
                        txcm.begin();
                        res = method.invoke(userService,objects);//核心
                        txcm.commit();
                        return res;
                    }catch (Exception e){
                        txcm.rollback();
                        throw new RuntimeException(e);
                    }finally {
                        txcm.release();
                    }
                }else {
                    res=method.invoke(userService,objects);
                }
                return res;
            }
        });
    }
}
