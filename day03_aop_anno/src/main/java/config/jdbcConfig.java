package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import javax.sql.DataSource;


@PropertySource("classpath:jdbc.properties")
@ComponentScan("cn.koberb.spring")
public class jdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 用于创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name = "runner")//将当前方法的返回值作为bean对象存入spring的ioc容器中,方法名就是默认id
    @Scope("prototype")//多例
    public QueryRunner creatQueryRunner(DataSource dataSource){//spring框架会去ioc容器中以AutoWired形式查找有没有可用的bean对象
        return new QueryRunner(dataSource);
    }

    @Bean(name = "dataSource")
    public DataSource creatDataSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(user);
            ds.setPassword(password);
            return ds;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
