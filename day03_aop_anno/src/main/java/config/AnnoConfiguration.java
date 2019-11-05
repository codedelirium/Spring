package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Import(jdbcConfig.class)
@EnableAspectJAutoProxy//开启aop
public class AnnoConfiguration {


}
