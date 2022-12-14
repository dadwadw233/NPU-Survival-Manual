package com.yyh.nwpusurvivalmanual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class NwpuSurvivalManualApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    void printData() throws SQLException {
        System.out.println("默认数据源为：" + dataSource.getClass());
        System.out.println("数据库连接实例：" + dataSource.getConnection());
        //访问数据库user表，查询user表的数据量
        Integer i = jdbcTemplate.queryForObject("SELECT count(*) from `test`", Integer.class);
        System.out.println("user 表中共有" + i + "条数据。");
    }

}
