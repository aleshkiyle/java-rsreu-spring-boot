package com.rodin.sanitaryEngineeringShop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class JDBCPostgreConfig {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addStudent() {
        String sql = "INSERT INTO students(name, email) VALUES('Nasty', 'lobash17@gmail.com')";

        int rows = jdbcTemplate.update(sql);
        if (rows > 0) {
            System.out.println("A new row has been inserted");
        }
    }
}
