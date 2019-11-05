package cn.koberb.spring.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    public static Properties props;

    //容器，用于存放创建的对象（都是单例）
    private static Map<String,Object> beans;

    //使用静态代码块为properties对象赋值
    static {
        try {
            props = new Properties();

            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");

            props.load(in);

            //实例化容器
            beans = new HashMap<String, Object>();
            //取出properties中的所有key
            Enumeration keys = props.keys();
            //遍历keys
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                //创建Impl代理对象
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }
        }catch (Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
     * 懒汉模式，单例对象
     * @param beanName
     * @return
     */
    public static Object getOneBean(String beanName){
        return beans.get(beanName);
    }

    /**
     * 饿汉模式，多例对象
     * @param beanName
     * @return
     */
    public static Object getMultBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();//每次都会调用默认构造函数创建对象
        }catch (Exception e){
            e.printStackTrace();
        }
        return bean;
    }
}
