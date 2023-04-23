package com.limu.review.jdbc.test;

import com.limu.view.jdbc.SpringConfig;
import com.limu.view.jdbc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class JdbcTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger log = LoggerFactory.getLogger(JdbcTest.class);


    @Test
    public void testJdbc() {
        String sql = "insert into t_user(real_name,age) values(?,?)";
        int count = jdbcTemplate.update(sql, "leo", 24);
        log.info("添加了" + count + "条数据！");
    }

    @Test
    public void testSelectOne() {
        String sql = "select * from t_user where id = ?";
        //查询一个对象
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 2);
        log.info(user.toString());

        sql = "select * from t_user where real_name = ?";
        //查询多个对象
        List<User> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), "leo");
        log.info(list.toString());
    }
}
