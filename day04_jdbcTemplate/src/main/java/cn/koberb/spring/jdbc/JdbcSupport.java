package cn.koberb.spring.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcSupport的使用方法
 *      此类用于抽取dao中的重复代码
 */
public class JdbcSupport {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
