package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.lang.annotation.*;

/**
 * 该类是一个配置类，他的作用和bean.xml是一样的
 *
 */

//@Configuration//指定当前类是一个配置类
@Import(jdbcConfig.class)//用于导入定子配置类的字节码
//@ComponentScan("cn.koberb.spring")//相当于base-package，指定spring在创建容器时要扫描的包
public class SpringConfiguration {

}
